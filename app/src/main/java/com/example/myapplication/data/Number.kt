package com.example.myapplication.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import javax.annotation.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("length", "luhn")
@Generated("jsonschema2pojo")
class Number {
    //    @JsonIgnore
    //    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @get:JsonProperty("length")
    @set:JsonProperty("length")
    @JsonProperty("length")
    var length: Int? = null

    @get:JsonProperty("luhn")
    @set:JsonProperty("luhn")
    @JsonProperty("luhn")
    var luhn: Boolean? = null

    //
    //    @JsonAnyGetter
    //    public Map<String, Object> getAdditionalProperties() {
    //        return this.additionalProperties;
    //    }
    //    @JsonAnySetter
    //    public void setAdditionalProperty(String name, Object value) {
    //        this.additionalProperties.put(name, value);
    //    }
    override fun toString(): String {
        return "NUMBER: length: $length, luhn: $luhn"
        //                ", additionalProperties=" + additionalProperties +;
    }
}