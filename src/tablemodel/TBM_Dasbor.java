/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Model_Barang;

/**
 *
 * @author aridw
 */
public class TBM_Dasbor extends AbstractTableModel  {
    private List<Model_Barang> list = new ArrayList<>();
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<Model_Barang> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex){
            case 0: return list.get(rowIndex).getId_barang();
            case 1: return list.get(rowIndex).getNama_barang();
            case 2: return list.get(rowIndex).getStok();
            
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Barang";
            case 1: return "Nama Barang";
            case 2: return "Stok Barang";
            
            default: return null;
            
        }
    }
    
}
