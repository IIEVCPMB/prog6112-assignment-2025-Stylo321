/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progs2sb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author silol
 */
public class FoodItemTest {
    
    public FoodItemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class FoodItem.
     */
    @Test
    public void testConstructorAndGetters() {
        FoodItem item = new FoodItem(1, "Pizza", 99.99);
        assertEquals(1, item.getId());
        assertEquals("Pizza", item.getName());
        assertEquals(99.99, item.getPrice(), 0.001);
    }

    @Test
    public void testToString() {
        FoodItem item = new FoodItem(2, "Burger", 49.50);
        assertEquals("[2] Burger - R49.5", item.toString());
    }
}