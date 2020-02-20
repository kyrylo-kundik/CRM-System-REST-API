package com.lknmproduction.spring_cms_yalynky.domain.utils.ids

import java.io.Serializable

class BenefitWorkerId(
        var benefit: Int,
        var worker: Int
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as BenefitWorkerId

        return other.benefit == this.benefit && other.worker == this.worker
    }

    override fun hashCode(): Int = 23 * this.benefit + 17 * this.worker
}