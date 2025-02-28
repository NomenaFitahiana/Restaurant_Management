package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.entity.Criteria;
import dao.entity.Dish;
import dao.entity.Ingredient;
import db.DataSource;

public class DishDao implements CrudOperation<Dish>{
    DataSource dataSource = new DataSource();
    Connection connection = dataSource.getConnection();
    IngredientDao ingredientDao = new IngredientDao();

    public  List<Dish> getDishes(int pageSize, int page, List<Criteria> criterias){
        List<Dish> dishes = new ArrayList<>();
        StringBuilder query = new StringBuilder("select d.id, d.name, d.unit_price from dish d where 1 = 1 ");

        criterias.forEach(criteria -> query.append(criteria.getLogicalOperator()).append(" ").append(criteria.getFieldName()).append(" ").append(criteria.getCriteriaOperator()).append(" ").append(criteria.getValue()));

        query.append(" limit ? offset ?;");

        try (PreparedStatement statement = connection.prepareStatement(query.toString())){
            int offset = pageSize * (page - 1);

            statement.setInt(1, pageSize);
            statement.setInt(2, offset);

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
    public List<Dish> getAll(int page, int pageSize, List<Criteria> criterias) {
        List<Dish> dishes = new ArrayList<>();
        List<Dish> dishList = this.getDishes(page, pageSize, criterias);

       IngredientDao ingredientDao = new IngredientDao();

    for(Dish d : dishList){
       List<Ingredient> newIngredient = ingredientDao.convertToIngredient(d.getId());
        Dish dish = new Dish(d.getId(), d.getName(), d.getUnitPrice(), newIngredient);
        dish.setIngredientsCost(ingredientDao.getTotal(d.getId())); 
        dishes.add(dish);
    }
       

        return dishes;
    }

    @Override
    public Dish getById(int id) {
        String query = "select d.id, d.name, d.unit_price from dish d where id = ?;";
        Dish dish = new Dish();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            
            if(result.next()){
                String name = result.getString("name");
                double unitPrice = result.getDouble("unit_price");
                List<Ingredient> ingredients = ingredientDao.convertToIngredient(id);

                 dish = new Dish(id, name, unitPrice, ingredients);
                 dish.setIngredientsCost(ingredientDao.getTotal(id));
            } else {
                return null;
            }

            return dish;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
