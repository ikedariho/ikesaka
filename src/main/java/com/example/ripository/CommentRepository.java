package com.example.ripository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;

/**
 * commentsテーブルを操作するリポジトリ.
 * 
 * @author riho.ikeda
 *
 */
@Repository
public class CommentRepository {
	/**
	 * Commentオブジェクトを生成するローマッパー.
	 */
	public static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));

		return comment;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 投稿IDを指定しコメント情報を取得.
	 * 
	 * @param articleId 投稿ID
	 * @return 指定した投稿IDのコメント情報
	 */
	public List<Comment> findByArticleId(int articleId) {
		String sql = "SELECT id,name,content,article_id FROM comments WHERE article_id=:articleId ORDER BY id DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		List<Comment> commentList = template.query(sql, param, COMMENT_ROW_MAPPER);
		return commentList;

	}

	/**
	 * コメント投稿.
	 * 
	 * @param comment コメント情報
	 */
	public void insert(Comment comment) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
		String sql = "INSERT INTO comments (name,content,article_id) VALUES (:name,:content,:articleId)";
		template.update(sql, param);

	}

	/**
	 * コメントの削除.
	 * 
	 * @param articleId 投稿ID
	 */
	public void deleteByArticleId(int articleId) {
		String sql = "DELETE FROM comments WHERE article_id=:articleId";
		SqlParameterSource param = new MapSqlParameterSource("articleId", articleId);
		template.update(sql, param);

	}

}
