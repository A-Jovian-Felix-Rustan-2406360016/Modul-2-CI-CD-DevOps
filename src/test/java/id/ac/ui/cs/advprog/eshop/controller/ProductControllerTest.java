package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean; // Diperbarui untuk Spring Boot 3.5+
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean // Menggantikan @MockBean yang deprecated
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("123");
        product.setProductName("Sabun");
        product.setProductQuantity(15);
    }

    @Test
    void testCreateProductPage() throws Exception {
        mockMvc.perform(get("/product/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("CreateProduct")) // Sesuaikan kapital: 'C'
                .andExpect(model().attributeExists("product"));
    }

    @Test
    void testCreateProductPost() throws Exception {
        mockMvc.perform(post("/product/create")
                        .flashAttr("product", product))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:list"));
        verify(productService, times(1)).create(any(Product.class));
    }

    @Test
    void testProductListPage() throws Exception {
        when(productService.findAll()).thenReturn(Collections.singletonList(product));

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("ProductList")) // Sesuaikan kapital: 'P' dan 'L'
                .andExpect(model().attributeExists("products"));
    }

    @Test
    void testEditProductPage() throws Exception {
        when(productService.findById("123")).thenReturn(product);

        mockMvc.perform(get("/product/edit/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("EditProduct")) // Sudah benar sesuai file
                .andExpect(model().attributeExists("product"));
    }

    @Test
    void testEditProductPost() throws Exception {
        mockMvc.perform(post("/product/edit")
                        .flashAttr("product", product))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:list"));
        verify(productService, times(1)).edit(any(Product.class));
    }

    @Test
    void testDeleteProduct() throws Exception {
        mockMvc.perform(get("/product/delete/123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product/list"));
        verify(productService, times(1)).delete("123");
    }
}