package com.lknmproduction.spring_cms_yalynky.domain

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "board_cards")
data class BoardCard(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,

        @Column(name = "title", nullable = false)
        var title: String? = null,

        @Column(name = "description")
        var description: String? = null,

        @Column(name = "image_url")
        var imageUrl: String? = null,

        @Column(name = "created_at", nullable = false)
        var dateTimeCreated: Date = Date(),

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_fk", nullable = false)
        var creator: User? = null,

        @ManyToMany
        @JoinTable(
                name = "board_cards_tags",
                joinColumns = [JoinColumn(name = "board_card_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "tag_id", referencedColumnName = "id")]
        )
        var tags: Collection<Tag>? = null
)