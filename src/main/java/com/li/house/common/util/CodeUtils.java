package com.li.house.common.util;

/**
 * @author Mr.Li
 */

public class CodeUtils {

    public static void main(String[] args) {
        String b = "700";
        String b1 = b.substring(0, b.indexOf("-"));
        String b2 = b.substring(b.indexOf("-")+1);
        System.out.println(b1);//8618523825157
        System.out.println(b2);//10655599

    }
    /**
     * 随机验证码生成
     * @return
     */
    public static String createCode() {
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += (int) (Math.random() * 10);
        }
        return code;
    }

}
