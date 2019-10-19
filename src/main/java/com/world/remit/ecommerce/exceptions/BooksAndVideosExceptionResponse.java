package com.world.remit.ecommerce.exceptions;

public class BooksAndVideosExceptionResponse {

    private String projectIdentifier;

    public BooksAndVideosExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
