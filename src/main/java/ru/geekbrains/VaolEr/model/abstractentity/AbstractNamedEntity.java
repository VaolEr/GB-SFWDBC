package ru.geekbrains.VaolEr.model.abstractentity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class AbstractNamedEntity extends AbstractBaseEntity{

    @NotNull
    @NotBlank
    @Column(name = "name", nullable = false, length = 128) //для наглядности
    public String name;

}
