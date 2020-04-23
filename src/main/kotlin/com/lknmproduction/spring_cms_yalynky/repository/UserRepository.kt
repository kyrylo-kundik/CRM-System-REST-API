package com.lknmproduction.spring_cms_yalynky.repository

import com.lknmproduction.spring_cms_yalynky.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import java.util.*
import javax.transaction.Transactional

interface UserRepository : JpaRepository<User, Long> {

    fun existsByEmail(@Param("email") email: String): Boolean

    fun findByEmail(@Param("email") email: String): Optional<User>

    @Transactional
    fun deleteByEmail(@Param("email") email: String)

}