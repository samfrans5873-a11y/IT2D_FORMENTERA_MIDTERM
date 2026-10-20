package com.laundry.model;

public class ScenarioEntity {
    private int id;
    private String customerName;
    private double weightKg;
    private double totalAmount;
    private String status;

    public ScenarioEntity(int id, String customerName, double weightKg, double totalAmount, String status) {
        this.id = id;
        this.customerName = customerName;
        this.weightKg = weightKg;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public ScenarioEntity(String customerName, double weightKg, double totalAmount, String status) {
        this.customerName = customerName;
        this.weightKg = weightKg;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}