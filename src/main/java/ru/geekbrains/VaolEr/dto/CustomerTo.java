package ru.geekbrains.VaolEr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.VaolEr.web.validation.ValidationGroups;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity: Customer")
public class CustomerTo {

    //This class created for transfer model to JSON

    @Null(
            groups = ValidationGroups.Create.class
    )
    @NotNull(
            groups = { ValidationGroups.Update.class, ValidationGroups.Delete.class}
    )
    @Schema(description = "UUID", example = "1")
    String id;

    @NotNull
    @NotBlank
    @Schema(description = "Customer first name", example = "Jhon")
    String firstName;

    @NotNull
    @NotBlank
    @Schema(description = "Customer last name", example = "Doe")
    String lastName;

    @NotNull
    @Schema(description = "Customer's city", example = "City")
    String city;
}
