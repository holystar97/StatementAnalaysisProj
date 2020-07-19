package com.powerapps.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powerapps.main.dao.TextUploadDAO;
import com.powerapps.main.dto.ReceiveData;
import com.powerapps.main.dto.ResponseData;

@Service
public class TextProcessServiceImpl implements TextProcessService {

	@Autowired
	private TextUploadDAO textUploadDAO;
	
	@Override
	public boolean textProcess(String data) {
		return textUploadDAO.uploadText(data);
	}
}
