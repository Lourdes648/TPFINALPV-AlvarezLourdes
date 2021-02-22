package ar.edu.unju.edm.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Cadena;
import ar.edu.unju.edm.model.Habitacion;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IHabitacionService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class UserController {
	
	@Autowired
	IUsuarioService iUsuarioService;
	@Autowired
	IHabitacionService iHabitacionService;
	
	@GetMapping("/Client")
	public String InterfazClient() {
		return "InterfazClient";
	}
	
	@GetMapping("/Admin")
	public String Admin(Model model) {
		return "InterfazAdmin";
	}

	@GetMapping("/BuscarFecha")
	public String BuscarFecha(Model model) {
		Cadena unaCad = new Cadena();
		model.addAttribute("fecha", unaCad);
		return "BuscarFecha";
	}
	@PostMapping("/BuscarFecha")
	public String IrABuscarFecha(@ModelAttribute("fecha") Cadena fecha, Model model) {
		LocalDate xd = LocalDate.of(fecha.getA(), fecha.getM(), fecha.getD());
		System.out.println("Fecha buscada PRIMERA: "+xd);
		return MostrarFecha(xd,model);
	}
	@GetMapping("/FechaBuscada")
	public String MostrarFecha(LocalDate fecha, Model model) {
		model.addAttribute("reservas",iHabitacionService.BuscarPorFecha(fecha));
		System.out.println("Fecha buscada SEGUNDA: "+fecha);
		return "FechaBuscada";
	}
	
	@GetMapping("/BuscarUsuario")
	public String BuscarUsuario(Model model) {
		Cadena unaCad = new Cadena();
		model.addAttribute("user", unaCad);
		return "BuscarUsuario";
	}
	@PostMapping("/BuscarUsuario")
	public String IrABuscarUsuario(@ModelAttribute("user") Cadena usuario, Model model) {
		return MostrarUsuario(usuario,model);
	}
	@GetMapping("/UsuarioBuscado")
	public String MostrarUsuario(Cadena usuario, Model model) {
		model.addAttribute("reservas",iHabitacionService.BuscarPorUsuario(usuario.getCad()));
		return "UsuarioBuscado";
	}
	
	@GetMapping("/AgregarUsuario")
	public String AgregarUsuario(Model model) {
		model.addAttribute("usuarioDelForm",new Usuario());
		return "AgregarUsuario";
	}
	@PostMapping("/AgregarUsuario")
	public String AgregarUsuarioPost(@ModelAttribute("usuarioDelForm") Usuario usuario, Model model) {
		iUsuarioService.EncriptarYGuardarUsuario(usuario);
		return "InterfazAdmin";
	}
	
	@GetMapping("/AgregarHabitacion")
	public String AgregarHabitacion(Model model) {
		model.addAttribute("habitacionDelForm",new Habitacion());
		return "AgregarHabitacion";
	}
	@PostMapping("/AgregarHabitacion")
	public String AgregarHabitacionPost(@ModelAttribute("habitacionDelForm") Habitacion habitacion, Model model) {
		iHabitacionService.GuardarHabitacion(habitacion);
		return "InterfazAdmin";
	}
	
}

