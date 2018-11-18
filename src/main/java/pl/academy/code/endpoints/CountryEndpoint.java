package pl.academy.code.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.academy.code.countries.Country;
import pl.academy.code.countries.GetCountryRequest;
import pl.academy.code.countries.GetCountryResponse;
import pl.academy.code.repository.CountryRepository;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://code.academy.pl/countries/";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryResponse(@RequestPayload GetCountryRequest getCountryRequest) {
        System.out.println("Serwis zawołany - przyszło: " + getCountryRequest.getName());
        GetCountryResponse response = new GetCountryResponse();
        Country countryToSend = this.countryRepository.findCountry(getCountryRequest.getName());
        response.setCountry(countryToSend);

        return response;
    }
}
