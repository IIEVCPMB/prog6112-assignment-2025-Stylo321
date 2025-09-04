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
public class DessertTest {

     public DessertTest() {
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
        @Test
    public void testDessertConstructorAndGetters() {
        Dessert dessert = new Dessert(30, "Ice Cream", 35.00);
        assertEquals(30, dessert.getId());
        assertEquals("Ice Cream", dessert.getName());
        assertEquals(35.00, dessert.getPrice(), 0.001);
    }

    @Test
    public void testDessertToString() {
        Dessert dessert = new Dessert(31, "Cake", 40.00);
        assertEquals("[31] Cake - R40.0", dessert.toString());
    }


}
