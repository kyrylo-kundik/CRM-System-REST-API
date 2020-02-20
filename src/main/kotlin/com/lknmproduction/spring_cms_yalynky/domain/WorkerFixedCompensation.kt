package com.lknmproduction.spring_cms_yalynky.domain

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "worker_fixed_compensation")
data class WorkerFixedCompensation(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @ManyToOne var worker: Worker,
        @Column(nullable = false, name = "expiration_date") var expirationDate: Date,
        @Column(nullable = false, name = "pay_rate") var payRate: Int,
        @Column(nullable = false, name = "is_active") var isActive: Boolean
)