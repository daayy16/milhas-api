package com.milhas.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record StateRecordDTO(@NotBlank String name, @NotBlank String initials) {
}
