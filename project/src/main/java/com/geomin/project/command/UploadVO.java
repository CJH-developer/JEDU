package com.geomin.project.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadVO {
	
	private String uploadFilename;  // 작성자가 업로드한 파일명
    private String storeFilename;
	private String game_title; // fk
	
}
