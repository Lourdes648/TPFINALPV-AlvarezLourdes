package ar.edu.unju.edm.controller;
/*
import ar.edu.unju.edm.model.Habitacion;
import ar.edu.unju.edm.model.Usuario;
//*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unju.edm.model.Habitacion;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IHabitacionService;
import ar.edu.unju.edm.service.IUsuarioService;
@Controller
public class AplicacionController {
	
	@Autowired
	IUsuarioService iUsuarioService;
	
	@Autowired
	IHabitacionService iHabitacionService;
	
	@GetMapping({"/","/login","/home","/login?error=true"})
	public String IniciarAplicacion(Model model) {
		 iHabitacionService.GuardarHabitacion(new Habitacion((long)1,01,"Doble","Grande"));
		 iHabitacionService.GuardarHabitacion(new Habitacion((long)2,02,"Simple","Grande"));
		 iHabitacionService.GuardarHabitacion(new Habitacion((long)3,03,"Doble","Grande"));
		 iHabitacionService.GuardarHabitacion(new Habitacion((long)4,04,"Simple","Grande"));
		 iHabitacionService.GuardarHabitacion(new Habitacion((long)5,05,"Doble","Grande"));
		 Usuario bas = new Usuario((long)1,"Lourdes","lourdes1","Lourdes","Alvarez",43269479,"Admin");
		 iUsuarioService.EncriptarYGuardarUsuario(bas);
		 bas = new Usuario((long)2,"Luz","luz1","Luz","Alvarez",4327282,"Client");
		 iUsuarioService.EncriptarYGuardarUsuario(bas);
		
		return "index";
	}
}
