package com.github.zhengsimu;

import com.alibaba.fastjson2.annotation.JSONField;
import com.github.zhengsimu.signer.AwsAuthenticationCredentials;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class ShopTokenInfo  {

    @JSONField(serialize = false)
    private String sellerId;


    @JSONField(serialize = false)
    private List<String> site;

    @JSONField(serialize = false)
    private String accessToken;

    @JSONField(name = "grant_type")
    private String grantType;

    @JSONField(name = "refresh_token")
    private String refreshToken;

    @JSONField(name = "client_id")
    private String clientId;

    @JSONField(name = "client_secret")
    private String clientSecret;

    @JSONField(name = "scope")
    private Set<String> scopes;

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "redirect_uri")
    private String redirectUri;

    @JSONField(serialize = false)
    private AwsAuthenticationCredentials credentials;
}
