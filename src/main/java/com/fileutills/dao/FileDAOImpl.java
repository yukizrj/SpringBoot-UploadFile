package com.fileutills.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fileutills.entity.Files;

/**
 * @author Rachel Zheng Implementation of file dao
 *
 */
@Repository
@Transactional
public class FileDAOImpl implements FileDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @save record to database
	 */
	@Override
	public String save(Files file) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(file);
		} catch (RuntimeException re) {
			re.printStackTrace();
			return "failed upload to db";
		}
		return "uploaded successfully";
	}

}
