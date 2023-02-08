package com.example.apicart;

public class singleproduct {

    int id,price,quantity,total,discountper,discountprice;
    String title;

    public singleproduct(int id, int price, int quantity, int total, int discountper, int discountprice, String title) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.discountper = discountper;
        this.discountprice = discountprice;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDiscountper() {
        return discountper;
    }

    public void setDiscountper(int discountper) {
        this.discountper = discountper;
    }

    public int getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(int discountprice) {
        this.discountprice = discountprice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
