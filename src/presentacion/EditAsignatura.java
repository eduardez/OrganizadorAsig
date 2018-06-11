package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class EditAsignatura extends JFrame {
	private Asignatura a;
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
	private JLabel lblAo;
	private JTextField textAo;
	private JButton btnActivarEdicionCompleta;
	private JTextField textCurso;
	private JLabel lblCurso;

	public EditAsignatura(JComboBox cajaAsig, String nom, ArrayList<Asignatura> asigArray, JComboBox cajaAo)
			throws SQLException {

		metod met = new metod();
		Dialogos di = new Dialogos();
		Agente ag = new Agente();
		setTitle("Editar " + nom);

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(
				new MigLayout("", "[grow,left][grow,center][][grow,right]", "[][][][][][][][][][][][][][][][][grow]"));

		lblNombreAsignatura = new JLabel("Nombre Asignatura:");
		lblNombreAsignatura.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNombreAsignatura, "cell 0 1,alignx trailing");

		textNombre = new JTextField();
		textNombre.setEditable(false);
		contentPane.add(textNombre, "cell 1 1 3 1,growx");
		textNombre.setColumns(10);

		lblAo = new JLabel("A\u00F1o:");
		contentPane.add(lblAo, "cell 0 2,alignx trailing");

		textAo = new JTextField();
		contentPane.add(textAo, "cell 1 2,growx");
		textAo.setColumns(10);

		lblCurso = new JLabel("Curso:");
		lblCurso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurso.setEnabled(true);
		contentPane.add(lblCurso, "cell 2 2,alignx trailing");

		textCurso = new JTextField();
		textCurso.setEditable(false);
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
		boolGlobal.setEnabled(false);

		textNota1Por = new JTextField();
		textNota1Por.setEditable(false);
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
		textNota2Por.setEditable(false);
		textNota2Por.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNota2Por, "cell 3 5,growx");
		textNota2Por.setColumns(10);

		lblNewLabel_1 = new JLabel("Nota Laboratorio:");
		contentPane.add(lblNewLabel_1, "cell 0 6,alignx right");

		textNotaLab = new JTextField();
		textNotaLab.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaLab, "cell 1 6,growx");
		textNotaLab.setColumns(10);

		textNotaLabPor = new JTextField();
		textNotaLabPor.setEditable(false);
		textNotaLabPor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaLabPor, "cell 3 6,growx");
		textNotaLabPor.setColumns(10);

		lblNotaParticipacion = new JLabel("Nota Participacion:");
		contentPane.add(lblNotaParticipacion, "cell 0 7,alignx right");

		textNotaPar = new JTextField();
		textNotaPar.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaPar, "cell 1 7,growx");
		textNotaPar.setColumns(10);

		textNotaParPor = new JTextField();
		textNotaParPor.setEditable(false);
		textNotaParPor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaParPor, "cell 3 7,growx");
		textNotaParPor.setColumns(10);

		lblNewLabel_2 = new JLabel("Nota Trabajo Teorico:");
		contentPane.add(lblNewLabel_2, "cell 0 8,alignx right");

		textNotaTeorico = new JTextField();
		textNotaTeorico.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaTeorico, "cell 1 8,growx");
		textNotaTeorico.setColumns(10);

		textNotaTeoricoPor = new JTextField();
		textNotaTeoricoPor.setEditable(false);
		textNotaTeoricoPor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textNotaTeoricoPor, "cell 3 8,growx");
		textNotaTeoricoPor.setColumns(10);

		lblOtrasNotas = new JLabel("Otras notas:");
		contentPane.add(lblOtrasNotas, "cell 0 9,alignx right");

		textOtros = new JTextField();
		textOtros.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textOtros, "cell 1 9,growx");
		textOtros.setColumns(10);

		textOtrosPor = new JTextField();
		textOtrosPor.setEditable(false);
		textOtrosPor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textOtrosPor, "cell 3 9,growx");
		textOtrosPor.setColumns(10);

		debug = new TextArea();
		debug.setEditable(false);
		contentPane.add(debug, "cell 0 14 4 2,grow");

		// ---------------------------- COPIPASTE --------------------------------
		// textNombre
		// textNota1Por,textNota2,textNota2Por,textNotaLab,textNotaLabPor,textNotaPar,textNotaParPor,textNotaTeorico,textNotaTeoricoPor,textOtros,textOtros

		/*
		 * JTextField[] val = Grupo(textNombre,
		 * boolGlobal,textNota1Por,textNota2,textNota2Por,textNotaLab,textNotaLabPor,
		 * textNotaPar,textNotaParPor,
		 * textNotaTeorico,textNotaTeoricoPor,textOtros,textOtrosPor);
		 */
		JTextField[] text = crearGrupo(textNota1, textNota2, textNotaLab, textNotaPar, textNotaTeorico, textOtros);
		JTextField[] por = crearGrupo(textNota1Por, textNota2Por, textNotaLabPor, textNotaParPor, textNotaTeoricoPor,
				textOtrosPor);

		btnActivarEdicionCompleta = new JButton("Activar edicion completa");
		btnActivarEdicionCompleta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNombre.setEditable(true);
				textCurso.setEditable(true);
				boolGlobal.setEnabled(true);;
				for (int i = 0; i < por.length; i++)
					por[i].setEditable(true);
			}
		});
		contentPane.add(btnActivarEdicionCompleta, "cell 3 16");

		// ------------------------------ BOTONES ------------------------------------
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				try {
					met.ActAsig(cajaAsig, asigArray, cajaAo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opt = di.dialogAsig(); // Preguntar si se desea autocompletar valores
				if (opt == 0) {
					rellenarCero(text);
					try {
						ag.EliminarAsig(a);
						Asignatura asi=CrearAsig(textNombre, boolGlobal, textNota1, textNota1Por, textNota2,
								textNota2Por, textNotaLab, textNotaLabPor, textNotaPar, textNotaParPor,
								textNotaTeorico, textNotaTeoricoPor, textOtros, textOtrosPor, textAo, textCurso);
						
						if(met.comprobAsig(asi)) {
						ag.insertarAsig(asi);
						}else {
							debug.append("Esta asignatura ya existe\n");
							ag.insertarAsig(a);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					debug.append("Cancelado\n");
				}

			}
		});
		contentPane.add(btnGuardar, "cell 0 13,alignx center");

		JButton btnCancelar = new JButton("Cancelar");
		contentPane.add(btnCancelar, "cell 1 13");

		JButton btnEliminar = new JButton("Eliminar Asignatura");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ag.EliminarAsig(getAsig());
					System.out.println("Eliminada");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnEliminar, "cell 3 13,alignx center");

	}

	// ------------------------------------------ METODOS
	// ------------------------------------------
	private String[] todasAsig() throws Exception {
		ArrayList<Asignatura> a = getNam();
		String[] nombres = new String[a.size()];
		for (int i = 0; i < a.size(); i++)
			nombres[i] = a.get(i).getNombre() + " - " + String.valueOf(a.get(i).getAo());
		return nombres;
	}

	public ArrayList<Asignatura> getNam() throws Exception {
		Agente ag = new Agente();
		return ag.selectAsignaturas();
	}

	private void rellenar(Asignatura asig, JTextField a, JCheckBox b, JTextField c, JTextField d, JTextField e,
			JTextField f, JTextField g, JTextField h, JTextField i, JTextField j, JTextField k, JTextField l,
			JTextField m, JTextField n, JTextField o, JTextField curso) {
	
		a.setText(asig.getNombre());
		b.setSelected(asig.isGlobal());
		c.setText(String.valueOf(asig.getNota1()));
		d.setText(String.valueOf(asig.getNota1Por()));
		e.setText(String.valueOf(asig.getNota2()));
		f.setText(String.valueOf(asig.getNota2Por()));
		g.setText(String.valueOf(asig.getNotaLab()));
		h.setText(String.valueOf(asig.getNotaLabPor()));
		i.setText(String.valueOf(asig.getNotaPar()));
		j.setText(String.valueOf(asig.getNotaParPor()));
		k.setText(String.valueOf(asig.getNotaTeorico()));
		l.setText(String.valueOf(asig.getNotaTeoricoPor()));
		m.setText(String.valueOf(asig.getOtros()));
		n.setText(String.valueOf(asig.getOtrosPor()));
		o.setText(String.valueOf(asig.getAo()));
		curso.setText(String.valueOf(asig.getCurso()));
		if (b.isSelected()) {
			textNota2.setVisible(false);
			textNota2Por.setVisible(false);

		} else {
			textNota2.setVisible(true);
			textNota2Por.setVisible(true);

		}

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

	private void rellenarCero(JTextField[] text) {
		for (int i = 0; i < text.length; i++) {
			if (text[i].getText().equals(""))
				text[i].setText("0");
		}
	}

	public void setAsig(Asignatura a) {
		this.a = a;
		rellenar(getAsig(), textNombre, boolGlobal, textNota1, textNota1Por, textNota2, textNota2Por, textNotaLab,
				textNotaLabPor, textNotaPar, textNotaParPor, textNotaTeorico, textNotaTeoricoPor, textOtros,
				textOtrosPor, textAo, textCurso);
	}

	public Asignatura getAsig() {
		return a;
	}
}
