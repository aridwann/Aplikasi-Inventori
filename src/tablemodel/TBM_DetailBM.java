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
import model.Model_DetailBM;

/**
 *
 * @author aridw
 */
public class TBM_DetailBM extends AbstractTableModel {
    private List<Model_DetailBM> list = new ArrayList<>();
    
    public void addData(Model_DetailBM mdDetailBM){
        list.add(mdDetailBM);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_DetailBM mdDetailBM){
        list.add(row, mdDetailBM);
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
    
    public void setData(List<Model_DetailBM> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_DetailBM mdDetailBM){
        list.set(index, mdDetailBM);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_DetailBM getData(int index){
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
            case 0: return list.get(rowIndex).getBarang_masuk().getId_barang_masuk();
            case 1: return list.get(rowIndex).getBarang().getId_barang();
            case 2: return list.get(rowIndex).getBarang().getNama_barang();
            case 3: return list.get(rowIndex).getBarang().getHarga_beli();
            case 4: return list.get(rowIndex).getJumlah_masuk();
            case 5: return list.get(rowIndex).getSubtotal_masuk();
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Barang Masuk";
            case 1: return "Id Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga Beli";
            case 4: return "Jumlah Masuk";
            case 5: return "Subtotal";
            
            default: return null;
            
        }
    }
}
