package ru.geekbrains.VaolEr.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.geekbrains.VaolEr.model.abstractentity.AbstractNamedEntity;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Product")
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractNamedEntity implements Comparable<Product> {

    @NotNull
    @Column(name = "price")
    public Double cost;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("product")
    private Set<Cart> carts = new HashSet<>();

    @Override
    public int compareTo(Product o) {
        int result = this.name.compareTo(o.name);
        if(result == 0){
            result = this.cost.compareTo(o.cost);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "cost=" + cost +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
