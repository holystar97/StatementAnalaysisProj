package com.powerapps.main.dao;

import org.springframework.stereotype.Service;

import com.powerapps.main.util.FileUtility;

@Service
public class TextUploadDAO {
	public boolean uploadText(String data) {
		System.out.println("▷ TextUploadDAO.uploadText()");
		boolean result = FileUtility.writeStringtoText(data, "result");
		if(!result)
			System.out.println("Failed to upload text");
		
		return result;
	}
}
