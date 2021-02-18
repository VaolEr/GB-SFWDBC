package ru.geekbrains.VaolEr.util;

import ru.geekbrains.VaolEr.dto.BuyerTo;
import ru.geekbrains.VaolEr.model.Buyer;

import java.util.List;
import java.util.stream.Collectors;

public class BuyersUtil {

    public static BuyerTo toBuyerTo(Buyer buyer) {
        return BuyerTo
                .builder()
                .id(buyer.getId())
                .name(buyer.getName())
                .build();
    }

    public static List<BuyerTo> toBuyerTos(List<Buyer> buyers) {
        return buyers.stream().map(BuyersUtil::toBuyerTo).collect(Collectors.toList());
    }

    public static Buyer fromBuyerTo(BuyerTo buyerTo) {
        Buyer newBuyer = new Buyer();
        newBuyer.setId(buyerTo.getId());
        newBuyer.setName(buyerTo.getName());
        return newBuyer;
    }

}
