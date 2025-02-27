package dao;

public class Criteria {
    private String fieldName;
    private String value;
    private CriteriaOperator CriteriaOperator;
    private LogicalOperator LogicalOperator;

    public Criteria(String fieldName, String value, CriteriaOperator criteriaOperator,
            LogicalOperator logicalOperator) {
        this.fieldName = fieldName;
        this.value = value;
        CriteriaOperator = criteriaOperator;
        LogicalOperator = logicalOperator;
    }

    @Override
    public String toString() {
        return "Criteria [fieldName=" + fieldName + ", value=" + value + ", CriteriaOperator=" + CriteriaOperator
                + ", LogicalOperator=" + LogicalOperator + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((CriteriaOperator == null) ? 0 : CriteriaOperator.hashCode());
        result = prime * result + ((LogicalOperator == null) ? 0 : LogicalOperator.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Criteria other = (Criteria) obj;
        if (fieldName == null) {
            if (other.fieldName != null)
                return false;
        } else if (!fieldName.equals(other.fieldName))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (CriteriaOperator != other.CriteriaOperator)
            return false;
        if (LogicalOperator != other.LogicalOperator)
            return false;
        return true;
    }

    

    
}
