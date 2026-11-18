/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projectsalesreport;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class ProjectSalesReport {
    public static void main(String[] args) {
// Single-dimensional array for product names
        Scanner scanner = new Scanner(System.in);
// Single-dimensional array for product names
            String[] products = {
                "Cozy Nights Monarch mattress",
                "Restonic Barbados mattress",
                "Sealy Phuket mattress"
            };
            
// Two-dimensional array for sales [3 products][3 months]
            int[][] sales = new int[3][3];
            
// Collect user input
            for (int i = 0; i < products.length; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + ": ");
                    sales[i][j] = scanner.nextInt();
                }
                System.out.println(); // Blank line between products
            }
            
            // Instantiate classes and print the report
            Product productReport = new Product(products, sales);
            PrintProduct printer = new PrintProduct();
            
            printer.printReportHeader();
            printer.printTotalProductSales();
            printer.printAverageProductSales();
            printer.printMostPopularProducts();
        }
    }


