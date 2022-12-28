package com.example.myapplication.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonProperty
import javax.annotation.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("number", "scheme", "type", "brand", "prepaid", "country", "bank")
@Generated("jsonschema2pojo")
class Entity {



    //    @JsonIgnore
    //    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @get:JsonProperty("number")
    @set:JsonProperty("number")
    @JsonProperty("number")
    var number: Number? = null

    @get:JsonProperty("scheme")
    @set:JsonProperty("scheme")
    @JsonProperty("scheme")
    var scheme: String? = null

    @get:JsonProperty("type")
    @set:JsonProperty("type")
    @JsonProperty("type")
    var type: String? = null

    @get:JsonProperty("brand")
    @set:JsonProperty("brand")
    @JsonProperty("brand")
    var brand: String? = null

    @get:JsonProperty("prepaid")
    @set:JsonProperty("prepaid")
    @JsonProperty("prepaid")
    var prepaid: Boolean? = null

    @get:JsonProperty("country")
    @set:JsonProperty("country")
    @JsonProperty("country")
    var country: Country? = null

    @get:JsonProperty("bank")
    @set:JsonProperty("bank")
    @JsonProperty("bank")
    var bank: Bank? = null

    constructor()

    override fun toString(): String {
        return "Entity{" +
                "number=" + number +
                ", scheme='" + scheme + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", prepaid=" + prepaid +
                ", country=" + country +
                ", bank=" + bank +
                '}'
    }
}