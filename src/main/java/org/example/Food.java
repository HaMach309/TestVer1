package org.example;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;

public class Food extends Product {
    private LocalDate dateOfManufacture; // ngay san xuat
    private LocalDate dateOfExpiry; // ngay het han
    private String supplier;

    public Food(String code, String name, int amount, long price) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.vat = 8;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }


    @Override
    String assessSalesLevel() {
        if (dateOfManufacture == null
                || dateOfExpiry == null
                || dateOfExpiry.isBefore(dateOfManufacture)
                || amount < 0
                || price < 0)
            return ("Data error - Vui lòng kiểm tra lại data của sản phầm");
        else if ((amount > 0) && (dateOfManufacture.isBefore(LocalDate.now())))
            return ("Hàng thực phẩm khó bán");
        else return ("Hàng thực phẩm dễ bán");
    }

    @Override
    void showProduct() {
        System.out.printf("Mã sản phẩm: %s  --  Tên sản phẩm: %s  --  Số lượng tồn kho: %d   --  Giá bán: %d -- %s%n", code, name, amount, price, assessSalesLevel());
    }
}