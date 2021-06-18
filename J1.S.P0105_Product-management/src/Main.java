
import entity.Product;
import entity.Storekeeper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        DataInput in = new DataInput();
        ProductManagement manager = new ProductManagement();

        List<Storekeeper> storekeepers = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        storekeepers.add(new Storekeeper(1, "abc"));
        storekeepers.add(new Storekeeper(2, "a"));
        storekeepers.add(new Storekeeper(3, "b"));
        storekeepers.add(new Storekeeper(4, "c"));

        products.add(new Product(1, "p1", "l1", 123, new Date("20/02/2020"), new Date("20/02/2019"), "drink", new Storekeeper(1, "abc"), new Date("20/04/2020")));
        products.add(new Product(2, "p2", "l2", 123, new Date("19/02/2020"), new Date("02/02/2019"), "drink", new Storekeeper(2, "a"), new Date("20/06/2020")));
        products.add(new Product(3, "p3", "l3", 123, new Date("18/02/2020"), new Date("04/02/2019"), "drink", new Storekeeper(3, "b"), new Date("20/08/2020")));
        products.add(new Product(4, "p4", "l4", 123, new Date("17/02/2020"), new Date("06/02/2019"), "drink", new Storekeeper(4, "b"), new Date("20/10/2020")));
        boolean isStop = false;
        while (!isStop) {
            m.displayMenu();
            int choice = in.inputChoice(0, 5);

            switch (choice) {
                case 1: {
                    manager.addStorekeeper(storekeepers);
                    break;
                }
                case 2: {
                    manager.addProduct(products, storekeepers);
                    break;
                }
                case 3: {
                    manager.updateProduct(products, storekeepers);
                    break;
                }
                case 4: {
                    manager.searchProduct(products, storekeepers);
                    break;
                }
                case 5: {
                    manager.sortProduct(products, storekeepers);
                    break;
                }
                case 0: {
                    isStop = true;
                    break;
                }
            }
        }
    }

    private void displayMenu() {
        System.out.println("========MAIN MENU=======");
        System.out.println("1. Add Storekeeper.");
        System.out.println("2. Add product.");
        System.out.println("3. Update product.");
        System.out.println("4. Search product by Name, Category, Storekeeper, ReceiptDate.");
        System.out.println("5. Sort product by Expiry date, Date of manufacture.");
        System.out.println("0. Exit.");
        System.out.print("Your choice: ");
    }
}
