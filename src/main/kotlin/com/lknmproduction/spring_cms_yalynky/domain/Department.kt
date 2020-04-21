package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*

@Entity
@Table(name = "departments")
data class Department(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,

        @Column(name = "name", nullable = false)
        var name: String? = null,

        @OneToMany(mappedBy = "department")
        var employees: Collection<User>? = null
)