package com.lknmproduction.spring_cms_yalynky.domain.utils

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

class NewUser : Serializable {

    @JsonProperty("email")
    var email: String? = null

    @JsonProperty("name")
    var name: String? = null

    @JsonProperty("password")
    var password: String? = null

    @JsonProperty("role")
    var role: String? = null

    constructor() {}

    constructor(email: String, name: String, password: String, role: String) {
        this.email = email
        this.name = name
        this.password = password
        this.role = role
    }

    companion object {
        private const val serialVersionUID = -1764970284520387975L
    }
}