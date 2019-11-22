package com.example.domain;

import java.util.List;

/**
<<<<<<< HEAD
 * 記事投稿情報を表すドメイン.
 * 
 * @author riho.ikeda
=======
 * 記事情報を表すドメイン.
 * 
 * @author sakai
>>>>>>> feature/articledomain
 *
 */
public class Article {
	/** 投稿ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** コンテント */
	private String content;
	/** コメントリスト */
	private List<Comment> commentList;

	public Article() {
		super();
	}

	public Article(Integer id, String name, String content, List<Comment> commentList) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.commentList = commentList;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", content=" + content + ", commentList=" + commentList + "]";
	}


	/** 記事ID */
	private Integer id;
	/** 投稿者名 */
	private String name;
	/** 投稿内容 */
	private String content;
	/** コメント情報 */
	private List<Comment> commentList;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", content=" + content + ", commentList=" + commentList + "]";
	}

}
