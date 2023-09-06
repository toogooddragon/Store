/**
*   Description of Program’s Functionality:
*    This program demonstrates the use of files and arrays.
*    The main logic of the program is printing out a menu for the user to pick, either option 1 to open a new tab or 2 to close the store.
*    If the user enter 1, it then open another screen asking the user for things they have bought, like drinks, snacks, or merchandises.
*    It then store these data in an ArrayList and save the ArrayList in a new ArrayList and puts the old ArrayList equal to null after
*    the user close a transaction. It then output the user what they have bought and ask them to either pay in credit card or cash. It then
*    save this value and outputs it in a receipt format, as well as printing it on a text file. 
*     
*/ 

package finalchallenge;

import Food.Merchandise;
import Food.Snack;
import Food.Drink;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CashRegister {

    public static Scanner keyboard = new Scanner(System.in);
    public static SalesTransaction aTransaction;
    public static StarbucksStore aStore;
    
    /**
     * Local variable: menuOption1, menuOption2
     * Global variable: keyboard, aTransaction, aStore
     * 
     * This is the main method, it first runs the openStore method, then goes into a nested do-while loop that ask the user to pick an option
     * of 1, to openTab, or 2, close the store.
     * 
     * If the user enter 1, it runs the openTab() method, then ask the user to pick an option of 1 to 4, 1 is to sell a drink, 2 is to sell a 
     * snack, 3 is to sell a merchandise, and 4 to close the transaction. If the user enter 1, it will runs the processDrink() method, if the 
     * user enter 2, it will runs the processSnack() method, if the user enter 3, it will runs the processMerchandise() method, if the user 
     * enter 4, it will runs the processsSale() method, and if the user enter any other numbers, it will prompt them to pick a number between 
     * 1 to 4, and show the menu again.
     * 
     * If the user enter 2, it will close the store
     * 
     * if the user enter any other number, it will prompt the user to enter either 1 or 2 and show the user the menu again.
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String args[]) throws IOException {

        int menuOption1 = 0;
        int menuOption2 = 0;

        openStore();

        System.out.println("Welcome to my Starbucks Store!  We are now open for business.");

        do {
            menuOption1 = displayMenu1();

            switch (menuOption1) {
                case 1:
                    openTab();
                    do {
                        menuOption2 = displayMenu2();
                        switch (menuOption2) {
                            case 1:
                                processDrink();
                                break;
                            case 2:
                                processSnack();
                                break;
                            case 3:
                                processMerchandise();
                                break;
                            case 4:
                                processSale();
                                break;
                            default:
                                System.out.println("Invalid menu selection; Choose 1 - 3 or 4 to Close Transaction");
                        }
                    } while (menuOption2 != 4);
                case 2:
                    break;
                default:
                    System.out.println("Invalid menu selection; Choose 1 to Open Tab, or 2 to Close Store");
            }
            
        } while (menuOption1 != 2);
    }

    /**
     * Local variable: menuOption
     * 
     * This method checks if aTransaction is equal to null, if it is, then out put 2 lines that says 
     * "1. Open a tab for customer."
     * "2. Close store for the day."
     * and then retrieve the user's choice and save it into menuOption and returns it.
     * 
     * @return menuOption
     */
    public static int displayMenu1() {
        if (aTransaction == null) {
            System.out.println("\t1. Open a tab for a customer.");
            System.out.println("\t2. Close store for the day.");
        }
        int menuOption = keyboard.nextInt();
        keyboard.nextLine();

        return menuOption;
    }

    /**
     * Local variable: menuOption
     * 
     * This method asks the user for enter a number between 1 and 4, and then retrieve the answer and save it into menuOption.
     * Then it checks if aTransaction is equal to null, and if it is, then set menuOption equal to 0, then returns the value of menuOption.
     * @return menuOption
     */
    public static int displayMenu2() {
        System.out.println("\nWhat would you like to do next? ");

        System.out.println("\t1. Sell a drink.");
        System.out.println("\t2. Sell a snack.");
        System.out.println("\t3. Sell a merchandise");
        System.out.println("\t4. Close a sale.");

        int menuOption = keyboard.nextInt();
        keyboard.nextLine();

        if (aTransaction == null) {
            menuOption = 0;   //force menu option to be 0
        }
        return menuOption;
    }

    /**
     * Local variable: storeCode, storeLocation, hourOpen, hourClosed, dailySales
     * 
     * This menu set storeCode to 703, storeLocation to "FIU," hourOpen to 0700, hourClosed to 2200, and then create an empty ArrayList named
     * named dailySales, then creates a new aStore with these variables as parameters.
     */
    public static void openStore() {
        final int storeCode = 703;
        final String storeLocation = "FIU";
        final int hourOpen = 0700;
        final int hourClosed = 2200;
        ArrayList<SalesTransaction> dailySales = new ArrayList<>();
        aStore = new StarbucksStore(storeCode, storeLocation, hourOpen, hourClosed, dailySales);
    }

    /**
     * Local variable: custName, date, dateFormat, timeStamp
     * 
     * This method ask the user for their name, and gets the instant time that they started the transaction and create a new aTransaction
     * with the timeStamp and custName.
     */
    public static void openTab() {
        System.out.println("\n\nWelcome to Starbucks! \nWhat is your name please?");
        String custName = keyboard.nextLine();
        Date date;
        date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss-a");
        String timeStamp = dateFormat.format(date);
        aTransaction = new SalesTransaction(timeStamp, custName);

    }

    /**
     * Local variable: aDrink, drinkName, drinkSize, drinkOunces, drinkCost , creamChoice, addedCream, flavorChoice, addedFlavor
     * 
     * This menu first ask the user for their drink's name, then store it to drinkName. It then ask the size of the user's drink. 
     * 
     * If the size is small, set drinkOunces to 8.0, and drinkCost to 2.50. If the size is medium, set drinkOunces to 12.5, and drinkCost to 3.75.
     * If the size is large, set drinkOunces to 16.8, and drinkCost to 5.90. If the size is something else, set drinkOunces to 4.0, and drinkCost 
     * to 1.25.
     * 
     * It then ask the user if they want to add cream, if the user answer yes, set addCream to true and add 1.50 to drinkCost. It then ask the 
     * user if they want to add flavor onto their drink, if the answer is yes, ask the user for the flavor and add 1.95 to drinkCost.
     * 
     * It then print out the drinkCost and creates a new aDrink with these values as parameter, then calls the getDrink() method from
     * aTransaction and add aDrink to it, then print out aTransaction.
     * 
     */
    public static void processDrink() {
        Drink aDrink;

        System.out.println("What is the name of your drink?");
        String drinkName = keyboard.nextLine();

        System.out.println("What is the size of your drink? (small, medium, large)");
        String drinkSize = keyboard.nextLine();

        double drinkOunces = 0;
        double drinkCost = 0;
        drinkSize = drinkSize.toLowerCase();
        switch (drinkSize) {
            case "small":
                drinkOunces = 8.0;
                drinkCost = 2.50;
                break;
            case "medium":
                drinkOunces = 12.5;
                drinkCost = 3.75;
                break;
            case "large":
                drinkOunces = 16.8;
                drinkCost = 5.90;
                break;
            default:
                drinkOunces = 4.0;
                drinkCost = 1.25;
        }

        System.out.println("Do you want to add cream?");
        String creamChoice = keyboard.nextLine();
        boolean addedCream = false;
        if (creamChoice.equalsIgnoreCase("yes")) {
            addedCream = true;
            drinkCost += 1.50;
        }

        System.out.println("Do you want to add a flavor?");
        String flavorChoice = keyboard.nextLine();
        String addedFlavor = null;
        if (flavorChoice.equalsIgnoreCase("yes")) {
            System.out.println("What is your desired flavor?");
            addedFlavor = keyboard.nextLine();
            drinkCost += 1.95;
        }

        System.out.println("\nYour drink cost is " + drinkCost);
        aDrink = new Drink(drinkName, drinkSize, drinkOunces, addedCream, addedFlavor, drinkCost);
        aTransaction.getDrinks().add(aDrink);
        System.out.println(aTransaction);
    }

    /**
     * Local variable: aSnack, snackName, description, cost 
     * 
     * This method first ask the user for the name of the snack and save it to snackName. If snackName is apple or banana, set description
     * to "fruit snack" and cost to 2.50. If snackName is bagel, cake, or cookies, then set description to "carbohydrate snack" and cost
     * to 3.50. If the snackName is none of the above, set description to "other snack" and cost to 1.50.
     * 
     * It then print out the cost and creates a new aSnack with these values as parameter, then calls the getSnack() method from
     * aTransaction and add aSnack to it, then print out aTransaction.
     */
    public static void processSnack() {
        Snack aSnack;
        System.out.println("What is the name of your snack?");
        String snackName = keyboard.nextLine();
        String description;
        double cost = 0.0;
        snackName = snackName.toLowerCase();
        switch (snackName) {
            case "apple", "banana":
                description = "fruit snack";
                cost = 2.50;
                break;
            case "bagel", "cake", "cookies":
                description = "carbohydrate snack";
                cost = 3.50;
                break;
            default:
                description = "other snack";
                cost = 1.50;
        }
        
        System.out.println("\nYour snack cost is " + cost);
        aSnack = new Snack(snackName, description, cost);
        aTransaction.getSnacks().add(aSnack);
        System.out.println(aTransaction);
    }

    /**
     * Local variable: aMerchandise, merchCost, merchName, merchSize, merchPrice, merchQuantity
     * 
     * This method ask the user for the name of the merchandise, then save it to merchName. It then ask the user for the size of the merchandise
     * and save it to merchSize.
     * 
     * If the merchSize is small, set merchCost to 1.50, if merchSize is medium, set merchCost to 2.75, if merchSize is large, set merchCost to 3.90
     * and if merchSize is something else, set merchCost to 1.25.
     * 
     * It then ask the user for the price of the merchandise and add it to merchCost, it then ask the user for the quantity of the merchandise
     * and save it to merchQuantity. 
     * 
     * It then print out the cost and creates a new aMerchandise with these values as parameter, then calls the getMerchandises() method from
     * aTransaction and add aMerchandise to it, then print out aTransaction.
     * 
     */
    public static void processMerchandise() {
        Merchandise aMerchandise;
        double merchCost;
        System.out.println("What is the merchandise's name?");
        String merchName = keyboard.nextLine();
        System.out.println("What is the merchandise's size? (small, medium, large)");
        String merchSize = keyboard.nextLine();
        
        switch (merchSize) {
            case "small":
                merchCost = 1.50;
                break;
            case "medium":
                merchCost = 2.75;
                break;
            case "large":
                merchCost = 3.90;
                break;
            default:
                merchCost = 1.25;
        }
        System.out.println("What is the merchandise's price?");
        merchCost += keyboard.nextDouble();
        System.out.println("What is the merchandise's quantity");
        int merchQuantity = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("\nYour merchandise cost is " + (merchCost*merchQuantity));
        aMerchandise = new Merchandise(merchName, merchSize, merchCost, merchQuantity);
        aTransaction.getMerchandises().add(aMerchandise);
        System.out.println(aTransaction);
    }

    /**
     * Local variable: grandTotal, payType, crediCardname, creditCardNumber, creditCardPayment
     * 
     * This method ask the user for their payment method, enter 1 for credit card, 2 for cash
     * 
     * If the user enter 1, it then ask the user for the type of credit card and their credit card number, then save it to creditCardName and
     * creditCardNumber, then calls setCustomerPaymentMethod, setcreditCardname, and setCreditCardNumber from aTransaction with these values
     * 
     * If the user enter 2, calls the method setCustomerPaymentMethod with the parameter "Cash"
     * 
     * It then runs the summarizeStoreSales() and recordTransaction() method
     * @throws IOException 
     */
    public static void processSale() throws IOException {
        DecimalFormat df = new DecimalFormat("##0.00");
        double grandTotal = aTransaction.tabulateSale();
        System.out.println("Please pay $" + df.format(grandTotal));

        System.out.println("Will you be paying by Credit Card or Cash?");
        System.out.println("Enter 1 for Credit Card, 2 for Cash");
        String payType = keyboard.nextLine();
        if (payType.contains("1")) {
            System.out.println("What credit card will you be using?");
            String creditCardName = keyboard.nextLine();
            System.out.println("What is your cc number?");
            String creditCardNumber = keyboard.nextLine();
            aTransaction.setCustomerPaymentMethod("Credit card");
            aTransaction.setCreditCardName(creditCardName);
            aTransaction.setCreditCardNumber(creditCardNumber);
        } else {
            aTransaction.setCustomerPaymentMethod("Cash");
            System.out.println("Please pay in cash now.");
        }
        aTransaction.setAmountPaid(grandTotal);
        System.out.println("\nThank you for stopping by.  Please come back soon!");

        summarizeStoreSales();
        recordTransaction();
    }

    /**
     * Local variable: fw, pw, menuOption1
     * 
     * Write aTransaction to salesTransactions.txt, then set aTransaction to null and menuOption1 to 2, then return menuOption1
     * 
     * @return menuOption1
     * @throws IOException 
     */
    public static int recordTransaction() throws IOException {
        FileWriter fw = new FileWriter("salesTransactions.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(aTransaction);
        pw.close();

        aTransaction = null; //reset after sale is complete, to force menu to show open a new tab.
        int menuOption1 = 2;
        return menuOption1;
    }

    /**
     * Local variable: dailiGrandTotal, date, timeStamp, storemessage, fw, pw
     * 
     * This method calls getDailySales() from aStore and add aTransaction to it. It then prints out aTransaction and storeMessage then
     * writes storeMessage in salesTransactions.txt
     * @throws IOException 
     */
    public static void summarizeStoreSales() throws IOException {
        double dailyGrandTotal = 0;
        aStore.getDailySales().add(aTransaction);

        dailyGrandTotal = aStore.accumulateDailySales();

        DecimalFormat df = new DecimalFormat("##00.00");
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss-a"
                + "");
        String timeStamp = dateFormat.format(date);
        String storeMessage = "On " + timeStamp + 
                                ", the " + aStore.getLocation() + 
                                " Starbucks store has sold $" + 
                                df.format(dailyGrandTotal) + "\n";
        
        System.out.println(aTransaction);
        System.out.println(storeMessage);

        FileWriter fw = new FileWriter("salesTransactions.txt", true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(storeMessage);
        pw.close();
    }

}
