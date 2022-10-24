package com.github.zhengsimu.signer;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class AwsAuthenticationCredentials {
    /**
     * AWS IAM User Access Key Id
     */
    @NonNull
    private String accessKeyId;

    /**
     * AWS IAM User Secret Key
     */
    @NonNull
    private String secretKey;

    /**
     * AWS Region
     */
    @NonNull
    private String region;
    /**
     * AWS IAM Role ARN
     */
    @NonNull
    private String roleArn;

    /**
     * AWS IAM Role Session Name
     */
    @NonNull
    private String roleSessionName;

}
