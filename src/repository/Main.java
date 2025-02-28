package repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.DishDao;
import dao.IngredientDao;
import dao.entity.Criteria;
import dao.entity.CriteriaOperator;
import dao.entity.Dish;
import dao.entity.FieldName;
import dao.entity.Ingredient;
import dao.entity.LogicalOperator;
import dao.entity.Unit;

public class Main {
    public static void main(String[] args) {
       // IngredientDao ingredientDao = new IngredientDao();
        DishDao dish = new DishDao();

       Criteria criteria = new Criteria(FieldName.name, "'hot dog'", CriteriaOperator.EQUAL.getSymbol(), LogicalOperator.AND);
       List<Criteria> cr = new ArrayList<>();
       cr.add(criteria);

       /*System.out.println(ingredientDao.getAll(2, 1, cr));*/
        //System.out.println(dish.getAll());
       //System.out.println(ingredientDao.getByDishId(1));
    /* List<Dish> dishes = dish.getAll(1, 1);

      for (Dish d : dishes) {
        System.out.println(d.getIngredientsCost());
      }*/

      //Ingredient ing = new Ingredient(1, "A", Unit.G, 1500.0, LocalDateTime.parse("2025-01-01T00:00"));

      System.out.println(dish.getAll(1, 1, cr));
    }
}

