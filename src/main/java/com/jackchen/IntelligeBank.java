package com.jackchen;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jackchen.ErrorCode.CARD_FOMATE_ERROR;
import static com.jackchen.ErrorCode.CARD_INFO_NOT_EXIST;
import static com.jackchen.ErrorCode.CARD_LENGTH_ERROR;

/**
 * Created by MinZeng
 * 时间：2018/9/17.
 */
public class IntelligeBank {

    //业务介绍
    //发卡行，卡名，主账号长度，主账号，发卡行标示长度，发卡行标示，卡片种类

    //工商银行，牡丹运通卡金卡，15，370246xxxxxxxxx，6 ,370246，贷记卡
    //工商银行，牡丹灵通卡，18，624000xxxxxxxxxxxx，6 ,624000，借记卡

    //输入：370246xxxxxxxxx
    //输出：工商银行  贷记卡

    //模拟的数据
    private Map<Integer, BankCard> dataMap = new HashMap<Integer, BankCard>();

    /**
     * 初始化数据
     */
    private void initData() {
        dataMap.put(370246, new BankCard(1001, "工商银行", "牡丹运通卡金卡", 15, "370246xxxxxxxxx", 6, 370246, "贷记卡"));
        dataMap.put(624000, new BankCard(1002, "工商银行", "牡丹灵通卡", 18, "624000xxxxxxxxxxxx", 6, 624000, "借记卡"));
    }

    /**
     * 数据校验
     */
    private void validate(String mainCardAccount) {
        if (mainCardAccount == null || mainCardAccount.trim().length() == 0) {
            throw new ApiException(CARD_LENGTH_ERROR);
        }
        if (!mainCardAccount.contains("x")) {
            throw new ApiException(CARD_FOMATE_ERROR);
        }
        String[] cardArray = mainCardAccount.split("x");
        if (cardArray.length != 1) {
            throw new ApiException(CARD_FOMATE_ERROR);
        }
        boolean isNumeric = isNumeric(cardArray[0]);
        if (!isNumeric) {
            throw new ApiException(CARD_FOMATE_ERROR);
        }
        int xLength = mainCardAccount.substring(cardArray[0].length()).length();
        int mainCardAccountLen = cardArray[0].length();
        if ((xLength + mainCardAccountLen) != mainCardAccount.trim().length()) {
            throw new ApiException(CARD_FOMATE_ERROR);
        }
    }

    /**
     * 根据主账号获取银行卡信息
     */
    public BankCardVM getBankInfoByMainCardAccount(String mainCardAccount) {
        //1.数据校验
        validate(mainCardAccount);

        //2.获取数据并返回
        String[] cardArray = mainCardAccount.split("x");
        Integer bankMark;
        try {
            bankMark = Integer.parseInt(cardArray[0]);
        } catch (NumberFormatException e) {
            throw new ApiException(CARD_FOMATE_ERROR);
        }

        if (!dataMap.containsKey(bankMark)) {
            throw new ApiException(CARD_INFO_NOT_EXIST);
        }
        BankCard bankCard = dataMap.get(bankMark);
        if (!mainCardAccount.equals(bankCard.getMainCardAccount())) {
            throw new ApiException(CARD_INFO_NOT_EXIST);
        }
        return new BankCardVM(bankCard);
    }


    /**
     * 利用正则表达式判断字符串是否是数字
     */
    private boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IntelligeBank obj = new IntelligeBank();

        //1.初始化数据
        obj.initData();

        //2.获取银行卡信息
        try {
            BankCardVM bankCardVM = obj.getBankInfoByMainCardAccount("370246xxxxxxxxx");
            System.out.println(bankCardVM);
        } catch (ApiException e) {
            System.out.print("异常码：" + e.getCode() + ",异常信息：" + e.getMessage());
        } catch (Exception e) {
            System.out.println("服务不可用");
        }
    }
}
