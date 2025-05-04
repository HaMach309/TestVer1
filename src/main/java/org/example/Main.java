package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Main {
    static ArrayList<Product> productArrayList = new ArrayList<Product>();

    //Thêm sản phẩm thành công nếu không trùng mã hàng hóa - code
    private static boolean addProduce(Product product) {
        for (Product p : productArrayList) {
            if (Objects.equals(p.code, product.code)) {
                return false;
            }
        }
        productArrayList.add(product);
        return true;
    }

    //In list sản phẩm và Đánh giá khả năng tiêu thụ theo từng loại
    private static void showListProduct(String name) {
        System.out.println("\nCác sản phẩm thuộc loại " + name + ": ");
        for (Product p : productArrayList) {
            if (p.getClass().getSimpleName().equals(name)) {
                p.showProduct();
            }
        }
    }

    public static void main(String[] args) {
        Food food1 = new Food("F1", "Custas", 10, 10000);
        food1.setDateOfManufacture(LocalDate.of(2022, 5, 4));
        food1.setDateOfExpiry(LocalDate.of(2023, 5, 3));
        food1.setSupplier("Orion");
        Food food2 = new Food("F2", "choco", 0, 10000);
        food2.setDateOfManufacture(LocalDate.of(2024, 5, 4));
        food2.setDateOfExpiry(LocalDate.of(2025, 10, 10));
        food2.setSupplier("Orion");
        Food food3 = new Food("F3", "ori", 0, 5000);
        food3.setDateOfManufacture(LocalDate.of(2024, 5, 4));
        food3.setDateOfExpiry(LocalDate.of(2023, 4, 10));
        food3.setSupplier("Orion");

        Product machine1 = new Machine("M1", "pc", 0, 50000);
        Product machine2 = new Machine("M2", "mac", 5, 250000);
        Product machine3 = new Machine("M3", "iphone", 0, 100000);

        Clothes clothes1 = new Clothes("C1", "ao", 61, 100);
        clothes1.setDateOfEntry(LocalDate.of(2025, 4, 4));
        Clothes clothes2 = new Clothes("C2", "quan", 0, 2000);
        clothes2.setDateOfEntry(LocalDate.of(2025, 4, 30));
        Clothes clothes3 = new Clothes("C3", "vay", 5, 500);
        clothes1.setDateOfEntry(LocalDate.of(2025, 4, 28));

        addProduce(food1);
        addProduce(food1);
        addProduce(food2);
        addProduce(food3);
        addProduce(machine1);
        addProduce(machine2);
        addProduce(machine3);
        addProduce(clothes1);
        addProduce(clothes2);
        addProduce(clothes3);

        // In ra và Đánh giá khả năng tiêu thụ các sản phẩm thuộc lại Food
        showListProduct("Food");

        // In ra và Đánh giá khả năng tiêu thụ các sản phẩm thuộc lại Machine
        showListProduct("Machine");

        // In ra và Đánh giá khả năng tiêu thụ các sản phẩm thuộc lại Clothes
        showListProduct("Clothes");
    }
}