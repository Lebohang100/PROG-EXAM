/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */


public class ProductTest {

    // Sample data matching the exam screenshot
    private final String[] testProducts = {
        "Cozy Nights Monarch mattress",
        "Restonic Barbados mattress",
        "Sealy Phuket mattress"
    };

    private final int[][] testSales = {
        {25, 18, 20},
        {15, 10, 12},
        {18, 15, 20}
    };

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(testProducts, testSales);
        int expectedTotal = 153;
        int actualTotal = product.TotalProductsSold();
        
        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(testProducts, testSales);
        double expectedAverage = 17.0;
        double actualAverage = product.AverageProductsSold();
        
        // The third parameter (0.001) is the delta for comparing double values
        assertEquals(expectedAverage, actualAverage, 0.001);
    }
}
