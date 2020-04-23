package com.lknmproduction.spring_cms_yalynky.repository

import com.lknmproduction.spring_cms_yalynky.domain.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository : JpaRepository<Payment, Long>