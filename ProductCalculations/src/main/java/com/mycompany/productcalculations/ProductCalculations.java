/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productcalculations;

/**
 *
 * @author Student
 */
public class ProductCalculations implements IProductCalculations {
    private double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double Vat() {
        return price * 0.15;
    }

    @Override
    public double Commission() {
        return price * 0.05;
    }

    @Override
    public double Total() {
        return price + Vat() + 
                
                
                
                
                
                
                Commission();
    }
}

