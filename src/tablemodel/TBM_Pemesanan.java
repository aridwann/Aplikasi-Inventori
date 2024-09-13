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
import model.Model_Pemesanan;

/**
 *
 * @author aridw
 */
public class TBM_Pemesanan extends AbstractTableModel  {
    private List<Model_Pemesanan> list = new ArrayList<>();
    
    public void addData(Model_Pemesanan mdPemesanan){
        list.add(mdPemesanan);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_Pemesanan mdPemesanan){
        list.add(row, mdPemesanan);
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
    
    public void setData(List<Model_Pemesanan> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_Pemesanan mdPemesanan){
        list.set(index, mdPemesanan);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Pemesanan getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId_pemesanan();
            case 1: return list.get(rowIndex).getDistributor().getId_distributor();
            case 2: return list.get(rowIndex).getTgl_pemesanan();
            case 3: return list.get(rowIndex).getTotal_pemesanan();
            case 4: return list.get(rowIndex).getPengguna().getId_pengguna();
            case 5: return list.get(rowIndex).getStatus();
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Pemesanan";
            case 1: return "Id Distributor";
            case 2: return "Tanggal Pemesanan";
            case 3: return "Total Pemesanan";
            case 4: return "Id Pengguna";
            case 5: return "Status";
            
            default: return null;
            
        }
    }
}
