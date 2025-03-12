package com.milhas.api.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.milhas.api.models.StateModel;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UserRecordDTO(@NotBlank String name, @JsonFormat(pattern = "yyyy-MM-dd")
@NotBlank String dateOfBirth, @NotBlank String document, @NotBlank String email, @NotBlank String phoneNumber, @NotBlank String password, String gender, @NotBlank String city, @NotBlank String initials) {
}
