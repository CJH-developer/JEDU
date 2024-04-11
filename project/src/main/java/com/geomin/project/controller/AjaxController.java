package com.geomin.project.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geomin.project.command.GameContentVO;
import com.geomin.project.gameContentService.GameContentService;

@RestController
public class AjaxController {

	
	// 파일 업로드 경로
	@Value("${project.upload.path}")
	private String uploadPath;
	// 이미지 표출
	@GetMapping("/display/{filepath}/{uuid}/{filename}")
	public ResponseEntity<byte[]> display(@PathVariable("filepath") String filepath,
										  @PathVariable("uuid") String uuid,
										  @PathVariable("filename") String filename){
		
		ResponseEntity<byte[]> entity = null;
		try {
			// 로컬에 있는 파일데이터 byte 정보
			String savePath = uploadPath + "/" + filepath + "/" + uuid + "_" + filename;
			File file = new File(savePath);
			
			// 데이터
			byte[] arr = FileCopyUtils.copyToByteArray(file);
			
			// 헤더
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			
			entity = new ResponseEntity<>(arr, header ,HttpStatus.OK);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return entity;
	}
	
	

	
}
