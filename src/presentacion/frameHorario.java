package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frameHorario extends JFrame {

	private JPanel contentPane;
	private JTable tablaHorario;
	private JPanel panelHor;

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
		/*addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				try {
					menuPrincipal prin = new menuPrincipal();
					prin.setVisible(true);
					prin.setLocationRelativeTo(null);
				} catch (Exception e) {
				}
			}
		});
		*/
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 787, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panelHor = new JPanel();
		panelHor.setBounds(10, 11, 761, 402);
		contentPane.add(panelHor);

		// ------------------- LA TABLA -------------------
		String[] dias = { "Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
		tablaHorario = new JTable();
		tablaHorario.setModel(new DefaultTableModel(crearTabla(), dias));
		resizeTabla(tablaHorario, panelHor);

		JButton btnEdit = new JButton("Editar Horario");
		btnEdit.setBounds(615, 424, 129, 30);
		contentPane.add(btnEdit);

		JPanel panelCuatri = new JPanel();
		panelCuatri.setBounds(241, 420, 300, 41);
		contentPane.add(panelCuatri);
		panelCuatri.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btn1cuatri = new JButton("1\u00BA Cuatrimestre");
		panelCuatri.add(btn1cuatri);

		JButton btn2cuatri = new JButton("2\u00BA Cuatrimestre");
		panelCuatri.add(btn2cuatri);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(31, 424, 129, 30);
		contentPane.add(comboBox);
	}

	private void resizeTabla(JTable tab, JPanel pan) {
		panelHor.setLayout(new BorderLayout(0, 0));
		//--- Header ---
		int gordoHeader=40;
		tab.getTableHeader().setPreferredSize( new Dimension(pan.getWidth(),gordoHeader));
		pan.add(tab.getTableHeader(), BorderLayout.NORTH);
		//--- Tabla inf ---
		int tam=((pan.getHeight()-gordoHeader)/tab.getRowCount());
		tab.setRowHeight(tam);
		pan.add(tab);

	}

	public Object[][] crearTabla() {
		int rows=7;
		int dias=8;
		Object[][] tabla = new Object[rows][dias];

		for(int i=0;i<rows;i++) {
			for(int j=0;j<dias;j++) {
				tabla[i][j]="polla";
			}
		}
		return tabla;

	}
}
