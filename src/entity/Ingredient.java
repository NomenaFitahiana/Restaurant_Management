import java.time.LocalDateTime;
import java.util.Objects;

public class Ingredient {
    private int id;
    private String name;
    private LocalDateTime lastModificationDate;
    private double unitPrice;
    private Unit unit;

    public Ingredient(){};
    public Ingredient(String  name, LocalDateTime lastModificationDate, double unitPrice, Unit unit){
        this.name = name;
        this.lastModificationDate = lastModificationDate;
        this.unitPrice = unitPrice;
        this.unit = unit;
    }

     public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getLastModificationDate() {
        return lastModificationDate;
    }
    public void setLastModificationDate(LocalDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Unit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Ingredient { id = " + id +
                        ", name = " + name +
                        ", lastModificationDate = " + lastModificationDate +
                        ", unitPrice = " + unitPrice +
                        ", unit = " + unit + "}";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Ingredient ingredient = (Ingredient) o;

        return Objects.equals(id, ingredient.id) && Objects.equals(name, ingredient.name) && Objects.equals(unitPrice, ingredient.unitPrice) && Objects.equals(lastModificationDate, ingredient.lastModificationDate) && Objects.equals(unit, ingredient.unit);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, lastModificationDate, unitPrice, unit);
    }
}

