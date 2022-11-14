package com.github.zhengsimu.signer;

import com.amazonaws.util.StringUtils;
import com.github.zhengsimu.Marketplace;
import com.github.zhengsimu.ShopTokenInfo;
import com.github.zhengsimu.ShopPool;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Locale;

/**
 * 类名:com.github.zhengsimu.signer
 * 描述:
 *
 * @author: zhengsimu
 * @date: 2022年10月25日 时间:11:51
 * 修改说明:
 */
public class SignerInterceptor implements Interceptor {

    private final ShopPool shopPool;

    public SignerInterceptor(ShopPool shopPool) {
        this.shopPool = shopPool;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String sellerId = request.header("sellerId");
        if (!StringUtils.isNullOrEmpty(sellerId)){
            String marketplaceId = request.header("marketplaceId");
            ShopTokenInfo shop  = this.shopPool.getShop(sellerId);
            Request.Builder builder = request.newBuilder().removeHeader("sellerId");
            assert marketplaceId != null;
            Marketplace marketplace = Marketplace.valueOf(marketplaceId.toUpperCase(Locale.ROOT));
            builder.url(request.url().newBuilder().host(marketplace.getEndpoint().getEndpoint()).build())
                    .addHeader("x-amz-access-token", shop.getAccessToken())
                    .addHeader("Content-Type", "application/json;charset=UTF-8");
            AWSSigV4Signer signer = new AWSSigV4Signer(AwsAuthenticationCredentials.builder()
                    .accessKeyId(shop.getCredentials().getAccessKeyId())
                    .secretKey(shop.getCredentials().getSecretKey())
                    .region(marketplace.getEndpoint().getRegion())
                    .roleArn(shop.getCredentials().getRoleArn())
                    .roleSessionName(shop.getCredentials().getRoleSessionName())
                    .build());
            request = signer.sign(builder.build());
        }
        return chain.proceed(request);
    }
}
