package dominio;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Dialogos {
	public int dialogAsig() {
		int n = JOptionPane.showConfirmDialog(null, "Se completaran los recuadros vacios con '0'", "Atencion",
				JOptionPane.YES_NO_OPTION);
		return n;
	}

	public void dialogNoBD() {
		JOptionPane.showMessageDialog(null, "No se ha encontrado una base de datos compatible.", "Errorzaco",
				JOptionPane.ERROR_MESSAGE);
	}

	public void dialogProx() {
		JOptionPane.showMessageDialog(null,
				"Poner un radio button para seleccionar asignaturas por año \no por curso, en plan  asignaturas de primero, segundo... y tal \n",
				"Para la proxima", JOptionPane.INFORMATION_MESSAGE);

	}

	public void dialogEdulcorante() {
		ImageIcon edul = new ImageIcon(Dialogos.class.getResource("/profilebig.jpg"));
		JOptionPane.showMessageDialog(null, "2018, All rigth.       凸ಠ益ಠ)凸        ", "Edulcorante", JOptionPane.INFORMATION_MESSAGE, edul);
	}
}
