package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DataSource;

/*public class DishDao implements CrudOperation<Dish>{
    DataSource dataSource = new DataSource();
    Connection connection = dataSource.getConnection();
    IngredientDao ingredientDao = new IngredientDao();

    @Override
    public List<Dish> getAll() {
      List<Ingredient> ingredients = ingredientDao.getAll();
      String query = "select dish.name, dish.unit_price from dish";
      List<Dish> dishes = new ArrayList<>();

       try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet result = statement.executeQuery();


            while (result.next()) {
                String name = result.getString("name");
                double unitPrice = result.getDouble("unit_price");
               
                Dish dish = new Dish(name, unitPrice, ingredients);
                dishes.add(dish);
              
            }
               

            return dishes;
       } catch (SQLException e) {
        throw new RuntimeException(e);
       }
      
    }
    
}*/
