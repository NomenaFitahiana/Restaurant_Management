import java.util.List;
import java.util.Objects;

public class Dish{
    private int id;
    private String name;
    private double unitPrice; 
    private List<Ingredient> ingredients;
    private double productPrice;

    public Dish(){};

    public Dish (String name, double unitPrice, List<Ingredient> ingredients){
        this.name = name;
        this.unitPrice = unitPrice;
        this.ingredients = ingredients;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice() {
        this.productPrice = this.getIngredients().stream()
        .mapToDouble(ingredient -> ingredient.getUnitPrice())
        .sum();
    }

    @Override
    public String toString() {
        return "Dish { id = " + id +
                        ", name = " + name +
                        ", unitPrice = " + unitPrice +
                        ", ingredients = " + ingredients + 
                         ", productPrice = " + productPrice + "}";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        return Objects.equals(id, dish.id) && Objects.equals(name, dish.name) && Objects.equals(unitPrice, dish.unitPrice) && Objects.equals(ingredients, dish.ingredients);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, unitPrice, ingredients);
    }

}