package com.lknmproduction.spring_cms_yalynky.domain

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "worker_identification_number")
data class WorkerIdentificationNumber(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @ManyToOne var worker: Worker,
        var description: String,
        @Column(nullable = false, name = "expiration_date") var expirationDate: Date,
        @Column(nullable = false, name = "identification_number") var identificationNumber: String,
        @Column(nullable = false, name = "issue_date") var issueDate: Date,
        @Column(nullable = false) var type: String,
        @Column(nullable = false, name = "issue_address") var issueAddress: String
        )