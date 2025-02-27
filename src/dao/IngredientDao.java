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

import dao.entity.Ingredient;
import dao.entity.Price;
import dao.entity.Unit;
import db.DataSource;
import dto.IngredientDto;

public class IngredientDao implements CrudOperation <Ingredient>{
    DataSource dataSource = new DataSource();
    Connection connection = dataSource.getConnection();

    // TODOS : get misy filtre miaraka amin'ny date | checker-na ilay date any am price dia izay mifanaraka amin'iny no alaina na izay manakaiky azy
    
    /*@Override
    public List<IngredientDto> getAll() {
       String query = "select i.id, i.name, p.addedon, di.quantity, i.unit, p.unit_price, di.montant from ingredient i join dish_ingredient di on i.id = di.ingredient_id join price p on p.ingredient_id = di.ingredient_id;";
       List<Price> prices = new ArrayList<>();
       List<IngredientDto> ingredientList = new ArrayList<>(); 

       try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double unitPrice = result.getDouble("unit_price");
                Unit unit = Unit.valueOf(result.getString("unit"));
                LocalDateTime lastModificationDate = result.getTimestamp("addedon").toLocalDateTime();
                double quantity = result.getDouble("quantity");
                double montant = result.getDouble("montant");

                IngredientDto ingredientDto = new IngredientDto(id, name, unitPrice, unit, lastModificationDate, quantity, montant);
                ingredientList.add(ingredientDto);

            }
               

            return ingredientList;
       } catch (SQLException e) {
        throw new RuntimeException(e);
       }

     
    }*/

    @Override
    public List<Ingredient> getAll(){
        List<Price> prices = new ArrayList<>();
        List<Ingredient> ingredientList = new ArrayList<>(); 
        String query = "select i.id, i.name, i.unit from ingredient i;";

        try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                Unit unit = Unit.valueOf(result.getString("unit"));
                prices = getPriceByIngId(id);

                Ingredient ingredient = new Ingredient(id, name, unit, prices);

                ingredientList.add(ingredient);

            }
               

            return ingredientList;
       } catch (SQLException e) {
        throw new RuntimeException(e);
       }
 
    }

   public List<IngredientDto> getByDishId(int dish_id){
        String query = "select i.id, i.name, p.added_on, di.quantity, i.unit, p.unit_price, di.montant from ingredient i join dish_ingredient di on i.id = di.ingredient_id join price p on p.ingredient_id = di.ingredient_id where di.dish_id = ? ";
        List<IngredientDto> ingredients = new ArrayList<>();
        
        try ( PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, dish_id);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double unitPrice = result.getDouble("unit_price");
                Unit unit = Unit.valueOf(result.getString("unit"));
                LocalDateTime lastModificationDate = result.getTimestamp("added_on").toLocalDateTime();
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
   
        for(IngredientDto i : ingredientDto){
            Ingredient ingredient = new Ingredient(i.getId(), i.getName(),i.getUnit(),i.getUnitPrice(), i.getAddedOn() );
            ingredients.add(ingredient);
        }


        return ingredients;
    }

    public double getTotal(int dish_id) {
        List<IngredientDto> ingredientDto = this.getByDishId(dish_id);
    
        DecimalFormat finalValue = new DecimalFormat("#.##");
        
        double total = ingredientDto.stream()
                .mapToDouble(IngredientDto::getMontant)
                .sum();
        
        return Double.parseDouble(finalValue.format(total).replace(",", "."));
    }
    
    
    public List<Price> getPriceByIngId(int ingredientId){
        List<Price> prices = new ArrayList<>();
        String query = "select id, unit_price, added_on from price where ingredient_id = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, ingredientId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                double unitPrice = result.getDouble("unit_price");
                LocalDateTime addedOn = result.getTimestamp("added_on").toLocalDateTime();

                Price price = new Price(unitPrice, addedOn);
                prices.add(price);
            }

            return prices;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
