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
import model.Model_BarangKeluar;

/**
 *
 * @author aridw
 */
public class TBM_BarangKeluar extends AbstractTableModel {
    private List<Model_BarangKeluar> list = new ArrayList<>();
    
    public void addData(Model_BarangKeluar mdBarangKeluar){
        list.add(mdBarangKeluar);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_BarangKeluar mdBarangKeluar){
        list.add(row, mdBarangKeluar);
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
    
    public void setData(List<Model_BarangKeluar> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_BarangKeluar mdBarangKeluar){
        list.set(index, mdBarangKeluar);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_BarangKeluar getData(int index){
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
            case 0: return list.get(rowIndex).getId_barang_keluar();
            case 1: return list.get(rowIndex).getTgl_keluar();
            case 2: return list.get(rowIndex).getTotalKeluar();
            case 3: return list.get(rowIndex).getPengguna().getId_pengguna();
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Barang Keluar";
            case 1: return "Tanggal Keluar";
            case 2: return "Total Keluar";
            case 3: return "Id Pengguna";
            
            default: return null;
            
        }
    }
}
