package com.lknmproduction.spring_cms_yalynky.domain.utils

import com.lknmproduction.spring_cms_yalynky.domain.JobPosition
import com.lknmproduction.spring_cms_yalynky.domain.Worker
import com.lknmproduction.spring_cms_yalynky.domain.utils.ids.PositionWorkerId
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "position_to_worker")
@IdClass(PositionWorkerId::class)
data class PositionWorker(
        @Column(name = "valid_from", nullable = false) var validFrom: Date,
        @Column(name = "valid_to", nullable = false) var validTo: Date,
        @Id @ManyToOne var position: JobPosition,
        @Id @ManyToOne var worker: Worker
)