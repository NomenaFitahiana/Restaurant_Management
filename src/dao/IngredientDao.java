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

public class IngredientDao implements CrudOperation <IngredientDto>{
    DataSource dataSource = new DataSource();
    Connection connection = dataSource.getConnection();

    @Override
    public List<IngredientDto> getAll() {
       String query = "select i.id, i.name, i.last_modification_date, di.quantity, i.unit, p.unit_price, di.montant from ingredient i join dish_ingredient di on i.id = di.ingredient_id join price p on p.ingredient_id = di.ingredient_id;";

       List<Ingredient> ingredients = new ArrayList<>();
       List<IngredientDto> ingredientList = new ArrayList<>(); 

       try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double unitPrice = result.getDouble("unit_price");
                Unit unit = Unit.valueOf(result.getString("unit"));
                LocalDateTime lastModificationDate = result.getTimestamp("last_modification_date").toLocalDateTime();
                int quantity = result.getInt("quantity");
                double montant = result.getDouble("montant");

                IngredientDto ingredientDto = new IngredientDto(id, name, unitPrice, unit, lastModificationDate, quantity, montant);
                ingredientList.add(ingredientDto);

                /*Ingredient ingredient = new Ingredient(name, addedOn, unitPrice, unit);
                ingredients.add(ingredient);*/
            }
               

            return ingredientList;
       } catch (SQLException e) {
        throw new RuntimeException(e);
       }

     
    }
    
}
