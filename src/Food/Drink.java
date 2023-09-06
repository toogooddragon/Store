package Food;
public class Drink {

    private String name;
    private String size;
    private double ounces;
    private boolean addedCream;
    private String addedFlavor;
    private double cost;

    /**
     * constructor for Drink
     * 
     * @param name
     * @param size
     * @param ounces
     * @param addedCream
     * @param addedFlavor
     * @param cost 
     */
    public Drink(String name, String size, double ounces, boolean addedCream, String addedFlavor, double cost) {
        this.name = name;
        this.size = size;
        this.ounces = ounces;
        this.addedCream = addedCream;
        this.addedFlavor = addedFlavor;
        this.cost = cost;
    }

    /**
     * getters and setters  for Drink
     * @return 
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getOunces() {
        return ounces;
    }

    public void setOunces(double ounces) {
        this.ounces = ounces;
    }

    public boolean getAddedCream() {
        return addedCream;
    }

    public void setAddedCream(boolean addedCream) {
        this.addedCream = addedCream;
    }

    public String getAddedFlavor() {
        return addedFlavor;
    }

    public void setAddedFlavor(String addedFlavor) {
        this.addedFlavor = addedFlavor;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    /**
     * toString  for Drink
     */
    public String toString() {
        return "Drink{" +
                "name = '" + name + '\'' +
                ", size = '" + size + '\'' +
                ", ounces = " + ounces +
                ", addedCream = " + addedCream +
                ", addedFlavor = '" + addedFlavor + '\'' +
                ", cost = " + String.format("%.2f", cost) +
                '}';
    }
}
