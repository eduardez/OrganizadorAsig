package persistencia;

import java.util.ArrayList;

import dominio.Asignatura;

public class CrearAlumno {
	public static void main(String[] args) throws Exception {
		Agente ag = new Agente();
		Asignatura a = new Asignatura();
		//ag.insertarAsig(a); FUNCIONA
		//ag.EliminarAsig(a); FUNCIONA
		ArrayList<Asignatura> asig = ag.selectAsignaturas();
	}
}
