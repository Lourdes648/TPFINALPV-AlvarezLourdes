package ar.edu.unju.edm.model;
import org.springframework.stereotype.Component;

@Component
public class Cadena {
	private String cad;
	private int d;
	private int m;
	private int a;
	
	public Cadena() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cadena(String cad, int d, int m, int a) {
		super();
		this.cad = cad;
		this.d = d;
		this.m = m;
		this.a = a;
	}

	public String getCad() {
		return cad;
	}

	public void setCad(String cad) {
		this.cad = cad;
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
