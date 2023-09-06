package finalchallenge;

import Food.Merchandise;
import Food.Snack;
import Food.Drink;
import java.util.ArrayList;

public class SalesTransaction {

    private String transactDateTime;
    private String customerName;
    private ArrayList<Drink> drinks;
    private ArrayList<Snack> snacks;
    private ArrayList<Merchandise> merchandises;
    private String customerPaymentMethod;
    private String creditCardName;
    private String creditCardNumber;
    private double amountPaid;

    /**
     * constructor for SalesTransaction
     * 
     * @param transactDateTime
     * @param customerName
     * @param drinks
     * @param snacks
     * @param merchandises
     * @param customerPaymentMethod
     * @param creditCardName
     * @param creditCardNumber
     * @param amountPaid 
     */
    public SalesTransaction(String transactDateTime, String customerName, ArrayList<Drink> drinks,
                            ArrayList<Snack> snacks, ArrayList<Merchandise> merchandises, String customerPaymentMethod, String creditCardName,
                            String creditCardNumber, double amountPaid) {
        this.transactDateTime = transactDateTime;
        this.customerName = customerName;
        this.drinks = new ArrayList<>();
        this.snacks = new ArrayList<>();
        this.merchandises = new ArrayList<>();
        this.customerPaymentMethod = customerPaymentMethod;
        this.creditCardName = creditCardName;
        this.creditCardNumber = creditCardNumber;
        this.amountPaid = amountPaid;
    }

    /**
     * default constructor for SalesTransaction
     * 
     * @param transactDateTime
     * @param customerName 
     */
    public SalesTransaction(String transactDateTime, String customerName) {
        this.transactDateTime = transactDateTime;
        this.customerName = customerName;
        this.drinks = new ArrayList<>();
        this.snacks = new ArrayList<>();
        this.merchandises = new ArrayList<>();
        this.customerPaymentMethod = "none";
        this.creditCardName = "none";
        this.creditCardNumber = "none";
        this.amountPaid = 0;
    }

    /**
     * getters and setters for for SalesTransaction
     *
     */
    
    public String getTransactDateTime() {
        return transactDateTime;
    }

    public void setTransactDateTime(String transactDateTime) {
        this.transactDateTime = transactDateTime;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    public ArrayList<Snack> getSnacks() {
        return snacks;
    }

    public void setSnacks(ArrayList<Snack> snacks) {
        this.snacks = snacks;
    }

    public ArrayList<Merchandise> getMerchandises() {
        return merchandises;
    }

    public void setMerchandises(ArrayList<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }
 
    public String getCustomerPaymentMethod() {
        return customerPaymentMethod;
    }

    public void setCustomerPaymentMethod(String customerPaymentMethod) {
        this.customerPaymentMethod = customerPaymentMethod;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
    
    /**
     * This method add up all the cost of snacks, drinks, and merchandises together, multiply them by taxRate and set it to granTotal
     * 
     * @return grandTotal
     */
    public double tabulateSale()
    {
        double totalDrinkCosts = 0;
        double totalSnackCosts = 0;
        double totalMerchandiseCosts = 0;
        double grandTotal = 0;
        double salesTax;
        final double taxRate = .07;

        for (int i = 0; i < getSnacks().size(); i++) {
            totalSnackCosts += getSnacks().get(i).getCost();
        }

        for (int i = 0; i < getDrinks().size(); i++) {
            totalDrinkCosts += getDrinks().get(i).getCost();
        }
        for (int i = 0; i < getMerchandises().size(); i++) {
            totalMerchandiseCosts += getMerchandises().get(i).getCost();
        }

        grandTotal = totalSnackCosts + totalDrinkCosts + totalMerchandiseCosts;

        salesTax = grandTotal * taxRate;
        grandTotal += salesTax;
        return grandTotal;
    }

    @Override
    /**
     * toString of SalesTransaction
     */
    public String toString() {
        String receipt = "\n----------------------------------------------\n";
        receipt +=
                transactDateTime + "\n" +
                customerName + "\n" ;
        
        if (!drinks.isEmpty()) {
            receipt += " \n Drinks: " + drinks;
        }
        if (!snacks.isEmpty()) {
            receipt += " \n Snacks: " + snacks;
        }
        if (!merchandises.isEmpty()) {
            receipt += " \n Merchandes: " + merchandises;
        }
        
        receipt += String.format("\n Total: %.2f$", tabulateSale());

        receipt += " \n Payment Method: " + customerPaymentMethod;
        if (customerPaymentMethod.equalsIgnoreCase("credit card")) {
            receipt += "\n Credit Card: " + creditCardName +
                    "\n Credit Card Number: " + creditCardNumber;
        }
        receipt += String.format("\n AmountPaid = %.2f", amountPaid);
        receipt += "\n----------------------------------------------\n";

        return receipt;
    }
}

