
import entity.Product;
import entity.Storekeeper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    ProductManagement pm;

    public View(ProductManagement pm) {
        this.pm = pm;
    }

    public void addStorekeeper() {
        DataInput in = new DataInput();
        while (true) {
            Storekeeper s = inputStorekeeper();
            pm.addStorekeeper(s);

            System.out.println("Add storekeeper successful.");
            System.out.println("");
            System.out.println("LIST STOREKEEPERS");
            displayStorekeepers();
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                System.out.println("");
                continue;
            }
        }
        System.out.println("");
        System.out.println("Add all storekeeper successful.");
        System.out.println("");
    }

    public Storekeeper inputStorekeeper() {
        DataInput in = new DataInput();

        int id;
        if (pm.getStorekeepers().isEmpty()) {
            id = 1;
        } else {
            id = pm.getLastID() + 1;
        }
        String name = in.inputStorekeeperName();

        Storekeeper s = new Storekeeper(id, name);
        return s;
    }

    public void displayStorekeepers() {
        for (Storekeeper s : pm.getStorekeepers()) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }

    public void addProduct() {
        if (pm.getStorekeepers().isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            Product p = inputProduct();
            ArrayList<Product> products = (ArrayList<Product>) pm.addProduct(p);
            System.out.println("Add product successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll();
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
        System.out.println("Add all product successful.");
        System.out.println("");
    }

    public void displayAll() {
        System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n", "ID", "Name",
                "Location", "Price", "Expiry date", "Date of manufacture",
                "Category", "Storekeeper", "Receipt date");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Product p : pm.getProducts()) {
            System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n",
                    p.getId(), p.getName(), p.getLocation(), p.getPrice(),
                    sdf.format(p.getExpiryDate()), sdf.format(p.getDateOfManufacture()), p.getCategory(),
                    p.getStorekeeper().getName(), sdf.format(p.getReceiptDate()));
        }
    }

    public Product inputProduct() {
        DataInput in = new DataInput();

        int id;
        while (true) {
            id = in.inputID();
            if (pm.checkDuplicate(id)) {
                System.out.print("ID is already in use "
                        + " please enter another ID: ");
                continue;
            } else {
                break;
            }
        }
        String name = in.inputString("Product name");
        String location = in.inputString("Location");
        double price = in.inputPrice();
        Date expiryDate = in.inputExpDate();
        Date dateOfManufacture = in.inputManufactureDate(expiryDate);
        String category = in.inputString("Category");
        System.out.println("Choose storekeeper [1-" + pm.getLastID() + "]");
        displayStorekeepers();
        System.out.print("Your choice: ");
        int sid = in.inputChoice(1, pm.getLastID());
        Storekeeper s = new Storekeeper(pm.getStorekeeperByID(id).getId(), pm.getStorekeeperByID(id).getName());
        Date receiptDate = in.inputReceiptDate(dateOfManufacture, expiryDate);

        Product p = new Product(id, name, location, price, expiryDate, dateOfManufacture, category, s, receiptDate);
        return p;
    }

    public void updateProduct() {
        Scanner sc = new Scanner(System.in);
        if (pm.getStorekeepers().isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        if (pm.getProducts().isEmpty()) {
            System.out.println("Please enter the product first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        Product p = null;
        while (true) {
            int id = in.inputID();
            if (pm.getProductByID(id) == null) {
                System.out.print("ID not found, enter again: ");
                continue;
            } else {
                p = new Product(pm.getProductByID(id).getId(),
                        pm.getProductByID(id).getName(), pm.getProductByID(id).getLocation(),
                        pm.getProductByID(id).getPrice(), pm.getProductByID(id).getExpiryDate(),
                        pm.getProductByID(id).getDateOfManufacture(), pm.getProductByID(id).getCategory(),
                        pm.getProductByID(id).getStorekeeper(), pm.getProductByID(id).getReceiptDate());
                if (in.checkYesNo("Do you want update product name")) {
                    String name = in.inputString("Product name");
                    p.setName(name);
                }
                if (in.checkYesNo("Do you want update location")) {
                    String location = in.inputString("Location");
                    p.setLocation(location);
                }
                if (in.checkYesNo("Do you want update price")) {
                    double price = in.inputPrice();
                    p.setPrice(price);
                }
                if (in.checkYesNo("Do you want update expiry date")) {
                    Date expiryDate = in.inputExpDate();
                    p.setExpiryDate(expiryDate);
                }
                if (in.checkYesNo("Do you want update manufacture date")) {
                    Date dateOfManufacture = in.inputManufactureDate(p.getExpiryDate());
                    p.setDateOfManufacture(dateOfManufacture);
                }
                if (in.checkYesNo("Do you want update category")) {
                    String category = in.inputString("Category");
                    p.setCategory(category);
                }
                if (in.checkYesNo("Do you want update storekeeper")) {
                    System.out.println("Choose storekeeper [1-" + pm.getLastID() + "]");
                    displayStorekeepers();
                    System.out.print("Your choice: ");
                    int sid = in.inputChoice(1, pm.getLastID());
                    Storekeeper s = new Storekeeper(pm.getStorekeeperByID(id).getId(), pm.getStorekeeperByID(id).getName());
                    p.setStorekeeper(s);
                }
                if (in.checkYesNo("Do you want update receipt date")) {
                    Date receiptDate = in.inputReceiptDate(p.getDateOfManufacture(), p.getExpiryDate());
                    p.setReceiptDate(receiptDate);
                }
                pm.updateProduct(p);
            }
            System.out.println("Update product successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll();
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
        System.out.println("Update all products successful.");
        System.out.println("");
    }

    public void searchProduct() {
        if (pm.getStorekeepers().isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        if (pm.getProducts().isEmpty()) {
            System.out.println("Please enter the product first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            String searchValue = in.inputString("Enter search keywords");
            List<Product> searched = pm.searchProductBySth(searchValue);
            if (searched.isEmpty()) {
                System.out.println("There are no product match with "
                        + "\"" + searchValue + "\"");
                return;
            }
            System.out.println("");
            System.out.println("LIST OF PRODUCTS FOUND");
            System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n", "ID", "Name",
                    "Location", "Price", "Expiry date", "Date of manufacture",
                    "Category", "Storekeeper", "Receipt date");

            for (Product p : searched) {
                displayProduct(p);
            }
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
    }

    public void displayProduct(Product p) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n",
                p.getId(), p.getName(), p.getLocation(), p.getPrice(),
                sdf.format(p.getExpiryDate()), sdf.format(p.getDateOfManufacture()), p.getCategory(),
                p.getStorekeeper().getName(), sdf.format(p.getReceiptDate()));
    }

    public void sortProduct() {
        if (pm.getStorekeepers().isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        if (pm.getStorekeepers().isEmpty()) {
            System.out.println("Please enter the product first.");
            System.out.println("");
            return;
        }
        while (true) {
            System.out.println("");
            System.out.println("LIST BEFORE SORT:");
            displayAll();
            DataInput in = new DataInput();
            System.out.println("");
            System.out.println("Press \"E\" if you want to sort by expiry date,"
                    + " press \"D\" if you want to sort by production date.");
            String choice = in.EoD();
            System.out.println("");
            if (choice.equalsIgnoreCase("d")) {
                pm.sortByDateOfManufacture();
                System.out.println("LIST AFTER SORT:");
            } else if (choice.equalsIgnoreCase("e")) {
                pm.sortByExp();
                System.out.println("LIST AFTER SORT:");
            }
            displayAll();
            System.out.println("");
            if (!in.checkYesNo("Press \"Y\" if you want to keep taking action,"
                    + " press \"N\" if you want to end the action.")) {
                System.out.println("");
                break;
            } else {
                System.out.println("");
                continue;
            }
        }
    }

}
