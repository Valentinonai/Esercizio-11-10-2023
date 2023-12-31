package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Product {
    private static String[] names = {"phone", "tv", "videogames", "bike"};
    private static String[] categories = {"Books", "Baby", "Boys"};
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static List<Product> fillProducts(int n) {
        Random rnd = new Random();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            products.add(new Product(rnd.nextInt(), names[rnd.nextInt(0, 4)], categories[rnd.nextInt(0, 3)], rnd.nextInt(10, 1000)));
        }
        return products;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
