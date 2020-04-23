package com.lknmproduction.spring_cms_yalynky.domain.utils

import java.io.Serializable
import com.fasterxml.jackson.annotation.JsonProperty

class LoginUser : Serializable {

    @JsonProperty("email")
    var email: String? = null

    @JsonProperty("password")
    var password: String? = null

    constructor()

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    companion object {
        private const val serialVersionUID = -1764970284520387975L
    }
}