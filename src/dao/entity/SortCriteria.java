package dao.entity;

public class SortCriteria {
    private FieldName fieldName;
    private Order order; 

    public SortCriteria(FieldName fieldName, Order order) {
        this.fieldName = fieldName;
        this.order = order;
    }

    public FieldName getFieldName() {
        return fieldName;
    }

    public Order getOrder() {
        return order;
    }
}
