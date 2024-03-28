package org.example.restfullsimplejpa.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
        @NotNull
        @NotEmpty
        String title,
        String description,

        String imageUrl,
        @Positive
        float price) {
}
