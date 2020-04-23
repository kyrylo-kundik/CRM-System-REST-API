package com.lknmproduction.spring_cms_yalynky.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "polls")
data class Poll(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,

        @Column(name = "title", nullable = false)
        var title: String? = null,

        @Column(name = "description", nullable = false)
        var description: String? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_fk", nullable = false)
        var creator: User? = null,

        @JsonIgnore
        @OneToMany(mappedBy = "poll")
        var submissions: Collection<PollSubmission>? = null
)