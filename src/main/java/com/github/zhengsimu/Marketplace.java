package com.github.zhengsimu;


/**
 * 销售伙伴 API 端点
 *
 * @author zhengsimu
 */
public enum Marketplace {
    /**
     * marketplaceId 标识了请求的商城。
     */
    /**
     * North America 北美
     */
    CA("A2EUQ1WTGCTBG2", "Canada", "USD", Endpoints.NA),
    US("ATVPDKIKX0DER", "United States of America", "USD", Endpoints.NA),
    MX("A1AM78C64UM0Y8", "Mexico", "USD", Endpoints.NA),
    BR("A2Q3Y263D00KWC", "Brazil", "USD", Endpoints.NA),
    /**
     * Europe  欧洲
     */
    ES("A1RKKUPIHCS9HS", "Spain", "EUR", Endpoints.EU),
    GB("A1F83G8C2ARO7P", "United Kingdom", "EUR", Endpoints.EU),
    UK("A1F83G8C2ARO7P", "United Kingdom", "EUR", Endpoints.EU),
    FR("A13V1IB3VIYZZH", "France", "EUR", Endpoints.EU),
    NL("A1805IZSGTT6HS", "Netherlands", "EUR", Endpoints.EU),
    DE("A1PA6795UKMFR9", "Germany", "EUR", Endpoints.EU),
    IT("APJ6JRA9NG5V4", "Italy", "EUR", Endpoints.EU),
    SE("A2NODRKZP88ZB9", "Sweden", "EUR", Endpoints.EU),
    PL("A1C3SOZRARQ6R3", "Poland", "EUR", Endpoints.EU),
    EG("ARBP9OOSHTCHU", "Egypt", "EUR", Endpoints.EU),
    TR("A33AVAJ2PDY3EV", "Turkey", "EUR", Endpoints.EU),
    SA("A17E79C6D8DWNP", "Saudi Arabia", "EUR", Endpoints.EU),
    AE("A2VIGQ35RCS4UG", "United Arab Emirates", "EUR", Endpoints.EU),
    IN("A21TJRUUN4KGV", "India", "EUR", Endpoints.EU),
    /**
     * Far East 远东
     */
    SG("A19VAU5U5O7RUS", "Singapore", "USD", Endpoints.FE),
    AU("A39IBJ37TRP1C6", "Australia", "USD", Endpoints.FE),
    JP("A1VC38T7YXB528", "Japan", "JPY", Endpoints.FE);
    private final String id;
    private final String county;

    private final String currencyCode;
    private final Endpoints endpoint;

    Marketplace(String id, String county, String currencyCode, Endpoints endpoint) {
        this.id = id;
        this.county = county;
        this.currencyCode = currencyCode;
        this.endpoint = endpoint;
    }

    public String getId() {
        return id;
    }

    public String getCounty() {
        return county;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public Endpoints getEndpoint() {
        return endpoint;
    }

    public enum Endpoints {
        /**
         * 北美（加拿大、美国、墨西哥和巴西商城）
         */
        NA("sellingpartnerapi-na.amazon.com", "us-east-1"),
        /**
         * 欧洲（西班牙、英国、法国、荷兰、德国、意大利、土耳其、阿联酋和印度商城）
         */
        EU("sellingpartnerapi-eu.amazon.com", "eu-west-1"),
        /**
         * 远东（新加坡、澳大利亚和日本商城）
         */
        FE("sellingpartnerapi-fe.amazon.com", "us-west-2");

        private final String endpoint;
        private final String region;

        Endpoints(String endpoint, String region) {
            this.endpoint = endpoint;
            this.region = region;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public String getRegion() {
            return region;
        }
    }
}