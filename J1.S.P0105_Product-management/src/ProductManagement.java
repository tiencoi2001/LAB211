
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

    private List<Storekeeper> storekeepers;
    private List<Product> products;

    public ProductManagement(List<Storekeeper> storekeepers, List<Product> products) {
        this.storekeepers = storekeepers;
        this.products = products;
    }

    public boolean checkListStorekeeper() {
        return storekeepers.isEmpty();
    }

    public boolean checkListProduct() {
        return products.isEmpty();
    }

    public List<Storekeeper> addStorekeeper(Storekeeper s) {
        storekeepers.add(s);
        return storekeepers;
    }

    public void displayStorekeepers() {
        for (Storekeeper s : storekeepers) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }

    public int getLastID() {
        return storekeepers.get(storekeepers.size() - 1).getId();
    }

    public boolean checkDuplicate(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public List<Product> addProduct(Product p) {
        products.add(p);
        return products;
    }

    public void displayAll() {
        System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n", "ID", "Name",
                "Location", "Price", "Expiry date", "Date of manufacture",
                "Category", "Storekeeper", "Receipt date");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Product p : products) {
            System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n",
                    p.getId(), p.getName(), p.getLocation(), p.getPrice(),
                    sdf.format(p.getExpiryDate()), sdf.format(p.getDateOfManufacture()), p.getCategory(),
                    p.getStorekeeper().getName(), sdf.format(p.getReceiptDate()));
        }
    }

    public Storekeeper getStorekeeperByID(int id) {
        for (Storekeeper s : storekeepers) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void updateProduct(Product p) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == p.getId()) {
                products.set(i, p);
                break;
            }
        }
    }

    public Product getProductByID(int id) {
        for (Product p : products) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    public void displayProduct(Product p) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%5s %10s %10s %10s %15s %25s %15s %15s %15s\n",
                p.getId(), p.getName(), p.getLocation(), p.getPrice(),
                sdf.format(p.getExpiryDate()), sdf.format(p.getDateOfManufacture()), p.getCategory(),
                p.getStorekeeper().getName(), sdf.format(p.getReceiptDate()));
    }

    public List<Product> searchProductBySth(String searchValue) {
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

    public  void sortByExp() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getExpiryDate().compareTo(o2.getExpiryDate());
            }
        });
    }

    public  void sortByDateOfManufacture() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getDateOfManufacture().compareTo(o2.getDateOfManufacture());
            }
        });
    }
}
