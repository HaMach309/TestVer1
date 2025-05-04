package org.example;

public class Machine extends Product {
    private int warrantyPeriod = 0;
    private int power = 0;

    public Machine(String code, String name, int amount, long price) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.vat = 15;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    String assessSalesLevel() {
        if (amount < 0
                || price < 0
                || warrantyPeriod < 0
                || power < 0)
            return ("Data error - Vui lòng kiểm tra lại data của sản phầm");
        else if (amount < 3)
            return ("Hàng điện máy dễ bán");
        else return ("Hàng điện máy khó bán");
    }

    @Override
    void showProduct() {
        System.out.printf("Mã sản phẩm: %s  --  Tên sản phẩm: %s  --  Số lượng tồn kho: %d   --  Giá bán: %d -- %s%n", code, name, amount, price, assessSalesLevel());
    }
}
