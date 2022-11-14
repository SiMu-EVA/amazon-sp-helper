package com.github.zhengsimu.config.converter;

import com.alibaba.fastjson2.JSON;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;


/**
 * 类名:com.github.zhengsimu.config.converter
 * 描述:
 *
 * @author: zhengsimu
 * @date: 2022年11月02日 时间:11:08
 * 修改说明:
 */
public class FastJsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    @Override
    public RequestBody convert(T value) {
        return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value));
    }
}

