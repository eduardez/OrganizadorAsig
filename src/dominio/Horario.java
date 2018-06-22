package dominio;

import java.util.ArrayList;
import java.util.Arrays;

public class Horario {
	private int ao;
	private int cuatri;
	private String[] horas;
	private String[] lun;
	private String[] mar;
	private String[] mie;
	private String[] jue;
	private String[] vie;
	private String[] sab;
	private String[] dom;

	public Horario() {
		
	}
	
	public Horario(int ao, int cuatri, String[] horas, String[] lun, String[] mar, String[] mie, String[] jue,
			String[] vie, String[] sab, String[] dom) {
		this.ao = ao;
		this.cuatri = cuatri;
		this.horas = horas;
		this.lun = lun;
		this.mar = mar;
		this.mie = mie;
		this.jue = jue;
		this.vie = vie;
		this.sab = sab;
		this.dom = dom;
	}

	public int getAo() {
		return ao;
	}

	public void setAo(int ao) {
		this.ao = ao;
	}

	public int getCuatri() {
		return cuatri;
	}

	public void setCuatri(int cuatri) {
		this.cuatri = cuatri;
	}

	public String[] getHoras() {
		return horas;
	}

	public void setHoras(String[] horas) {
		this.horas = horas;
	}

	public String[] getLun() {
		return lun;
	}

	public void setLun(String[] lun) {
		this.lun = lun;
	}

	public String[] getMar() {
		return mar;
	}

	public void setMar(String[] mar) {
		this.mar = mar;
	}

	public String[] getMie() {
		return mie;
	}

	public void setMie(String[] mie) {
		this.mie = mie;
	}

	public String[] getJue() {
		return jue;
	}

	public void setJue(String[] jue) {
		this.jue = jue;
	}

	public String[] getVie() {
		return vie;
	}

	public void setVie(String[] vie) {
		this.vie = vie;
	}

	public String[] getSab() {
		return sab;
	}

	public void setSab(String[] sab) {
		this.sab = sab;
	}

	public String[] getDom() {
		return dom;
	}

	public void setDom(String[] dom) {
		this.dom = dom;
	}
	
	public String [] genArray(String cadena) {
		String[] arr = cadena.split(" -- ");
		
		return arr;
	}
	public String genString(String [] arr) {
		String cad="";
		for(int i=0;i<arr.length-1;i++) {
			cad+=arr[i]+" -- ";
		}
		cad+=arr[arr.length-1];
		return cad;
	}

}
