package finalchallenge;

import java.util.ArrayList;

public class StarbucksStore {
    private int code;
    private String location;
    private int hourOpen;
    private int hourClosed;
    private ArrayList<SalesTransaction> dailySales;
    
    /**
     * constructor for StarbuckStore
     * @param code
     * @param location
     * @param hourOpen
     * @param hourClosed
     * @param dailySales 
     */
    public StarbucksStore(int code, String location, int hourOpen, int hourClosed, ArrayList<SalesTransaction> dailySales) {
        this.code = code;
        this.location = location;
        this.hourOpen = hourOpen;
        this.hourClosed = hourClosed;
        this.dailySales = new ArrayList<>();
    }

    /**
     * getters and setters for StarbuckStore
     * 
     */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getHourOpen() {
        return hourOpen;
    }

    public void setHourOpen(int hourOpen) {
        this.hourOpen = hourOpen;
    }

    public int getHourClosed() {
        return hourClosed;
    }

    public void setHourClosed(int hourClosed) {
        this.hourClosed = hourClosed;
    }

    public ArrayList<SalesTransaction> getDailySales() {
        return dailySales;
    }

    public void setDailySales(ArrayList<SalesTransaction> dailySales) {
        this.dailySales = dailySales;
    }
    
    /**
     * This method gets the each grandTotal and add them all up, then set it to dailyGrandTotal
     * @return dailyGrandTotal
     */
    public double accumulateDailySales()
    {
        double dailyGrandTotal = 0; 
        
        for (int i = 0; i < getDailySales().size(); i++) {
            dailyGrandTotal += getDailySales().get(i).getAmountPaid();
        }
        
        return dailyGrandTotal;
    }

    @Override
    /**
     * toString for StarbuckStore
     */
    public String toString() {
        return "StarbucksStore{" +
                "code = " + code +
                ", location = '" + location + '\'' +
                ", hourOpen = " + hourOpen +
                ", hourClosed = " + hourClosed +
                ", dailySales = " + dailySales +
                '}';
    }
}
