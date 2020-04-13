package com.li.house.common.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AliPayConfig {

        // 商户appid
        public static String APPID ="2016092500596798";

        public static String RSA_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCK25cNozaF5QzZkbT9xB9pHWRYnd7C9QH9oCNfoD/qo1wL5NHmbmxibZXW5GWC0w5Fm04IOHQQX5vx3z83YAHYQERCPnBDDzUyMB4W2LVvN5h3ugPf75MTe5SqM84/dKx3duHHG1QiMiJoOnbJzSTUUuy3sJLzxk1GJd2nDnDQZ07JC/wQuM99IlNWOXYEHpxVB9rvwwP+Ki1qBeeORULsA1Bl523j7sB9LMwmaZ28JVLjAAhB8QGmLYpHlbhoTiN+gClwNvbva4AgVp612ni23kdK6NthJ3WI6c44HYIH4gZqjz3b2vB4kT0Z82YyrrvzkaJ/RIKCXO+pMDteNrH9AgMBAAECggEAXfAQUHmJ+SrrdoTMHKEBXuszZ3/lo558qkgbpiWTF/lL3AAAwBMT38KjC62XvtlpXk2ijI0kd682oHqXGa8pkFJp2ybCa5tuMXW75VjV5VeHHfgJhwVcSmHgQQSrEuKrimYyd7BVSo0AGeLzWbIeqEUxP1OFFsWgoUQcn1d1moZItI16ZmU64leU79AthOY0aWRho4mqYaR+HKt4AfYs0jTSCh+ZAWvfcRvbAKFqeRDAHD92lt4KOKnfQIxAlhgKBUBmsDIL+RuzRZdXIJSMaNB3us7RueA+WUU+PaYthCL+DnF/CU5h1n2N77Ams2jwNIFXelXgql3+3lZtTRVcAQKBgQDQaJCQgMvw3iv4v+8i0VN5M3AroTe13TDl27RoNnlTi4ijzTj9h+HSq0I/aLi7d50Kq8OWsClzIGEhRXgqLejRmJf3/iWCDqjWWmvH3qN8DoLxDzOdjhJmEvPypGdBFj3wPdA/Y+/b0xnaMsXXdl1xOicOsh/cluJDjEUMJOmszQKBgQCqkSIukMJFxZCwF+CmxySa3XQlJRcYqiwvb8adebZqkhSn+7WI1fiZZarrLd4Wrp5PKXkf3TtPMy6pni4tq/rkKOssRL+3s1rXxgp0OD6Udk1Khw6Bfisvdq3A9AteWvUYkYqInVlquK+fnb4alioZf2Or8Ft2J7jjAtXeXccZ8QKBgQDNvYyJuzyaCxqptQElBDU9v3QK/lr7JOOy55RQFQbtXSCFZIHQeCaNTRhXdNB58XmNIUgzKLGiv+JjcCtSqIPg9p1/6tuoa0RuaFFivP3z6HeH9pPkBG9RaYB+l6J/dK+szbkZ+1S9VMd+ywTY0jcpIlmQfnRJ1oKEYKOBe6dcOQKBgC8ZbpfvL0Y2/PIzVbyYBxqghj7vlAYij5r1waGgh2e8OOn+Dq3fcAtj0KOqgcY/p8VyTVkoLQV8u6jo3hWMhPZV+kK6JTqj0zT8Iczf7x/t3v/ydWX6ohA0NFywxybh9QY4wklhMdzPbOellmYfCzcJP0uuToM9Csfc85O4z47xAoGBAKLF6UUyYzxPm4bBArPOsR771AnlHI5B8EV78FxvvqXLvW74hzhPBCkkJvzDZKdmwhUvyDeki0angntlGrWBO6IiJ/iS1GOvgFoPb0FtNWbPEwDgn2i0JHp3SdDr8+UsW1xl+OjwybVdwRXK2RaCn9Y3LL0p3s08yIjVaebBoWkq";
        // 私钥 pkcs8格式的
        // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
        public static String notify_url = "http://localhost:8080/pay/error";
        // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
        public static String return_url = "http://localhost:8081/#/Appointment";
        // 请求网关地址
        public static String URL = "https://openapi.alipaydev.com/gateway.do";
        // 编码
        public static String CHARSET = "utf-8";
        // 返回格式
        public static String FORMAT = "json";
        // 支付宝公钥
        public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApPTbK2y36mS1PdnteU87HOGGxpLBGUoiSXyZLD5O37MntT008eZgm7JaFhtwVJRbBs1AzVvuKbUUVpNSqmmFTHOlVlR+wU9sVah38YFwgEKeRuvydW+lrUKekAzQ99nJD4q6ItaqkwudN/zQhweOoiRbkXq7QW51I0R9/cIc+628KcID7apiH3VVlszqYcDqTSx1JuGyWfbg4wCwfNj5jxlc8lJtUyqzRWhFFkgvqiwIMhikh0CNQDa9e8LaH9W5F5Lykt7jvqk9yF0B2iKY3SBIlwT0zrMdpUFHr9fRpV40RC4Yf9VoWwnqVkLbtTmnfm1AdH6bMiW9yKwn2/KG+QIDAQAB";
        // 日志记录目录
        public static String log_path = "/log";
        // RSA2
        public static String SIGNTYPE = "RSA2";

}
