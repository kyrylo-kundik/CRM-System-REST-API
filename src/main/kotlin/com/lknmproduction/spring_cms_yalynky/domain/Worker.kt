package com.lknmproduction.spring_cms_yalynky.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.lknmproduction.spring_cms_yalynky.domain.utils.PositionWorker
import javax.persistence.*

@Entity
@Table(name = "worker")
data class Worker(
        @OneToMany(mappedBy = "worker") @JsonIgnoreProperties("positionWorkers") var positionWorkers: Set<PositionWorker> = mutableSetOf(),
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)