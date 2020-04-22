package com.lknmproduction.spring_cms_yalynky.repository

import com.lknmproduction.spring_cms_yalynky.domain.BoardCard
import org.springframework.data.jpa.repository.JpaRepository

interface BoardCardRepository : JpaRepository<BoardCard, Long>