package com.fileuitlls;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fileutills.controller.UploadController;
import com.fileutills.entity.Files;
import com.fileutills.service.FileService;

/**
 * @author Rachel intergation test for uploadcontroller
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = UploadController.class, secure = false)

public class TestController {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private FileService fileService;

	@InjectMocks
	private UploadController uploadController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(uploadController).build();

	}

	@Test
	public void testGetEmployee() throws Exception {
		// necessary data
		Date date = new Date();
		byte[] content = null;
		Path path = Paths.get("~/LocalUpload/testcase.txt");
		try {
			content = java.nio.file.Files.readAllBytes(path);
		} catch (final IOException e) {
		}

		File file = new File("~/LocalUpload/testcase.txt");
		when(fileService.save(new Files("abc", content, date)));
		FileInputStream fis = new FileInputStream(file);
		// mock test
		MockMultipartFile multipart = new MockMultipartFile("file", file.getName(), "multipart/form-data", fis);
		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload").file(multipart).param("name", "abc"))

				.andExpect(status().is(200)).andExpect(content().string("uploaded successfully"));

	}

}
