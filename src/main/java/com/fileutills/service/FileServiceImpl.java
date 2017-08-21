package com.fileutills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fileutills.dao.FileDAO;
import com.fileutills.entity.Files;

/**
 * @author Rachel Zheng Implementation for service
 *
 */
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDAO filedao;

	/*
	 * (non-Javadoc)
	 * 
	 * @call save method in file dao
	 */
	@Override
	public String save(Files file) {
		return filedao.save(file);
	}

}
