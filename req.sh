# get wsdl file
# curl http://localhost:8080/ws/countries.wsdl

# add new country
# curl --header "content-type: text/xml" -d @add_country_request.xml http://localhost:8080/ws


# get country by name
# curl --header "content-type: text/xml" -d @country_name_request.xml http://localhost:8080/ws


# get country by population
# curl --header "content-type: text/xml" -d @country_population_request.xml http://localhost:8080/ws


# get all countries
# curl --header "content-type: text/xml" -d @countries_request.xml http://localhost:8080/ws