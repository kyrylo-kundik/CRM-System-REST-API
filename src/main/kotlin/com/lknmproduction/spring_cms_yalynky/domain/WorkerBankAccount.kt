package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*


@Entity
@Table(name = "worker_bank_account")
data class WorkerBankAccount(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @ManyToOne var worker: Worker,
        @Column(name = "bank_account_type") var bankAccountType: String,
        @Column(name = "account_holder") var accountHolder: String,
        @Column(nullable = false) var name: String,
        @Column(nullable = false) var number: Int,
        @Column(nullable = false) var city: String,
        @Column(nullable = false) var country: String,
        var description: String,
        var email: String,
        @Column(nullable = false) var iban: String,
        @Column(name = "swift_code") var swiftCode: String,
        var state: String,
        var webURL: String,
        @Column(nullable = false, name = "account_number") var accountNumber: String
)