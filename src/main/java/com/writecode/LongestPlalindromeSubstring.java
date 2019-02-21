package com.writecode;


public class LongestPlalindromeSubstring {


    /**
     * 最长回文字串
     *1、abcbadddd
     *2、abccbaxxxxxx
     * */
    private static String longestPlalindromeSubstring(String s) throws Exception {
        if(s==null || "".equals(s)){
            throw new Exception("参数校验："+s+"字符串不能为空");
        }
        //记录的最大长度
        int max =0 ;
        //最大长度对应的左右index
        int left = 0,right=0;

        //1、最长回文子串是奇数
        for(int i=0;i<s.length();i++){
            int leftIndex =i-1;
            int rightIndex =i+1;
            while (leftIndex>=0&&rightIndex<s.length()){
                if (s.charAt(leftIndex)==s.charAt(rightIndex)){
                    if ((rightIndex-leftIndex+1)>max){
                        max=rightIndex-leftIndex+1;
                        left=leftIndex;
                        right=rightIndex;
                    }
                    leftIndex--;
                    rightIndex++;
                }else {
                    break;
                }
            }
        }

        //2、最长回文子串是偶数
        for(int i=0;i<s.length();i++){
            int leftIndex =i;
            int rightIndex =i+1;
            while (leftIndex>=0&&rightIndex<s.length()){
                if (s.charAt(leftIndex)==s.charAt(rightIndex)){
                    if ((rightIndex-leftIndex+1)>max){
                        max=rightIndex-leftIndex+1;
                        left=leftIndex;
                        right=rightIndex;
                    }
                    leftIndex--;
                    rightIndex++;
                }else {
                    break;
                }
            }
        }

        //不存在，返回#
        if (max==0){
            return "#";
        }
        return s.substring(left,right+1);
    }


    public static void main(String[] args) {
        try {
            System.out.println(longestPlalindromeSubstring("abcbaxymnkknm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
