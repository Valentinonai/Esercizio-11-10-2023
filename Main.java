import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
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

        List<Customer> customers = new ArrayList<>(Customer.fillCustomer(5));
       /* for (Customer c : customers)
            System.out.println(c);*/

        for (int i = 0; i < customers.size(); i++) {
            int n = rnd.nextInt(1, 5);

            orders.add(Order.fillOrder(products, customers.get(i), n));

        }
        /*for (Order o : orders) {
            System.out.println(o);
        }*/
        System.out.println("\n*********************Prodotti con prezzo >100 e category Books***************************\n");

        esercizio1(products);

        System.out.println("\n*********************Ordini prodotti categoria baby***********************\n");

        esercizio2(orders);

        System.out.println("\n********************Prodotti categoria Boys -10%***************************\n");

        esercizio3(products);

        System.out.println("\n********************Ordini cliente livello 2 tra 1-2-2021 e 1-4-2021***************************\n");

        esercizio4(orders);
    }

    public static void esercizio1(List<Product> p) {

        p.stream().filter(x -> x.getPrice() > 100 && x.getCategory().equals("Books")).forEach(x -> System.out.println(x));
    }

    public static void esercizio2(List<Order> o) {
        for (int i = 0; i < o.size(); i++) {
            o.get(i).getProducts().stream().filter(x -> x.getCategory() == "Baby").forEach(x -> System.out.println(x));
        }
    }

    public static void esercizio3(List<Product> p) {

        List<Product> app = p.stream().filter(x -> x.getCategory().equals("Boys")).toList();
        app.stream().map(x -> {
            x.setPrice(x.getPrice() - ((x.getPrice() * 10) / 100));
            return x;
        }).forEach(x -> System.out.println(x));
    }

    public static void esercizio4(List<Order> o) {
        LocalDate start = LocalDate.of(2021, 02, 01);
        LocalDate end = LocalDate.of(2021, 04, 01);
        List<Order> app = o.stream().filter(x -> x.getOrderDate().isAfter(start) && x.getOrderDate().isBefore(end)).toList();
        for (int i = 0; i < app.size(); i++) {
            if (app.get(i).getCustomer().getTier() == 2) {
                System.out.println(app.get(i));
            }
        }
    }
}
