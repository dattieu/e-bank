package com.dtu.banking.user.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class KeycloakAuthenticationResponse {
    private String accessToken;
    private String refreshToken;
    private Long refreshExpiresIn;
    private Long expiresIn;
    private String sessionState;
    private String scope;
    private String tokenType;
}
