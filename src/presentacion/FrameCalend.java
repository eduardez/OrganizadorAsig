package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import persistencia.Agente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Tarea;
import dominio.metod;

import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

public class FrameCalend extends JFrame {

	private JPanel contentPane;

	// --------------- Variables del calendario ------------
	String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
			"Octubre", "Noviembre", "Diciembre" };
	public final static int finMes[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	protected int yy, mm, dd; // año dia y mes
	Calendar calendar = new GregorianCalendar();// Objeto calendario
	protected int diasIni = 0;// numero de dias vacios hasta primero de mes
	protected final int aoAct = calendar.get(Calendar.YEAR); // Conocer mes y año actuales
	protected final int mesAct = calendar.get(Calendar.MONTH);
	protected final int diaActual = calendar.get(calendar.DAY_OF_MONTH);
	protected JButton btnDias[][];// Botones como dias
	private int diaAct = -1;
	private JButton b0;// Boton de referencia para background
	private JLabel lblDiaNota;
	private JTable tabla7Dias;
	private JTextArea areaTareas;
	// ----------------------------------------------
	metod met = new metod();

	public FrameCalend() {

		setResizable(false);
		setTitle("Calendario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelFecha = new JPanel();
		panelFecha.setBorder(null);
		panelFecha.setBounds(0, 0, 364, 64);
		contentPane.add(panelFecha);
		panelFecha.setLayout(null);

		JButton btnHoy = new JButton("Hoy");
		btnHoy.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHoy.setBounds(7, 7, 96, 23);
		panelFecha.add(btnHoy);

		JLabel lblHoy = new JLabel("");
		lblHoy.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHoy.setHorizontalAlignment(SwingConstants.LEFT);
		lblHoy.setBounds(113, 7, 191, 23);
		panelFecha.add(lblHoy);

		JButton btnAoAtras = new JButton("<<");
		btnAoAtras.setBounds(7, 34, 49, 23);
		panelFecha.add(btnAoAtras);

		JButton btnMesAtras = new JButton("<");
		btnMesAtras.setBounds(62, 34, 41, 23);
		panelFecha.add(btnMesAtras);

		JLabel lblMesAo = new JLabel("");
		lblMesAo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMesAo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesAo.setBounds(114, 34, 139, 23);
		panelFecha.add(lblMesAo);

		JButton btnMesAlante = new JButton(">");
		btnMesAlante.setBounds(263, 34, 41, 23);
		panelFecha.add(btnMesAlante);

		JButton btnAoAlante = new JButton(">>");
		btnAoAlante.setBounds(308, 34, 49, 23);
		panelFecha.add(btnAoAlante);

		JPanel panelMes = new JPanel();
		panelMes.setBounds(0, 61, 364, 266);
		crearPanelMes(panelMes);
		contentPane.add(panelMes);

		JPanel panelCosas = new JPanel();
		panelCosas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cosas por hacer",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCosas.setBounds(369, 0, 364, 339);
		contentPane.add(panelCosas);
		panelCosas.setLayout(null);

		JLabel lblDentroDe = new JLabel("Dentro de 7 dias:");
		lblDentroDe.setBounds(10, 176, 96, 20);
		panelCosas.add(lblDentroDe);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 170, 339, 2);
		panelCosas.add(separator);

		lblDiaNota = new JLabel("Dia ");
		lblDiaNota.setBounds(10, 11, 270, 20);
		panelCosas.add(lblDiaNota);

		tabla7Dias = new JTable();
		tabla7Dias.setEnabled(false);
		tabla7Dias
				.setModel(
						new DefaultTableModel(
								new Object[][] { { null, null }, { null, null }, { null, null }, { null, null },
										{ null, null }, { null, null }, { null, null }, },
								new String[] { "New column", "New column" }));
		tabla7Dias.setBounds(10, 207, 344, 112);
		panelCosas.add(tabla7Dias);

		areaTareas = new JTextArea();
		areaTareas.setLineWrap(true);
		areaTareas.setEditable(false);
		areaTareas.setBounds(10, 31, 339, 105);
		panelCosas.add(areaTareas);

		JButton btnAnadir = new JButton("A\u00F1adir Evento");
		btnAnadir.setBounds(15, 142, 159, 23);
		panelCosas.add(btnAnadir);

		JButton btnEliminarEvento = new JButton("Eliminar Evento");
		btnEliminarEvento.setBounds(187, 142, 159, 23);
		panelCosas.add(btnEliminarEvento);

		JButton btnInfo = new JButton("");
		btnInfo.setBounds(329, 7, 25, 25);
		ImageIcon img = new ImageIcon(
				FrameCalend.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-confirm.png"));
		btnInfo.setIcon(met.resizeIcon(img, btnInfo.getWidth(), btnInfo.getHeight()));
		panelFecha.add(btnInfo);

		// ----------------------- Metodos -----------------------
		setYYMMDD(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		lblHoy.setText(dd + " de " + meses[mm] + ", " + yy);
		lblMesAo.setText(meses[mm] + " " + yy);

		calcDias();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					menuPrincipal men = new menuPrincipal();
					men.setVisible(true);
					men.setLocationRelativeTo(null);
				} catch (Exception e1) {
				}
			}
		});
		try {
			met.comprobarTareas(areaTareas, yy, mm, dd);
			met.dentro7dias(tabla7Dias);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnInfo.addActionListener(new ActionListener() {//Boton de info
			public void actionPerformed(ActionEvent e) {
				areaTareas.setText("Significado del color de las casillas \n·Azul: 3 eventos o menos \n·Amarillo: De 3 a 5 eventos \n·Rojo: Mas de 5 eventos");
			}
		});
		btnEliminarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					elimTarea eli = new elimTarea(met.comprobarTareas(null, yy, mm, dd));
					eli.setModal(true);
					eli.setLocationRelativeTo(null);
					eli.setVisible(true);
				} catch (SQLException ea) {

				}
			}
		});

		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertTarea ins = new insertTarea(dd + " de " + meses[mm] + ", " + yy);
				ins.setLocationRelativeTo(null);
				ins.setDia(yy, mm, dd);
				ins.setVisible(true);
				ins.setModal(true);
				repaint();
			}
		});

		btnHoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setYYMMDD(aoAct, mesAct, diaActual);
				calcDias();
				lblHoy.setText(dd + " de " + meses[mm] + ", " + yy);
				lblMesAo.setText(meses[mm] + " " + yy);

			}
		});

		btnMesAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (mm == 0) {
					mm = 11;
					yy -= 1;
				} else {
					mm -= 1;
				}
				lblMesAo.setText(meses[mm] + " " + yy);
				calcDias();
			}
		});

		btnMesAlante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mm == 11) {
					mm = 0;
					yy += 1;
				} else {
					mm += 1;
				}
				lblMesAo.setText(meses[mm] + " " + yy);
				calcDias();
			}
		});

		btnAoAlante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yy += 1;

				lblMesAo.setText(meses[mm] + " " + yy);
				calcDias();
			}
		});
		btnAoAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yy -= 1;

				lblMesAo.setText(meses[mm] + " " + yy);
				calcDias();
			}
		});
	}

	private void crearPanelMes(JPanel panelMes) {
		panelMes.setLayout(new GridLayout(7, 7));
		btnDias = new JButton[6][7]; // primera columna como nombre de los dias

		panelMes.add(b0 = new JButton("L"));
		b0.setForeground(Color.black);
		b0.setBackground(new Color(136, 208, 247));
		JButton button = new JButton("M");
		button.setForeground(Color.BLACK);
		button.setBackground(new Color(136, 208, 247));
		panelMes.add(button);
		JButton button_1 = new JButton("X");
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(new Color(136, 208, 247));
		panelMes.add(button_1);
		JButton button_2 = new JButton("J");
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(new Color(136, 208, 247));
		panelMes.add(button_2);
		JButton button_3 = new JButton("V");
		button_3.setForeground(Color.BLACK);
		button_3.setBackground(new Color(136, 208, 247));
		panelMes.add(button_3);
		JButton button_4 = new JButton("S");
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBackground(new Color(73, 29, 196));
		panelMes.add(button_4);
		JButton button_5 = new JButton("D");
		button_5.setForeground(new Color(255, 255, 255));
		button_5.setBackground(new Color(73, 29, 196));
		panelMes.add(button_5);
		ActionListener dateSetter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = e.getActionCommand();
				if (!num.equals("")) {
					setDiaAct(Integer.parseInt(num));
				}
			}
		};
		// Construir todos los botones y añadirlos
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++) {
				panelMes.add(btnDias[i][j] = new JButton(""));
				btnDias[i][j].addActionListener(dateSetter);
			}

		getContentPane().add(BorderLayout.SOUTH, panelMes);
		for (int i = 0; i < btnDias.length; i++) {
			for (int j = 0; j < btnDias[i].length; j++) {
				btnDias[i][j].setBackground(Color.white);
				btnDias[i][j].setVisible(false);
			}
		}
	}

	public boolean aoBisiesto(int ao) { // Devuelve true si el año es bisiesto
		if (ao % 4 == 0 && ao % 100 != 0 || ao % 400 == 0)
			return true;
		return false;
	}

	private void setYYMMDD(int ao, int mes, int hoy) {
		yy = ao;
		mm = mes;
		dd = hoy;
	}

	protected void calcDias() {
		deselecDia();
		calendar = new GregorianCalendar(yy, mm, dd);

		// calcular cuantos botones hay antes del 1 del mes
		diasIni = new GregorianCalendar(yy, mm, 0).get(Calendar.DAY_OF_WEEK) - 1;

		int totalDias = finMes[mm];
		if (aoBisiesto(calendar.get(Calendar.YEAR)) && mm == 1)
			++totalDias;

		// dejar vacios los dias de antes de primero de mes
		for (int i = 0; i < diasIni; i++) {
			btnDias[0][i].setText("");
			btnDias[0][i].setVisible(false);
		}

		// Rellena los dias del mes con sus numeros
		for (int i = 1; i <= totalDias; i++) {
			JButton b = btnDias[(diasIni + i - 1) / 7][(diasIni + i - 1) % 7];
			if (met.comprobarTareasMes(yy, mm, i)) {
				try {
					ArrayList<Tarea> tar = met.comprobarTareas(null, yy, mm, i);
					String tareasJibiri = "";
					for (int jibiri = 0; jibiri < tar.size(); jibiri++) {
						tareasJibiri += tar.get(jibiri).getTexto() + ", ";
					}
					b.setToolTipText(tareasJibiri);
					// poner color
					if (tar.size() <= 3) {
						b.setBackground(new Color(142, 255, 165));
					} else if (tar.size() > 3 && tar.size() <= 5) {
						b.setBackground(new Color(255, 255, 117));
					} else if (tar.size() > 5) {
						b.setBackground(new Color(255, 68, 85));
					}
					b.setForeground(Color.black);
					b.setFont(new Font("Tahoma", Font.BOLD, 13));
				} catch (SQLException e) {

				}

			} else {
				b.setForeground(Color.black);
				b.setBackground(Color.WHITE);
				b.setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
			b.setText(Integer.toString(i));
			b.setVisible(true);
		}

		// 7 dias/semana * 6 filas
		for (int i = diasIni + totalDias; i < 6 * 7; i++) {
			btnDias[(i) / 7][(i) % 7].setVisible(false);
		}

		// Si es el mes actual
		if (aoAct == yy && mm == mesAct)
			setDiaAct(dd); // Oculta box de hoy

		// Actualizar
		repaint();
	}

	private void deselecDia() {
		JButton b;

		// desseleccionar el que ya este seleccionado
		if (diaAct > 0) {
			b = btnDias[(diasIni + diaAct - 1) / 7][(diasIni + diaAct - 1) % 7];
			int diaViejo = Integer.valueOf(b.getText());
			if (met.comprobarTareasMes(yy, mm, diaViejo)) {// Comprobar si tiene tareas
				try {
					ArrayList<Tarea> tar = met.comprobarTareas(null, yy, mm, diaViejo);
					String tareasJibiri = "";
					for (int jibiri = 0; jibiri < tar.size(); jibiri++) {
						tareasJibiri += tar.get(jibiri).getTexto() + ", ";
					}
					b.setToolTipText(tareasJibiri);
					// poner color
					if (tar.size() <= 3) {
						b.setBackground(new Color(142, 255, 165));
					} else if (tar.size() > 3 && tar.size() <= 5) {
						b.setBackground(new Color(255, 255, 117));
					} else if (tar.size() > 5) {
						b.setBackground(new Color(255, 68, 85));
					}
					b.setForeground(Color.black);
					b.setFont(new Font("Tahoma", Font.BOLD, 13));
				} catch (SQLException e) {

				}

			} else {
				b.setForeground(Color.black);
				b.setBackground(Color.WHITE);
				b.setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
			b.repaint();
			diaAct = -1;
		}

	}

	public void setDiaAct(int auxDia) {

		deselecDia();
		// Seleccionar el nuevo dia
		if (auxDia <= 0)
			dd = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		else
			dd = auxDia;
		// Shade el cuadrado del dia
		Component square = btnDias[(diasIni + auxDia - 1) / 7][(diasIni + auxDia - 1) % 7];
		square.setBackground(new Color(136, 208, 247));
		square.repaint();
		diaAct = auxDia;
		lblDiaNota.setText(dd + " de " + meses[mm] + ", " + yy);
		try {
			met.comprobarTareas(areaTareas, yy, mm, dd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
