package com.lknmproduction.spring_cms_yalynky.bootstrap

import com.lknmproduction.spring_cms_yalynky.domain.Role
import com.lknmproduction.spring_cms_yalynky.repository.RoleRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class UserSeeder(private val repository: RoleRepository) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        if (!repository.findByName("HR").isPresent) {
            repository.save(Role(0, "HR"))
        }
        if (!repository.findByName("Employee").isPresent) {
            repository.save(Role(0, "Employee"))
        }
    }

}
