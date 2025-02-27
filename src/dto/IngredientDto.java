package dto;

import java.time.LocalDateTime;
import java.util.Objects;

import dao.entity.Ingredient;
import dao.entity.Unit;

public class IngredientDto {
    private int id;
    private String name;
    private double unitPrice;
    private Unit unit;
    private LocalDateTime addedOn;
    private double quantity;
    private double montant;

    public IngredientDto(int id, String name, double unitPrice, Unit unit, LocalDateTime addedOn, double quantity, double montant) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.addedOn = addedOn;
        this.quantity = quantity;
        this.id  = id;
        this.montant = montant;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "IngredientDto { id=" + id + ", name=" + name + ", addedOn=" + addedOn +  ", quantity=" + quantity + ", unit=" + unit + ", unitPrice=" + unitPrice  + " ,montant=" + montant 
                + "}";
    }

     @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        IngredientDto ingredient = (IngredientDto) o;

        return Objects.equals(id, ingredient.id) && Objects.equals(name, ingredient.name) && Objects.equals(unitPrice, ingredient.unitPrice) && Objects.equals(addedOn, ingredient.addedOn) && Objects.equals(unit, ingredient.unit) && Objects.equals(quantity, ingredient.quantity) && Objects.equals(montant, ingredient.montant);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, addedOn, quantity, unitPrice, unit, montant);
    }
    
}
