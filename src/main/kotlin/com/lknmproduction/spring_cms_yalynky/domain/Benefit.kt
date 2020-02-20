package com.lknmproduction.spring_cms_yalynky.domain

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "benefit")
data class Benefit(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @Column(nullable = false) var name: String,
        var description: String,
        @Column(nullable = false, name = "payroll_impact") var payrollImpact: Int,
        @Column(name = "benefit_type") var benefitType: String,
        @Column(nullable = false, name = "start_date") var startDate: Date,
        @Column(nullable = false, name = "end_date") var endDate: Date
)