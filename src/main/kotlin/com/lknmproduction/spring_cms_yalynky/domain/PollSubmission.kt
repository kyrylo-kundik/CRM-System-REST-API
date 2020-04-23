package com.lknmproduction.spring_cms_yalynky.domain

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "poll_submissions")
data class PollSubmission(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,

        @Column(name = "response_text", nullable = false)
        var responseText: String? = null,

        @Column(name = "created_at", nullable = false)
        var dateTimeCreated: Date = Date(),

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_fk", nullable = false)
        var respondent: User? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "poll_fk", nullable = false)
        var poll: Poll? = null
)