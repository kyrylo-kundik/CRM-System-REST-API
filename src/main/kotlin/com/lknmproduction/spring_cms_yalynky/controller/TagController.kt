package com.lknmproduction.spring_cms_yalynky.controller

import com.lknmproduction.spring_cms_yalynky.domain.Tag
import com.lknmproduction.spring_cms_yalynky.repository.TagRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.util.*

@Api(value = "Tag controller", tags = ["Tag"])
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/tags")
class TagController(val tagRepository: TagRepository) {

    @ApiOperation(value = "Get all tags")
    @GetMapping
    @PreAuthorize("hasRole('HR') or hasRole('Employee')")
    fun getTags(): MutableList<Tag> = tagRepository.findAll()

    @ApiOperation(value = "Get tag by id")
    @GetMapping("/{tagId}")
    @PreAuthorize("hasRole('HR') or hasRole('Employee')")
    fun getTag(@PathVariable tagId: Long): Optional<Tag>? {
        return tagRepository.findById(tagId)
    }

    @ApiOperation(value = "Create a new tag")
    @PostMapping
    @PreAuthorize("hasRole('HR')")
    fun newTag(@RequestBody tag: Tag): Tag {
        tagRepository.save(tag)
        return tag
    }

    @ApiOperation(value = "Update an existing tag")
    @PutMapping
    @PreAuthorize("hasRole('HR')")
    @ResponseStatus(HttpStatus.OK)
    fun updateTag(tag: Tag) {
        tagRepository.save(tag)
    }

    @ApiOperation(value = "Delete an existing tag")
    @DeleteMapping("/{tagId}")
    @PreAuthorize("hasRole('HR')")
    fun deleteTag(@PathVariable tagId: Long) {
        tagRepository.deleteById(tagId)
    }

}