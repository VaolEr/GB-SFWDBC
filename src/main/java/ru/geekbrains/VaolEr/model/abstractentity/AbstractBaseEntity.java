package ru.geekbrains.VaolEr.model.abstractentity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AbstractBaseEntity {
//Данный класс будет полезен в дальнейшем при работе с БД.
//Нужно будет добавить implements Persistable<Integer> и аннотации
    public Integer id;
}
