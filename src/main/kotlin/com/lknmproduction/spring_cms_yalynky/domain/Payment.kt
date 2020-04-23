package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*

@Entity
@Table(name = "payments")
data class Payment(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,

        @Column(name = "amount", nullable = false)
        var amount: Long? = 0,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_fk", nullable = false)
        var user: User? = null
)