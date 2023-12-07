package design_pattern.strategy.strategy_a;

/**
 * @author ronin
 */
public class SimpleTaxCalculateStrategy implements TaxCalculatorStrategy{

    @Override
    public double calculate(double salary, double bonus) {
        return salary * 0.5 + bonus * 0.5;
    }
}
