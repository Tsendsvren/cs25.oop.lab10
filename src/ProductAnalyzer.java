import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // toString method
    @Override
    public String toString() {
        return name + " (" + price + ")";
    }
}

public class ProductAnalyzer {

    public static Map<String, List<Product>> analyze(List<Product> products) {
        return products.stream()
                // 1000₮-с дээш бүтээгдэхүүнийг шүү
                .filter(p -> p.getPrice() >= 1000)
                // Категориар бүлэглэ
                .collect(Collectors.groupingBy(Product::getCategory, 
                        // Категори дотор үнийг буурах дарааллаар эрэмбэл
                        Collectors.collectingAndThen(
                            Collectors.toList(),
                            list -> {
                                list.sort(Comparator.comparingDouble(Product::getPrice).reversed());
                                return list;
                            }
                        )
                ));
    }

    public static void main(String[] args) {
        List<Product> items = Arrays.asList(
                new Product("Gutal", 1500, "Huwtsas"),
                new Product("Togloom", 800, "Togloom"),
                new Product("Tsamts", 1200, "Huwtsas")
        );

        // analyze дуудаж, хэвлэх
        Map<String, List<Product>> result = analyze(items);
        
        result.forEach((category, products) -> {
            System.out.println(category + ": " + products);
        });
    }
}
