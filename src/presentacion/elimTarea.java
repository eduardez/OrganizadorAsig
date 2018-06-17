package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Tarea;
import persistencia.Agente;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Toolkit;

public class elimTarea extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public elimTarea(ArrayList<Tarea> tare) {
		setTitle("Eliminar tarea");
		setIconImage(Toolkit.getDefaultToolkit().getImage(elimTarea.class.getResource("/org/hsqldb/util/RedCircle.gif")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblSel = new JLabel("Tareas seleccionadas: ");
		lblSel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSel.setBounds(20, 188, 172, 24);
		contentPanel.add(lblSel);

		JLabel lblTareas = new JLabel("");
		lblTareas.setHorizontalAlignment(SwingConstants.LEFT);
		lblTareas.setBounds(202, 188, 172, 24);
		contentPanel.add(lblTareas);

		DefaultListModel<String> model = new DefaultListModel<>();
		mostTareas(model, tare, lblTareas);

		JList<String> listTareas = new JList<>(model);

		listTareas.setBounds(10, 11, 412, 166);
		contentPanel.add(listTareas);
		listTareas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				lblTareas.setText(String.valueOf(listTareas.getSelectedIndices().length));
			}
		});

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Eliminar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int opt= JOptionPane.showConfirmDialog (null, "¿Eliminar "+listTareas.getSelectedIndices().length+" tarea(s)?","Atencion", JOptionPane.YES_NO_OPTION);
						if(opt==0) {
						elimAsig(listTareas, tare);
						dispose();
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void elimAsig(JList<String> listTareas, ArrayList<Tarea> tare) {
		try {
			int[] elimPos = listTareas.getSelectedIndices();
			for (int i = 0; i < elimPos.length; i++) {
				Agente ag=new Agente();
				ag.EliminarTarea(tare.get(elimPos[i]));
			}
		} catch (Exception e) {

		}

	}

	private void mostTareas(DefaultListModel<String> model, ArrayList<Tarea> tare, JLabel lblTareas) {
		if (tare.isEmpty()) {
			lblTareas.setText("No hay tareas creadas");
		} else {
			for (int i = 0; i < tare.size(); i++) {
				model.add(i, tare.get(i).getTexto());
			}
			lblTareas.setText("0");
		}

	}
}
