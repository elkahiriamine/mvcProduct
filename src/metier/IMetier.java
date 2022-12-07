package metier;

import model.Category;
import model.FactoryDate;
import model.Product;

import java.util.List;

public interface IMetier {

    public void addCategory(Category category);
    public void addProduct(Product product, int id_CG, int id_date);
    public List<Product> getProduct(String nameProduct);
    public List<Category> getAllCategory();
    public Category getCategory(int id_CG);
    public FactoryDate getFactoryDate(int id_date);
}
