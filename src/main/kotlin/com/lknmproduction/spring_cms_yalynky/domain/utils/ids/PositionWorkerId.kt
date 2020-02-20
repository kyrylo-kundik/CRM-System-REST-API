package com.lknmproduction.spring_cms_yalynky.domain.utils.ids

import java.io.Serializable

class PositionWorkerId(
        var position: Int,
        var worker: Int
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as PositionWorkerId

        return other.position == this.position && other.worker == this.worker
    }

    override fun hashCode(): Int {
        return 27 * this.position + 13 * this.worker
    }
}