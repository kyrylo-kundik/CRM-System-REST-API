package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*


@Entity
@Table(name = "worker_personal_info")
data class WorkerPersonalInfo(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @ManyToOne var worker: Worker,
        @Column(nullable = false, name = "city_of_living") var cityOfLiving: String,
        @Column(nullable = false, name = "country_of_living") var countryOfLiving: String,
        @Column(nullable = false) var citizenship: String,
        var education: String,
        @Column(nullable = false, name = "full_time") var fullTime: Boolean,
        @Column(nullable = false, name = "part_time") var partTime: Boolean,
        @Column(nullable = false, name = "is_student") var isStudent: Boolean,
        @Column(nullable = false, name = "marital_status") var maritalStatus: String,
        @Column(nullable = false, name = "personal_title") var personalTitle: String,
        @Column(name = "preferred_language") var preferredLanguage: String
)