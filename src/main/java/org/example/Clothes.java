package org.example;

import java.time.LocalDate;

public class Clothes extends Product {
    private String supplier;
    private LocalDate dateOfEntry;

    public Clothes(String code, String name, int amount, long price) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.vat = 15;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    @Override
    String assessSalesLevel() {
        if (dateOfEntry == null
                || amount < 0
                || price < 0)
            return ("Data error - Vui lòng kiểm tra lại data của sản phầm");
        else if ((amount > 60) && ((dateOfEntry.plusDays(20)).isAfter(LocalDate.now())))
            return "Hàng may mặc bán chậm";
        else return ("Hàng may mặc bán nhanh");
    }

    @Override
    void showProduct() {
        System.out.printf("Mã sản phẩm: %s  --  Tên sản phẩm: %s  --  Số lượng tồn kho: %d   --  Giá bán: %d -- %s%n",code, name, amount, price, assessSalesLevel());
    }
}
