package com.example.myapplication.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import javax.annotation.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("numeric", "alpha2", "name", "emoji", "currency", "latitude", "longitude")
@Generated("jsonschema2pojo")
class Country {
    //    @JsonIgnore
    //    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @get:JsonProperty("numeric")
    @set:JsonProperty("numeric")
    @JsonProperty("numeric")
    var numeric: String? = null

    @get:JsonProperty("alpha2")
    @set:JsonProperty("alpha2")
    @JsonProperty("alpha2")
    var alpha2: String? = null

    @get:JsonProperty("name")
    @set:JsonProperty("name")
    @JsonProperty("name")
    var name: String? = null

    @get:JsonProperty("emoji")
    @set:JsonProperty("emoji")
    @JsonProperty("emoji")
    var emoji: String? = null

    @get:JsonProperty("currency")
    @set:JsonProperty("currency")
    @JsonProperty("currency")
    var currency: String? = null

    @get:JsonProperty("latitude")
    @set:JsonProperty("latitude")
    @JsonProperty("latitude")
    var latitude: String? = null

    @get:JsonProperty("longitude")
    @set:JsonProperty("longitude")
    @JsonProperty("longitude")
    var longitude: String? = null

    override fun toString(): String {
        return """
            COUNTRY: 
            numeric: $numeric, alpha2: $alpha2
            name: $name, emoji='$emoji', currency=$currency
            latitude: $latitude, longitude: $longitude
            """.trimIndent()
    }
}