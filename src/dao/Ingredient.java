package dao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ingredient {
    private int id;
    private String name;
    private List<Price> prices = new ArrayList<>();
    private Unit unit;

    public Ingredient(){};

    public Ingredient(int id, String  name, Unit unit, double unitPrice, LocalDateTime addedOn){
        this.name = name;
        this.unit = unit;
        this.id = id;
        
        Price newPrice = new Price(unitPrice, addedOn);

        this.prices.add(newPrice);

    }

     public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

   
    public Unit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Ingredient { id = " + id +
                        ", name = " + name +
                        ", unit = " + unit + "}";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Ingredient ingredient = (Ingredient) o;

        return Objects.equals(id, ingredient.id) && Objects.equals(name, ingredient.name) && Objects.equals(unit, ingredient.unit);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, unit);
    }
}

