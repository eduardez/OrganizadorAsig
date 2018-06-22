package persistencia;

import java.sql.*;
import java.util.ArrayList;

import dominio.Asignatura;
import dominio.Dialogos;
import dominio.Horario;
import dominio.Tarea;
import java.util.Date;

public class Agente {

	private final String url = "jdbc:ucanaccess://data/Asignaturas.accdb";

	public Agente() throws SQLException {
	}

	/**
	 * --------------------------------------------------------------
	 * ------------------- Agente de asignaturas---------------------
	 * --------------------------------------------------------------
	 **/
	public ArrayList<Asignatura> selectAsignaturas() {
		try {
			String sql = "SELECT * FROM Asignatura ";
			Connection conn = DriverManager.getConnection(url);
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);

			ArrayList<Asignatura> lasig = new ArrayList<>();
			Asignatura a = null;
			while (res.next()) {

				a = new Asignatura();

				a.setNombre(res.getString("Nombre"));
				a.setGlobal(res.getBoolean("global"));
				a.setNota1(res.getDouble("Parcial1"));
				a.setNota1Por(res.getDouble("PorP1"));
				a.setNota2(res.getDouble("Parcial2"));
				a.setNota2Por(res.getDouble("PorP2"));
				a.setNotaLab(res.getDouble("lab"));
				a.setNotaLabPor(res.getDouble("labPor"));
				a.setNotaPar(res.getDouble("Particip"));
				a.setNotaParPor(res.getDouble("ParticipPor"));
				a.setNotaTeorico(res.getDouble("TrabTeo"));
				a.setNotaTeoricoPor(res.getDouble("Trabtpor"));
				a.setOtros(res.getDouble("Otros"));
				a.setOtrosPor(res.getDouble("otrosPor"));
				a.setAo(res.getInt("Ao"));
				a.setCurso(res.getInt("curso"));
				lasig.add(a);
			}

			conn.commit();
			stm.close();
			conn.close();
			return lasig;

		} catch (SQLException e) {
			Dialogos di = new Dialogos();
			di.dialogNoBD();
			return null;
		}
	}

	public void insertarAsig(Asignatura a) throws SQLException {
		String nombre;
		boolean global;
		double textNota1, textNota1Por, textNota2, textNota2Por, textNotaLab, textNotaLabPor, textNotaPar,
				textNotaParPor, textNotaTeorico, textNotaTeoricoPor, textOtros, textOtrosPor;
		int ao, curso;
		nombre = a.getNombre();
		global = a.isGlobal();
		textNota1 = a.getNota1();
		textNota2 = a.getNota2();
		textNota1Por = a.getNota1Por();
		textNota2Por = a.getNota2Por();
		textNotaLab = a.getNotaLab();
		textNotaLabPor = a.getNotaLabPor();
		textNotaPar = a.getNotaPar();
		textNotaParPor = a.getNotaParPor();
		textNotaTeorico = a.getNotaTeorico();
		textNotaTeoricoPor = a.getNotaTeoricoPor();
		textOtros = a.getOtros();
		textOtrosPor = a.getOtrosPor();
		ao = a.getAo();
		curso = a.getCurso();

		String sql = "INSERT INTO Asignatura (Nombre, global, Parcial1, porp1, parcial2, porp2, lab, labpor, particip, particippor, trabteo, trabtpor, otros, otrospor, ao, curso) VALUES "
				+ "('" + nombre + "' , " + global + " , '" + textNota1 + "' , '" + textNota1Por + "' , '" + textNota2
				+ "' , '" + textNota2Por + " ', '" + textNotaLab + "' , '" + textNotaLabPor + "' ,'" + textNotaPar
				+ "' , '" + textNotaParPor + "' , '" + textNotaTeorico + "' , '" + textNotaTeoricoPor + "' , '"
				+ textOtros + "' , '" + textOtrosPor + "', '" + ao + "', '" + curso + "'  )";
		Connection conn = DriverManager.getConnection(url);
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
		conn.commit();
		stm.close();
		conn.close();
	}

	public void EliminarAsig(Asignatura a) throws SQLException {
		String nombre;
		int ao;

		nombre = a.getNombre();
		ao = a.getAo();
		Connection conn = DriverManager.getConnection(url);
		Statement stm = conn.createStatement();
		stm.executeUpdate("DELETE FROM Asignatura WHERE nombre='" + nombre + "' AND ao='" + ao + "' ; ");
		conn.commit();
		stm.close();
		conn.close();

	}

	/**
	 * --------------------------------------------------------------
	 * ---------------------- Agente de Tareas ----------------------
	 * --------------------------------------------------------------
	 **/

	public ArrayList<Tarea> selectTareas() {
		try {
			String sql = "SELECT * FROM Tarea ";
			Connection conn = DriverManager.getConnection(url);
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);

			ArrayList<Tarea> ltareas = new ArrayList<>();
			Tarea t = null;
			while (res.next()) {

				t = new Tarea();

				t.setFecha(res.getTimestamp("fechaIni"));
				t.setIdTiempo(res.getLong("IDtiempo"));
				t.setTexto(res.getString("texto"));
				t.setAnual(res.getBoolean("anual"));
				ltareas.add(t);
			}

			conn.commit();
			stm.close();
			conn.close();
			return ltareas;

		} catch (SQLException e) {
			Dialogos di = new Dialogos();
			di.dialogNoBD();
			return null;
		}
	}

	public void insertarTarea(Tarea t) throws SQLException {
		Long IDtiempo;
		String texto;
		boolean anual;
		Date fech = t.getFecha();

		@SuppressWarnings("deprecation")
		Object fechaIni = new java.sql.Timestamp((fech.getYear() - 1900), fech.getMonth(), fech.getDate(),
				fech.getHours(), fech.getMinutes(), 0, 0);
		IDtiempo = t.getIdTiempo();
		texto = t.getTexto();
		anual = t.isAnual();

		String sql = "INSERT INTO Tarea (fechaIni, IDtiempo, texto, anual) VALUES " + "('" + fechaIni + "' , '"
				+ IDtiempo + "' , '" + texto + "' , " + anual + "  )";
		Connection conn = DriverManager.getConnection(url);
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
		conn.commit();
		stm.close();
		conn.close();
	}

	public void EliminarTarea(Tarea t) throws SQLException {
		Object fechaIni;
		long IDtiempo;

		fechaIni = t.getFecha();
		IDtiempo = t.getIdTiempo();
		Connection conn = DriverManager.getConnection(url);
		Statement stm = conn.createStatement();
		stm.executeUpdate("DELETE FROM Tarea WHERE fechaIni='" + fechaIni + "' AND IDtiempo='" + IDtiempo + "' ; ");
		conn.commit();
		stm.close();
		conn.close();

	}

	/**
	 * --------------------------------------------------------------
	 * ---------------------- Agente de Tareas ----------------------
	 * --------------------------------------------------------------
	 **/

	public ArrayList<Horario> selectHoraio() {
		try {
			String sql = "SELECT * FROM Horario ";
			Connection conn = DriverManager.getConnection(url);
			Statement stm = conn.createStatement();
			ResultSet res = stm.executeQuery(sql);

			ArrayList<Horario> lhorario = new ArrayList<>();
			Horario h = null;
			while (res.next()) {

				h = new Horario();

				h.setAo(res.getInt("ao"));
				h.setCuatri(res.getInt("cuatri"));
				h.setHoras(h.genArray((res.getString("horas"))));
				h.setLun(h.genArray((res.getString("lun"))));
				h.setMar(h.genArray((res.getString("mar"))));
				h.setMie(h.genArray((res.getString("mie"))));
				h.setJue(h.genArray((res.getString("jue"))));
				h.setVie(h.genArray((res.getString("vie"))));
				h.setSab(h.genArray((res.getString("sab"))));
				h.setDom(h.genArray((res.getString("dom"))));

				lhorario.add(h);
			}

			conn.commit();
			stm.close();
			conn.close();
			return lhorario;

		} catch (SQLException e) {
			Dialogos di = new Dialogos();
			di.dialogNoBD();
			return null;
		}
	}

	public void insertarHorario(Horario h) throws SQLException {
		int ao = h.getAo();
		int cuatri = h.getCuatri();

		String horas = h.genString(h.getHoras());
		String lun = h.genString(h.getLun());
		String mar = h.genString(h.getMar());
		String mie = h.genString(h.getMie());
		String jue = h.genString(h.getJue());
		String vie = h.genString(h.getVie());
		String sab = h.genString(h.getSab());
		String dom = h.genString(h.getDom());

		System.out.println(lun);

		String sql = "INSERT INTO Horario (ao, cuatri, horas, lun, mar, mie, jue, vie, sab, dom) VALUES " + "('" + ao
				+ "' , '" + cuatri + "' , '" + horas + "' , '" + lun + "' , '" + mar + "' , '" + mie + "' , '" + jue
				+ "' , '" + vie + "' , '" + sab + "' , '" + dom + "'  )";
		Connection conn = DriverManager.getConnection(url);
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
		conn.commit();
		stm.close();
		conn.close();
	}

	public void EliminarHorario(Horario h) throws SQLException {
		int ao = h.getAo();
		int cuatri = h.getCuatri();

		Connection conn = DriverManager.getConnection(url);
		Statement stm = conn.createStatement();
		stm.executeUpdate("DELETE FROM Horario WHERE ao='" + ao + "' AND cuatri='" + cuatri + "' ; ");
		conn.commit();
		stm.close();
		conn.close();

	}

}
