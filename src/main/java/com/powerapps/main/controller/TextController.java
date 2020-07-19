package com.powerapps.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.powerapps.main.dto.ReceiveData;
import com.powerapps.main.service.TextProcessServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/ibk/*")
public class TextController {
	
	@Autowired
	private TextProcessServiceImpl textProcessServiceImpl;
	
	@ApiOperation(value = "TextController", tags="text")
	@RequestMapping(path = "/textProcess", method = RequestMethod.POST)
	public void textProcess(@RequestBody ReceiveData receiveData) {
		System.out.println("▷ textController.textProcess()");
		System.out.println("ReceiveString : " + receiveData.getData());
		textProcessServiceImpl.textProcess(receiveData.getData());
	}
}
