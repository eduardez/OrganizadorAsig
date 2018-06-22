package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Horario;
import dominio.metod;
import persistencia.Agente;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class frameHorario extends JFrame {

	private JPanel contentPane;
	private JTable tablaHorario;
	private JPanel panelHor;
	private int cuatriSelecc;
	private int aoSelecc;
	private metod met = new metod();
	private ArrayList<Horario> HORARIO;
	private String[] dias = { "Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameHorario frame = new frameHorario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frameHorario() {
		setTitle("Horario");
		/*
		 * addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosed(WindowEvent arg0) { try { menuPrincipal
		 * prin = new menuPrincipal(); prin.setVisible(true);
		 * prin.setLocationRelativeTo(null); } catch (Exception e) { } } });
		 */
		try {// El buen look an fil
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 787, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelHor = new JPanel();
		panelHor.setBounds(10, 11, 761, 382);
		contentPane.add(panelHor);

		try {
			Agente ag = new Agente();
			HORARIO = ag.selectHoraio();
		} catch (Exception e) {

		}

		// ------------------- LA TABLA -------------------
		tablaHorario = new JTable();
		tablaHorario.setRowSelectionAllowed(false);
		tablaHorario.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tablaHorario.setShowVerticalLines(false);
		tablaHorario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaHorario.setCellSelectionEnabled(true);
		tablaHorario.setModel(new DefaultTableModel(crearTabla(), dias));
		resizeTabla(tablaHorario, panelHor);

		JPanel panelCuatri = new JPanel();
		panelCuatri.setBounds(241, 415, 300, 41);
		contentPane.add(panelCuatri);
		panelCuatri.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btn1cuatri = new JButton("1\u00BA Cuatrimestre");
		panelCuatri.add(btn1cuatri);

		JButton btn2cuatri = new JButton("2\u00BA Cuatrimestre");
		panelCuatri.add(btn2cuatri);

		JComboBox cmbAo = new JComboBox();
		int[] aos = met.getAoHor();
		Arrays.sort(aos);
		String[] a = Arrays.toString(aos).split("[\\[\\]]")[1].split(", ");
		cmbAo.setModel(new DefaultComboBoxModel(a));
		cmbAo.setBounds(31, 420, 129, 30);
		contentPane.add(cmbAo);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(602, 395, 154, 84);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnGuard = new JButton("Guardar Cambios");
		btnGuard.setBounds(10, 6, 134, 23);
		panel.add(btnGuard);

		JButton btnAadirHorario = new JButton("A\u00F1adir Horario");
		btnAadirHorario.setBounds(10, 30, 134, 23);
		panel.add(btnAadirHorario);
		
		JButton btnElimHor = new JButton("Eliminar Horario");
		btnElimHor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Agente ag=new Agente();
					ag.EliminarHorario(met.getHor(aoSelecc, cuatriSelecc));
				}catch(Exception e) {
					
				}
			}
		});
		btnElimHor.setBounds(10, 54, 134, 23);
		panel.add(btnElimHor);


		// ------ Acciones ---------------
		aoSelecc=Integer.valueOf(cmbAo.getSelectedItem().toString());
		met.compCuatri(aoSelecc, cuatriSelecc);

		cmbAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoSelecc=Integer.valueOf(cmbAo.getSelectedItem().toString());
				modTabla(tablaHorario, met.getHor(aoSelecc, cuatriSelecc));
			}
		});
		btnGuard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Agente ag = new Agente();
					ag.insertarHorario(modHorario(tablaHorario));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnAadirHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				dialogHorario di=new dialogHorario();
				di.setVisible(true);
				
			}
		});
		btn1cuatri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuatriSelecc = 1;
			}
		});

		btn2cuatri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuatriSelecc = 2;
			}
		});
	}


	protected void modTabla(JTable tab, Horario h) {
		int rows = h.getHoras().length;
		int dias = 8;
		Object[][] tabla = new Object[rows][dias];
		String[] diasa = { "Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };

		for (int i = 0; i < rows; i++) {
			tabla[i][0] = h.getHoras()[i];
			tabla[i][1] = h.getLun()[i];
			tabla[i][2] = h.getMar()[i];
			tabla[i][3] = h.getMie()[i];
			tabla[i][4] = h.getJue()[i];
			tabla[i][5] = h.getVie()[i];
			tabla[i][6] = h.getSab()[i];
			tabla[i][7] = h.getDom()[i];

		}
		tablaHorario.setModel(new DefaultTableModel(tabla, diasa));

	}

	protected Horario modHorario(JTable tabHor) {
		int tam = HORARIO.get(cuatriSelecc).getHoras().length;
		Horario hor = new Horario();
		hor.setAo(HORARIO.get(cuatriSelecc).getAo());
		String[] datos = new String[tam];
		for (int x = 0; x < dias.length; x++) {
			for (int y = 0; y < tam; y++) {// Hay que hacer el cuatriSelecc ya que HORARIOS solo tiene los dos horarios
											// de un año
				datos[y]=tabHor.getModel().getValueAt(y, x).toString();
				System.out.println(datos[y]);
			}
			switch(x) {
			case 0: 
				hor.setHoras(datos);
				break;
			case 1: 
				hor.set
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				break;
			case 7: 
				break;
			}
			datos = new String[tam];
		}
		return hor;
	}

	public void genHorarioBlanco(int ao, int cuatri, int filas) {
		Horario hor = new Horario();
		hor.setAo(ao);
		hor.setCuatri(cuatri);

		String[] arr = new String[filas];
		for (int i = 0; i < filas; i++)
			arr[i] = " ";

		hor.setHoras(arr);
		hor.setLun(arr);
		hor.setMar(arr);
		hor.setMie(arr);
		hor.setJue(arr);
		hor.setVie(arr);
		hor.setSab(arr);
		hor.setDom(arr);

		Agente ag;
		try {
			ag = new Agente();
			ag.insertarHorario(hor);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void resizeTabla(JTable tab, JPanel pan) {// Te quiero idiota
		panelHor.setLayout(new BorderLayout(0, 0));
		// --- Header ---
		int gordoHeader = 40;
		tab.getTableHeader().setPreferredSize(new Dimension(pan.getWidth(), gordoHeader));
		pan.add(tab.getTableHeader(), BorderLayout.NORTH);
		// --- Tabla inf ---
		int tam = ((pan.getHeight() - gordoHeader - 1) / tab.getRowCount());
		tab.setRowHeight(tam);
		pan.add(tab);

	}

	public Object[][] crearTabla() {
		int rows = 7;
		int dias = 8;
		Object[][] tabla = new Object[rows][dias];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < dias; j++) {
				tabla[i][j] = "polla";
			}
		}
		return tabla;

	}
}
