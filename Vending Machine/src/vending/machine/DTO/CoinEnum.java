package vending.machine.DTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * Quarters, Dimes, Nickles and Cents. Gotta keep track of value, while also keeping it easy to follow.
 */
public enum CoinEnum {
    QUARTER(new BigDecimal(".25").setScale(2, RoundingMode.HALF_UP)), 
    DIME(new BigDecimal(".10").setScale(2, RoundingMode.HALF_UP)), 
    NICKEL(new BigDecimal(".05").setScale(2, RoundingMode.HALF_UP)), 
    PENNY(new BigDecimal(".01").setScale(2, RoundingMode.HALF_UP));
    
    private final BigDecimal cents;
    
    private CoinEnum(BigDecimal cents){
        this.cents = cents;
    }
    
    public BigDecimal getBD() {
        return cents;
    }
}
