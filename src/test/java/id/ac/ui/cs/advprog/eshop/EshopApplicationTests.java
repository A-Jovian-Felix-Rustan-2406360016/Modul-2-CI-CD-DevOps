package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {


    @Test
    void contextLoads() {
        // Walaupun kosong, test ini memastikan context loads berjalan
    }

    @Test
    void testMain() {
        EshopApplication.main(new String[] {});
    }

}
