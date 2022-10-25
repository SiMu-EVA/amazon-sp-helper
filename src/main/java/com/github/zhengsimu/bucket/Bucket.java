package com.github.zhengsimu.bucket;

import lombok.Data;

/**
 * 类名:com.github.zhengsimu.bucket
 * 描述:
 *
 * @author: zhengsimu
 * @date: 2022年10月25日 时间:11:29
 * 修改说明:
 */
@Data
public class Bucket {

    /**
     * maxPermits 最大存储令牌数
     */
    private Long maxPermits;

    /**
     * intervalTime 添加令牌时间间隔
     */
    private Long intervalTime;

    public Bucket(Long maxPermits, Long intervalTime) {
        this.maxPermits = maxPermits;
        this.intervalTime = intervalTime;
    }
}
