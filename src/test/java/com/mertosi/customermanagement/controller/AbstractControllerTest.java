package com.mertosi.customermanagement.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@Import(WebFluxSecurityConfig.class)
public abstract class AbstractControllerTest {

    @Autowired
    protected WebTestClient client;
}
