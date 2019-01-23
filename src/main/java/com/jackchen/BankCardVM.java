package com.jackchen;

/**
 * Created by MinZeng
 * 时间：2018/9/17.
 */
public class BankCardVM {

    private String bankType;

    private String cardType;

    public BankCardVM(BankCard bankCard) {
        this.bankType = bankCard.getBankType();
        this.cardType = bankCard.getCardType();
    }

    public BankCardVM(String bankType, String cardType) {
        this.bankType = bankType;
        this.cardType = cardType;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "BankCardVM{" +
                "bankType='" + bankType + '\'' +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
