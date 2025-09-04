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
public class MainCourseTest {
    



    
    public MainCourseTest() {
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
    public void testMainCourseConstructorAndGetters() {
        MainCourse main = new MainCourse(20, "Steak", 120.00);
        assertEquals(20, main.getId());
        assertEquals("Steak", main.getName());
        assertEquals(120.00, main.getPrice(), 0.001);
    }

    @Test
    public void testMainCourseToString() {
        MainCourse main = new MainCourse(21, "Pasta", 80.00);
        assertEquals("[21] Pasta - R80.0", main.toString());
    }
}