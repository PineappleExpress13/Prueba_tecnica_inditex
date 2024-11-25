package com.inditex.integration;

import com.inditex.JosueTest.JosueTestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@SpringBootTest(classes = JosueTestApplication.class)
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     * */
    @Test
    public void testCase1() throws Exception {
        mockMvc.perform(get("/v1/prices/getProductPrice?date=2020-06-14T10:00:00&id=35455&brand=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
    }

    /**
     * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     * */
    @Test
    public void testCase2() throws Exception {
        mockMvc.perform(get("/v1/prices/getProductPrice?date=2020-06-14T16:00:00&id=35455&brand=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("25.45"));
    }

    /**
     * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
     * */
    @Test
    public void testCase3() throws Exception {
        mockMvc.perform(get("/v1/prices/getProductPrice?date=2020-06-14T21:00:00&id=35455&brand=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
    }

    /**
     * Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
     * */
    @Test
    public void testCase4() throws Exception {
        mockMvc.perform(get("/v1/prices/getProductPrice?date=2020-06-15T10:00:00&id=35455&brand=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("30.5"));
    }


    /**
     * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
     * */
    @Test
    public void testCase5() throws Exception {
        mockMvc.perform(get("/v1/prices/getProductPrice?date=2020-06-16T21:00:00&id=35455&brand=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("38.95"));
    }
}
