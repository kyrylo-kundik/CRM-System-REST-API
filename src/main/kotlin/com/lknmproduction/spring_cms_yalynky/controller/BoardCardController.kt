package com.lknmproduction.spring_cms_yalynky.controller

import com.lknmproduction.spring_cms_yalynky.domain.BoardCard
import com.lknmproduction.spring_cms_yalynky.repository.BoardCardRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@Api(value = "Board card controller", tags = ["Board card"])
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/boardCards")
class BoardCardController(val boardCardRepository: BoardCardRepository) {

    @ApiOperation(value = "Get all Board Cards")
    @GetMapping
    fun getBoardCards(): MutableList<BoardCard> = boardCardRepository.findAll()

    @ApiOperation(value = "Get Board Card by id")
    @GetMapping("/{boardCardId}")
    fun getBoardCard(@PathVariable boardCardId: Long): Optional<BoardCard>? {
        return boardCardRepository.findById(boardCardId)
    }

    @ApiOperation(value = "Create a new Board Card")
    @PostMapping
    fun newBoardCard(@RequestBody boardCard: BoardCard): BoardCard {
        boardCardRepository.save(boardCard)
        return boardCard
    }

    @ApiOperation(value = "Update an existing Board Card")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateBoardCard(boardCard: BoardCard) {
        boardCardRepository.save(boardCard)
    }

    @ApiOperation(value = "Delete an existing Board Card")
    @DeleteMapping("/{boardCardId}")
    fun deleteBoardCard(@PathVariable boardCardId: Long) {
        boardCardRepository.deleteById(boardCardId)
    }

}