package com.lknmproduction.spring_cms_yalynky.domain

import com.fasterxml.jackson.annotation.JsonIgnore
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

        @JsonIgnore
        @Column(name = "password", nullable = false)
        var password: String? = null,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
        )
        var roles: Collection<Role>? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "creator")
        var cards: Collection<BoardCard>? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "creator")
        var polls: Collection<Poll>? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "user")
        var payments: Collection<Payment>? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "user")
        var userPositions: Collection<UserPosition>? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "respondent")
        var pollsSubmissions: Collection<PollSubmission>? = null
)