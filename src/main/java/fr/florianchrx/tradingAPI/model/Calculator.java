package fr.florianchrx.tradingAPI.model;

/**
 * A calculator is an entity who can calculate some analytics values.
 */
public interface Calculator {
    /**
     * Calculate the benefits
     * @return the realized benefits
     */
    double getBenefits();

    /**
     * Calculate the amount bought
     * @return the total amount bought
     */
    double getBuyAmount();

    /**
     * Calculate the amount sell
     * @return the total amount sell
     */
    double getSellAmount();

    /**
     * Calculate the average buy price
     * @return the average buy price
     */
    double getAverageBuyPrice();

    /**
     * Calculate the average sell price
     * @return the average sell price
     */
    double getAverageSellPrice();
}
