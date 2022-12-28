package com.example.myapplication.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import javax.annotation.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("name", "url", "phone", "city")
@Generated("jsonschema2pojo")
 class Bank {
    //    @JsonIgnore
    //    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    @JsonProperty("name")
    var name: String? = null

    @get:JsonProperty("url")
    @set:JsonProperty("url")
    @JsonProperty("url")
    var url: String? = null

    @get:JsonProperty("phone")
    @set:JsonProperty("phone")
    @JsonProperty("phone")
    var phone: String? = null

    @get:JsonProperty("city")
    @set:JsonProperty("city")
    @JsonProperty("city")
    var city: String? = null

    //    @JsonAnyGetter
    //    public Map<String, Object> getAdditionalProperties() {
    //        return this.additionalProperties;
    //    }
    //
    //    @JsonAnySetter
    //    public void setAdditionalProperty(String name, Object value) {
    //        this.additionalProperties.put(name, value);
    //    }
    override fun toString(): String {
        return """
            BANK: 
            name='$name
            city='$city
            """.trimIndent()
    }
}