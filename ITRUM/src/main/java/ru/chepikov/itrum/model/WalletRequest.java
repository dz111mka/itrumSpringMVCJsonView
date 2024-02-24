package ru.chepikov.itrum.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class WalletRequest {
    private UUID walletId;
    private OperationType operationType;
    private double amount;
    private int version;
}
