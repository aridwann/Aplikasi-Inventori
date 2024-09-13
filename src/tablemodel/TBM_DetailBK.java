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
import model.Model_DetailBK;

/**
 *
 * @author aridw
 */
public class TBM_DetailBK extends AbstractTableModel {
    private List<Model_DetailBK> list = new ArrayList<>();
    
    public void addData(Model_DetailBK mdDetailBK){
        list.add(mdDetailBK);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_DetailBK mdDetailBK){
        list.add(row, mdDetailBK);
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
    
    public void setData(List<Model_DetailBK> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_DetailBK mdDetailBK){
        list.set(index, mdDetailBK);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_DetailBK getData(int index){
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
            case 0: return list.get(rowIndex).getBarang_keluar().getId_barang_keluar();
            case 1: return list.get(rowIndex).getBarang().getId_barang();
            case 2: return list.get(rowIndex).getBarang().getNama_barang();
            case 3: return list.get(rowIndex).getBarang().getHarga_jual();
            case 4: return list.get(rowIndex).getJumlah_keluar();
            case 5: return list.get(rowIndex).getSubtotal_keluar();
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Barang Keluar";
            case 1: return "Id Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga Jual";
            case 4: return "Jumlah Keluar";
            case 5: return "Subtotal";
            
            default: return null;
            
        }
    }
}
