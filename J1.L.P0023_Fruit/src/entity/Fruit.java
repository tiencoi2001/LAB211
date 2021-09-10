/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.DecimalFormat;

/**
 *
 * @author Vu Duc Tien
 */
public class Fruit {

    private String fruitId;
    private String fruitName;
    private double Price;
    private int Quantity;
    private String Origin;

    public Fruit() {
    }

    public Fruit(String fruitId, String fruitName, double Price, int Quantity, String Origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Origin = Origin;
    }

    public String getFruitId() {
        return fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public double getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public void print() {
        DecimalFormat format = new DecimalFormat("0.##$");
        System.out.printf("|   %-7s| %-15s|   %-8s|      %-8d| %-11s|\n",
                getFruitId(), getFruitName(), format.format(getPrice()), getQuantity(), getOrigin());
    }
}
