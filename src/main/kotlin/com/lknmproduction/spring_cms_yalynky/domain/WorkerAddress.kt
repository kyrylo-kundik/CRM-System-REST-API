package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*


@Entity
@Table(name = "worker_address")
data class WorkerAddress(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @ManyToOne var worker: Worker,
        @Column(nullable = false, name = "address_type") var addressType: String,
        @Column(name = "address_description") var addressDescription: String?,
        @Column(nullable = false) var city: String,
        @Column(nullable = false) var country: String,
        var county: String,
        @Column(name = "address_line_1") var addressLine1: String,
        @Column(nullable = false, name = "address_line_2") var addressLine2: String,
        var fax: String,
        @Column(name = "postal_code") var postalCode: String,
        @Column(name = "phone_1") var phone1: String,
        @Column(name = "phone_2") var phone2: String,
        var state: String
)