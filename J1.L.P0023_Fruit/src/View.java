
import entity.Fruit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vu Duc Tien
 */
public class View {

    Manage mn;

    public View() {
    }

    public View(Manage mn) {
        this.mn = mn;
    }

    public void createFruit() {
        System.out.println("___CREATE FRUIT___");
        while (true) {
            String fruitID = Validation.inputID("ID: ");
            if (mn.findFruitByID(fruitID) != null) {
                System.err.println("Fruit existed! Enter another fruit.");
                continue;
            }
            String fruitName = Validation.inputNameProduct("Fruit name: ");
            double price = Validation.inputDouble("Price: ");
            int quantity = Validation.inputInt("Quantity: ");
            String origin = Validation.inputName("Origin: ");
            Fruit f = new Fruit(fruitID, fruitName, price, quantity, origin);
            mn.addFruit(f);
            if (!Validation.checkYesNo("Do You Want to add more fruits?(Y/N): ")) {
                System.err.println("__Creating successful__");
                System.out.println("");
                displayFruit();
                System.out.println("");
                break;
            }
        }
    }

    public void updateFruit() {
        if (mn.getFruitList().isEmpty()) {
            System.err.println("Empty warehouse! Add more fruit first.");
            System.out.println("");
            System.out.println("");
            return;
        }

        System.out.println("___UPDATE FRUIT___");
        while (true) {
            String fruitID = Validation.inputID("Enter ID of fruit: ");
            if (mn.findFruitByID(fruitID) != null) {
                System.err.println("Fruit you choose: ");
                fruitHeader();
                mn.findFruitByID(fruitID).print();
                mn.update(UpdateAfruit(mn.findFruitByID(fruitID)));
            } else {
                System.err.println("Not found fruit with ID: " + fruitID);
                if (Validation.checkYesNo("Do You Want to add more fruits?(Y/N): ")) {
                    createFruit();
                    break;
                }
            }

            if (!Validation.checkYesNo("Do You Want to update another fruits?(Y/N): ")) {
                System.err.println("___Update Successfull___");
                System.out.println("");
                System.out.println("");
                break;
            }
        }
    }

    private Fruit UpdateAfruit(Fruit f) {

        if (Validation.checkYesNo("Do U want to update price of fruit? (Y/N): ")) {
            double price = Validation.inputDouble("New price: ");
            f.setPrice(price);
        }

        if (Validation.checkYesNo("Do U want to update quantity of fruit? (Y/N): ")) {
            int quantity = Validation.inputInt("New quantity: ");
            f.setQuantity(quantity);
        }

        return f;
    }

    public void shopping() {
        if (mn.getFruitList().isEmpty()) {
            System.err.println("Empty warehouse! Add more fruit first.");
            System.out.println("");
            System.out.println("");
            return;
        }

        ArrayList<Fruit> orderList = new ArrayList<>();
        String customer = "";
        while (true) {
            displayForOrder(mn.getFruitList());
            int item = Validation.inputInt("Choose item: ");
            if (mn.findFruitByIndex(item) != null) {
                Fruit f = new Fruit(mn.findFruitByIndex(item).getFruitId(), mn.findFruitByIndex(item).getFruitName(),
                        mn.findFruitByIndex(item).getPrice(), mn.findFruitByIndex(item).getQuantity(),
                        mn.findFruitByIndex(item).getOrigin());
                System.out.println("Your select: " + f.getFruitName());
                int quantity;
                while (true) {
                    quantity = Validation.inputInt("Please input quantity: ");
                    if (quantity <= f.getQuantity()) {
                        break;
                    } else if (Validation.checkYesNo("The quantity you want has exceeded our stock"
                            + ", you want to take all the remaining quantity ("
                            + f.getQuantity() + " " + f.getFruitName() + "s)?(Y/N): ")) {
                        quantity = f.getQuantity();
                        break;
                    } else {
                        System.err.println("Choose quantity you want!");
                    }
                }
                Fruit o = new Fruit(f.getFruitId(), f.getFruitName(), f.getPrice(), quantity, f.getOrigin());
                mn.setQuantity(o);
                if (orderList.isEmpty()) {
                    orderList.add(o);
                } else {
                    boolean isExist = false;
                    for (int i = 0; i < orderList.size(); i++) {
                        if (orderList.get(i).getFruitId().equalsIgnoreCase(o.getFruitId())) {
                            orderList.get(i).setQuantity(orderList.get(i).getQuantity() + o.getQuantity());
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) {
                        orderList.add(o);
                    }
                }

                if (Validation.checkYesNo("Do you want to order now? (Y/N): ")) {
                    viewOrder(orderList);
                    customer = Validation.inputName("Input your name: ");
                    mn.order(orderList, customer);
                    System.out.println("");
                    break;
                }
            } else {
                System.err.println("Not found product with item: " + item);
            }

            if (!Validation.checkYesNo("Do you want to shopping continue? (Y/N): ")) {
                System.out.println("The products you have selected:");
                viewOrder(orderList);
                if (Validation.checkYesNo("You want to buy them? (Y/N): ")) {
                    customer = Validation.inputName("Customer: ");
                    mn.order(orderList, customer);
                    break;
                } else {
                    for (Fruit o : orderList) {
                        mn.setQuantityIfNotOrder(o);
                    }
                    break;
                }
            }
        }
    }

    public void viewCustomerList() {
        if (mn.getCustomerList().isEmpty()) {
            System.err.println("There are nothing to view!");
            System.out.println("");
            System.out.println("");
            return;
        }

        double total = 0;
        DecimalFormat format = new DecimalFormat("0.##$");

        //Display
        Enumeration names = mn.getCustomerList().keys();
        ArrayList<Fruit> orderList;
        while (names.hasMoreElements()) {
            String nameStr = (String) names.nextElement();
            orderList = mn.getCustomerList().get(nameStr);
            total = 0;
            System.out.println("Customer: " + nameStr);
            System.out.println("Product    | Quantity | Price | Amount |");
            System.out.println("----------------------------------------");
            for (Fruit o : orderList) {
                System.out.printf("%-11s|    %-6d|  %-5s|   %-6s|\n", o.getFruitName(), o.getQuantity(),
                        format.format(o.getPrice()), format.format(o.getPrice() * o.getQuantity()));
                total += o.getQuantity() * o.getPrice();
            }
            System.out.println("----------------------------------------");
            System.out.printf("%-39s|\n", "Total: " + format.format(total));
            System.out.println("----------------------------------------\n");
        }
    }

    private void fruitHeader() {
        System.out.printf("|%-10s|%-15s|%-10s|%-10s|\n", "++ Item ++", "++ Fruit Name ++", "++ Origin ++", "++ Price ++");
    }

    public void displayFruit() {
        System.out.println("____List fruit____");
        fruitHeader();
        DecimalFormat format = new DecimalFormat("0.##$");
        for (int i = 0; i < mn.getFruitList().size(); i++) {
            System.out.printf("|     %-5d| %-15s| %-11s|   %-8s|\n",
                    i + 1, mn.getFruitList().get(i).getFruitName(),
                    mn.getFruitList().get(i).getOrigin(), format.format(mn.getFruitList().get(i).getPrice()));
        }
    }

    private void displayForOrder(ArrayList<Fruit> fruits) {
        System.out.println("____List fruit____");
        fruitHeader();
        DecimalFormat format = new DecimalFormat("0.##$");
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getQuantity() > 0) {
                System.out.printf("|     %-5d| %-15s| %-11s|   %-8s|\n",
                        i + 1, fruits.get(i).getFruitName(),
                        fruits.get(i).getOrigin(), format.format(fruits.get(i).getPrice()));
            }
        }
    }

    public void viewOrder(ArrayList<Fruit> order) {
        DecimalFormat format = new DecimalFormat("0.##$");
        System.err.println("Your order: ");
        System.out.println("");
        System.out.println("Product    | Quantity | Price | Amount  |");
        System.out.println("-----------------------------------------");
        for (Fruit o : order) {
            System.out.printf("%-11s|    %-6d|  %-5s|   %-6s|\n", o.getFruitName(), o.getQuantity(),
                    format.format(o.getPrice()), format.format(o.getPrice() * o.getQuantity()));
        }

        System.out.println("");
    }

    public void displayAllInforFruit(ArrayList<Fruit> x) {
        if (x.isEmpty()) {
            System.err.println("Empty warehouse! Add more fruit first.");
            System.out.println("\n");
            return;
        }

        System.out.println("All Infor");
        System.out.printf("|%-10s|%-15s|%-10s|%-10s|%-10s|\n", "++ ID ++", "++ Fruit Name ++",
                "++ Price ++", "++ Quantity ++", "++ Origin ++");
        for (Fruit f : x) {
            f.print();
        }
        System.out.println("");
    }

}
