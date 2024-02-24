package ru.chepikov.itrum.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.UUID;

class WalletControllerTest {

    static DriverManagerDataSource dataSource = new DriverManagerDataSource();

    @BeforeAll
    public static void dataSource() {
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/itrum");
        dataSource.setUsername("postgres");
        dataSource.setPassword("321678");
    }

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


    @Test
    void getBalanceOfWalletByIdTest() {
        UUID id = UUID.randomUUID();
        jdbcTemplate.update("INSERT INTO wallets(id, balance) values (?, 1000.0)", id);

        Double balance = jdbcTemplate.queryForObject("SELECT balance FROM wallets WHERE id = ?", Double.class, id);
        Assertions.assertEquals(1000.0, balance);
        jdbcTemplate.update("DELETE FROM wallets WHERE id = ?", id);
    }

}