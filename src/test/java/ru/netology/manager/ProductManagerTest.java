package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "name1", 100, "Author1");
    Product book2 = new Book(2, "name2", 900, "Author1");
    Product book3 = new Book(3, "name3", 1000, "Author3");
    Product book4 = new Book(4, "name2", 1000, "Author4");
    Product smartphone1 = new Smartphone(5, "name5", 1500, "USA");
    Product smartphone2 = new Smartphone(6, "name6", 1500, "Russia");
    Product smartphone3 = new Smartphone(7, "name6", 1500, "USA");
    Product smartphone4 = new Smartphone(8, "name8", 1500, "China");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
    }

    @Test
    void shouldSearchByIfNoBookWithName() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("name15");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfBookWithTitleExist() {
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("name1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIf1BooksWithTitleExist() {
        Product[] expected = new Product[]{book2, book4};
        Product[] actual = manager.searchBy("name2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfNoBookWithAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Author50");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIf2BooksWithAuthorExist() {
        Product[] expected = new Product[]{book1, book2};
        Product[] actual = manager.searchBy("Author1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfNoSmartphoneWithManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Germany");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfSmartphoneWithManufacturerExist() {
        Product[] expected = new Product[]{smartphone2};
        Product[] actual = manager.searchBy("Russia");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfSmartphonesWithManufacturerExist1() {
        Product[] expected = new Product[]{smartphone1, smartphone3};
        Product[] actual = manager.searchBy("USA");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfSmartphoneWithTitleExist2() {
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("name5");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfSmartphonesWithNameExist3() {
        Product[] expected = new Product[]{smartphone2, smartphone3};
        Product[] actual = manager.searchBy("name6");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByIfSmartphonesWithManufacturerExist4() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("hit");
        assertArrayEquals(expected, actual);
    }

}