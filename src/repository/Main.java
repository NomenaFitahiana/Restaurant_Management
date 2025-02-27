package repository;

import java.time.LocalDateTime;
import java.util.List;

import dao.Dish;
import dao.Ingredient;
import dao.DishDao;
import dao.IngredientDao;
import dao.Unit;

public class Main {
    public static void main(String[] args) {
        //IngredientDao ingredientDao = new IngredientDao();
        DishDao dish = new DishDao();

        //System.out.println(dish.getAll());
       //System.out.println(ingredientDao.getByDishId(1));
     List<Dish> dishes = dish.getAll();

      for (Dish d : dishes) {
        System.out.println(d.getIngredientsCost());
      }

      //Ingredient ing = new Ingredient(1, "A", Unit.G, 1500.0, LocalDateTime.parse("2025-01-01T00:00"));

      System.out.println(dish.getAll());
    }
}