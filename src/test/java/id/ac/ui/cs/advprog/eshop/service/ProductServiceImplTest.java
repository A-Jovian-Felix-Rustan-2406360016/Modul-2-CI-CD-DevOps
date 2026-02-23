package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("123");
        product.setProductName("Kecap");
        product.setProductQuantity(10);
    }

    @Test
    void testCreate() {
        productService.create(product);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList.iterator());

        List<Product> result = productService.findAll();
        assertEquals(1, result.size());
        assertEquals("123", result.getFirst().getProductId());
    }

    @Test
    void testFindById() {
        when(productRepository.findById("123")).thenReturn(product);
        Product result = productService.findById("123");
        assertEquals("123", result.getProductId());
    }

    @Test
    void testEdit() {
        when(productRepository.edit(product)).thenReturn(product);
        Product result = productService.edit(product);
        assertEquals("123", result.getProductId());
        verify(productRepository, times(1)).edit(product);
    }

    @Test
    void testDelete() {
        productService.delete("123");
        verify(productRepository, times(1)).delete("123");
    }
}