package view;

import model.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class ProductList extends AbstractTableModel {
    private String[] nomColones = new String[]{"REFP","NAMEP","PRICE","ID_CG"};
    private Vector<String[]> rows = new Vector<>() ;

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return nomColones.length;
    }

    @Override
    public String getColumnName(int column) {
        return nomColones[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }


    public void loadData(List<Product> productList){
        rows = new Vector<>();
        for (Product e:productList){
            rows.add(new String[]{e.getRefP(),e.getNameP(),e.getPrice()+"",e.getCategory().getNameCG()});
        }
        fireTableChanged(null);
    }
}
