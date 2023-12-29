package com.bill;

public class PremiumCustomer extends Customer {
    int billNo;
    float billAmount;

    public PremiumCustomer(int custId, String custName, long mobileNumber, int billNo) {
        super(custId, custName, mobileNumber);
        this.billNo = billNo;
    }

    public int getBillNo() {
        return billNo;
    }

    public float getBillAmount() {
        return billAmount;
    }

    //Premium customer price first 30 minute 1 after that 0.5
    @Override
    public double calculateBill(int minutes) throws NegativeNumberException {
        if (minutes < 0) {
            throw new NegativeNumberException("minute can't be negative");
        }
        if (minutes <= 30) {
            this.billAmount = (float) minutes;
            return minutes;
        } else {
            double value = (minutes - 30) * 0.5 + 30;
            this.billAmount = (float) value;
            return value;
        }
    }
}
