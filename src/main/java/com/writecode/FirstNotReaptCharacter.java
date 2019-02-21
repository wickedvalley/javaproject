package com.writecode;

public class FirstNotReaptCharacter {

    /**
     * 找寻第一个不重复字符
     * google
     */
    private static char findFirstNotReaptCharacter(String originChar){
        char result = '#';

        for (int i=0;i<originChar.length();i++){
            char temp = originChar.charAt(i);
            boolean preExist = false;
            boolean afterExist = false;

            //前方查找
            for (int j=i+1;j<originChar.length();j++){
                if (originChar.charAt(j)==temp){
                    preExist = true;
                    break;
                }
            }

            //后方查找
            for (int k=i-1;k>=0;k--){
                if (originChar.charAt(k)==temp){
                    afterExist = true;
                    break;
                }
            }

            if (!preExist && !afterExist){
                return temp;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(findFirstNotReaptCharacter("google"));
    }
}
