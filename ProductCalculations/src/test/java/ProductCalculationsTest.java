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
public class ProductCalculationsTest {

    @Test
    public void Vat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        double expectedVat = 525.0;
        double actualVat = calc.Vat();
        
        assertEquals(expectedVat, actualVat, 0.001);
    }
}
