package com.lknmproduction.spring_cms_yalynky.controller

import com.lknmproduction.spring_cms_yalynky.domain.Payment
import com.lknmproduction.spring_cms_yalynky.domain.User
import com.lknmproduction.spring_cms_yalynky.domain.UserPosition
import com.lknmproduction.spring_cms_yalynky.domain.utils.NewFare
import com.lknmproduction.spring_cms_yalynky.repository.PaymentRepository
import com.lknmproduction.spring_cms_yalynky.repository.UserPositionRepository
import com.lknmproduction.spring_cms_yalynky.repository.UserRepository
import com.lknmproduction.spring_cms_yalynky.web.response.ResponseMessage
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.NoSuchElementException

@Api(value = "User controller", tags = ["User"])
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/users")
class UserController(val userRepository: UserRepository, val paymentRepository: PaymentRepository, val userPositionRepository: UserPositionRepository) {

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

    @ApiOperation("Get user payments")
    @GetMapping("/{userId}/payments")
    fun getUserPayments(@PathVariable userId: Long): ResponseEntity<*> {
        return try {
            ResponseEntity(userRepository.findById(userId).orElseThrow { throw NoSuchElementException() }.payments!!, HttpStatus.OK)
        } catch (e: NoSuchElementException) {
            ResponseEntity(ResponseMessage("User not found"), HttpStatus.NOT_FOUND)
        }
    }

    @ApiOperation("Create user payment (= pay user his salary)")
    @PostMapping("/{userId}/payments")
    fun createUserPayment(@PathVariable userId: Long, @RequestBody payment: Payment): ResponseEntity<*> {
        val user: User?
        try {
            user = userRepository.findById(userId).orElseThrow { NoSuchElementException() }
        } catch (e: NoSuchElementException) {
            return ResponseEntity(ResponseMessage("User not found"), HttpStatus.NOT_FOUND)
        }
        payment.user = user
        return ResponseEntity(paymentRepository.save(payment), HttpStatus.OK)
    }

    @ApiOperation("Change User amount of salary")
    @PostMapping("/{userId}/changeFare")
    fun changeUserFare(@PathVariable userId: Long, @RequestBody newFare: NewFare): ResponseEntity<*> {
        val position: UserPosition
        try {
            position = getUserCurrentPosition(userId)
        } catch (e: NoSuchElementException) {
            return ResponseEntity(ResponseMessage("User not found"), HttpStatus.NOT_FOUND)
        }
        position.currentSalary = newFare.newFare

        return ResponseEntity(userPositionRepository.save(position), HttpStatus.OK)
    }

    @ApiOperation("Change user current position")
    @PostMapping("/{userId}/changePosition")
    fun changeUserPosition(@PathVariable userId: Long, @RequestBody userPosition: UserPosition): ResponseEntity<*> {
        val user: User
        try {
            user = userRepository.findById(userId).orElseThrow { throw NoSuchElementException() }
        } catch (e: NoSuchElementException) {
            return ResponseEntity(ResponseMessage("User not found"), HttpStatus.NOT_FOUND)
        }
        user.userPositions!!.stream().map { p: UserPosition? -> p?.isActive = false }

        userPosition.isActive = true

        userPosition.user = user

        userRepository.save(user)
        return ResponseEntity(userPositionRepository.save(userPosition), HttpStatus.OK)
    }

    @ApiOperation("Fire user from the position")
    @PostMapping("/{userId}/fire")
    fun fireUser(@PathVariable userId: Long): ResponseEntity<*> {
        val user: User
        try {
            user = userRepository.findById(userId).orElseThrow { throw NoSuchElementException() }
        } catch (e: NoSuchElementException) {
            return ResponseEntity(ResponseMessage("User not found"), HttpStatus.NOT_FOUND)
        }
        user.userPositions!!.stream().map { p: UserPosition? -> p?.isActive = false }

        userRepository.save(user)

        return ResponseEntity("ok", HttpStatus.OK)
    }

    private fun getUserCurrentPosition(userId: Long): UserPosition {
        val user: User? = userRepository.findById(userId).orElseThrow { throw NoSuchElementException() }
        return user?.userPositions!!.stream().filter { p: UserPosition? -> p?.isActive!! }.findFirst().orElseThrow { throw NoSuchElementException() }
    }

}