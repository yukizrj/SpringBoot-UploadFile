package com.fileutills.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * @author Rachel Zheng file entity
 *
 */
@Entity
@Table(name = "file_tbl")
public class Files implements Serializable {

	private static final long serialVersionUID = 3883931310161826286L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Lob
	@Column(length = Integer.MAX_VALUE, nullable = true)
	private byte[] content;
	@Column(name="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public Files(String name, byte[] content, Date dt) {
		super();
		this.name = name;
		this.content = content;
		this.dt = dt;
	}

}
