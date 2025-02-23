package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.IngredientDao;
import dao.Unit;
import dto.IngredientDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class IngredientDaoTest {
   @Test
   public void get_all_ingredients_ok(){
    IngredientDao subject = new IngredientDao();

    List<IngredientDto> expected = new ArrayList<>();

    IngredientDto expected1 = new IngredientDto(1, "Saucisse", 20.0, Unit.G, LocalDateTime.parse("2025-01-01T00:00"), 100, 2000.0);
    IngredientDto expected2 = new IngredientDto(2, "Huile", 10000.0 , Unit.L, LocalDateTime.parse("2025-01-01T00:00"), 0.15000000596046448, 1500.00005960464);
    IngredientDto expected3 = new IngredientDto(3, "Oeuf", 1000.0, Unit.U, LocalDateTime.parse("2025-01-01T00:00"), 1, 1000.0);
    IngredientDto expected4 = new IngredientDto(4, "Pain", 1000.0, Unit.U, LocalDateTime.parse("2025-01-01T00:00"), 1, 1000.0);

    expected.add(expected1);
    expected.add(expected2);
    expected.add(expected3);
    expected.add(expected4);

    List<IngredientDto> actual = subject.getAll();

    assertEquals(expected, actual);

   }
}
