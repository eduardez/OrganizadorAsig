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
		cell.setBackground(Color.white);

		if (condicion) {

			double nota = Double.parseDouble(String.valueOf(tablaNotas.getValueAt(row, 7)));
			if (nota < 5) {
				if (column == 7) {// Suspenso
					cell.setForeground(Color.black);
					cell.setBackground(new Color(255, 103, 110));
				} else {
					cell.setForeground(Color.black);
					cell.setBackground(Color.white);
				}

			} else {
				double not1, not2;
				not1 = Double.parseDouble(String.valueOf(tablaNotas.getValueAt(row, 1)));
				not2 = Double.parseDouble(String.valueOf(tablaNotas.getValueAt(row, 2)));
				if (((not2 < 4 && not2 != 0.0) && not1 >= 4) || ((not1 < 4 && not1 != 0.0) && not2 >= 4)) {// Ambos parciales
					if (column == 1 && not1 < 4) {
						cell.setForeground(Color.black);
						cell.setBackground(new Color(255, 103, 110));
					} else if (column == 2 && not2 < 4) {
						cell.setForeground(Color.black);
						cell.setBackground(new Color(255, 103, 110));
					} else if (column != 1 || column != 2) {
						cell.setFont(new Font("Tahoma", Font.PLAIN, 12));
						cell.setForeground(Color.black);
						cell.setBackground(new Color(253, 250, 109));
					}
				} else if ((not1 >= 4 && not2 == 0.0) || (not1 >= 4 && not2 >= 4)) {// Solo un parcial superado

					cell.setFont(new Font("Tahoma", Font.PLAIN, 12));
					cell.setForeground(Color.black);
					cell.setBackground(new Color(105, 254, 110));
				}

			}
		}

		return cell;
	}

}
