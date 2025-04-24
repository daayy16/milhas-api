package com.milhas.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PromotionRecordDTO(@NotBlank String destination, String image, @NotNull float price) {
}
