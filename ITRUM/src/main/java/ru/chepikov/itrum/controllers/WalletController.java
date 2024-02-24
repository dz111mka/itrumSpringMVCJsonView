package ru.chepikov.itrum.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import ru.chepikov.itrum.model.WalletRequest;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/wallet")
    public ResponseEntity<?> updateWallet(@RequestBody WalletRequest request) {
        int update;
        try {
            switch (request.getOperationType()) {
                case DEPOSIT ->
                        update = jdbcTemplate.update("UPDATE wallets SET balance = balance + ?, version = version + 1 WHERE id = ? AND version = ?", request.getAmount(), request.getWalletId(), request.getVersion());
                case WITHDRAW ->
                        update = jdbcTemplate.update("UPDATE wallets SET balance = balance - ?, version = version + 1 WHERE id = ? AND version = ?", request.getAmount(), request.getWalletId(), request.getVersion());
                default -> {
                    return ResponseEntity.badRequest().body("Invalid operation type");
                }
            }
            if (update == 0) {
                throw new OptimisticLockingFailureException("Entity has been updated by another transaction");
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update wallet");
        }
    }


    @GetMapping("/wallets/{walletId}")
    public ResponseEntity<?> getWalletBalance(@PathVariable UUID walletId) {
        try {
            Double balance = jdbcTemplate.queryForObject("SELECT balance FROM wallets WHERE id = ?", Double.class, walletId);
            if (balance == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(balance);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch wallet balance");
        }
    }
}
