package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import dominio.Asignatura;
import dominio.metod;
import persistencia.Agente;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class menuPrincipal extends JFrame {

	private JPanel contentPane;
	private Asignatura a;
	static menuPrincipal frame;
	private String[] asigNombre;
	public ArrayList<Asignatura> asigArray;
	private JTable table;
	private JTable tablaNotas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new menuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public menuPrincipal() throws Exception {
		asigNombre = todasAsig();
		asigArray = getAsig();
		metod met = new metod();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JComboBox cajaAsig = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.EAST, cajaAsig, -10, SpringLayout.EAST, contentPane);
		cajaAsig.setModel(new DefaultComboBoxModel(asigNombre));
		contentPane.add(cajaAsig);

		JButton botonNuevAsig = new JButton("A\u00F1adir Asignatura");
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonNuevAsig, 1, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonNuevAsig, -10, SpringLayout.EAST, contentPane);

		contentPane.add(botonNuevAsig);

		JButton botonEditAsig = new JButton("Editar Asignatura");
		sl_contentPane.putConstraint(SpringLayout.WEST, botonEditAsig, 559, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, botonEditAsig, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, cajaAsig, 6, SpringLayout.SOUTH, botonEditAsig);
		sl_contentPane.putConstraint(SpringLayout.NORTH, botonEditAsig, 6, SpringLayout.SOUTH, botonNuevAsig);
		contentPane.add(botonEditAsig);

		JLabel lblCurso = new JLabel("Curso:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCurso, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCurso, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblCurso);

		JComboBox cajaAo = new JComboBox();
		cajaAo.setModel(new DefaultComboBoxModel(met.aosAsig(asigArray)));
		sl_contentPane.putConstraint(SpringLayout.WEST, botonNuevAsig, 416, SpringLayout.EAST, cajaAo);
		sl_contentPane.putConstraint(SpringLayout.WEST, cajaAo, 19, SpringLayout.EAST, lblCurso);
		sl_contentPane.putConstraint(SpringLayout.EAST, cajaAo, -575, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, cajaAo, -3, SpringLayout.NORTH, lblCurso);
		contentPane.add(cajaAo);

		JButton btnAct = new JButton("Actualizar Notas");

		sl_contentPane.putConstraint(SpringLayout.EAST, btnAct, -273, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, cajaAsig, 114, SpringLayout.EAST, btnAct);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAct, 291, SpringLayout.WEST, contentPane);
		contentPane.add(btnAct);

		JTextArea textDebug = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAct, -334, SpringLayout.NORTH, textDebug);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textDebug, -40, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, textDebug, 109, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textDebug, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textDebug, -98, SpringLayout.EAST, contentPane);
		contentPane.add(textDebug);

		tablaNotas = new JTable();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tablaNotas, 138, SpringLayout.NORTH, contentPane);
		tablaNotas.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "Asignatura", "P1 / Global", "P2", "Laboratorio", "Participacion", "Trabajo Teorico",
						"Otros", "Total" }));
		met.customTabla(tablaNotas);
		
		sl_contentPane.putConstraint(SpringLayout.WEST, tablaNotas, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tablaNotas, -50, SpringLayout.SOUTH, textDebug);
		sl_contentPane.putConstraint(SpringLayout.EAST, tablaNotas, -15, SpringLayout.EAST, contentPane);
		tablaNotas.setColumnSelectionAllowed(true);
		tablaNotas.setCellSelectionEnabled(true);
		contentPane.add(tablaNotas);

		JLabel lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAsignatura, 0, SpringLayout.WEST, tablaNotas);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAsignatura, 85, SpringLayout.WEST, tablaNotas);
		lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblAsignatura, 0, SpringLayout.NORTH, tablaNotas);
		contentPane.add(lblAsignatura);

		JLabel lblglob = new JLabel("P1 / Global");
		lblglob.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblglob, 0, SpringLayout.NORTH, lblAsignatura);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblglob, 0, SpringLayout.EAST, lblAsignatura);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblglob, 85, SpringLayout.EAST, lblAsignatura);
		lblglob.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblglob);

		JLabel lblP = new JLabel("P2");
		lblP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblP, 0, SpringLayout.EAST, lblglob);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblP, 85, SpringLayout.EAST, lblglob);
		lblP.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblP, 0, SpringLayout.NORTH, lblAsignatura);
		contentPane.add(lblP);

		JLabel lblLaboratorio = new JLabel("Laboratorio");
		lblLaboratorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLaboratorio.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLaboratorio, 0, SpringLayout.NORTH, lblAsignatura);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblLaboratorio, 0, SpringLayout.EAST, lblP);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblLaboratorio, 85, SpringLayout.EAST, lblP);
		contentPane.add(lblLaboratorio);

		JLabel lblParticipacion = new JLabel("Participacion");
		lblParticipacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblParticipacion, 0, SpringLayout.EAST, lblLaboratorio);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblParticipacion, 85, SpringLayout.EAST, lblLaboratorio);
		lblParticipacion.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblParticipacion, 0, SpringLayout.NORTH, lblAsignatura);
		contentPane.add(lblParticipacion);

		JLabel lblteo = new JLabel("Trab. Teorico");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblteo, 90, SpringLayout.EAST, lblParticipacion);
		lblteo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblteo.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblteo, 0, SpringLayout.NORTH, lblAsignatura);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblteo, 0, SpringLayout.EAST, lblParticipacion);
		contentPane.add(lblteo);

		JLabel lblOtros = new JLabel("Otros");
		lblOtros.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblOtros.setEnabled(true);
		lblOtros.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOtros, 0, SpringLayout.EAST, lblteo);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblOtros, 0, SpringLayout.NORTH, tablaNotas);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblOtros, 85, SpringLayout.EAST, lblteo);
		contentPane.add(lblOtros);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTotal, 0, SpringLayout.EAST, lblOtros);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTotal, 0, SpringLayout.SOUTH, lblAsignatura);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTotal, 85, SpringLayout.EAST, lblOtros);
		contentPane.add(lblTotal);

		// ------------------------------------------ Acciones
		// ------------------------------------------
		btnAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				met.modTabla(tablaNotas, asigArray, textDebug);
			}
		});

		botonEditAsig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int inde = cajaAsig.getSelectedIndex();
					EditAsignatura e = new EditAsignatura(cajaAsig,
							asigArray.get(inde).getNombre() + " - " + asigArray.get(inde).getAo(), asigArray, cajaAo);
					e.setAsig(asigArray.get(inde));
					e.setVisible(true);
				} catch (IndexOutOfBoundsException e) {
					textDebug.append("Problema de indices en el array de asignaturas. \nCambia de año y solucionao\n");
				} catch (Exception e) {
					textDebug.append("Ha pasado algo, algo malo, pero tranquilo, que el mundo no av a explotar.\n");
				}
			}
		});
		botonNuevAsig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaAsig nu;
				try {
					nu = new nuevaAsig(cajaAsig, asigArray, cajaAo);
					nu.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		cajaAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					updateAsig(cajaAsig, asigArray, cajaAo, met);
					met.modTabla(tablaNotas, asigArray, textDebug);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void updateAsig(JComboBox cajaAsig, ArrayList<Asignatura> asigArray1, JComboBox cajaAo, metod met)
			throws Exception {
		asigArray = met.ActAsig(cajaAsig, asigArray1, cajaAo);
		for (int i = 0; i < asigArray.size(); i++)
			System.out.println(asigArray.get(i).getNombre());
	}

		// ------------------------------------------ METODOS  ------------------------------------------

	private String[] todasAsig() throws Exception {
		ArrayList<Asignatura> a = getAsig();
		String[] nombres = new String[a.size()];
		for (int i = 0; i < a.size(); i++)
			nombres[i] = a.get(i).getNombre() + " - " + String.valueOf(a.get(i).getAo());
		return nombres;
	}

	public ArrayList<Asignatura> getAsig() throws Exception {
		Agente ag = new Agente();
		return ag.selectAsignaturas();
	}
}
