package dominio;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class mainPrin extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// Only for specific cell
		if (row == 1 && column == 1) {
			// you may want to address isSelected here too
			c.setForeground(Color.RED);
		}
		return c;
	}
}