package com.TwentySevenFour.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class InterviewApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(InterviewApplication.class, args);
//			To-do. Read from the source file and import the excel data straight to the database
//			final String file_path = "C:\\Interview\\27Four\\Interview\\src\\main\\resources\\excel_data\\";
//			final String file_name = "27fourIM.xlsx".trim();
//			FileInputStream fileInputStream = new FileInputStream(file_path + file_name);
//			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
//			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
//			Row row;
//			for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {
//				row = xssfSheet.getRow(i);
//				System.err.println(row.getCell(0) + " " + " " + row.getCell(1));
//
//			}
//			xssfWorkbook.close();

		}
	}


