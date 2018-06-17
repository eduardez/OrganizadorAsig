package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import persistencia.Agente;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import dominio.Tarea;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JCheckBox;

public class insertTarea extends JDialog {

	private final JPanel contentPanel = new JPanel(false);
	private Date dia;
	private int year, mes, day, hh, mm;
	

	public insertTarea(String diaText) {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);

		String.format("%02d", mm);
		String.format("%02d", hh);
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(insertTarea.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
		setTitle("A\u00F1adir Tarea");
		setBounds(100, 100, 450, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		

		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFecha.setBounds(10, 11, 78, 28);
		contentPanel.add(lblFecha);

		JLabel lblDia = new JLabel(diaText);
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDia.setBounds(98, 11, 213, 28);
		contentPanel.add(lblDia);

		JPanel panelTarea = new JPanel();
		panelTarea.setBorder(new TitledBorder(null, "Tarea", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTarea.setBounds(10, 144, 412, 88);
		contentPanel.add(panelTarea);
		panelTarea.setLayout(null);

		JTextArea areaTarea = new JTextArea();
		areaTarea.setFont(new Font("Calibri", Font.PLAIN, 15));
		areaTarea.setBounds(10, 25, 392, 52);
		panelTarea.add(areaTarea);

		JLabel lblhora = new JLabel("");
		lblhora.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblhora.setHorizontalAlignment(SwingConstants.CENTER);
		lblhora.setBounds(316, 11, 88, 26);
		contentPanel.add(lblhora);

		JSlider slideHora = new JSlider();
		slideHora.setToolTipText("Seleccionar la hora de la tarea");
		slideHora.setSnapToTicks(true);
		slideHora.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slideHora.setPaintTicks(true);
		slideHora.setValue(12);
		slideHora.setMaximum(24);
		slideHora.setBounds(32, 50, 160, 45);
		slideHora.setPaintTicks(true);
		slideHora.setMajorTickSpacing(4);
		slideHora.setMinorTickSpacing(1);
		slideHora.setPaintLabels(true);

		contentPanel.add(slideHora);

		JSlider sliderMinuto = new JSlider();
		sliderMinuto.setValue(30);
		sliderMinuto.setToolTipText("Seleccionar el minuto de la tarea");
		sliderMinuto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sliderMinuto.setSnapToTicks(true);
		sliderMinuto.setPaintTicks(true);
		sliderMinuto.setMaximum(60);
		sliderMinuto.setMinimum(0);
		sliderMinuto.setPaintLabels(true);
		sliderMinuto.setBounds(232, 50, 160, 45);
		sliderMinuto.setMajorTickSpacing(15);
		sliderMinuto.setMinorTickSpacing(5);
		contentPanel.add(sliderMinuto);
		// --------------------- METODOS -----------------------------

		hh = slideHora.getValue();
		mm = sliderMinuto.getValue();

		lblhora.setText(String.format("%02d", hh) + " : " + String.format("%02d", mm));
		
		JCheckBox chckbxAnual = new JCheckBox("\u00BFRepetir cada a\u00F1o?");
		chckbxAnual.setBounds(145, 114, 148, 23);
		contentPanel.add(chckbxAnual);

		slideHora.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarHora(slideHora, lblhora);
			}
		});
		slideHora.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				cambiarHora(slideHora, lblhora);
			}
		});

		sliderMinuto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarMin(sliderMinuto, lblhora);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				cambiarMin(sliderMinuto, lblhora);
			}
		});
		sliderMinuto.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				cambiarMin(sliderMinuto, lblhora);
			}
		});

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Insertar"); // ----------------- Insertar tarea
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							Agente ag = new Agente();
							Tarea t = new Tarea();
							Date fecha=new Date(year,mes,day,hh,mm,0);
							t.setIdTiempo(t.generarIdTiempo(dia));
							t.setTexto(areaTarea.getText());
							t.setFecha(fecha);
							t.setAnual(chckbxAnual.isSelected());
							ag.insertarTarea(t);
							dispose();

						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void cambiarHora(JSlider slideHora, JLabel lblhora) {
		if (slideHora.getValue() == 24) {
			hh = 23;
		} else {
			hh = slideHora.getValue();
		}
		lblhora.setText(String.format("%02d", hh) + " : " + String.format("%02d", mm));
	}

	protected void cambiarMin(JSlider sliderMinuto, JLabel lblhora) {
		if (sliderMinuto.getValue() == 60) {
			mm = 59;
		} else {
			mm = sliderMinuto.getValue();
		}
		lblhora.setText(String.format("%02d", hh) + " : " + String.format("%02d", mm));

	}

	public void setDia(int yy, int mees, int dd) {
		year = yy;
		mes = mees;
		day = dd;
		dia = new Date(year, mes, day);
	}
}
