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
import model.Model_Barang;

/**
 *
 * @author aridw
 */
public class TBM_Barang extends AbstractTableModel {
    private List<Model_Barang> list = new ArrayList<>();
    
    public void addData(Model_Barang mdBarang){
        list.add(mdBarang);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_Barang mdBarang){
        list.add(row, mdBarang);
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
    
    public void setData(List<Model_Barang> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_Barang mdBarang){
        list.set(index, mdBarang);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Barang getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getId_barang();
            case 1: return list.get(rowIndex).getJenis().getId_jenis();
            case 2: return list.get(rowIndex).getJenis().getNama_jenis();
            case 3: return list.get(rowIndex).getNama_barang();
            case 4: return list.get(rowIndex).getSatuan();
            case 5: return list.get(rowIndex).getHarga_beli();
            case 6: return list.get(rowIndex).getHarga_jual();
            case 7: return list.get(rowIndex).getStok();
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Barang";
            case 1: return "Id Jenis Barang";
            case 2: return "Nama Jenis Barang";
            case 3: return "Nama Barang";
            case 4: return "Satuan";
            case 5: return "Harga Beli";
            case 6: return "Harga Jual";
            case 7: return "Stok";
            
            default: return null;
            
        }
    }
}
