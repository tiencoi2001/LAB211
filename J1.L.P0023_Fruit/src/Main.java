
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
public class Main {

    public static void main(String[] args) {
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("1", "Coconut", 2, 20, "VietNam"));
        list.add(new Fruit("2", "Orange", 3, 20, "US"));
        list.add(new Fruit("3", "Apple", 4, 20, "Thailand"));
        list.add(new Fruit("4", "Grape", 6, 20, "France"));
        Hashtable<String, ArrayList<Fruit>> listView = new Hashtable<>();
        Manage mn = new Manage(list,listView);
        View v = new View(mn);
        
        //Process
        while(true){
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("================ Menu ================");
            System.out.println("1. Create Fruit");
            System.out.println("2. Update Fruit");
            System.out.println("3. View orders");
            System.out.println("4. Shopping (for buyer)");
            System.out.println("5. Exit");
            System.out.println("(Please choose 1 to create product, 2 to update fruit,"
                    + " 3 to view order, 4 for shopping, 5 to Exit program).");
            int choice = Validation.inputInt("Enter choice: ");
            switch(choice){
                case 1:
                    v.createFruit();
                    break;
                case 2:
                    v.updateFruit();
                    break;
                case 3:
                    v.viewCustomerList();
                    break;
                case 4:
                    v.shopping();
                    break;
                case 5:
                    System.exit(0);
                case 6:
                    v.displayAllInforFruit(mn.getFruitList());
                    break;
                default:
                    System.err.println("You must choose from 1 to 6!");
                    System.out.println("");
            }
        }
        
    }

}
