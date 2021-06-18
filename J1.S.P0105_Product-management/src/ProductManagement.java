
import entity.Product;
import entity.Storekeeper;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class ProductManagement {

    public void addStorekeeper(List<Storekeeper> storekeepers) {
        DataInput in = new DataInput();
        while (true) {
            int newid = storekeepers.size() + 1;
            String name = in.inputStorekeeperName();
            Storekeeper s = new Storekeeper(newid, name);
            storekeepers.add(s);
            System.out.println("Add storekeeper successful.");
            System.out.println("");
            System.out.println("LIST STOREKEEPERS");
            displayStorekeepers(storekeepers);
            System.out.println("");
            if (!in.checkYesNo()) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
        System.out.println("Add all storekeeper successful.");
        System.out.println("");
    }

    public void addProduct(List<Product> products, List<Storekeeper> storekeepers) {
        if (storekeepers.isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            int id = in.inputNewID(products);
            String name = in.inputString("Product name");
            String location = in.inputString("Location");
            double price = in.inputPrice();
            Date expiryDate = in.inputExpDate();
            Date dateOfManufacture = in.inputManufactureDate(expiryDate);
            String category = in.inputString("Category");
            System.out.println("Choose storekeeper [1-" + storekeepers.size() + "]");
            displayStorekeepers(storekeepers);
            System.out.print("Your choice: ");
            int sid = in.inputChoice(1, storekeepers.size());
            Storekeeper s = getStorekeeperByID(storekeepers, id);
            Date receiptDate = in.inputReceiptDate(dateOfManufacture, expiryDate);

            Product p = new Product(id, name, location, price, expiryDate, dateOfManufacture, category, s, receiptDate);
            products.add(p);

            System.out.println("Add product successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll(products);
            System.out.println("");
            if (!in.checkYesNo()) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
        System.out.println("Add all product successful.");
        System.out.println("");
    }

    private void displayStorekeepers(List<Storekeeper> storekeepers) {
        for (Storekeeper s : storekeepers) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }

    private Storekeeper getStorekeeperByID(List<Storekeeper> storekeepers, int id) {
        for (Storekeeper s : storekeepers) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void updateProduct(List<Product> products, List<Storekeeper> storekeepers) {
        if (storekeepers.isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        if (products.isEmpty()) {
            System.out.println("Please enter the product first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            int id = in.inputExistedID(products);
            Product p = getProductByID(products, id);
            String name = in.inputString("Product name");
            String location = in.inputString("Location");
            double price = in.inputPrice();
            Date expiryDate = in.inputExpDate();
            Date dateOfManufacture = in.inputManufactureDate(expiryDate);
            String category = in.inputString("Category");
            System.out.println("Choose storekeeper [1-" + storekeepers.size() + "]");
            displayStorekeepers(storekeepers);
            System.out.print("Your choice: ");
            int sid = in.inputChoice(1, storekeepers.size());
            Storekeeper s = getStorekeeperByID(storekeepers, id);
            Date receiptDate = in.inputReceiptDate(dateOfManufacture, expiryDate);

            p.setName(name);
            p.setLocation(location);
            p.setPrice(price);
            p.setExpiryDate(expiryDate);
            p.setDateOfManufacture(dateOfManufacture);
            p.setCategory(category);
            p.setStorekeeper(s);
            p.setReceiptDate(receiptDate);

            System.out.println("Update product successful.");
            System.out.println("");
            System.out.println("LIST PRODUCTS");
            displayAll(products);
            System.out.println("");
            if (!in.checkYesNo()) {
                break;
            } else {
                continue;
            }
        }
        System.out.println("");
        System.out.println("Update all products successful.");
        System.out.println("");
    }

    private Product getProductByID(List<Product> products, int id) {
        for (Product p : products) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    public void searchProduct(List<Product> products, List<Storekeeper> storekeepers) {
        if (storekeepers.isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        if (products.isEmpty()) {
            System.out.println("Please enter the product first.");
            System.out.println("");
            return;
        }
        DataInput in = new DataInput();
        while (true) {
            String searchValue = in.inputString("Enter search keywords");
            List<Product> searched = searchProductBySth(products, searchValue);
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
            if (!in.checkYesNo()) {
                break;
            } else {
                continue;
            }
        }

        System.out.println("");
    }

    private void displayAll(List<Product> list) {
        System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n", "ID", "Name",
                "Location", "Price", "Expiry date", "Date of manufacture",
                "Category", "Storekeeper", "Receipt date");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Product p : list) {
            System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n",
                    p.getId(), p.getName(), p.getLocation(), p.getPrice(),
                    sdf.format(p.getExpiryDate()), sdf.format(p.getDateOfManufacture()), p.getCategory(),
                    p.getStorekeeper().getName(), sdf.format(p.getReceiptDate()));
        }
    }

    private void displayProduct(Product p) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n",
                p.getId(), p.getName(), p.getLocation(), p.getPrice(),
                sdf.format(p.getExpiryDate()), sdf.format(p.getDateOfManufacture()), p.getCategory(),
                p.getStorekeeper().getName(), sdf.format(p.getReceiptDate()));
    }

    private List<Product> searchProductBySth(List<Product> products, String searchValue) {
        List<Product> searched = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(searchValue.toLowerCase())
                    || p.getCategory().toLowerCase().contains(searchValue.toLowerCase())
                    || p.getStorekeeper().getName().toLowerCase().contains(searchValue.toLowerCase())
                    || sdf.format(p.getReceiptDate()).contains(searchValue)) {
                searched.add(p);
            }
        }
        return searched;
    }

    public void sortProduct(List<Product> products, List<Storekeeper> storekeepers) {
        if (storekeepers.isEmpty()) {
            System.out.println("Please enter the storekeeper first.");
            System.out.println("");
            return;
        }
        if (products.isEmpty()) {
            System.out.println("Please enter the product first.");
            System.out.println("");
            return;
        }
        while (true) {
            System.out.println("");
            System.out.println("LIST BEFORE SORT:");
            displayAll(products);
            DataInput in = new DataInput();
            System.out.println("");
            System.out.println("Press \"E\" if you want to sort by expiry date,"
                    + " press \"D\" if you want to sort by production date.");
            String choice = in.EoD();
            System.out.println("");
            if (choice.equalsIgnoreCase("d")) {
                sortByDateOfManufacture(products);
                System.out.println("LIST AFTER SORT:");
            } else if (choice.equalsIgnoreCase("e")) {
                sortByExp(products);
                System.out.println("LIST AFTER SORT:");
            }
            displayAll(products);
            System.out.println("");
            if (!in.checkYesNo()) {
                System.out.println("");
                break;
            } else {
                System.out.println("");
                continue;
            }
        }
    }

    private void sortByExp(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getExpiryDate().compareTo(o2.getExpiryDate());
            }
        });
    }

    private void sortByDateOfManufacture(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getDateOfManufacture().compareTo(o2.getDateOfManufacture());
            }
        });
    }
}
