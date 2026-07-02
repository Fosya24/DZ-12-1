import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.NotFoundException;
import ru.netology.javaqa.Product;
import ru.netology.javaqa.ShopRepository;

public class ShopRepositoryTest {
    ShopRepository shopRepository = new ShopRepository();

    Product product = new Product(1, "", 300);
    Product product2 = new Product(22, "", 525);
    Product product3 = new Product(58, "", 7_000);
    Product product4 = new Product(56, "", 5_000);
    Product product5 = new Product(900, "", 56_000);
    Product product6 = new Product(236, "", 889);

    @BeforeEach
    public void setUp() {
        shopRepository.add(product);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.add(product4);
        shopRepository.add(product5);
        shopRepository.add(product6);
    }

    @Test
    public void shouldRemoveById() {
        shopRepository.remove(22);

        Product[] expected = {product, product3, product4, product5, product6};
        Product[] actual = shopRepository.removeById();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfIdNoMath() {

        Product[] expected = {product, product3, product4, product5, product6};
        Product[] actual = shopRepository.removeById();

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(100);
        });
    }

    @Test
    public void shouldFindAll() {

        Product[] expected = {product, product2, product3, product4, product5, product6};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}