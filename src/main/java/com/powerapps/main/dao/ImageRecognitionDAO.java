package com.powerapps.main.dao;

import org.springframework.stereotype.Service;

import com.powerapps.main.dto.ImageAnnotation;
import com.powerapps.main.dto.ResponseData;
import com.powerapps.main.util.FileUtility;

@Service
public class ImageRecognitionDAO {

	public String recognizeImage(String formtype, ImageAnnotation imageAnnotation) {
		System.out.println("▷ ImageRecognitionDAO.recognizeImage()");
		/*
		 * 이미지 인식의 결과 데이터를 반환한다.
		 * 결과 데이터는 txt 형태로 저장.
		 * 현재는 더미 String으로 반환되어짐.
		 */
		String resultString = "";
		if(true) {
			System.out.println("▷  recognizeImage success..");
			resultString = FileUtility.getFormData(formtype);
			FileUtility.writeStringtoText(resultString, "pre");
		}
		
		return resultString;
	}
}
