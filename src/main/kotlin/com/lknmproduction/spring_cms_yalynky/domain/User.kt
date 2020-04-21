package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,

        @Column(name = "username", nullable = false, unique = true)
        var username: String? = null,

        @Column(name = "full_name")
        var fullName: String? = null,

        @Column(name = "image_url")
        var imageUrl: String? = null,

        @Column(name = "password", nullable = false)
        var password: String? = null,

        @Column(name = "enabled", nullable = false)
        var enabled: Boolean = false,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
        )
        var roles: Collection<Role>? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "position_fk")
        var position: Position? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "department_fk")
        var department: Department? = null,

        @OneToMany(mappedBy = "creator")
        var cards: Collection<BoardCard>? = null,

        @OneToMany(mappedBy = "creator")
        var polls: Collection<Poll>? = null,

        @OneToMany(mappedBy = "respondent")
        var polls_submissions: Collection<PollSubmission>? = null
)