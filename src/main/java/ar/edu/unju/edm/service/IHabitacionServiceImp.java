package ar.edu.unju.edm.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Habitacion;
import ar.edu.unju.edm.model.Reserva;
import ar.edu.unju.edm.repository.IHabitacionDAO;

@Service
public class IHabitacionServiceImp implements IHabitacionService {
	@Autowired
	IHabitacionDAO iHabitacionDAO;
	Habitacion unaHabitacion;
	@Override
	public void GuardarHabitacion(Habitacion unaHabitacion) {
		iHabitacionDAO.save(unaHabitacion);
	}
	@Override
	public void ReservarHabitacion(Reserva reserva) {
		iHabitacionDAO.findById(reserva.getCodigoReserva()).get().setUser(reserva.getUsuarioReserva());
		iHabitacionDAO.findById(reserva.getCodigoReserva()).get().setDesayuno(reserva.getDesayuno());
		iHabitacionDAO.findById(reserva.getCodigoReserva()).get().setFecha(LocalDate.of(reserva.getA(),reserva.getM(),reserva.getD()));
		iHabitacionDAO.findById(reserva.getCodigoReserva()).get().setPrecioNombre(reserva.getMonto());
	}
	@Override
	public Iterable<Habitacion> MostrarHabitaciones() {
		return iHabitacionDAO.findAll();
	}
	@Override
	public void update() {
		Habitacion xd = new Habitacion();
		iHabitacionDAO.save(xd);
		iHabitacionDAO.delete(xd);
		
	}
	@Override
	public Iterable<Habitacion> BuscarPorUsuario(String user) {
		return iHabitacionDAO.findByUser(user);
	}
	@Override
	public Iterable<Habitacion> BuscarPorFecha(LocalDate fecha) {
		return iHabitacionDAO.findByFecha(fecha);
	}

}
