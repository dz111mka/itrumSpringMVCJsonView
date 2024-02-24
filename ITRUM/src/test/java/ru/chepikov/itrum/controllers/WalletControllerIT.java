package ru.chepikov.itrum.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class WalletControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testTest() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("http://localhost:8080/api/v1/wallet");

        this.mockMvc.perform(requestBuilder).andExpectAll(
                status().is4xxClientError(),
                content().contentType(MediaType.APPLICATION_JSON),
                content().json("""
                        [{
                             "walletId" : "1c14e6e5-2853-4a5a-a973-005c25943898",
                             "operationType" : "DEPOSIT",
                             "amount" : 1000.0,
                             "version" : 5
                         }]
                        """)
        );

    }

}