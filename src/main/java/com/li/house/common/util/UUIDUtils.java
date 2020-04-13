package com.li.house.common.util;

import java.util.UUID;

/**
 * uuid 生成器
 */
public class UUIDUtils {

    /**
     * uuid 生成去除“-”
     * @return
     */
        public static String UUIDGenerate(){
            //定义uuid
            String uuid = UUID.randomUUID().toString();
            //将 '-' 去掉
            uuid = uuid.replaceAll("-", "");
            return uuid;
        }

    public static void main(String[] args) {
        System.out.println(UUIDGenerate());
    }
}
