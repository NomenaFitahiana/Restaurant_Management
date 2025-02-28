package dao.entity;

public class Criteria {
    private FieldName fieldName;
    private String value;
    private String CriteriaOperator;
    private LogicalOperator LogicalOperator;

    public Criteria(FieldName fieldName, String value, String criteriaOperator,
            LogicalOperator logicalOperator) {
        this.fieldName = fieldName;
        this.value = value;
        CriteriaOperator = criteriaOperator;
        LogicalOperator = logicalOperator;
    }

    

    public FieldName getFieldName() {
        return fieldName;
    }



    public void setFieldName(FieldName fieldName) {
        this.fieldName = fieldName;
    }



    public String getValue() {
        return value;
    }



    public void setValue(String value) {
        this.value = value;
    }



    public String getCriteriaOperator() {
        return CriteriaOperator;
    }



    public void setCriteriaOperator(String criteriaOperator) {
        CriteriaOperator = criteriaOperator;
    }



    public LogicalOperator getLogicalOperator() {
        return LogicalOperator;
    }



    public void setLogicalOperator(LogicalOperator logicalOperator) {
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
