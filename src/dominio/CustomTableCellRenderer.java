package dominio;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable tablaNotas, Object obj, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cell = super.getTableCellRendererComponent(tablaNotas, obj, isSelected, hasFocus, row, column);
		boolean condicion = ((String.valueOf(tablaNotas.getValueAt(row, 7)).length() > 0
				&& tablaNotas.getValueAt(row, column) != null));
		if (condicion) {
			double nota = Double.parseDouble(String.valueOf(tablaNotas.getValueAt(row, 7)));
			if (nota < 5) {
				cell.setForeground(Color.red);
			} else {

				cell.setFont(new Font("Tahoma", Font.BOLD, 12));
				cell.setForeground(new Color(0, 110, 0));
			}
		}

		return cell;
	}

}
