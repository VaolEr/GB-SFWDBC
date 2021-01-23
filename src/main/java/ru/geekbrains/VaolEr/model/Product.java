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
public class Product extends AbstractNamedEntity implements Comparable<Product> {

    @NotNull
    public Double cost;

    @Override
    public int compareTo(Product o) {
        int result = this.name.compareTo(o.name);
        if(result == 0){
            result = this.cost.compareTo(o.cost);
        }
        return result;
    }
}
