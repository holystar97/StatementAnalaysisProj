package com.powerapps.main.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUtility {
	//경로 지정자
	private static final String imagePath = new File("src/main/resources/images/").getAbsolutePath();
	private static final String formPath = new File("src/main/resources/formText/").getAbsolutePath();
	private static final String resultTextPath = new File("src/main/resources/resultText/").getAbsolutePath();
	private static final String preTextPath = new File("src/main/resources/preText/").getAbsolutePath();
	
	//텍스트 확장자
	private static final String textExtension = ".txt";
	
	public static String getFormData(String formtype) {
		String formData = "";
		String fileName = "";
		
		switch (formtype) {
		case "01":
			fileName = "form01.txt"; 
			break;
		case "02":
			fileName = "form02.txt"; 
			break;
		case "03":
			fileName = "form03.txt"; 
			break;
		default:
			System.out.println("해당 양식은 존재하지 않습니다."); 
			break;
		}
		
		if(!fileName.equals("")) {
			File file = new File(formPath + "/" + fileName);
			formData = filetoString(file);
		}
		
		return formData;
	}

	
	public static String filetoString(File file) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) { br.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	
	public static List<List<String>> readTextFile(File sourceFile) {
		// 반환용 리스트
		List<List<String>> ret = new ArrayList<List<String>>();
		BufferedReader br = null;
		File file = sourceFile;
		FileReader fileReader = null;

		try {
			String originalfileName = "statement3.txt";
			String path = new File("src/main/resources/static/pretext/").getAbsolutePath() + "/" + originalfileName;

			file = new File(path);
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);

			String line = "";
			while ((line = br.readLine()) != null) {
				List<String> tmpList = new ArrayList<String>();
				String[] array = line.split("\\s+");
				tmpList = Arrays.asList(array);
				System.out.println(tmpList);
				ret.add(tmpList);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public static void writeFiletoText() {
		BufferedWriter bw = null;
		String originalfileName = "statement_result.txt";
		String path = new File("src/main/resources/static/resulttext/").getAbsolutePath() + "/" + originalfileName;

		try {
			File file = new File(path);
			bw = new BufferedWriter(new FileWriter(file));
			List<List<String>> allData = readTextFile(null);

			for (List<String> newLine : allData) {
				List<String> list = newLine;
				for (String data : list) {
					bw.write(data);
					bw.write("\t");
				}
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String generateFileName() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");

		return sdf.format(date) + textExtension;
	}
	
	
	public static boolean writeStringtoText(String content, String type) {
		BufferedWriter bw = null;
		String fileName = generateFileName();
		String path = "";
		
		if("result".equals(type))
			path = resultTextPath;
		else if("pre".equals(type))
			path = preTextPath;
		
		
		try {
			File file = new File(path + "/" + fileName);
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(content);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (bw != null) { bw.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public static boolean uploadImage(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		File dest = new File(imagePath + "/" + fileName);
		try {
			file.transferTo(dest);
		} catch (Exception e) {
			return false;
		}
		return true;
	}	
}