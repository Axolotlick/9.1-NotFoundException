package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

class ProductRepositoryTest {

    Product product1 = new Product(1, "книга1", 50);
    Product product2 = new Product(2, "книга2", 150);
    Product product3 = new Product(3, "книга3", 100);


    @Test
    //тест должен проверять успешность удаления существующего элемента
    public void testSave1() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    //тест на удаление товара по ID (удаление несуществующего в списке id)
    public void testRemoveNotId2() {
        ProductRepository repo = new ProductRepository();

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(8));
    }


}