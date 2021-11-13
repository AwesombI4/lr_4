package streamsApi.Exercises;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex13 {

    public static void main(String[] args) {
        //Exercise 13 — Produce a data map with order record and product total sum

        Map<Order, Double> orderAndTotalSum = orders.stream()
                .collect(Collectors.toMap(Function.identity(),
                        order -> order.getProducts().stream()
                                .mapToDouble(Product::getPrice)
                                .sum()));

        orderAndTotalSum.forEach((order, totalSum) ->
                System.out.println("orderId = " + order.getId() + ", totalSum = " + totalSum));
    }

    static List<Customer> customers = List.of(
            new Customer(1L, "bob", 3),
            new Customer(2L, "batman", 2)
    );
    static List<Product> products = List.of(
            new Product(1L, "potato", "vegetables", 30.00),
            new Product(2L, "carrot", "vegetables", 15.50),
            new Product(3L, "cabbage", "vegetables", 20.00),
            new Product(4L, "table", "furniture", 300.00),
            new Product(5L, "pen", "stationery", 30.00),
            new Product(6L, "ruler", "stationery", 125.00),
            new Product(7L, "pencil", "stationery", 25.00)
    );
    static List<Product> products2 = List.of(
            new Product(products.get(2).getId(), "cabbage", "vegetables", 20.00),
            new Product(products.get(6).getId(), "pencil", "stationery", 25.00)
    );
    static List<Order> orders = List.of(
            new Order(1L,
                    customers.get(0),
                    products,
                    LocalDate.of(2021, 12, 30),
                    LocalDate.of(2021, 12, 30),
                    "success"),
            new Order(2L,
                    customers.get(1),
                    products2,
                    LocalDate.of(2021, 3, 15),
                    LocalDate.of(2021, 3, 15),
                    "fail"),
            new Order(3L,
                    customers.get(1),
                    List.of(products.get(2), products.get(3)),
                    LocalDate.of(2021, 3, 15),
                    LocalDate.of(2021, 3, 15),
                    "fail"),
            new Order(4L,
                    customers.get(1),
                    List.of(products.get(2), products.get(4)),
                    LocalDate.of(2021, 3, 14),
                    LocalDate.of(2021, 3, 14),
                    "success")
    );
}
