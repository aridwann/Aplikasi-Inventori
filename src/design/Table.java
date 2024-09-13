package design;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class Table {
    public void CustomTable(JTable table, JScrollPane jsp){
        jsp.setBorder(new LineBorder(new Color(204,204,204), 1));
        table.setFont(new Font("Inter", Font.PLAIN, 14));
        table.setRowHeight(40);
        table.setForeground(Color.white);
        table.setBackground(new Color(17,79,109));
        table.setSelectionForeground(Color.white);
        table.setFocusable(false);
        table.setShowGrid(false);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        
        
        table.getTableHeader().setDefaultRenderer(headerRenderer);
        headerRenderer.setBackground(new Color(3,57,84)); 
        headerRenderer.setForeground(Color.WHITE);
        headerRenderer.setPreferredSize(new Dimension(WIDTH, 40));
        headerRenderer.setFont(new Font("Inter", Font.BOLD, 14));
    }
}