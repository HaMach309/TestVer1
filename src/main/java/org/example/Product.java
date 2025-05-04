package org.example;

public abstract class Product {
    protected String code;
    protected String name;
    protected int amount = 0;
    protected long price = 0;
    protected int vat = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public long getPrice() {
        return price;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    abstract String assessSalesLevel();
    abstract void showProduct();

}
