package dto;

import java.time.LocalDateTime;

import dao.Unit;

public class IngredientDto {
    private int id;
    private String name;
    private double unitPrice;
    private Unit unit;
    private LocalDateTime lastModificationDate;
    private int quantity;
    private double montant;

    public IngredientDto(int id, String name, double unitPrice, Unit unit, LocalDateTime lastModificationDate, int quantity, double montant) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.lastModificationDate = lastModificationDate;
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

    public LocalDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(LocalDateTime addedOn) {
        this.lastModificationDate = addedOn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "IngredientDto { id=" + id + ", name=" + name + ", lastModificationDate=" + lastModificationDate +  ", quantity=" + quantity + ", unit=" + unit + ", unitPrice=" + unitPrice  + " ,montant=" + montant 
                + "}";
    }

    
    
}
