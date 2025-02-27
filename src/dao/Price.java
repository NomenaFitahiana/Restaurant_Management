package dao;

import java.time.LocalDateTime;
import java.util.Objects;

public class Price {
    private int id;
    private double unitPrice;
    private LocalDateTime addedOn;
    
    public Price(double unitPrice, LocalDateTime addedOn) {
        this.unitPrice = unitPrice;
      this.addedOn = (addedOn == null) ? LocalDateTime.now() : addedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    @Override
    public String toString() {
        return "Price [ unitPrice=" + unitPrice + ", addedOn=" + addedOn + "]";
    }

   @Override
    public int hashCode(){
        return Objects.hash(id,  unitPrice, addedOn);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Price other = (Price) obj;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice))
            return false;
        if (addedOn == null) {
            if (other.addedOn != null)
                return false;
        } else if (!addedOn.equals(other.addedOn))
            return false;
        return true;
    }

    
}
