package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {

    public static String[] names = {"pippo", "pluto", "paperino", "topolino"};
    private long id;
    private String name;
    private int tier;

    public Customer(long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public static List<Customer> fillCustomer(int n) {
        Random rnd = new Random();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            customers.add(new Customer(rnd.nextInt(), names[rnd.nextInt(0, 4)], rnd.nextInt(0, 4)));
        }
        return customers;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
