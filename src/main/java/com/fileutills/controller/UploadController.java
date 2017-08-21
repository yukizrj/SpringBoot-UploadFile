package com.fileutills.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileutills.entity.Files;
import com.fileutills.service.FileService;

/**
 * @author Rachel Zheng controller for upload file
 *
 */
@RestController
public class UploadController {

	/**
	 * service for upload file
	 */
	@Autowired
	private FileService service;

	/**
	 * @param name
	 * @param file
	 * @return
	 */
	@PostMapping("/upload")
	public @ResponseBody String FileUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			byte[] bytes;
			try {
				// 1:store file in a folder
				bytes = file.getBytes();
				// create path
				File path = new File("~/LocalUpload");
				if (!path.exists()) {
					path.mkdirs();
				}
				// store file
				File serverFile = new File(path.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				// 2:store metadata in database
				// get current date time
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				// call service to store in db
				Files obj = new Files(name, bytes, date);
				String resp = service.save(obj);
				return resp;
			} catch (IOException e) {
				e.printStackTrace();
				return "failed to upload";
			}
		} else {
			return "empty file";
		}
	}

}
