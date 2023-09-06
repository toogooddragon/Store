package Food;
public class Merchandise {
    private String name;
    private String size;
    private double price;
    private int quantity;
    
    /**
     * constructor for Merchandise
     * @param name
     * @param size
     * @param price
     * @param quantity 
     */
    public Merchandise(String name, String size, double price, int quantity) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * getters and setters for Merchandise
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getCost() {
        double total = price*quantity;
        return total;
    }

    @Override
    /**
     * toString for Merchandise
     */
    public String toString() {
        return "Merchandise{" + "name = " + name + '\'' +
                ", size = " + size + '\'' +
                ", price = " + price + '\'' +
                ", quantity = " + quantity + '\'' +
                ", cost = " + String.format("%.2f", getCost()) +
                '}';
    } 
}
