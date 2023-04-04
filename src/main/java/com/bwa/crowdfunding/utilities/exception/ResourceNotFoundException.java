package com.bwa.crowdfunding.utilities.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    /**
     * // use on controller
     * example
     * Optional<T> findById(ID id) -> Mengambil entitas dengan id-nya.
     *
     * @GetMapping("/notes/{id}")
     * public Note getNoteById(@PathVariable(value = "id") Long noteId) {
     *     return noteRepository.findById(noteId)
     *             .orElseThrow(() -> new ResourceNotFoundException("Id Tidak ada bro!"));
     * }
     *
     * @GetMapping("/notes/{id}")
     * public Note getNoteById(@PathVariable(value = "id") Long noteId) {
     *     return noteRepository.findById(noteId)
     *             .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
     * }
     *
     */


    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }





}
