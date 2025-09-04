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
public class StarterTest {
    
    public StarterTest() {
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
    public void testStarterConstructorAndGetters() {
        Starter starter = new Starter(10, "Soup", 25.00);
        assertEquals(10, starter.getId());
        assertEquals("Soup", starter.getName());
        assertEquals(25.00, starter.getPrice(), 0.001);
    }

    @Test
    public void testStarterToString() {
        Starter starter = new Starter(11, "Salad", 30.00);
        assertEquals("[11] Salad - R30.0", starter.toString());
    }
}