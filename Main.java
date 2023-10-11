import entities.Customer;
import entities.Order;
import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rnd = new Random();
        List<Order> orders = new ArrayList<>();
        List<Product> products = new ArrayList<>(Product.fillProducts(50));

       /* for (Product p : products)
            System.out.println(p);*/

        List<Customer> customers = new ArrayList<>(Customer.fillCustomer(20));
       /* for (Customer c : customers)
            System.out.println(c);*/

        for (int i = 0; i < customers.size(); i++) {
            int n = rnd.nextInt(1, 5);
            for (int j = 0; j < n; j++) {
                orders.add(Order.fillOrder(products, customers.get(i), n));
            }
        }
        /*for (Order o : orders) {
            System.out.println(o);
        }*/
        System.out.println("Prodotti con prezzo >100");

        esercizio1(products);

        
    }

    public static void esercizio1(List<Product> p) {

        p.stream().filter(x -> x.getPrice() > 100).forEach(x -> System.out.println(x));
    }
}
