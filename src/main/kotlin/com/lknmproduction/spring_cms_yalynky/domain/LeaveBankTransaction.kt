package com.lknmproduction.spring_cms_yalynky.domain

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "leave_bank_transaction")
data class LeaveBankTransaction(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @ManyToOne var worker: Worker,
        @Column(nullable = false) var amount: Float,
        @Column(nullable = false, name = "transaction_number") var transactionNumber: Int,
        @Column(nullable = false, name = "transaction_date") var transactionDate: Date,
        @Column(nullable = false, name = "transaction_type") var transactionType: String
)