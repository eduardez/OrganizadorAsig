package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dialogHorario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textAo;
	private JTextField textFilas;

	public dialogHorario() {
		setTitle("Nuevo Horario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblFilas = new JLabel("Numero de Filas: ");
		lblFilas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFilas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFilas.setBounds(46, 145, 162, 27);
		contentPanel.add(lblFilas);

		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAo.setBounds(46, 32, 162, 27);
		contentPanel.add(lblAo);

		JLabel lblCuatri = new JLabel("Cuatrimestre: ");
		lblCuatri.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCuatri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuatri.setBounds(46, 85, 162, 27);
		contentPanel.add(lblCuatri);

		textAo = new JTextField();
		textAo.setBounds(218, 34, 106, 27);
		contentPanel.add(textAo);
		textAo.setColumns(10);

		textFilas = new JTextField();
		textFilas.setColumns(10);
		textFilas.setBounds(218, 145, 106, 27);
		contentPanel.add(textFilas);

		JRadioButton rdbtn1cuatri = new JRadioButton("1\u00BA Cuatrimestre");
		rdbtn1cuatri.setBounds(214, 74, 154, 23);
		contentPanel.add(rdbtn1cuatri);

		JRadioButton rdbtn2cuatri = new JRadioButton("2\u00BA Cuatrimestre");
		rdbtn2cuatri.setBounds(214, 100, 154, 23);
		contentPanel.add(rdbtn2cuatri);

		ButtonGroup cuatri = new ButtonGroup();
		rdbtn1cuatri.setSelected(true);
		rdbtn1cuatri.setActionCommand("1");
		rdbtn2cuatri.setActionCommand("2");

		cuatri.add(rdbtn1cuatri);
		cuatri.add(rdbtn2cuatri);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (comprobar(cuatri, textFilas, textAo)) {
							frameHorario fr = new frameHorario();
							fr.genHorarioBlanco(Integer.valueOf(textAo.getText()),
									Integer.valueOf(cuatri.getSelection().getActionCommand()),
									Integer.valueOf(textFilas.getText()));
							dispose();
							frameHorario hor=new frameHorario();
							hor.setVisible(true);
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

	public boolean numValido(JTextField txt) {
		try {
			Integer.parseInt(txt.getText());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Introducir solo valores numericos.", "Errorzaco",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	protected boolean comprobar(ButtonGroup cuatri, JTextField fil, JTextField ao) {
		boolean valido = false;
		if (cuatri.getSelection().getActionCommand() != null && !fil.getText().equals("") && !ao.getText().equals("")
				&& numValido(fil) && numValido(ao)) {
			valido = true;
		}
		return valido;
	}

}
