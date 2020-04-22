package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*

@Entity
@Table(name = "positions")
data class Position(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,

        @Column(name = "name", nullable = false)
        var name: String? = null,

        @Column(name = "salary", nullable = false)
        var salary: Double? = null,

        @Column(name = "description")
        var description: String? = null,

        @Column(name = "image_url")
        var imageUrl: String? = null,

        @OneToMany(mappedBy = "position")
        var userPositions: Collection<UserPosition>? = null
)