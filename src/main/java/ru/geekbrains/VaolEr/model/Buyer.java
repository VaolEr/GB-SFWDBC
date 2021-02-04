package ru.geekbrains.VaolEr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.VaolEr.model.abstractentity.AbstractNamedEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Buyer")
@Table(name = "buyers")
@Getter
@Setter
@NoArgsConstructor
public class Buyer extends AbstractNamedEntity {

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("buyer")
    private Set<Cart> carts = new HashSet<>();

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
