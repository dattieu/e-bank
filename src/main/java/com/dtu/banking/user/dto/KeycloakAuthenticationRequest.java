package com.dtu.banking.user.dto;

import feign.form.FormProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.LinkedMultiValueMap;

@Data
@Accessors(chain = true)
public class KeycloakAuthenticationRequest {

    @FormProperty("grant_type")
    private String grantType = "client_credentials";
    private String username;
    private String password;

    @FormProperty("client_id")
    private String clientId;

    @FormProperty("client_secret")
    private String clientSecret;

    @FormProperty("refresh_token")
    private String refreshToken;

    @FormProperty("scope")
    private String scope;

    public LinkedMultiValueMap<String, String> toMap() {
        LinkedMultiValueMap<String, String> res = new LinkedMultiValueMap<>();
        res.add("grant_type", grantType);
        res.add("username", username);
        res.add("password", password);
        res.add("client_id", clientId);
        res.add("client_secret", clientSecret);
        res.add("refresh_token", refreshToken);
        if (StringUtils.isNotBlank(scope))
            res.add("scope", scope);
        return res;
    }
}
