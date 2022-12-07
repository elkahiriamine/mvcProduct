package metier;

import model.Category;
import model.FactoryDate;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Metier implements IMetier{
    private static  int counter;

    private int getNumberRecord(String nameTable){
        int numberRecord = 0;
        String statment = "select count (*) from "+nameTable;
        Connection connection = SingletonOracle.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(statment);){
            resultSet.next();
            numberRecord = resultSet.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return numberRecord;
    }

    @Override
    public void addCategory(Category category) {
        counter = getNumberRecord("CATEGORY");
        ++counter;
        String statement = "insert into CATEGORY values(?,?)";
        Connection connection = SingletonOracle.getConnection();
       try(PreparedStatement ps = connection.prepareStatement(statement)) {
                ps.setInt(1,counter);
                ps.setString(2,category.getNameCG());
                ps.executeUpdate();
       }catch (SQLException e){
              e.printStackTrace();
       }

    }

    @Override
    public void addProduct(Product product, int id_CG, int id_date) {
           counter = getNumberRecord("PRODUCT");
           ++counter;
           String statement = "insert into PRODUCT values(?,?,?,?,?,?)";
           Connection connection = SingletonOracle.getConnection();
           try (PreparedStatement ps= connection.prepareStatement(statement)){
               ps.setInt(1,counter);
               ps.setString(2,product.getRefP());
               ps.setString(3,product.getNameP());
               ps.setDouble(4,product.getPrice());
               ps.setInt(5,id_CG);
               ps.setInt(6,id_date);
               ps.executeUpdate();
           }catch (SQLException e){
               e.printStackTrace();
           }
    }

    @Override
    public List<Product> getProduct(String nameProduct) {
        List<Product> productList = new ArrayList<>();
        String statement = " select * from PRODUCT WHERE NAMEP LIKE ? ";
        Connection connection = SingletonOracle.getConnection();
        try(PreparedStatement ps= connection.prepareStatement(statement)) {
             ps.setString(1,"%"+nameProduct+"%");
             ResultSet resultSet = ps.executeQuery();
             while (resultSet.next()){
                 Product p = new Product();
                 p.setRefP(resultSet.getString("REFP"));
                 p.setNameP(resultSet.getString("NAMEP"));
                 p.setPrice(resultSet.getDouble("PRICE"));
                 Category category = getCategory(resultSet.getInt("ID_CG"));
                 FactoryDate factoryDate = getFactoryDate(resultSet.getInt("ID_DATE"));
                 if(factoryDate != null )
                     p.setFactoryDate(factoryDate);
                 if(category != null)
                 p.setCategory(category);
                 productList.add(p);
             }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category>  categoryList = new ArrayList<>();
        String statement = " select * from CATEGORY";
        Connection connection = SingletonOracle.getConnection();
        try(PreparedStatement ps= connection.prepareStatement(statement)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
               category.setId_CG(resultSet.getInt("ID_CG"));
               category.setNameCG(resultSet.getString("NAMECG"));
               categoryList.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Category getCategory(int id_CG) {
        String statement = " select * from CATEGORY WHERE  ID_CG=? ";
        Connection connection = SingletonOracle.getConnection();
        try(PreparedStatement ps= connection.prepareStatement(statement)) {
            ps.setInt(1,id_CG);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            Category category = new Category();
            category.setId_CG(resultSet.getInt("ID_CG"));
            category.setNameCG(resultSet.getString("NAMECG"));
            resultSet.close();
            return category;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public FactoryDate getFactoryDate(int id_date){
        String statement = " select * from FACTORYDATE WHERE  ID_DATE=? ";
        Connection connection = SingletonOracle.getConnection();
        try(PreparedStatement ps= connection.prepareStatement(statement)) {
            ps.setInt(1,id_date);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            FactoryDate factoryDate = new FactoryDate();
            factoryDate.setId_date(resultSet.getInt("ID_DATE"));
            factoryDate.setExpiredDate( resultSet.getDate("DATE_CREATE"));
            factoryDate.setStartDate(resultSet.getDate("DATE_EXPIRED"));
            resultSet.close();
            return factoryDate;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
