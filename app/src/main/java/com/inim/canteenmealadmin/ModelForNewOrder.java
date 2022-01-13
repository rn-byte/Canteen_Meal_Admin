package com.inim.canteenmealadmin;

public class ModelForNewOrder {


    private String date;
    private String food;
    private String orderId;
    private String qty;
    private long totalPrice;
    String name,phone,status;
    public ModelForNewOrder() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModelForNewOrder(String date, String food, String orderNo, String quantity, long totalPrice, String name, String phone, String status) {
        this.date = date;
        this.food = food;
        this.orderId = orderId;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.name=name;
         this.phone=phone;
        this.status=status;
    }
}

