package persistencia;
import java.sql.*;
import java.util.ArrayList;

import dominio.Asignatura;
import dominio.Dialogos;

public class Agente {
	
	private final String url = "jdbc:ucanaccess://resources\\Asignaturas.accdb";

	public Agente() throws SQLException {
	}

	public ArrayList<Asignatura> selectAsignaturas() {
		try {
		String sql = "SELECT * FROM Asignatura ";
		Connection conn = DriverManager.getConnection(url);
		Statement stm = conn.createStatement();
		ResultSet res = stm.executeQuery(sql);

		ArrayList<Asignatura> lasig= new ArrayList<>();
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
		
		}catch(SQLException e) {
			Dialogos di=new Dialogos();
			di.dialogNoBD();
			return null;
		}
	}
	

	public void insertarAsig(Asignatura a) throws SQLException {
		String nombre;
		boolean global;
		double textNota1, textNota1Por, textNota2, textNota2Por, textNotaLab, textNotaLabPor, textNotaPar,
				textNotaParPor, textNotaTeorico, textNotaTeoricoPor, textOtros, textOtrosPor;
		int ao,curso;
		nombre = a.getNombre();
		global = a.isGlobal();
		textNota1 = a.getNota1();
		textNota2 = a.getNota2();
		textNota1Por = a.getNota1Por();
		textNota2Por = a.getNota2Por();
		textNotaLab=a.getNotaLab();
		textNotaLabPor=a.getNotaLabPor();
		textNotaPar=a.getNotaPar();
		textNotaParPor=a.getNotaParPor();
		textNotaTeorico=a.getNotaTeorico();
		textNotaTeoricoPor=a.getNotaTeoricoPor();
		textOtros=a.getOtros();
		textOtrosPor=a.getOtrosPor();
		ao=a.getAo();
		curso=a.getCurso();
		System.out.println(a.toString());

		String sql = "INSERT INTO Asignatura (Nombre, global, Parcial1, porp1, parcial2, porp2, lab, labpor, particip, particippor, trabteo, trabtpor, otros, otrospor, ao, curso) VALUES "
				+ "('"+ nombre +"' , "+ global +" , '" + textNota1 + "' , '" + textNota1Por
				+ "' , '" + textNota2 + "' , '" + textNota2Por + " ', '" + textNotaLab + "' , '" + textNotaLabPor + "' ,'" + textNotaPar
				+ "' , '" + textNotaParPor + "' , '" + textNotaTeorico + "' , '" + textNotaTeoricoPor + "' , '" + textOtros + "' , '" + textOtrosPor + "', '" + ao + "', '"+curso+"'  )";
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
		ao=a.getAo();
		Connection conn = DriverManager.getConnection(url);
		Statement stm = conn.createStatement();
		stm.executeUpdate("DELETE FROM Asignatura WHERE nombre='" + nombre + "' AND ao='"+ao+"' ; ");
		conn.commit();
		stm.close();
		conn.close();
		
	}


}
