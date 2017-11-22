package com.dots.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	MultipartFile multipartfile;

	public MultipartFile getMultipartfile() {
		return multipartfile;
	}

	public void setMultipartfile(MultipartFile multipartfile) {
		this.multipartfile = multipartfile;
	}
	
}
