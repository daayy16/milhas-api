package com.milhas.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

public record UserUpdateDTO(@NotBlank String name, @JsonFormat(pattern = "yyyy-MM-dd")
                            @NotBlank String dateOfBirth, @NotBlank String document, @NotBlank String phoneNumber,
                            String gender,
                            @NotBlank String city, @NotBlank String initials) {
}
