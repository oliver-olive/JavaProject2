package com.bill;

public class RegularCustomer extends Customer{
    int billNo;
    float billAmount;

    public RegularCustomer(int custId, String custName, long mobileNumber, int billNo) {
        super(custId, custName, mobileNumber);
        this.billNo = billNo;
    }

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(float billAmount) {
        this.billAmount = billAmount;
    }

    //regular customer price first 30 minute 1.5 after that 1
    @Override
    public double calculateBill(int minutes) throws NegativeNumberException {
        if(minutes < 0){
            throw new NegativeNumberException("minute can't be negative");
        }
        if (minutes <= 30) {
            this.billAmount = (float) (minutes * 1.5);
            return minutes * 1.5;
        } else {
            double value = (minutes - 30) * 1 + 30 * 1.5;
            this.billAmount = (float) ((minutes - 30) * 1 + 30 * 1.5);
            return value;
        }
    }
}
