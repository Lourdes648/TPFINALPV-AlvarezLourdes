package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Reserva;
import ar.edu.unju.edm.service.IHabitacionService;

@Controller
public class HabitacionController {
	
	@Autowired
	IHabitacionService iHabitacionService;

	@GetMapping("/Reserva")
	public String ReservaHabitacion(Model model) {
		model.addAttribute("reservas1", iHabitacionService.MostrarHabitaciones());
		model.addAttribute("reservaDelForm", new Reserva());
		return "ReservaHabitacion";
	}

	@PostMapping("/Reserva")
	public String AgregarReserva(@ModelAttribute("reservaDelForm") Reserva reserva, Model model) {
		iHabitacionService.ReservarHabitacion(reserva);
		iHabitacionService.update();
		return "InterfazClient";
	}
	@GetMapping("/Reservas")
	public String ReservaHabitaciones() {
		return "ReservaHabitaciones";
		//return InterfazClient();
	}
	@GetMapping("/MostrarReservas")
	public String MostrarReservas(Model model) {
		model.addAttribute("reservas",iHabitacionService.MostrarHabitaciones());
		return "MostrarReservas";
	}


}
