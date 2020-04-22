package com.lknmproduction.spring_cms_yalynky.controller

import com.lknmproduction.spring_cms_yalynky.domain.User
import com.lknmproduction.spring_cms_yalynky.repository.UserRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@Api(value = "User controller", tags = ["User"])
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/users")
class UserController(val userRepository: UserRepository) {

    @ApiOperation(value = "Get all users")
    @GetMapping
    fun getUsers(): MutableList<User> = userRepository.findAll()

    @ApiOperation(value = "Get user by id")
    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long): Optional<User>? {
        return userRepository.findById(userId)
    }

    @ApiOperation(value = "Create a new User")
    @PostMapping
    fun newUser(@RequestBody user: User): User {
        userRepository.save(user)
        return user
    }

    @ApiOperation(value = "Update an existing User")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateUser(user: User) {
        userRepository.save(user)
    }

    @ApiOperation(value = "Delete an existing User")
    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable userId: Long) {
        userRepository.deleteById(userId)
    }

}