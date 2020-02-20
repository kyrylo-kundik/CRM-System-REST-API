package com.lknmproduction.spring_cms_yalynky.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.lknmproduction.spring_cms_yalynky.domain.utils.BenefitWorker
import com.lknmproduction.spring_cms_yalynky.domain.utils.PositionWorker
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "worker")
data class Worker(
        @OneToMany(mappedBy = "worker") @JsonIgnoreProperties("positionWorkers") var positionWorkers: Set<PositionWorker> = mutableSetOf(),
        @OneToMany(mappedBy = "worker") @JsonIgnoreProperties("benefitWorkers") var benefitWorkers: Set<BenefitWorker> = mutableSetOf(),
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        @Column(nullable = false, name = "birth_date") var birthDate: Date,
        @Column(nullable = false, unique = true) var email: String,
        @Column(nullable = false, name = "first_name") var firstName: String,
        @Column(nullable = false, name = "last_name") var lastName: String,
        var gender: String,
        @Column(name = "middle_name") var middleName: String? = null,
        @Column(nullable = false) var phone: String,
        var profession: String?,
        var status: String,
        @Column(nullable = false, name = "worker_number", unique = true) var workerNumber: Int,
        // TODO review manager relation
        @ManyToOne var manager: Worker,
        @OneToMany(mappedBy = "manager") @JsonIgnoreProperties("managedWorkers") var managedWorkers: Set<Worker> = mutableSetOf()
)