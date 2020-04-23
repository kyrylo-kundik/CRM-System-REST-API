package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*

@Entity
@Table(name = "user_positions")
data class UserPosition(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,

        @Column(name = "current_salary", nullable = false)
        var currentSalary: Long? = 0,

        @Column(name = "is_active", nullable = false)
        var isActive: Boolean? = true,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_fk", nullable = false)
        var user: User? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "position_fk", nullable = false)
        var position: Position? = null
)