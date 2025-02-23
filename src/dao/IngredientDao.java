package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import db.DataSource;
import dto.IngredientDto;

public class IngredientDao implements CrudOperation <Ingredient>{
    DataSource dataSource = new DataSource();
    Connection connection = dataSource.getConnection();

    @Override
    public List<Ingredient> getAll() {
       String query = "select ingredient.name, price.unit_price,ingredient.unit,  price.addedon, dish_ingredient.quantity from ingredient join dish_ingredient on dish_ingredient.ingredient_id = ingredient.id join price on price.ingredient_id = ingredient.id where dish_ingredient.dish_id = 1;";

       List<Ingredient> ingredients = new ArrayList<>();
       List<IngredientDto> ingredientList = new ArrayList<>(); 

       try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet result = statement.executeQuery();


            while (result.next()) {
                String name = result.getString("name");
                double unitPrice = result.getDouble("unit_price");
                Unit unit = Unit.valueOf(result.getString("unit"));
                LocalDateTime addedOn = result.getTimestamp("addedon").toLocalDateTime();
                int quantity = result.getInt("quantity");

                IngredientDto ingredientDto = new IngredientDto(name, unitPrice, unit, addedOn, quantity);
                ingredientList.add(ingredientDto);

                Ingredient ingredient = new Ingredient(name, addedOn, unitPrice, unit);
                ingredients.add(ingredient);
            }
               

            return ingredients;
       } catch (SQLException e) {
        throw new RuntimeException(e);
       }

     
    }
    
}
