package repository;

import java.util.List;

import dao.Dish;
import dao.DishDao;
//import dao.DishDao;
import dao.IngredientDao;

public class Main {
    public static void main(String[] args) {
        //IngredientDao ingredientDao = new IngredientDao();
        DishDao dish = new DishDao();

        System.out.println(dish.getAll());
       //System.out.println(ingredientDao.getByDishId(1));
     /*List<Dish> dishes = dish.getAll();

      for (Dish d : dishes) {
        System.out.println(d.getIngredientsCost());
      }*/
    }
}