package dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
                double quantity = result.getDouble("quantity");
                double montant = result.getDouble("montant");

                IngredientDto ingredientDto = new IngredientDto(id, name, unitPrice, unit, lastModificationDate, quantity, montant);
                ingredientList.add(ingredientDto);

            }
               

            return ingredientList;
       } catch (SQLException e) {
        throw new RuntimeException(e);
       }

     
    }

    public List<IngredientDto> getByDishId(int dish_id){
        String query = "select i.id, i.name, i.last_modification_date, di.quantity, i.unit, p.unit_price, di.montant from ingredient i join dish_ingredient di on i.id = di.ingredient_id join price p on p.ingredient_id = di.ingredient_id where di.dish_id = ? ";
        List<IngredientDto> ingredients = new ArrayList<>();
        
        try ( PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, dish_id);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double unitPrice = result.getDouble("unit_price");
                Unit unit = Unit.valueOf(result.getString("unit"));
                LocalDateTime lastModificationDate = result.getTimestamp("last_modification_date").toLocalDateTime();
                double quantity = result.getDouble("quantity");
                double montant = result.getDouble("montant");

                IngredientDto ingredientDto = new IngredientDto(id, name, unitPrice, unit, lastModificationDate, quantity, montant);
                ingredients.add(ingredientDto);
            }
       } catch (SQLException e) {
        throw new RuntimeException(e);
       }

       return ingredients;
    }

    public List<Ingredient> convertToIngredient(int dish_id){
        List<IngredientDto> ingredientDto = this.getByDishId(dish_id);
        List<Ingredient> ingredients = new ArrayList<>();

        double totalPrice = ingredientDto.stream()
        .mapToDouble(IngredientDto::getMontant)
        .sum();
    
        for(IngredientDto i : ingredientDto){
            Ingredient ingredient = new Ingredient(i.getId(), i.getName(), i.getLastModificationDate(), i.getUnitPrice(), i.getUnit());
            ingredients.add(ingredient);
        }


        return ingredients;
    }

    public double getToral(int dish_id){
        List<IngredientDto> ingredientDto = this.getByDishId(dish_id);

        return ingredientDto.stream()
        .mapToDouble(IngredientDto::getMontant)
        .sum();
    }
    
}
