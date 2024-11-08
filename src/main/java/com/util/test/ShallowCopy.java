
package com.util.test;

import lombok.Data;

import java.util.Arrays;

public class ShallowCopy {
    public static void main(String[] args) {
        Address[] originalArray = {
                new Address("123 Main St", "New York"),
                new Address("456 Elm St", "Los Angeles")
        };

        Address[] copiedArray = new Address[originalArray.length];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);
        // 修改原始数组中的一个地址
        originalArray[0].setStreet("789 Oak St");
        System.out.println("Original array: " + Arrays.toString(originalArray));
        System.out.println("Copied array: " + Arrays.toString(copiedArray));
    }
}
@Data
class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
    @Override
    public String toString() {
        return "Address{street='" + street + "', city='" + city + "'}";
    }
}
