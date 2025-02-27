package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DataSource;
import dto.IngredientDto;

public class DishDao implements CrudOperation<Dish>{
    DataSource dataSource = new DataSource();
    Connection connection = dataSource.getConnection();
    IngredientDao ingredientDao = new IngredientDao();

    public  List<Dish> getDishes(){
        List<Dish> dishes = new ArrayList<>();
        String query = "select * from dish;";

        try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet result = statement.executeQuery();


            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double unitPrice = result.getDouble("unit_price");
                List<Ingredient> ingredients = new ArrayList<>();
              
                Dish dish = new Dish(id, name, unitPrice,ingredients);
                dishes.add(dish);
            }
               

            return dishes;
       } catch (SQLException e) {
        throw new RuntimeException(e);
       }
      
    }

    @Override
    public List<Dish> getAll() {
        List<Dish> dishes = new ArrayList<>();
        List<Dish> dishList = this.getDishes();

       IngredientDao ingredientDao = new IngredientDao();

    for(Dish d : dishList){
       List<Ingredient> newIngredient = ingredientDao.convertToIngredient(d.getId());
        Dish dish = new Dish(d.getId(), d.getName(), d.getUnitPrice(), newIngredient);
        dish.setIngredientsCost(ingredientDao.getTotal(d.getId())); 
        dishes.add(dish);
    }
       

        return dishes;
    }
    
}
