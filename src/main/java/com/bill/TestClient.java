package com.bill;

import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {

        Customer[] c = new Customer[2];

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a premium custid");
        int custId = sc.nextInt();
        System.out.println("Please enter a premium custName");
        String custName = sc.next();
        System.out.println("Please enter a premium mobileNumber");
        long mobileNumber = sc.nextLong();
        System.out.println("Please enter a premium billNo");
        int billNo = sc.nextInt();
        System.out.println("Please enter a premium minute");
        int minute = sc.nextInt();
        try {
            PremiumCustomer p = new PremiumCustomer(custId,custName,mobileNumber,billNo);
            p.calculateBill(minute);
            c[0] = p;
        } catch (NegativeNumberException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Please enter a regular custid");
        int custId1 = sc.nextInt();
        System.out.println("Please enter a regular custName");
        String custName1 = sc.next();
        System.out.println("Please enter a regular mobileNumber");
        long mobileNumber1 = sc.nextLong();
        System.out.println("Please enter a regular billNo");
        int billNo1 = sc.nextInt();
        System.out.println("Please enter a regular minute");
        int minute1 = sc.nextInt();

        try {
            RegularCustomer p1 = new RegularCustomer(custId1,custName1,mobileNumber1,billNo1);
            p1.calculateBill(minute1);
            c[1] = p1;
        } catch (NegativeNumberException e) {
            throw new RuntimeException(e);
        }
        PremiumCustomer p1 = (PremiumCustomer) c[0];
        RegularCustomer r1 = (RegularCustomer) c[1];
        System.out.println(p1.getBillAmount());
        System.out.println(r1.getBillAmount());
    }
}