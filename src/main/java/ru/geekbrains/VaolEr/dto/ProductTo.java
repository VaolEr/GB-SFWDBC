package ru.geekbrains.VaolEr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity: Product")
public class ProductTo {

    //This class created for transfer model to JSON

    @Schema(description = "Identifier", example = "1")
    Long id;

    @NotNull
    @NotBlank
    @Schema(description = "Product name", example = "Prod1")
    String name;

    @NotNull
    @Schema(description = "Product cost", example = "100")
    Double cost;

}
