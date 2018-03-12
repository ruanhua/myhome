package cn.com.ulic.op.domain;

/**
 * 账户
 * Created by zhangzhihao on 2017/12/22.
 */
public class Account {
    /**
     * 账户ID
     */
    private String accountID;
    /**
     * 账户秘钥
     */
    private String accountSecret;
    /**
     * 访问票证
     */
    private String accessToken;

    public Account(String accountID, String accessToken) {
        this.accountID = accountID;
        this.accessToken = accessToken;
    }

    public Account() {
        super();
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountSecret() {
        return accountSecret;
    }

    public void setAccountSecret(String accountSecret) {
        this.accountSecret = accountSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
