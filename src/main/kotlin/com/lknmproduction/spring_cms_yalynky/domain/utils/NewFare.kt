package com.lknmproduction.spring_cms_yalynky.domain.utils

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

class NewFare : Serializable {

    @JsonProperty("new_fare")
    var newFare: Long? = null

    constructor()

    constructor(newFare: Long) {
        this.newFare = newFare
    }

    companion object {
        private const val serialVersionUID = -1764970284620387975L
    }

}