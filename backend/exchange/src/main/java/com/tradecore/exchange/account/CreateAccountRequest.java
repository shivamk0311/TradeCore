package com.tradecore.exchange.account;

import jakarta.validation.constraints.*;

public record CreateAccountRequest(

    @Email(message = "Invalid email format.")
    @NotBlank(message = "Email cannot be blank.")
    String email, 

    @Size(min = 3, max = 100, message = "Display name must be between 3 and 100 characters.")
    @NotBlank(message = "Display name can't be blank.")
    String displayName
) {}
