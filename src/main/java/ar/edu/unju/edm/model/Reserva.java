package ar.edu.unju.edm.model;

public class Reserva{
	
	private Long codigoReserva;
	private String usuarioReserva;
	private String desayuno;
	private int monto;
	private int d;
	private int m;
	private int a;
	public Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reserva(Long codigoReserva, String usuarioReserva, String desayuno, int monto, int d, int m, int a) {
		super();
		this.codigoReserva = codigoReserva;
		this.usuarioReserva = usuarioReserva;
		this.desayuno = desayuno;
		this.monto = monto;
		this.d = d;
		this.m = m;
		this.a = a;
	}
	public Long getCodigoReserva() {
		return codigoReserva;
	}
	public void setCodigoReserva(Long codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
	public String getUsuarioReserva() {
		return usuarioReserva;
	}
	public void setUsuarioReserva(String usuarioReserva) {
		this.usuarioReserva = usuarioReserva;
	}
	public String getDesayuno() {
		return desayuno;
	}
	public void setDesayuno(String desayuno) {
		this.desayuno = desayuno;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
}
