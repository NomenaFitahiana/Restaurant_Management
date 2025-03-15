/*package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.IngredientDao;
import dao.entity.Criteria;
import dao.entity.CriteriaOperator;
import dao.entity.FieldName;
import dao.entity.Ingredient;
import dao.entity.LogicalOperator;
import dao.entity.Order;
import dao.entity.SortCriteria;
import dao.entity.Unit;
import dto.IngredientDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class IngredientDaoTest {
   @Test
   public void get_all_ingredients_ok(){
    IngredientDao subject = new IngredientDao();

    List<Ingredient> expected = new ArrayList<>();

    Ingredient expected1 = new Ingredient(3, "Oeuf", Unit.U, 21000.0, LocalDateTime.parse("2025-01-01T00:00"));
    Ingredient expected2 = new Ingredient(2, "Huile",Unit.L, 10000.0 , LocalDateTime.parse("2025-01-01T00:00"));
   

    expected.add(expected1);
    expected.add(expected2);
   
   Criteria criteria = new Criteria(FieldName.name, "'%u%'", CriteriaOperator.ILIKE.getSymbol(), LogicalOperator.AND);
   List<Criteria> cr = new ArrayList<>();
   cr.add(criteria);

   SortCriteria sortCriterias = new SortCriteria(FieldName.unit, Order.DESC);

    List<Ingredient> actual = subject.getAll(2, 1, cr, sortCriterias);

    assertEquals(expected, actual);

   }
}*/
