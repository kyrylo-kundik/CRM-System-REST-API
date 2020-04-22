package com.lknmproduction.spring_cms_yalynky.repository

import com.lknmproduction.spring_cms_yalynky.domain.Poll
import org.springframework.data.jpa.repository.JpaRepository

interface PollRepository : JpaRepository<Poll, Long>