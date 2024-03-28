package org.example.restfullsimplejpa.dto;

public record ProductResponse(Long id, String title, String description, String imageUrl, float price) {
}
