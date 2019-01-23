package com.writecode;

/**
 * Created by MinZeng
 * 时间：2018/9/22.
 */
public class ConvertWords {


    //i am    YOUR frIEND can     i  borroW thIs bOOk from    yoU
    private static String handleWords(String s){
        StringBuffer stringBuffer = new StringBuffer();
        s=s.trim();
        String [] words = s.split(" ");
        for (String word : words){
            String lowerCase = word.trim().toLowerCase();
            if (lowerCase.trim().length()==0){
                continue;
            }
            String first  = String.valueOf(lowerCase.charAt(0)).toUpperCase();
            lowerCase = first+lowerCase.substring(1);
            stringBuffer.append(lowerCase);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(handleWords("i am        YOUR frIEND can     i  borroW thIs bOOk from    yoU"));
    }

}
