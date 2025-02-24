package repository;

import dao.DishDao;
//import dao.DishDao;
import dao.IngredientDao;

public class Main {
    public static void main(String[] args) {
        //IngredientDao ingredientDao = new IngredientDao();
        DishDao dish = new DishDao();

       //System.out.println(ingredientDao.getByDishId(1));
       System.out.println(dish.getAll());
    }
}