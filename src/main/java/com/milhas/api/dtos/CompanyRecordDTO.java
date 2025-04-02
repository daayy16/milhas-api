package com.milhas.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record CompanyRecordDTO(@NotBlank String name) {
}
