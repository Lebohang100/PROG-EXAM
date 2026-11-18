/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class Product implements IProducts {
    private String[] products;
    private int[][] sales;

    public Product(String[] products, int[][] sales) {
        this.products = products;
        this.sales = sales;
    }
// Method to calculate the total products sold in three months
    @Override
    public int TotalProductsSold() {
        int total = 0;
        for (int[] sale : sales) {
            for (int j = 0; j < sale.length; j++) {
                total += sale[j];
            }
        }
        return total;
    }
// Method used to calculate the average products sold 
    @Override
    public double AverageProductsSold() {
        int total = TotalProductsSold();
        int count = 0;
        for (int[] sale : sales) {
            count += sale.length;
        }
        return (count > 0) ? (double) total / count : 0;
    }
// Determines the products which contains the highest sales
    @Override
    public String MostPopularProducts() {
        int highestProductTotal = -1;
        int bestProductIndex = 0;
        int highestSingleMonthSale = 0;

        for (int i = 0; i < sales.length; i++) {
            int currentProductTotal = 0;
            int currentMaxMonth = 0;
            
            for (int j = 0; j < sales[i].length; j++) {
                currentProductTotal += sales[i][j];
                if (sales[i][j] > currentMaxMonth) {
                    currentMaxMonth = sales[i][j];
                }
            }

            if (currentProductTotal > highestProductTotal) {
                highestProductTotal = currentProductTotal;
                bestProductIndex = i;
                highestSingleMonthSale = currentMaxMonth;
            }
        }

        // Strip " mattress" to match the sample output: "Cozy Nights Monarch (25)"
        String shortName = products[bestProductIndex].replace(" mattress", "");
        return shortName + " (" + highestSingleMonthSale + ")";
    }
}
