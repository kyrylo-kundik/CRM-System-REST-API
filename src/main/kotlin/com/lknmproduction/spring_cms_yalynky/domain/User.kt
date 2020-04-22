package com.lknmproduction.spring_cms_yalynky.domain

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,

        @Column(name = "email", nullable = false, unique = true)
        var email: String? = null,

        @Column(name = "about")
        var about: String? = null,

        @Column(name = "name", nullable = false)
        var name: String? = null,

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

        @OneToMany(mappedBy = "creator")
        var cards: Collection<BoardCard>? = null,

        @OneToMany(mappedBy = "creator")
        var polls: Collection<Poll>? = null,

        @OneToMany(mappedBy = "user")
        var payments: Collection<Payment>? = null,

        @OneToMany(mappedBy = "user")
        var userPositions: Collection<UserPosition>? = null,

        @OneToMany(mappedBy = "respondent")
        var pollsSubmissions: Collection<PollSubmission>? = null
)