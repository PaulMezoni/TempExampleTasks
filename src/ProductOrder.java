import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductOrder {
    public static void main(String[] args) {
        Product milk = new Product(BigDecimal.valueOf(2), BigDecimal.valueOf(200));
        Product sugar = new Product(BigDecimal.valueOf(3), BigDecimal.valueOf(300));

        List<Product> productList = new ArrayList<>();
        productList.add(milk);
        productList.add(sugar);
        Order order = new Order("max", productList);
        System.out.println(order.sum());

        BigDecimal bigDecimal = BigDecimal.valueOf(1300);
        System.out.println(order.sum().equals(bigDecimal));
    }

    public static class Order {
        private final String name;
        private final List<Product> productList;

        public Order(String name, List<Product> productList) {
            this.name = name;
            this.productList = productList;
        }

        public BigDecimal sum() {
            return productList.stream().map(e -> e.getCount().multiply(e.getPrice())).reduce(BigDecimal::add).get();
        }

        public String getName() {
            return name;
        }

        public List<Product> getProductList() {
            return productList;
        }

    }

    static class Product {
        private final BigDecimal count;
        private final BigDecimal price;

        public Product(BigDecimal count, BigDecimal price) {
            this.count = count;
            this.price = price;
        }

        public BigDecimal getCount() {
            return count;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }

    static class Client {
        private final String name;
        private final List<Product> cartList;

        public Client(String name, List<Product> cartList) {
            this.name = name;
            this.cartList = cartList;
        }

        public String getName() {
            return name;
        }

        public List<Product> getCartList() {
            return cartList;
        }
    }
}

//@Service
//class MyService {
//    @Transactional(propagation = MANDATORY)
//    fun bar() {
//        // some logic
//        fizz()
//        // some logic
//    }
//    @Transactional(propagation = REQUIRES_NEW)
//    fun fizz() {
//        // some logic
//    }
//}
//@RestController
//class Controller(private val service: MyService) {
//
//    @GetMapping("/foo")
//    fun foo() {
//        service.bar()
//    }
//
//}
