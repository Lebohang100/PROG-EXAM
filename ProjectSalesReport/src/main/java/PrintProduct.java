/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class PrintProduct {
    private IProducts productData;

    public PrintProduct(IProducts productData) {
        this.productData = productData;
    }
// This prints the heading of the Report
    public void printReportHeader() {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
    }
// Print the total products sold
    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + productData.TotalProductsSold());
    }
// Print the average products sold
    public void printAverageProductSales() {
        // Cast to int to match the sample screenshot output ("17")
        System.out.println("AVERAGE PRODUCT SALES: " + (int) productData.AverageProductsSold());
    }
// Print most popular product
    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + productData.MostPopularProducts());
    }
}

