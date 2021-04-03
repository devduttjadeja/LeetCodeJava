import lombok.Value;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldProductsAggregator {

    private final EURExchangeService exchangeService;

    SoldProductsAggregator(EURExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    Map<String, BigDecimal> map = new HashMap<>();
    BigDecimal totalPrice = new BigDecimal(0);

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
        products.filter(Objects::nonNull).forEach(soldProduct -> {
            String name = soldProduct.getName();
            map.put(name, map.getOrDefault(name, new BigDecimal(0)).add(soldProduct.getPrice()));
            totalPrice = totalPrice.add(soldProduct.getPrice());
        });

        List<SimpleSoldProduct> ans = map.entrySet().stream().map(entry -> new SimpleSoldProduct(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        return new SoldProductsAggregate(ans, totalPrice);
    }

}

@Value
class SoldProduct {
    String name;
    BigDecimal price;
    String currency;
}

@Value
class SimpleSoldProduct {
    String name;
    BigDecimal price;
}

@Value
class SoldProductsAggregate {
    List<SimpleSoldProduct> products;
    BigDecimal total;
}


class EURExchangeService implements ExchangeService {
    @Override
    public Optional<BigDecimal> rate(String currency) {
        return Optional.empty();
    }
}

interface ExchangeService {
    Optional<BigDecimal> rate(String currency);
}