package es.pildoras.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.pildoras.crud.dao.IClienteDao;
import es.pildoras.entity.Cliente;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	@Autowired
	private IClienteDao clientDao;

	@RequestMapping("/lista")
	public String listaClientes(Model model) {
		// Obtener los clientes desde el DAO
		List<Cliente> clientes = clientDao.getClientes();

		// Agregar los clientes al modelo
		model.addAttribute("clientes", clientes);

		return "listaClientes";
	}

	@RequestMapping("/formularioCreacion")
	public String mostrarFormularioCreacion(Model model) {
		// Bind datos cliente
		Cliente cliente = new Cliente();

		model.addAttribute("cliente", cliente);
		model.addAttribute("accion", "crear");
		return "formularioCreacion";
	}

	@RequestMapping("/formularioModificacion")
	public String mostrarFormularioModificacion(@RequestParam int id, Model model) {
		// Bind datos cliente
		Cliente cliente = clientDao.obtenerCliente(id);

		model.addAttribute("cliente", cliente);
		model.addAttribute("accion", "modificar");
		return "formularioCreacion";
	}

	@PostMapping("/crear")
	public String crear(@ModelAttribute("cliente") Cliente cliente) {
		clientDao.crear(cliente);
		return "redirect:/cliente/lista";
	}

	@PostMapping("/modificar")
	public String modificar(@ModelAttribute("cliente") Cliente cliente) {
		clientDao.modificar(cliente);
		return "redirect:/cliente/lista";
	}

	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam int id) {
		clientDao.eliminar(id);
		return "redirect:/cliente/lista";
	}
}
