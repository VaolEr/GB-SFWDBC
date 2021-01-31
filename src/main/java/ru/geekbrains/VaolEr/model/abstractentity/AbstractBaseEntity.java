package ru.geekbrains.VaolEr.model.abstractentity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@Access(AccessType.FIELD)
@MappedSuperclass
public class AbstractBaseEntity implements Persistable<Long> {
//Данный класс будет полезен в дальнейшем при работе с БД.
//Нужно будет добавить implements Persistable<Integer> и аннотации
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @Override
    public boolean isNew() {
        return false;
    }
}
