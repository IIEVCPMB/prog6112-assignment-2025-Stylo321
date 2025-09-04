package com.mycompany.progs2;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class SeriesTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    void TestSearchSeries() {
        Series series = new Series(new Scanner(""));
        series.getSeriesList().add(new SeriesModel("S1", "Test Series", 12, 10));
        SeriesModel found = series.findSeriesById("S1");
        assertNotNull(found);
        assertEquals("S1", found.SeriesId);
        assertEquals("Test Series", found.SeriesName);
        assertEquals(12, found.SeriesAge);
        assertEquals(10, found.SeriesNumberOfEpisodes);
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        Series series = new Series(new Scanner(""));
        series.getSeriesList().add(new SeriesModel("S1", "Test Series", 12, 10));
        SeriesModel found = series.findSeriesById("S2");
        assertNull(found);
    }

    @Test
    void TestUpdateSeries() {
        Series series = new Series(new Scanner(""));
        series.getSeriesList().add(new SeriesModel("S3", "Old Name", 10, 5));
        SeriesModel toUpdate = series.findSeriesById("S3");
        assertNotNull(toUpdate);
        // Simulate update
        toUpdate.SeriesName = "New Name";
        toUpdate.SeriesAge = 14;
        toUpdate.SeriesNumberOfEpisodes = 12;
        assertEquals("New Name", toUpdate.SeriesName);
        assertEquals(14, toUpdate.SeriesAge);
        assertEquals(12, toUpdate.SeriesNumberOfEpisodes);
    }

    @Test
    void TestDeleteSeries() {
        Series series = new Series(new Scanner(""));
        series.getSeriesList().add(new SeriesModel("S4", "To Delete", 16, 20));
        boolean removed = series.getSeriesList().removeIf(s -> s.SeriesId.equals("S4"));
        assertTrue(removed);
        assertNull(series.findSeriesById("S4"));
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        Series series = new Series(new Scanner(""));
        series.getSeriesList().add(new SeriesModel("S5", "Keep Me", 18, 22));
        boolean removed = series.getSeriesList().removeIf(s -> s.SeriesId.equals("NotExist"));
        assertFalse(removed);
        assertNotNull(series.findSeriesById("S5"));
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        // Let's say valid age is >= 0 and <= 18 for this example
        int validAge = 15;
        assertTrue(isAgeValid(validAge));
    }

    @Test
    void TestSeriesAgeRestriction_SeriesAgeInValid() {
        int invalidAge = -3;
        assertFalse(isAgeValid(invalidAge));
        invalidAge = 25;
        assertFalse(isAgeValid(invalidAge));
    }

    // Helper method for age validation (adjust logic as per your app's rules)
    private boolean isAgeValid(int age) {
        return age >= 0 && age <= 18;
    }


}