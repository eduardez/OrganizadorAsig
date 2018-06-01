package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import dominio.metod;

public class notasCurso extends JFrame {

	private JPanel contentPane;
	private JTable tabla4;
	private JTable tabla2;
	private JTable tabla1;
	private JLabel lblPrimero;
	private JLabel lblSegundo;
	private JLabel lblTercero;
	private JLabel lblCuarto;
	
	metod met=new metod();
	public notasCurso() throws Exception {
		setAutoRequestFocus(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 797);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][][grow]", "[][][][][][][][grow][][][][][grow][][][][][][grow][][][][][grow]"));
		
		lblPrimero = new JLabel("Primero");
		contentPane.add(lblPrimero, "cell 0 0");
		
		tabla1 = new JTable();
		tabla1.setEnabled(false);
		tabla1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Asignatura", "Nota"
			}
		));
		contentPane.add(tabla1, "cell 0 2 14 5,grow");
		met.tablaCurso(tabla1, 1);		
		
		lblSegundo = new JLabel("Segundo");
		contentPane.add(lblSegundo, "cell 0 7");
		
		tabla2 = new JTable();
		tabla2.setEnabled(false);
		tabla2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		contentPane.add(tabla2, "cell 0 8 14 4,grow");
		met.tablaCurso(tabla2, 2);

		lblTercero = new JLabel("Tercero");
		contentPane.add(lblTercero, "cell 0 12");
		
		JTable tabla3 = new JTable();
		tabla3.setEnabled(false);
		tabla3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		contentPane.add(tabla3, "cell 0 13 14 5,grow");
		met.tablaCurso(tabla3, 3);

		lblCuarto = new JLabel("Cuarto");
		contentPane.add(lblCuarto, "cell 0 18");
		
		tabla4 = new JTable();
		tabla4.setEnabled(false);
		tabla4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		contentPane.add(tabla4, "cell 0 19 14 5,grow");
		met.tablaCurso(tabla4, 4);

	}

}
