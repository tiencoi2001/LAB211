
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

    public List<Storekeeper> getStorekeepers() {
        return storekeepers;
    }

    public void setStorekeepers(List<Storekeeper> storekeepers) {
        this.storekeepers = storekeepers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductManagement(List<Storekeeper> storekeepers, List<Product> products) {
        this.storekeepers = storekeepers;
        this.products = products;
    }

    public List<Storekeeper> addStorekeeper(Storekeeper s) {
        storekeepers.add(s);
        return storekeepers;
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

    public void sortByExp() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getExpiryDate().compareTo(o2.getExpiryDate());
            }
        });
    }

    public void sortByDateOfManufacture() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getDateOfManufacture().compareTo(o2.getDateOfManufacture());
            }
        });
    }

//        public void sortByExp() {
//        Collections.sort(products, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                switch (o1.getExpiryDate().compareTo(o2.getExpiryDate())){
//                    case 1:
//                        return 1;
//                    case -1:
//                        return -1;
//                    default:
//                        return o1.getDateOfManufacture().compareTo(o2.getDateOfManufacture());
//                }
//                    
//            }
//        });
//    }
//
//    public void sortByDateOfManufacture() {
//        Collections.sort(products, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                switch (o1.getDateOfManufacture().compareTo(o2.getDateOfManufacture())) {
//                    case 1:
//                        return 1;
//                    case -1:
//                        return -1;
//                    default:
//                        return o1.getExpiryDate().compareTo(o2.getExpiryDate());
//                }
//
//            }
//        });
//    }
}
