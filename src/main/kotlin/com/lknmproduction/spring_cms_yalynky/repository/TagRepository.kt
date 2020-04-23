package com.lknmproduction.spring_cms_yalynky.repository

import com.lknmproduction.spring_cms_yalynky.domain.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository : JpaRepository<Tag, Long>