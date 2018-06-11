package dominio;

import java.awt.Color;
import java.awt.Component;
import java.awt.TextArea;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import persistencia.Agente;
import presentacion.notasCurso;

public class metod {

	// ----------------------------- Gestion Tabla ------------------------

	public void modTabla(JTable tablaNotas, ArrayList<Asignatura> asigArray, JTextArea textDebug) {
		try {

			cleanTabla(tablaNotas);
			Collections.sort(asigArray, Asignatura.getCompNombre());
			for (int i = 0; i < asigArray.size(); i++) {
				tablaNotas.getModel().setValueAt(asigArray.get(i).getNombre(), i, 0);
				tablaNotas.getModel().setValueAt(asigArray.get(i).getNota1(), i, 1);
				tablaNotas.getModel().setValueAt(asigArray.get(i).getNota2(), i, 2);
				tablaNotas.getModel().setValueAt(asigArray.get(i).getNotaLab(), i, 3);
				tablaNotas.getModel().setValueAt(asigArray.get(i).getNotaPar(), i, 4);
				tablaNotas.getModel().setValueAt(asigArray.get(i).getNotaTeorico(), i, 5);
				tablaNotas.getModel().setValueAt(asigArray.get(i).getOtros(), i, 6);
				double total = calcTotal(asigArray.get(i));
				tablaNotas.getModel().setValueAt(total, i, 7);

			}
			customTabla(tablaNotas);

		} catch (ArrayIndexOutOfBoundsException e) {
			textDebug.setText("Selecciona un año.\n");
			cleanTabla(tablaNotas);
		}
	}

	public void customTabla(JTable tablaNotas) {
		CustomTableCellRenderer colorTotal = new CustomTableCellRenderer();
		colorTotal.setForeground(Color.RED);
		colorTotal.setHorizontalAlignment(SwingConstants.CENTER);
			for (int i = 0; i < tablaNotas.getModel().getColumnCount(); i++) {
				tablaNotas.getColumnModel().getColumn(i).setCellRenderer(colorTotal);
		}
	}

	public void cleanTabla(JTable tablaNotas) {
		for (int j = 0; j < tablaNotas.getModel().getRowCount(); j++) {
			for (int i = 0; i < tablaNotas.getModel().getColumnCount(); i++) {
				tablaNotas.getModel().setValueAt("", j, i);
			}
		}
	}

	public void tablaCurso(JTable tab, int curso) throws Exception {
		ArrayList<Asignatura> asig = getAsig();
		ArrayList<Asignatura> asigAprob = new ArrayList<Asignatura>();
		for (int i = 0; i < asig.size(); i++) {
			if (asig.get(i).getCurso() == curso) { // Si pertenece a ese curso
				if (!asigAprob.contains(asig.get(i))) { // El array no la contiene
					if (masDeUnCuatro(asig.get(i))) { // Ha superado con mas de un 4 lo obligatorio

						asigAprob.add(asig.get(i));

					}
				}
			}
		}
		// Meter en la tabla
		for (int i = 0; i < asigAprob.size(); i++) {
			System.out.println(asigAprob.get(i).getNombre() + "  |  " + calcTotal(asigAprob.get(i)));

		}
		if (asigAprob.size() > 0) {
			for (int i = 0; i < asigAprob.size() && i < 10; i++) {
				tab.getModel().setValueAt(asigAprob.get(i).getNombre(), i, 0);
				tab.getModel().setValueAt(calcTotal(asigAprob.get(i)), i, 1);

			}
		} else {
			tab.setValueAt("No se hacursado", 0, 0);
			tab.setValueAt(" ninguna asignatura", 0, 1);
		}

	}

	// ---------------------- Gestion Cajas -------------------

	public JComboBox updateBox(JComboBox caja, String[] valores) throws Exception {
		caja.removeAllItems();
		ArrayList<String> val=new ArrayList<String>();
		for(int i=0;i<valores.length;i++)val.add(valores[i]);
		val.sort(null);
		for (int i = 0; i < valores.length; i++)
			caja.addItem(val.get(i));
		
		return caja;
	}

	public void otrasOp(JComboBox cajaOtros) throws Exception {
		int opt = cajaOtros.getSelectedIndex();
		System.out.println(opt);
		switch (opt) {
		case 0:
			break;
		case 1:
			notasCurso not = new notasCurso();
			not.setVisible(true);
			break;
		}
	}

	// ------------------------ Calculos ----------------------

	public boolean compPor(JTextField[] por, TextArea debug) {
		boolean bien = true;
		int suma = 0;
		for (int i = 0; i < por.length && bien; i++) {
			if (por[i].getText().equals(""))
				bien = false;
			suma += Integer.valueOf(por[i].getText());
		}
		if (!(suma == 100)) {
			debug.append("Suma de porcentajes: " + suma + "\n");
			bien = false;
		}

		return bien;
	}

	public boolean masDeUnCuatro(Asignatura a) {
		boolean superado = false;
		if (a.isGlobal()) {
			if (a.getNota1() >= 4 && a.getNotaLab() >= 4) {
				superado = true;
			}
		} else if (a.getNota1() >= 4 && a.getNotaLab() >= 4 && a.getNota2() >= 4) {
			superado = true;
		}
		return superado;
	}

	private double calcTotal(Asignatura asignatura) {
		double tot = 0;
		Double n1 = asignatura.getNota1();
		Double n1p = asignatura.getNota1Por() / 100;
		Double n2 = asignatura.getNota2();
		Double n2p = asignatura.getNota2Por() / 100;
		Double nL = asignatura.getNotaLab();
		Double nLp = asignatura.getNotaLabPor() / 100;
		Double nP = asignatura.getNotaPar();
		Double nPp = asignatura.getNotaParPor() / 100;
		Double nO = asignatura.getOtros();
		Double nOp = asignatura.getOtrosPor() / 100;
		Double nT = asignatura.getNotaTeorico();
		Double nTp = asignatura.getNotaTeoricoPor() / 100;
		tot = ((n1 * n1p) + (n2 * n2p) + (nL * nLp) + (nP * nPp) + (nO * nOp) + (nT * nTp));
		tot = (double) Math.round(tot * 100d) / 100d;

		return tot;
	}

	// ------------------- Actualizar Vectores ----------------

	public String[] aosAsig(ArrayList<Asignatura> asig) throws Exception {
		ArrayList<String> Ayears = new ArrayList<String>();
		for (int i = 0; i < asig.size(); i++) {
			if (!Ayears.contains(String.valueOf(asig.get(i).getAo()))) {
				Ayears.add(String.valueOf(asig.get(i).getAo()));
			}
		}
		Ayears.sort(Collections.reverseOrder());
		String[] years = new String[Ayears.size() + 1];
		years[0] = "- Año -";
		for (int i = 1; i < years.length; i++)
			years[i] = Ayears.get(i - 1);
		return years;
	}

	public String[] todasAsig() throws Exception {
		ArrayList<Asignatura> a = getAsig();
		String[] nombres = new String[a.size()];
		for (int i = 0; i < a.size(); i++)
			nombres[i] = a.get(i).getNombre() + " - " + String.valueOf(a.get(i).getAo());
		return nombres;
	}

	public String[] nomAsig(ArrayList<Asignatura> a) throws Exception {

		String[] nombres = new String[a.size()];
		for (int i = 0; i < a.size(); i++)
			nombres[i] = a.get(i).getNombre() + " - " + String.valueOf(a.get(i).getAo());
		return nombres;
	}

	public ArrayList<Asignatura> getAsig() throws Exception {
		Agente ag = new Agente();
		return ag.selectAsignaturas();
	}

	public ArrayList<Asignatura> ActAsig(JComboBox cajaAsig, ArrayList<Asignatura> asigArray, JComboBox cajaAo)
			throws Exception {
		int index = cajaAo.getSelectedIndex();
		ArrayList<Asignatura> allAsig = getAsig();
		ArrayList<Asignatura> nuovoAsig = new ArrayList<Asignatura>();

		String ao = (String) cajaAo.getItemAt(index);
		if (ao.equals("- Año -")) {
			nuovoAsig = allAsig;
		} else {
			for (int i = 0; i < allAsig.size(); i++) {
				if (String.valueOf(allAsig.get(i).getAo()).equals(ao)) {
					nuovoAsig.add(allAsig.get(i));
				}
			}
		}
		cajaAsig = updateBox(cajaAsig, nomAsig(nuovoAsig));
		return nuovoAsig;
	}
	// ---------------------- Otros Metodos -------------------
	
	public boolean comprobAsig(Asignatura a) throws Exception {
		boolean esta=false;
		ArrayList<Asignatura> todas=getAsig();
		
		for(int i=0;i<todas.size() && !esta;i++) {
			if(todas.get(i).getNombre().equals(a.getNombre())&&todas.get(i).getAo()==a.getAo()) {
				esta=true;
				System.out.println("Cuidadoooooorrr");
			}
		}
		
		return !esta;
	}

}
