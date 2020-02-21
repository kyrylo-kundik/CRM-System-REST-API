package com.lknmproduction.spring_cms_yalynky.domain.utils

import com.lknmproduction.spring_cms_yalynky.domain.Benefit
import com.lknmproduction.spring_cms_yalynky.domain.Worker
import com.lknmproduction.spring_cms_yalynky.domain.utils.ids.BenefitWorkerId
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "benefit_to_worker")
@IdClass(BenefitWorkerId::class)
data class BenefitWorker(
        @Column(name = "valid_from", nullable = false) var validFrom: Date,
        @Column(name = "valid_to", nullable = false) var validTo: Date,
        @Id @ManyToOne var benefit: Benefit,
        @Id @ManyToOne var worker: Worker
)