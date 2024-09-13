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
import model.Model_BarangMasuk;

/**
 *
 * @author aridw
 */
public class TBM_BarangMasuk extends AbstractTableModel {
private List<Model_BarangMasuk> list = new ArrayList<>();
    
    public void addData(Model_BarangMasuk mdBarangMasuk){
        list.add(mdBarangMasuk);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_BarangMasuk mdBarangMasuk){
        list.add(row, mdBarangMasuk);
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
    
    public void setData(List<Model_BarangMasuk> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_BarangMasuk mdBarangMasuk){
        list.set(index, mdBarangMasuk);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_BarangMasuk getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId_barang_masuk();
            case 1: return list.get(rowIndex).getDistributor().getId_distributor();
            case 2: return list.get(rowIndex).getTotalmasuk();
            case 3: return list.get(rowIndex).getTgl_masuk();
            case 4: return list.get(rowIndex).getPengguna().getId_pengguna();
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Barang Masuk";
            case 1: return "Id Distributor";
            case 2: return "Total Masuk";
            case 3: return "Tanggal Masuk";
            case 4: return "Id Pengguna";
            
            default: return null;
            
        }
    }
}
