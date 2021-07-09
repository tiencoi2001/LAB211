
import entity.Product;
import entity.Storekeeper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public static void main(String[] args) throws ParseException {
        Main m = new Main();
        DataInput in = new DataInput();

        List<Storekeeper> storekeepers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        
        ProductManagement manager = new ProductManagement(storekeepers, products);
        View v = new View(manager);

        storekeepers.add(new Storekeeper(1, "abc"));
        storekeepers.add(new Storekeeper(2, "a"));
        storekeepers.add(new Storekeeper(3, "b"));
        storekeepers.add(new Storekeeper(4, "c"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        products.add(new Product(1, "p1", "l1", 123, sdf.parse("20/02/2020"), sdf.parse("20/02/2019"), "drink", new Storekeeper(1, "abc"), new Date("20/04/2020")));
        products.add(new Product(2, "p2", "l2", 123, sdf.parse("20/02/2020"), sdf.parse("19/02/2019"), "drink", new Storekeeper(2, "a"), new Date("20/06/2020")));
        products.add(new Product(3, "p3", "l3", 123, sdf.parse("20/02/2020"), sdf.parse("23/02/2019"), "drink", new Storekeeper(3, "b"), new Date("20/08/2020")));
        products.add(new Product(4, "p4", "l4", 123, sdf.parse("19/02/2020"), sdf.parse("06/02/2019"), "drink", new Storekeeper(4, "b"), new Date("20/10/2020")));
        boolean isStop = false;
        while (!isStop) {
            m.displayMenu();
            int choice = in.inputChoice(0, 5);

            switch (choice) {
                case 1: {
                    v.addStorekeeper();
                    break;
                }
                case 2: {
                    v.addProduct();
                    break;
                }
                case 3: {
                    v.updateProduct();
                    break;
                }
                case 4: {
                    v.searchProduct();
                    break;
                }
                case 5: {
                    v.sortProduct();
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
