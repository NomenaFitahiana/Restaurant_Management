package dao.entity;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;


public class Dish{
    private int id;
    private String name;
    private double unitPrice; 
    private List<Ingredient> ingredients;
    private double ingredientsCost;

    public Dish(){};

    public Dish (int id,String name, double unitPrice, List<Ingredient> ingredients){
        this.name = name;
        this.unitPrice = unitPrice;
        this.ingredients = ingredients;
        this.id = id;
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

    public String getIngredientsCost() {
        DecimalFormat finalValue = new DecimalFormat("#.##");
        return finalValue.format(ingredientsCost);
    }

    public void setIngredientsCost(double ingredientsCost) {
       this.ingredientsCost = ingredientsCost;
    }

    public String getGrossMargin(){
        DecimalFormat finalValue = new DecimalFormat("#.##");
        return finalValue.format(this.getUnitPrice() - this.ingredientsCost);
    }

    @Override
    public String toString() {
        return "Dish { id = " + id +
                        ", name = " + name +
                        ", unitPrice = " + unitPrice +
                        ", ingredients = " + ingredients + 
                         ", ingredientsCost = " + ingredientsCost + "}";
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