package com.github.zhengsimu;

import com.github.zhengsimu.ShopTokenInfo;

/**
 * @author zhengsimu
 */
public interface ShopPool {

    /**
     * 简要说明:
     * 通过卖家ID获得店铺令牌信息
     * Get the store token information through the seller ID
     *
     * @param sellerId 卖家ID
     * @return 店铺令牌信息
     * @author: zhengsimu
     * 创建时间:2022/10/25 16:52
     */
    ShopTokenInfo getShop(String sellerId);
}
