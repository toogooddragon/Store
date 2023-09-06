/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Food;

public class Snack {

    private String name;
    private String description;
    private double cost;

    /**
     * constructor for Snack
     * @param name
     * @param description
     * @param cost 
     */
    public Snack(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    /**
     * getters and setters  for Snack
     * @return 
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    /**
     * toString  for Snack
     */
    public String toString() {
        return "Snack{" +
                "name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", cost = " + String.format("%.2f", cost) +
                '}';
    }
}
