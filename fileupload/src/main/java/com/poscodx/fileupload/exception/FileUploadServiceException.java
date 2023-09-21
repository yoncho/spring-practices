package com.poscodx.fileupload.exception;

public class FileUploadServiceException extends RuntimeException {
	public FileUploadServiceException(String message) {
		super(message);
	}
	
	public FileUploadServiceException() {
		super("FileUploadService Exception Thrown");
	}
}
