package ru.geekbrains.VaolEr.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entity: Cart")
public class CartTo {

    //This class created for transfer model to JSON

    @Schema(description = "Cart id", example = "1")
    Long id;

    @NotNull
    BuyerTo buyerTo;

    @NotNull
    ProductTo productTo;

}
