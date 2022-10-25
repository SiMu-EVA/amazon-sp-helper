package com.github.zhengsimu.config;

import com.amazonaws.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类名:com.github.zhengsimu.config
 * 描述:
 *
 * @author: zhengsimu
 * @date: 2022年10月25日 时间:10:14
 * 修改说明:
 */
public class AmazonSpApiProperties {

    /**
     * AMAZON_SP_API 配置 文件
     */
    private static String AMAZON_SP_API_PROPERTIES = "AmazonSpApi.properties";


    public static Properties initProperties(){
        InputStream inputStream = AmazonSpApiProperties.class.getClassLoader().getResourceAsStream(AMAZON_SP_API_PROPERTIES);
        Properties p = new Properties();
        try {
            p.load(inputStream);
            return p;
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }
    }


    /**
     * 根据属性文件Key获取value
     * @param propKey
     * @return
     * 2015年4月7日
     * @author chenyfing
     * String
     */
    public static String getPropValue(String propKey){
        Properties prop = initProperties();
        String result = "";
        try {
            if(!StringUtils.isNullOrEmpty(propKey)){
                assert prop != null;
                result = prop.getProperty(propKey);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
