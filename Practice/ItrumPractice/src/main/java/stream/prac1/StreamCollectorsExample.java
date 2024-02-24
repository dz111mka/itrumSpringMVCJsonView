package stream.prac1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );


        List<Order> result1 = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct, Collectors.summingDouble(Order::getCost)))
                .entrySet()
                .stream()
                .map(entry -> new Order(entry.getKey(), entry.getValue()))
                .toList();

        List<Order> result2 = result1.stream().
                sorted(Comparator.comparingDouble(Order::getCost).
                        reversed()).
                toList();

        List<Order> result3 = orders.stream().sorted(Comparator.comparingDouble(Order::getCost).reversed()).limit(3).toList();

        System.out.println(result3);





    }
}

class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product='" + product + '\'' +
                ", cost=" + cost +
                '}';
    }
}


