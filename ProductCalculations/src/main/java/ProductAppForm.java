/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductAppForm extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductAppForm() {
        // Window Setup
        setTitle("Product App");
        setSize(420, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Q.2.4: Menu System Setup
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);

        JMenu menuTools = new JMenu("Tools");
        JMenuItem itemProcess = new JMenuItem("Process");
        JMenuItem itemClear = new JMenuItem("Clear");
        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // Q.2.2: Form Controls
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        panel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);

        panel.add(new JLabel("Select Product:"));
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct);

        panel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        panel.add(new JLabel("")); // Empty spacer cell for layout
        btnProcess = new JButton("PROCESS");
        panel.add(btnProcess);

        add(panel);

        // Event Listeners
        btnProcess.addActionListener(e -> processSale());
        itemProcess.addActionListener(e -> processSale());
        itemClear.addActionListener(e -> clearForm());
        itemExit.addActionListener(e -> System.exit(0));
    }

    // Q.2.3: Process Logic, Message Dialog, and File Saving
    private void processSale() {
        try {
            String customerName = txtCustomerName.getText().trim();
            String product = cmbProduct.getSelectedItem().toString();
            double price = Double.parseDouble(txtPrice.getText().trim());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Format output matching the JOptionPane screenshot
            String message = "Customer Name: " + customerName + "\n"
                           + "Product: " + product + "\n"
                           + "VAT: R " + vat + "\n"
                           + "COMMISSION: R " + commission + "\n"
                           + "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt matching the exact sample screenshot
            saveToFile(customerName, product, vat, commission, total);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFile(String customerName, String product, double vat, double commission, double total) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("***********************************");
            writer.println("Customer Name: " + customerName);
            writer.println("Product: " + product);
            writer.println("VAT: R " + vat);
            writer.println("COMMISSION: R " + commission);
            writer.println("TOTAL: R " + total);
            writer.println("***********************************");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to data.txt: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Q.2.4: Clear Logic
    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductAppForm().setVisible(true);
        });
    }
}
