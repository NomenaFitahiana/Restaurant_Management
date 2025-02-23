package repository;

import dao.DishDao;
import dao.IngredientDao;

public class Main {
    public static void main(String[] args) {
        IngredientDao ingredientDao = new IngredientDao();
        DishDao dish = new DishDao();

       // System.out.println(ingredientDao.getAll());
       System.out.println(dish.getAll());
    }
}