package pl.academy.code.repository;

import org.springframework.stereotype.Component;
import pl.academy.code.countries.Country;
import pl.academy.code.countries.Currency;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country france = new Country();
        france.setName("France");
        france.setCapital("Paris");
        france.setPopulation(66900000);
        france.setCurrency(Currency.EUR);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setPopulation(37950000);
        poland.setCurrency(Currency.PLN);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setPopulation(65640000);
        uk.setCurrency(Currency.GBP);

        countries.put(france.getName(), france);
        countries.put(poland.getName(), poland);
        countries.put(uk.getName(), uk);
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
