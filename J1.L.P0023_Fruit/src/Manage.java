
import entity.Fruit;
import java.util.ArrayList;
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vu Duc Tien
 */

public class Manage {

    private ArrayList<Fruit> fruitList;
    private Hashtable<String, ArrayList<Fruit>> customerList;

    public Manage() {
    }

    public Manage(ArrayList<Fruit> fruitList, Hashtable<String, ArrayList<Fruit>> customerList) {
        this.fruitList = fruitList;
        this.customerList = customerList;
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public Hashtable<String, ArrayList<Fruit>> getCustomerList() {
        return customerList;
    }

    public void addFruit(Fruit f) {
        fruitList.add(f);
    }

    public Fruit findFruitByID(String id) {
        for (Fruit fruit : fruitList) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    public void update(Fruit f) {
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getFruitId().equalsIgnoreCase(f.getFruitId())) {
                fruitList.set(i, f);
                break;
            }
        }
    }

    public Fruit findFruitByIndex(int item) {
        for (int i = 0; i < fruitList.size(); i++) {
            if (i == (item - 1)) {
                return fruitList.get(i);
            }
        }
        return null;
    }

    public void order(ArrayList<Fruit> orderList, String customer) {
        if (!orderList.isEmpty() && !customer.isEmpty()) {
            customerList.put(customer, orderList);
        }
    }

    public void setQuantity(Fruit o) {
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getFruitId().equalsIgnoreCase(o.getFruitId())) {
                fruitList.get(i).setQuantity(fruitList.get(i).getQuantity() - o.getQuantity());
                break;
            }
        }
    }
    
    public void setQuantityIfNotOrder(Fruit o){
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getFruitId().equalsIgnoreCase(o.getFruitId())) {
                fruitList.get(i).setQuantity(fruitList.get(i).getQuantity() + o.getQuantity());
                break;
            }
        }
    }
}
