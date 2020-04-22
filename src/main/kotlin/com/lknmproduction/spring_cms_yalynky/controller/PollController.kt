package com.lknmproduction.spring_cms_yalynky.controller

import com.lknmproduction.spring_cms_yalynky.domain.Poll
import com.lknmproduction.spring_cms_yalynky.domain.PollSubmission
import com.lknmproduction.spring_cms_yalynky.repository.PollRepository
import com.lknmproduction.spring_cms_yalynky.repository.UserRepository
import com.lknmproduction.spring_cms_yalynky.web.response.ResponseMessage
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletRequest

@Api(value = "Poll controller", tags = ["Poll"])
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/polls")
class PollController(val pollRepository: PollRepository, val userRepository: UserRepository) {

    @ApiOperation(value = "Get all Polls")
    @GetMapping
    fun getPolls(): MutableList<Poll> = pollRepository.findAll()

    @ApiOperation(value = "Get Poll by id")
    @GetMapping("/{pollId}")
    fun getPoll(@PathVariable pollId: Long): Optional<Poll>? {
        return pollRepository.findById(pollId)
    }

    @ApiOperation(value = "Create a new Poll")
    @PostMapping
    fun newPoll(@RequestBody poll: Poll): Poll {
        pollRepository.save(poll)
        return poll
    }

    @ApiOperation(value = "Update an existing Poll")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updatePoll(poll: Poll) {
        pollRepository.save(poll)
    }

    @ApiOperation(value = "Delete an existing Poll")
    @DeleteMapping("/{pollId}")
    fun deletePoll(@PathVariable pollId: Long) {
        pollRepository.deleteById(pollId)
    }

    @ApiOperation(value = "Submit poll answer")
    @PostMapping("/{pollId}/submit")
    fun submitPoll(@PathVariable pollId: Long, @RequestBody pollSubmission: PollSubmission, request: HttpServletRequest): ResponseEntity<*> {
        val poll: Poll = pollRepository.findById(pollId).orElse(null)
                ?: return ResponseEntity(ResponseMessage("Poll not found!"),
                        HttpStatus.NOT_FOUND)
        poll.submissions!!.plus(pollSubmission)

        val user = userRepository.findByEmail(request.userPrincipal.name).get()
        user.pollsSubmissions!!.plus(pollSubmission)

        userRepository.save(user)
        pollRepository.save(poll)

        return ResponseEntity(ResponseMessage("ok"), HttpStatus.OK)
    }

}