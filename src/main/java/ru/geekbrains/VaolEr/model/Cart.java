package ru.geekbrains.VaolEr.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.VaolEr.model.abstractentity.AbstractBaseEntity;

import javax.persistence.*;

@Entity(name = "Cart")
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
public class Cart extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("carts")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "buyer_id")
    @JsonIgnoreProperties("carts")
    private Buyer buyer;

    @Override
    public String toString() {
        return "Cart{" +
                "product=" + product +
                ", buyer=" + buyer +
                ", id=" + id +
                '}';
    }
}
