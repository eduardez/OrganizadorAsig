package presentacion;

import javax.swing.JOptionPane;

public class Dialogos {
	public int dialogAsig() {
		int n = JOptionPane.showConfirmDialog(null, "Se completaran los recuadros vacios con '0'", "Atencion",
				JOptionPane.YES_NO_OPTION);
		return n;
	}
}
