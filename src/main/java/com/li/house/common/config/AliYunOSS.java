package com.li.house.common.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AliYunOSS {

    //配置阿里云存储

    //阿里域名
    public static final String endpoint ="oss-cn-shenzhen.aliyuncs.com";
    //主要
    public static final String APPKEY = "LTAIRUs6ZGJ14F74";

    public static final String SECRET = "9MIADpDoli4iLcnMjPDmY9cqm6b2iU";
    //文件类型
    public static final   String file_filehost = "imges";
    //存储空间名称
    public static final String bucketname = "likuiting";

}
