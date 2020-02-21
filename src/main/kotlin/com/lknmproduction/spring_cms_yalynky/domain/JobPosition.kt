package com.lknmproduction.spring_cms_yalynky.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.lknmproduction.spring_cms_yalynky.domain.utils.PositionWorker
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "job_position")
data class JobPosition(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @OneToMany(mappedBy = "position") @JsonIgnoreProperties("positionWorkers") var positionWorkers: Set<PositionWorker> = mutableSetOf(),
        @ManyToOne var job: Job,
        @Column(name = "activation_date", nullable = false) var activationDate: Date,
        @Column(name = "available_for_assignment", nullable = false) var availableForAssignment: Date,
        var description: String,
        @Column(name = "full_time_equivalent") var fullTimeEquivalent: Int,
        var retirement: Date,
        @Column(nullable = false) var title: String,
        @Column(name = "valid_from", nullable = false) var validFrom: Date,
        @Column(name = "valid_to", nullable = false) var validTo: Date,
        @Column(name = "position_number", nullable = false, unique = true) var positionNumber: Int
)