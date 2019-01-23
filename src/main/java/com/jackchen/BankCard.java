package com.jackchen;

/**
 * Created by MinZeng
 * 时间：2018/9/17.
 */
public class BankCard {
    private Integer id;

    /**
     * 发卡行
     */
    private String bankType;

    /**
     * 卡名
     */
    private String cardName;

    /**
     * 主账号长度
     */
    private Integer mainCardLength;

    /**
     * 主账号
     */
    private String mainCardAccount;

    /**
     * 发卡行标示长度
     */
    private Integer bankMarkLength;

    /**
     * 发卡行标示
     */
    private Integer bankMark;

    /**
     * 卡片种类
     */
    private String cardType;

    public BankCard(Integer id, String bankType, String cardName, Integer mainCardLength
            , String mainCardAccount, Integer bankMarkLength, Integer bankMark, String cardType) {
        this.id = id;
        this.bankType = bankType;
        this.cardName = cardName;
        this.mainCardLength = mainCardLength;
        this.mainCardAccount = mainCardAccount;
        this.bankMarkLength = bankMarkLength;
        this.bankMark = bankMark;
        this.cardType = cardType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getMainCardLength() {
        return mainCardLength;
    }

    public void setMainCardLength(Integer mainCardLength) {
        this.mainCardLength = mainCardLength;
    }

    public String getMainCardAccount() {
        return mainCardAccount;
    }

    public void setMainCardAccount(String mainCardAccount) {
        this.mainCardAccount = mainCardAccount;
    }

    public Integer getBankMarkLength() {
        return bankMarkLength;
    }

    public void setBankMarkLength(Integer bankMarkLength) {
        this.bankMarkLength = bankMarkLength;
    }

    public Integer getBankMark() {
        return bankMark;
    }

    public void setBankMark(Integer bankMark) {
        this.bankMark = bankMark;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", bankType='" + bankType + '\'' +
                ", cardName='" + cardName + '\'' +
                ", mainCardLength=" + mainCardLength +
                ", mainCardAccount='" + mainCardAccount + '\'' +
                ", bankMarkLength=" + bankMarkLength +
                ", bankMark=" + bankMark +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
