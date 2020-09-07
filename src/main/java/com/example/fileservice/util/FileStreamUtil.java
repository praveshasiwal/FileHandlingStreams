package com.example.fileservice.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;


@Component
public class FileStreamUtil {
	
	Logger log = LoggerFactory.getLogger(getClass());

	public void fileStreams(File directory) throws IOException {
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ResourceUtils.getFile("classpath:output/test.csv"))));
		if(directory.exists()) {
			log.info("File Exist");
		}
		
		if(directory.isDirectory()) {
			log.info("file is Directory : {} ", directory.getAbsolutePath());
			File[] files = directory.listFiles();
			
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				log.info("File name is : {} ", file.getAbsolutePath());
				BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath())); 
		        String line = br.readLine(); 
		        while (line != null) 
		        { 
		            pw.println(line); 
		            line = br.readLine(); 
		        } 
		        pw.flush();
				
				br.close(); 
			}
			
			
		} else {
			log.info("file  : {} ", directory.getAbsolutePath());
		}

		pw.close(); 
	}
}
