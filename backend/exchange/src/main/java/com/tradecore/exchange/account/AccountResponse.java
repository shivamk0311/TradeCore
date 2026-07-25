package com.tradecore.exchange.account;

import java.time.Instant;
import java.util.UUID;

public record AccountResponse(
    UUID id,
    String email,
    String displayName,
    AccountStatus status,
    Instant createdAt,
    Instant updatedAt
) {}
