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
import model.Model_KeranjangPesan;

/**
 *
 * @author aridw
 */
public class TBM_KeranjangPesan extends AbstractTableModel {
private List<Model_KeranjangPesan> list = new ArrayList<>();
    
    public void addData(Model_KeranjangPesan mdkb){
        list.add(mdkb);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_KeranjangPesan mdkb){
        list.add(row, mdkb);
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
    
    public void setData(List<Model_KeranjangPesan> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_KeranjangPesan mdkb){
        list.set(index, mdkb);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_KeranjangPesan getData(int index){
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
            case 3: return list.get(rowIndex).getDetail_pemesanan().getJumlah_pemesanan();
            case 4: return list.get(rowIndex).getDetail_pemesanan().getSubtotal_pemesanan();
            
            default: return null;
        }
    }
    					
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Barang";
            case 1: return "Nama Barang";
            case 2: return "Harga Beli";
            case 3: return "Jumlah Pesan";
            case 4: return "Subtotal Pesan";
            
            default: return null;
            
        }
    }
}
