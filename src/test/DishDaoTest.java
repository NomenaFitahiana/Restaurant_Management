package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.entity.Dish;
import dao.DishDao;
import dao.entity.Ingredient;
import dao.IngredientDao;
import dao.entity.Unit;
import dto.IngredientDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DishDaoTest {
    @Test 
    public void get_all_dishes_ok(){
        DishDao subject = new DishDao();

        List<Dish> expected = new ArrayList<>();

        Ingredient ing1 = new Ingredient(1, "Saucisse",Unit.G,20.0, LocalDateTime.parse("2025-01-01T00:00"));
        Ingredient ing2 = new Ingredient(2, "Huile",Unit.L, 10000.0,LocalDateTime.parse("2025-01-01T00:00") );
        Ingredient ing3 = new Ingredient(3, "Oeuf",Unit.U,1000.0, LocalDateTime.parse("2025-01-01T00:00") );
        Ingredient ing4 = new Ingredient(4, "Pain",Unit.U ,1000.0, LocalDateTime.parse("2025-01-01T00:00") );

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ing1);
        ingredients.add(ing2);
        ingredients.add(ing3);
        ingredients.add(ing4);

        Dish dish = new Dish(1, "hot dog", 15000.0, ingredients);
        
        expected.add(dish);

        
        List<Dish> actual = subject.getAll();

        assertEquals(expected, actual);
    }

    @Test 
    public void check_ingredientsCost_ok(){
        DishDao subject = new DishDao();
        String expected = "5500";


        List<Dish> actualDishes = subject.getAll();
        
        String actual = actualDishes.get(0).getIngredientsCost();

        assertEquals(expected, actual);


    }
}
