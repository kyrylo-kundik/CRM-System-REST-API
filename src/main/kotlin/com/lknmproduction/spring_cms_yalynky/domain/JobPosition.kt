package com.lknmproduction.spring_cms_yalynky.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.lknmproduction.spring_cms_yalynky.domain.utils.PositionWorker
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "job_position")
data class JobPosition(
        @Column(nullable = false) var title: String,
        var description: String,
        @ManyToOne var job: Job,
        @OneToMany(mappedBy = "position") @JsonIgnoreProperties("positionWorkers") var positionWorkers: Set<PositionWorker> = mutableSetOf(),
        @Column(name = "valid_from", nullable = false) var validFrom: Date,
        @Column(name = "valid_to", nullable = false) var validTo: Date,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)