package com.fileutills.dao;

import com.fileutills.entity.Files;

/**
 * @author Rachel Zheng interface to upload file
 *
 */
public interface FileDAO {
	/**
	 * @param file
	 * @return
	 */
	public String save(Files file);
}
