package dao.entity;

public enum CriteriaOperator {
    EQUAL("="),
    LESS_THAN("<"),
    LESS_OR_EQUAL("<="),
    GREATER_THAN(">"),
    GREATER_OR_EQUAL(">="),
    ILIKE("ILIKE"); 
    
    private final String symbol;

    CriteriaOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}


