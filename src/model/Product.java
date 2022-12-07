package model;

import java.io.Serializable;

public class Product implements Serializable {
    private int  id_p;
    private String refP;
    private String nameP;
    private double price;
    private FactoryDate factoryDate;
    private Category category;
    public Product() {
    }

    public Product(String refP, String nameP, double price) {
        this.refP = refP;
        this.nameP = nameP;
        this.price = price;
    }

    public String getRefP() {
        return refP;
    }

    public void setRefP(String refP) {
        this.refP = refP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public FactoryDate getFactoryDate() {
        return factoryDate;
    }

    public void setFactoryDate(FactoryDate factoryDate) {
        this.factoryDate = factoryDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_p=" + id_p +
                ", refP='" + refP + '\'' +
                ", nameP='" + nameP + '\'' +
                ", price=" + price +
                ", factoryDate=" + factoryDate +
                ", category=" + category +
                '}';
    }
}
