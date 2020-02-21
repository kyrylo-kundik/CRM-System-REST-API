package com.lknmproduction.spring_cms_yalynky.domain

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "employment")
data class Employment(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @ManyToOne var worker: Worker,
        @Column(nullable = false, name = "start_date") var startDate: Date,
        @Column(name = "last_day_worked") var lastDayWorked: Date,
        @Column(nullable = false, name = "end_date") var endDate: Date,
        @Column(nullable = false, name = "worker_notice_amount") var workerNoticeAmount: String,
        @Column(nullable = false, name = "worker_type") var workerType: String,
        @Column(nullable = false, name = "employment_number") var employmentNumber: Int,
        @Column(nullable = false, name = "employment_date") var employmentDate: Date
)