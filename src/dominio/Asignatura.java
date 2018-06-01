package dominio;

public class Asignatura {
	
	private String nombre;
	private boolean global;
	private double Nota1, Nota1Por, Nota2, Nota2Por, NotaLab, NotaLabPor, NotaPar,
			NotaParPor, NotaTeorico, NotaTeoricoPor, Otros, OtrosPor;
	private int ao,curso;

	public Asignatura() {
		
	}
	public Asignatura(String nombre, boolean global,double a, double b, double c, double d, double e, double f, double g, double h, double i, double j, double k, double l, int ao,int curso) {
		this.nombre=nombre;
		this.global=global;
		this.Nota1 = a;
		this.Nota1Por = b;
		this.Nota2 = c;
		this.Nota2Por = d;
		this.NotaLab = e;
		this.NotaLabPor = f;
		this.NotaPar = g;
		this.NotaParPor = h;
		this.NotaTeorico = i;
		this.NotaTeoricoPor = j;
		this.Otros = k;
		this.OtrosPor = l;
		this.ao=ao;
		this.curso=curso;
	}

	
	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", global=" + global + ", Nota1=" + Nota1 + ", Nota1Por=" + Nota1Por
				+ ", Nota2=" + Nota2 + ", Nota2Por=" + Nota2Por + ", NotaLab=" + NotaLab + ", NotaLabPor=" + NotaLabPor
				+ ", NotaPar=" + NotaPar + ", NotaParPor=" + NotaParPor + ", NotaTeorico=" + NotaTeorico
				+ ", NotaTeoricoPor=" + NotaTeoricoPor + ", Otros=" + Otros + ", OtrosPor=" + OtrosPor + ", ao=" + ao
				+ "]";
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota1() {
		return Nota1;
	}

	public void setNota1(double Nota1) {
		this.Nota1 = Nota1;
	}

	public double getNota1Por() {
		return Nota1Por;
	}

	public void setNota1Por(double Nota1Por) {
		this.Nota1Por = Nota1Por;
	}

	public double getNota2() {
		return Nota2;
	}

	public void setNota2(double Nota2) {
		this.Nota2 = Nota2;
	}

	public double getNota2Por() {
		return Nota2Por;
	}

	public void setNota2Por(double Nota2Por) {
		this.Nota2Por = Nota2Por;
	}

	public double getNotaLab() {
		return NotaLab;
	}

	public void setNotaLab(double NotaLab) {
		this.NotaLab = NotaLab;
	}

	public double getNotaLabPor() {
		return NotaLabPor;
	}

	public void setNotaLabPor(double NotaLabPor) {
		this.NotaLabPor = NotaLabPor;
	}

	public double getNotaPar() {
		return NotaPar;
	}

	public void setNotaPar(double NotaPar) {
		this.NotaPar = NotaPar;
	}

	public double getNotaParPor() {
		return NotaParPor;
	}

	public void setNotaParPor(double NotaParPor) {
		this.NotaParPor = NotaParPor;
	}

	public double getNotaTeorico() {
		return NotaTeorico;
	}

	public void setNotaTeorico(double NotaTeorico) {
		this.NotaTeorico = NotaTeorico;
	}

	public double getNotaTeoricoPor() {
		return NotaTeoricoPor;
	}

	public void setNotaTeoricoPor(double NotaTeoricoPor) {
		this.NotaTeoricoPor = NotaTeoricoPor;
	}

	public double getOtros() {
		return Otros;
	}

	public void setOtros(double Otros) {
		this.Otros = Otros;
	}

	public double getOtrosPor() {
		return OtrosPor;
	}

	public void setOtrosPor(double OtrosPor) {
		this.OtrosPor = OtrosPor;
	}
	public boolean isGlobal() {
		return global;
	}
	public void setGlobal(boolean global) {
		this.global = global;
	}
	public int  getAo() {
		return ao;
	}
	public void setAo(int  ao) {
		this.ao = ao;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	
}
