package view;

import metier.IMetier;
import metier.Metier;
import model.Product;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewProduct extends JFrame {
    private JTable jTable = new JTable();
    private JTextField jTextField = new JTextField(12);
    private JButton jButton = new JButton("ok");
    private JTable jTable1;
    private ProductList  productList;
    IMetier iMetier = new Metier();

    public ViewProduct(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JPanel jPanelN = new JPanel();
        jPanelN.setLayout(new FlowLayout());
        jPanelN.add(jTable);
        jPanelN.add(jTextField);
        jPanelN.add(jButton);
        this.add(jPanelN,BorderLayout.NORTH);

        productList = new ProductList();
        jTable = new JTable(productList);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        this.add(jScrollPane,BorderLayout.CENTER);

        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mc = jTextField.getText();
                List<Product> products = iMetier.getProduct(mc);
                productList.loadData(products);
            }
        });
    }

}
