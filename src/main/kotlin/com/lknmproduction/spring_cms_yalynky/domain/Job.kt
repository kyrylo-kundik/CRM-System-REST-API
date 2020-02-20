package com.lknmproduction.spring_cms_yalynky.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.lknmproduction.spring_cms_yalynky.domain.utils.PositionWorker
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "job")
data class Job(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @OneToMany(mappedBy = "job") @JsonIgnoreProperties("jobFunctions") var jobFunctions: Set<JobFunction> = mutableSetOf(),
        @Column(nullable = false, unique = true) var title: String,
        var description: String,
        @Column(name = "max_number_positions") var maxNumberPositions: Int,
        @Column(name = "valid_from", nullable = false) var validFrom: Date,
        @Column(name = "valid_to", nullable = false) var validTo: Date,
        @Column(name = "allow_unlimited_positions", nullable = false) var allowUnlimitedPositions: Boolean = true
)