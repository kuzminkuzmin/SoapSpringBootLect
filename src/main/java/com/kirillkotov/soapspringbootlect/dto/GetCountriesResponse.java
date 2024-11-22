//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.09.08 at 05:08:21 PM MSK 
//


package com.kirillkotov.soapspringbootlect.dto;

import com.kirillkotov.soapspringbootlect.model.Country;
import jakarta.xml.bind.annotation.*;

import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="country" type="{http://kirillkotov.com/soapspringbootlect/model}country"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "countries"
})
@XmlRootElement(name = "getCountryResponse")
public class GetCountriesResponse {

    @XmlElementWrapper(name = "countries")
    @XmlElement(name = "country")
    protected List<Country> countries;

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public List<Country> getCountry() {
        return this.countries;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setCountries(List<Country> value) {
        this.countries = value;
    }

}