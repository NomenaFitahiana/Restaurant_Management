package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.IngredientDao;
import dao.entity.Criteria;
import dao.entity.CriteriaOperator;
import dao.entity.FieldName;
import dao.entity.Ingredient;
import dao.entity.LogicalOperator;
import dao.entity.Unit;
import dto.IngredientDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class IngredientDaoTest {
   @Test
   public void get_all_ingredients_ok(){
    IngredientDao subject = new IngredientDao();

    List<Ingredient> expected = new ArrayList<>();

    Ingredient expected1 = new Ingredient(1, "Saucisse", Unit.G, 20.0, LocalDateTime.parse("2025-01-01T00:00"));
    Ingredient expected2 = new Ingredient(2, "Huile",Unit.L, 10000.0 , LocalDateTime.parse("2025-01-01T00:00"));
   

    expected.add(expected1);
    expected.add(expected2);
   
   Criteria criteria = new Criteria(FieldName.name, "'%u%'", CriteriaOperator.ILIKE, LogicalOperator.AND);
   List<Criteria> cr = new ArrayList<>();
   cr.add(criteria);


    List<Ingredient> actual = subject.getAll(2, 1, cr);

    assertEquals(expected, actual);

   }
}
