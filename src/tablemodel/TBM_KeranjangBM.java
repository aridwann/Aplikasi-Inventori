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
import model.Model_KeranjangMasuk;

/**
 *
 * @author aridw
 */
public class TBM_KeranjangBM extends AbstractTableModel {
private List<Model_KeranjangMasuk> list = new ArrayList<>();
    
    public void addData(Model_KeranjangMasuk mdkm){
        list.add(mdkm);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_KeranjangMasuk mdkm){
        list.add(row, mdkm);
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
    
    public void setData(List<Model_KeranjangMasuk> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_KeranjangMasuk mdkm){
        list.set(index, mdkm);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_KeranjangMasuk getData(int index){
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
            case 0: return list.get(rowIndex).getBarang().getId_barang();
            case 1: return list.get(rowIndex).getBarang().getNama_barang();
            case 2: return list.get(rowIndex).getBarang().getHarga_beli();
            case 3: return list.get(rowIndex).getDetail_barang_masuk().getJumlah_masuk();
            case 4: return list.get(rowIndex).getDetail_barang_masuk().getSubtotal_masuk();
            
            default: return null;
        }
    }
    					
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Barang";
            case 1: return "Nama Barang";
            case 2: return "Harga Beli";
            case 3: return "Jumlah Masuk";
            case 4: return "Subtotal Masuk";
            
            default: return null;
            
        }
    }
}
