package com.kirillkotov.soapspringbootlect.endpoint;

import com.kirillkotov.soapspringbootlect.dto.*;
import com.kirillkotov.soapspringbootlect.model.Country;
import com.kirillkotov.soapspringbootlect.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://kirillkotov.com/soapspringbootlect/dto";

	private CountryService countryService;

	@Autowired
	public CountryEndpoint(CountryService countryService) {
		this.countryService = countryService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "postCountryRequest")
	@ResponsePayload
	public GetCountryResponse post(@RequestPayload PostCountryRequest request) {
		Country country = request.getCountry();
		this.countryService.add(country);
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(country);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryNameRequest")
	@ResponsePayload
	public GetCountryResponse get(@RequestPayload GetCountryNameRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryService.getByName(request.getName()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryPopulationRequest")
	@ResponsePayload
	public GetCountriesResponse get(@RequestPayload GetCountryPopulationRequest request) {
		GetCountriesResponse response = new GetCountriesResponse();
		response.setCountries(countryService.getByPopulation(request.getPopulation()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountriesRequest")
	@ResponsePayload
	public GetCountriesResponse get() {
		GetCountriesResponse response = new GetCountriesResponse();
		response.setCountries(countryService.getAll());
		return response;
	}
}
