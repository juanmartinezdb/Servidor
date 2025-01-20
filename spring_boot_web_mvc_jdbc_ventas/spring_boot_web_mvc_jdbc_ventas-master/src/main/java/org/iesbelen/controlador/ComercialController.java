package org.iesbelen.controlador;

import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ComercialController {

    @Autowired
    private ComercialService comercialService;

    @GetMapping("/comerciales")
    public String listar(Model model) {
        List<Comercial> listaComerciales = comercialService.listAll();
        model.addAttribute("listaComerciales", listaComerciales);
        return "comerciales";

    }

}
