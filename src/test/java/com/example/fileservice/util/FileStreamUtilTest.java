package com.example.fileservice.util;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FileStreamUtilTest {

	@Autowired
	FileStreamUtil fileStreamUtil;
	
	@Test
	public void testFileStreams() throws FileNotFoundException, IOException {
		
		fileStreamUtil.fileStreams(ResourceUtils.getFile("classpath:input/"));
		
		assertTrue(true);
		
	}

}
