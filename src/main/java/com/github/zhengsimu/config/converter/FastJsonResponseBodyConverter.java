package com.github.zhengsimu.config.converter;

import com.alibaba.fastjson2.JSON;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 类名:com.github.zhengsimu.config.converter
 * 描述:
 *
 * @author: zhengsimu
 * @date: 2022年11月02日 时间:11:07
 * 修改说明:
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Type type;

    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    /**
     * 简要说明:转换方法
     *
     * @param
     * @return
     * @author: zhengsimu
     * 创建时间:2022/11/2 11:09
     */
    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource bufferedSource = Okio.buffer(value.source());
        String tempStr = bufferedSource.readUtf8();
        bufferedSource.close();
        return JSON.parseObject(tempStr, type);

    }
}
