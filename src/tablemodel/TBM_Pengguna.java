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
import model.Model_Pengguna;

/**
 *
 * @author aridw
 */
public class TBM_Pengguna extends AbstractTableModel {
    private List<Model_Pengguna> list = new ArrayList<>();
    
    public void addData(Model_Pengguna mdPengguna){
        list.add(mdPengguna);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void updateData(int row, Model_Pengguna mdPengguna){
        list.add(row, mdPengguna);
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
    
    public void setData(List<Model_Pengguna> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_Pengguna mdPengguna){
        list.set(index, mdPengguna);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Pengguna getData(int index){
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
            case 0: return list.get(rowIndex).getId_pengguna();
            case 1: return list.get(rowIndex).getNama_pengguna();
            case 2: return list.get(rowIndex).getUsername();
            case 3: return list.get(rowIndex).getPassword();
            case 4: return list.get(rowIndex).getTelp_pengguna();
            case 5: return list.get(rowIndex).getAlamat_pengguna();
            case 6: return list.get(rowIndex).getJabatan();
            case 7: return list.get(rowIndex).getStatus();
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id Pengguna";
            case 1: return "Nama Pengguna";
            case 2: return "Username";
            case 3: return "Password";
            case 4: return "Telp Pengguna";
            case 5: return "Alamat Pengguna";
            case 6: return "Jabatan";
            case 7: return "Status";
            
            default: return null;
            
        }
    }
}
