package ru.geekbrains.VaolEr.model;

import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.VaolEr.model.abstractentity.AbstractNamedEntity;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractNamedEntity {

    @NotNull
    public Double cost;

}
