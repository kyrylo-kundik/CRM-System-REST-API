package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*

@Entity
@Table(name = "job_function")
data class JobFunction(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @ManyToOne var worker: Worker,
        var description: String,
        @Column(nullable = false) var name: String
)