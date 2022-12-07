package model;

import java.util.ArrayList;
import java.util.List;

public class Category {

     private int id_CG; // CateGory
     private String nameCG;//CateGory
     private List<Product> productLis = new ArrayList<>();

    public Category() {
    }

    public Category(String nameCG) {
        this.nameCG = nameCG;
    }

    public void setId_CG(int id_CG) {
        this.id_CG = id_CG;
    }

    public int getId_CG() {
        return id_CG;
    }


    public String getNameCG() {
        return nameCG;
    }

    public void setNameCG(String nameCG) {
        this.nameCG = nameCG;
    }

    public void setProductLis(List<Product> productLis) {
        this.productLis = productLis;
    }

    public List<Product> getProductLis() {
        return productLis;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id_CG=" + id_CG +
                ", nameCG='" + nameCG + '\'' +
                '}';
    }
}
