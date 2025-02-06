package org.iesbelen.controlador;

import java.util.List;

import jakarta.validation.Valid;
import org.iesbelen.exception.MiExcepcion;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	//@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	
	@GetMapping("/clientes") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Cliente> listaClientes =  clienteService.listAll();
		model.addAttribute("listaClientes", listaClientes);
				
		return "cliente/clientes";
		
	}

	@GetMapping("/clientes/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {

		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);

		return "cliente/detalle-cliente";

	}

	@GetMapping("/clientes/crear")
	public String crear(Model model) {

		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);

		return "cliente/crear-cliente";

	}

	@PostMapping("/clientes/crear")
	public String submitCrear(@Valid @ModelAttribute Cliente cliente, BindingResult bindingResulted, Model model) {

		if (bindingResulted.hasErrors()) {
			model.addAttribute("cliente", cliente);

			return "cliente/crear-cliente";

		}
		clienteService.newCliente(cliente);

		return ("redirect:/clientes") ;

	}

	@GetMapping("/clientes/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {

		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);

		return "cliente/editar-cliente";

	}


	@PostMapping("/clientes/editar/{id}")
	public RedirectView submitEditar(@ModelAttribute("cliente") Cliente cliente) {

		clienteService.replaceCliente(cliente);

		return new RedirectView("/clientes");
	}

	@PostMapping("/clientes/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {

		clienteService.deleteCliente(id);

		return new RedirectView("/clientes");
	}
	///////////////////////////////////EXCEPCIONES
	//Excepcion de Runtime
	@GetMapping("/clientes/error")
	public String RunTimeErrorEnClientes() {
		throw new RuntimeException("Error de prueba en clientes");
	}

	//Excepcion declarada directamente en controlador sin pasar por el ControllerAdvice
	//van seguidos junto el getmapping y el exceptionhandler
	@GetMapping("/clientes/error2")
	public String RunTimeErrorEnClientes2() throws MiExcepcion {
		throw new MiExcepcion();
	}
	@ExceptionHandler
	public  String miExcepcionDesdeController(Model model, MiExcepcion miExcepcion){
		model.addAttribute("traza", ("lanzado desde el controller de Cliente"+miExcepcion.getMessage()));
		return  "errores/error-mi-excepcion";
	}

}