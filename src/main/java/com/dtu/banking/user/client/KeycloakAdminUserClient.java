package com.dtu.banking.user.client;

import com.dtu.banking.user.domain.KeycloakUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "keycloak-user", url = "${keycloak.url}", configuration = KeycloakAdminClientConfiguration.class)
public interface KeycloakAdminUserClient {

    @GetMapping(value = "/admin/realms/${keycloak.realm}/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<KeycloakUser> findUserByUsername(@RequestParam("username") String username);

    @GetMapping(value = "/admin/realms/${keycloak.realm}/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<KeycloakUser> findUserByEmail(@RequestParam("email") String email);

    @GetMapping(value = "/admin/realms/${keycloak.realm}/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    KeycloakUser findKeycloakUser(@PathVariable(value = "id") String id);

    @DeleteMapping(value = "/admin/realms/${keycloak.realm}/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteUser(@PathVariable(value = "id") String id);

    @GetMapping(value = "/admin/realms/${keycloak.realm}/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<KeycloakUser> findAllUsers();
}

