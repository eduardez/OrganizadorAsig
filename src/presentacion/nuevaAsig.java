package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dominio.Asignatura;
import dominio.Dialogos;
import dominio.metod;
import net.miginfocom.swing.MigLayout;
import persistencia.Agente;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class nuevaAsig extends JFrame {

	private JPanel contentPane;
	private JTextField textNota1;
	private JTextField textNotaLab;
	private JTextField textNotaPar;
	private JTextField textNotaTeorico;
	private JCheckBox boolGlobal;
	private JTextField textNota2;
	private JTextField textOtros;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNotaParticipacion;
	private JLabel lblNewLabel_2;
	private JLabel lblOtrasNotas;
	private JTextField textNota1Por;
	private JTextField textNota2Por;
	private JTextField textNotaLabPor;
	private JTextField textNotaParPor;
	private JTextField textNotaTeoricoPor;
	private JTextField textOtrosPor;
	private JLabel lblPorcentaje;
	private TextArea debug;
	private JLabel lblNombreAsignatura;
	private JTextField textNombre;
	private JTextField textAo;
	private JLabel lblAo;
	private JTextField textCurso;
	private JLabel lblCurso;

	public nuevaAsig(JComboBox cajaAsig, ArrayList<Asignatura> asigArray, JComboBox cajaAo) throws SQLException {

		metod met = new metod();
		Dialogos di = new Dialogos();
		Agente ag = new Agente();

		setTitle("A\u00F1adir asignatura");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 508);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,left][grow,center][][grow,right]",
				"[][][][][][][][][][][][][][][][][][grow]"));

		lblNombreAsignatura = new JLabel("Nombre Asignatura:");
		lblNombreAsignatura.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNombreAsignatura, "cell 0 1,alignx trailing");

		textNombre = new JTextField();
		contentPane.add(textNombre, "cell 1 1 3 1,growx");
		textNombre.setColumns(10);

		lblAo = new JLabel("A\u00F1o:");
		contentPane.add(lblAo, "cell 0 2,alignx right");

		textAo = new JTextField();
		contentPane.add(textAo, "cell 1 2,growx");
		textAo.setColumns(10);

		lblCurso = new JLabel("Curso:");
		lblCurso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurso.setEnabled(true);
		contentPane.add(lblCurso, "cell 2 2,alignx trailing");

		textCurso = new JTextField();
		contentPane.add(textCurso, "cell 3 2,growx");
		textCurso.setColumns(10);

		lblPorcentaje = new JLabel("Porcentaje ( % )");
		contentPane.add(lblPorcentaje, "cell 3 3,alignx center");

		lblNewLabel = new JLabel("Nota Examen:");
		contentPane.add(lblNewLabel, "cell 0 4,alignx right");

		textNota1 = new JTextField();
		textNota1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNota1, "cell 1 4,growx");
		textNota1.setColumns(10);

		boolGlobal = new JCheckBox("Examen Global");
		boolGlobal.setBackground(new Color(230, 230, 250));
		boolGlobal.setForeground(Color.BLACK);

		textNota1Por = new JTextField();
		textNota1Por.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNota1Por, "cell 3 4,growx");
		textNota1Por.setColumns(10);
		boolGlobal.setHorizontalAlignment(SwingConstants.RIGHT);
		boolGlobal.setToolTipText("Marcar si la asignatura tiene un \u00FAnico examen global");
		contentPane.add(boolGlobal, "cell 0 5,alignx right");

		textNota2 = new JTextField();
		textNota2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNota2, "cell 1 5,growx");
		textNota2.setColumns(10);

		textNota2Por = new JTextField();
		textNota2Por.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNota2Por, "cell 3 5,growx");
		textNota2Por.setColumns(10);

		lblNewLabel_1 = new JLabel("Nota Laboratorio:");
		contentPane.add(lblNewLabel_1, "cell 0 7,alignx right");

		textNotaLab = new JTextField();
		textNotaLab.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaLab, "cell 1 7,growx");
		textNotaLab.setColumns(10);

		textNotaLabPor = new JTextField();
		textNotaLabPor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaLabPor, "cell 3 7,growx");
		textNotaLabPor.setColumns(10);

		lblNotaParticipacion = new JLabel("Nota Participacion:");
		contentPane.add(lblNotaParticipacion, "cell 0 8,alignx right");

		textNotaPar = new JTextField();
		textNotaPar.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaPar, "cell 1 8,growx");
		textNotaPar.setColumns(10);

		textNotaParPor = new JTextField();
		textNotaParPor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaParPor, "cell 3 8,growx");
		textNotaParPor.setColumns(10);

		lblNewLabel_2 = new JLabel("Nota Trabajo Teorico:");
		contentPane.add(lblNewLabel_2, "cell 0 9,alignx right");

		textNotaTeorico = new JTextField();
		textNotaTeorico.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaTeorico, "cell 1 9,growx");
		textNotaTeorico.setColumns(10);

		textNotaTeoricoPor = new JTextField();
		textNotaTeoricoPor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaTeoricoPor, "cell 3 9,growx");
		textNotaTeoricoPor.setColumns(10);

		lblOtrasNotas = new JLabel("Otras notas:");
		contentPane.add(lblOtrasNotas, "cell 0 10,alignx right");

		textOtros = new JTextField();
		textOtros.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textOtros, "cell 1 10,growx");
		textOtros.setColumns(10);

		textOtrosPor = new JTextField();
		textOtrosPor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textOtrosPor, "cell 3 10,growx");
		textOtrosPor.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");

		contentPane.add(btnGuardar, "cell 0 12,alignx center");

		// ------------------------------ FIN ------------------------------------

		// ------------ Acciones --------------

		JButton btnCancelar = new JButton("Cancelar");
		contentPane.add(btnCancelar, "cell 1 12");

		JButton btnLimpiar = new JButton("Limpiar");
		contentPane.add(btnLimpiar, "cell 3 12,alignx center");

		debug = new TextArea();
		debug.setEditable(false);
		contentPane.add(debug, "cell 0 13 4 2,alignx center,aligny top");

		// ---------------------------- COPIPASTE --------------------------------

		JTextField[] text = crearGrupo(textNota1, textNota2, textNotaLab, textNotaPar, textNotaTeorico, textOtros);
		JTextField[] por = crearGrupo(textNota1Por, textNota2Por, textNotaLabPor, textNotaParPor, textNotaTeoricoPor,
				textOtrosPor);
		JTextField[] todoText = { textNombre, textNota1, textNota1Por, textNota2, textNota2Por, textNotaLab,
				textNotaLabPor, textNotaPar, textNotaParPor, textNotaTeorico, textNotaTeoricoPor, textOtros,
				textOtrosPor, textAo, textCurso };

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					int opt = di.dialogAsig();
					if (opt == 0) {
						debug.append("Rellenados con 0\n");
						rellenarCero(text, por);
						if (met.compPor(por, debug)) {
							Asignatura a = CrearAsig(textNombre, boolGlobal, textNota1, textNota1Por, textNota2,
									textNota2Por, textNotaLab, textNotaLabPor, textNotaPar, textNotaParPor,
									textNotaTeorico, textNotaTeoricoPor, textOtros, textOtrosPor, textAo, textCurso);

							if (met.comprobAsig(a)) {
								ag.insertarAsig(a);
								dispose();
							} else {
								debug.append("Esta asignatura ya existe\n");
							}
						} else {
							debug.append("Cancelado\n");
						}
					} else {
						debug.append("Revisar porcentajes\n");
					}

				} catch (SQLException e) {
					debug.append("Error en base de datos. \n");
				} catch (Exception e) {
					debug.append("Error creando asignatura. \n");
				}
			}
		});
		boolGlobal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNota2.isVisible()) {
					textNota2.setVisible(false);
					textNota2Por.setVisible(false);

				} else {
					textNota2.setVisible(true);
					textNota2Por.setVisible(true);

				}
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				try {
					met.ActAsig(cajaAsig, asigArray, cajaAo);
					// met.updateBox(cajaAo,met.aosAsig(asigArray)); ESTO DA ERROR Y ERA PARA CUANDO
					// AÑADES UNA NUEVA ASIG CON OTRO AÑO NO EN LA TABLA AÑOS, ACTUALIZA LA TABLA
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar(todoText);
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}

	// ------------------------------------------ METODOS
	// ------------------------------------------
	protected void limpiar(JTextField[] todoText) {
		for (int i = 0; i < todoText.length; i++) {
			todoText[i].setText("");
		}
		boolGlobal.setSelected(false);
		textNota2.setVisible(true);
		textNota2Por.setVisible(true);

	}

	protected Asignatura CrearAsig(JTextField nom, JCheckBox glob, JTextField n1, JTextField n1p, JTextField n2,
			JTextField n2p, JTextField nla, JTextField nlap, JTextField npa, JTextField npap, JTextField nte,
			JTextField ntep, JTextField not, JTextField notp, JTextField ao, JTextField curso) {
		Asignatura a = new Asignatura();

		a.setNombre(nom.getText());
		a.setGlobal(glob.isSelected());
		a.setNota1(Double.valueOf(n1.getText()));
		a.setNota1Por(Double.valueOf(n1p.getText()));
		a.setNota2(Double.valueOf(n2.getText()));
		a.setNota2Por(Double.valueOf(n2p.getText()));
		a.setNotaLab(Double.valueOf(nla.getText()));
		a.setNotaLabPor(Double.valueOf(nlap.getText()));
		a.setNotaPar(Double.valueOf(npa.getText()));
		a.setNotaParPor(Double.valueOf(npap.getText()));
		a.setNotaTeorico(Double.valueOf(nte.getText()));
		a.setNotaTeoricoPor(Double.valueOf(ntep.getText()));
		a.setOtros(Double.valueOf(not.getText()));
		a.setOtrosPor(Double.valueOf(notp.getText()));
		a.setAo(Integer.valueOf(ao.getText()));
		a.setCurso(Integer.valueOf(curso.getText()));
		return a;
	}

	private JTextField[] crearGrupo(JTextField a, JTextField b, JTextField c, JTextField d, JTextField e,
			JTextField f) {
		JTextField[] por = new JTextField[6];
		por[0] = a;
		por[1] = b;
		por[2] = c;
		por[3] = d;
		por[4] = e;
		por[5] = f;
		return por;
	}

	private void rellenarCero(JTextField[] text, JTextField[] por) {
		for (int i = 0; i < text.length; i++) {
			if (text[i].getText().equals(""))
				text[i].setText("0.0");
		}
		for (int i = 0; i < por.length; i++) {
			if (por[i].getText().equals(""))
				por[i].setText("0.0");
		}
	}

}
