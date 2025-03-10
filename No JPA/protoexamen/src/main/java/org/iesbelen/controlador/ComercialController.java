package org.iesbelen.controlador;

import jakarta.validation.Valid;

import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.exception.MiExcepcion;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.iesbelen.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ComercialController {


    @Autowired
    private ComercialService comercialService;

    @Autowired
    private PedidoService pedidoService;


    @GetMapping("/comerciales")
    public String listar(Model model) {
        List<Comercial> listaComerciales = comercialService.listAll();
        model.addAttribute("listaComerciales", listaComerciales);
        return "comercial/comerciales";

    }
    @GetMapping("/comerciales/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {


        Comercial comercial = comercialService.one(id);
        List<PedidoDTO> pedidos = pedidoService.listarPedidosDTO(id);


//        List<PedidoDTO> pedidos= comercialService.pedidosComercial(id) ;
        Integer totalPedidos = pedidoService.pedidosTotales();
        BigDecimal porcentajePedidos = pedidoService.porcentajePedidos(totalPedidos, id);

        model.addAttribute("porcentaje", porcentajePedidos);
        model.addAttribute("totalPedidos", totalPedidos);
        model.addAttribute("comercial", comercial);
        model.addAttribute("pedidos", pedidos);

        return "comercial/detalle-comercial";

    }

    @GetMapping("/comerciales/crear")
    public String crear(Model model) {

        Comercial comercial = new Comercial();
        model.addAttribute("comercial", comercial);

        return "comercial/crear-comercial";

    }

    @PostMapping("/comerciales/crear")
    public String submitCrear(@Valid @ModelAttribute Comercial comercial,  BindingResult bindingResulted, Model model) {

        if (bindingResulted.hasErrors()) {
            model.addAttribute("comercial", comercial);

            return "comercial/crear-comercial";

        }
        comercialService.newComercial(comercial);

        return ("redirect:/comerciales") ;

    }

    @GetMapping("/comerciales/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Comercial comercial = comercialService.one(id);
        model.addAttribute("comercial", comercial);

        return "comercial/editar-comercial";

    }


    @PostMapping("/comerciales/editar/{id}")
    public RedirectView submitEditar(@ModelAttribute("comercial") Comercial comercial) {

        comercialService.replaceComercial(comercial);

        return new RedirectView("/comerciales");
    }

    @PostMapping("/comerciales/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {

        comercialService.deleteComercial(id);

        return new RedirectView("/comerciales");
    }

    ///////////////////////////////////EXCEPCIONES
    //Excepcion nuestra
    @GetMapping("/comerciales/error")
    public String lanzarMiExcepcion() throws MiExcepcion {
        throw new MiExcepcion();
    }

}
