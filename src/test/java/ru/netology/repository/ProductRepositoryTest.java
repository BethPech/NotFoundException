package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;
import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository productRepository = new ProductRepository();
    Product item1 = new Product(1, "Мертвые Души", 100);
    Product item2 = new Product(2, "Преступление и наказание", 120);
    Product item3 = new Product(3, "Бедная Лиза", 99);
    Product item4 = new Product(4, "Samsung", 11000);
    Product item5 = new Product(5, "Huawei", 9000);
    Product item6 = new Product(6, "Apple", 15000);

    @BeforeEach
    public void setUp() {
        productRepository.save(item1);
        productRepository.save(item2);
        productRepository.save(item3);
        productRepository.save(item4);
        productRepository.save(item5);
        productRepository.save(item6);
    }

    @Test
    void shouldRemoveById() {
        productRepository.removeById(1);
        Product[] expected = new Product[]{item2, item3, item4, item5, item6};
        Product[] actual = productRepository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {
        assertThrows(NotFoundException.class, () -> productRepository.removeById(10));
    }
}
