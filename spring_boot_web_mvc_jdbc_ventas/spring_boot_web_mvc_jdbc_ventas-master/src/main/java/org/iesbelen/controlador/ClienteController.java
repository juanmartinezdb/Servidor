package org.iesbelen.controlador;

import java.util.List;

import jakarta.validation.Valid;
import org.iesbelen.exception.MiExcepcion;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.service.ClienteService;
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
	
	private ClienteService clienteService;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
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

	// Simula una RuntimeException al acceder a esta ruta
	@GetMapping("/error-runtime")
	public String lanzarRuntimeException() {
		throw new RuntimeException("¡Ocurrió un error inesperado!");
	}

	// Simula una MiExcepcion al acceder a esta ruta
	@GetMapping("/error-custom")
	public String lanzarMiExcepcion() throws MiExcepcion {
		throw new MiExcepcion("¡Esta es una excepción personalizada!");
	}

}