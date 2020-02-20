package com.lknmproduction.spring_cms_yalynky.domain

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "leave_request")
data class LeaveRequest(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @ManyToOne var worker: Worker,
        @Column(nullable = false) var comment: String,
        @Column(nullable = false, name = "request_date") var requestDate: Date,
        @Column(nullable = false) var status: String,
        @Column(nullable = false, name = "start_leave_enrollment_date") var startLeaveEnrollmentDate: Date,
        @Column(nullable = false, name = "end_leave_enrollment_date") var endLeaveEnrollmentDate: Date,
        @Column(nullable = false, name = "leave_type") var leaveType: String,
        @Column(nullable = false, name = "leave_date") var leaveDate: Date,
        @Column(nullable = false) var amount: Float
)