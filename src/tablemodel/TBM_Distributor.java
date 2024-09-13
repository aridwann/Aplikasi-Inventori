/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_Distributor;

/**
 *
 * @author aridw
 */
public class TBM_Distributor extends AbstractTableModel {
    private List<Model_Distributor> list = new ArrayList<>();
    
    public void addData(Model_Distributor mdDistributor){
        list.add(mdDistributor);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_Distributor mdDistributor){
        list.add(row, mdDistributor);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
    };
    
    public void deleteData(int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    };
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<Model_Distributor> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_Distributor mdDistributor){
        list.set(index, mdDistributor);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Distributor getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId_distributor();
            case 1: return list.get(rowIndex).getNama_distributor();
            case 2: return list.get(rowIndex).getAlamat_distributor();
            case 3: return list.get(rowIndex).getTelp_distributor();
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Distributor";
            case 1: return "Nama Distributor";
            case 2: return "Alamat Distributor";
            case 3: return "No Telepon Distributor";
            
            default: return null;
            
        }
    }    
}
