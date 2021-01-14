package ru.geekbrains.VaolEr.model.abstractentity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AbstractNamedEntity extends AbstractBaseEntity{

    @NotNull
    @NotBlank
    public String name;

}
