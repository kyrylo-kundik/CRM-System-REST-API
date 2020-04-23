package com.lknmproduction.spring_cms_yalynky.controller

import com.lknmproduction.spring_cms_yalynky.domain.Position
import com.lknmproduction.spring_cms_yalynky.repository.PositionRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@Api(value = "Position controller", tags = ["Position"])
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/positions")
class PositionController(val positionRepository: PositionRepository) {

    @ApiOperation(value = "Get all positions")
    @GetMapping
    fun getPositions(): MutableList<Position> = positionRepository.findAll()

    @ApiOperation(value = "Get position by id")
    @GetMapping("/{positionId}")
    fun getPosition(@PathVariable positionId: Long): Optional<Position>? {
        return positionRepository.findById(positionId)
    }

    @ApiOperation(value = "Create a new position")
    @PostMapping
    fun newPosition(@RequestBody position: Position): Position {
        positionRepository.save(position)
        return position
    }

    @ApiOperation(value = "Update an existing position")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updatePosition(position: Position) {
        positionRepository.save(position)
    }

    @ApiOperation(value = "Delete an existing position")
    @DeleteMapping("/{positionId}")
    fun deletePosition(@PathVariable positionId: Long) {
        positionRepository.deleteById(positionId)
    }

}