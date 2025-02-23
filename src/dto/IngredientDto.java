package dto;

import java.time.LocalDateTime;

import dao.Unit;

public class IngredientDto {
    private String name;
    private double unitPrice;
    private Unit unit;
    private LocalDateTime addedOn;
    private int quantity;

    public IngredientDto(String name, double unitPrice, Unit unit, LocalDateTime addedOn, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.addedOn = addedOn;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "IngredientDto {name=" + name + ", unitPrice=" + unitPrice + ", unit=" + unit + ", addedOn=" + addedOn
                + ", quantity=" + quantity + "}";
    }

    
    
}
