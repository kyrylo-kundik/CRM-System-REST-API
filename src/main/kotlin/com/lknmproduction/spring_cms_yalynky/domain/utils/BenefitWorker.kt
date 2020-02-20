package com.lknmproduction.spring_cms_yalynky.domain.utils

import com.lknmproduction.spring_cms_yalynky.domain.Benefit
import com.lknmproduction.spring_cms_yalynky.domain.utils.ids.BenefitWorkerId
import sun.tools.jconsole.Worker
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "benefit_to_worker")
@IdClass(BenefitWorkerId::class)
data class BenefitWorker(
        @Column(name = "from", nullable = false) var from: Date,
        @Column(name = "to", nullable = false) var to: Date,
        @Id @ManyToOne var benefit: Benefit,
        @Id @ManyToOne var worker: Worker
)