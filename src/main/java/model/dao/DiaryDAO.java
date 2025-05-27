package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.DiaryBean;

public class DiaryDAO {
	
	
	public List<DiaryBean> selectAll() throws SQLException, ClassNotFoundException {
		List<DiaryBean> diaryList = new ArrayList<DiaryBean>();
		
		String sql = "select * from diary";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet rs =  pstmt.executeQuery();
			
			while(rs.next()) {
				DiaryBean diary = new DiaryBean();
				
				diary.setId(rs.getInt("id"));
				diary.setTitle(rs.getString("title"));
				diary.setContent(rs.getString("content"));
				diary.setCreatedAt(rs.getDate("created_at"));
				
				diaryList.add(diary);
			}
			
			return diaryList;
		}
	}
	
	public DiaryBean select(int id) throws SQLException, ClassNotFoundException {
		DiaryBean diary = new DiaryBean();
//		String sql = "select * from diary where id = ?";
		String sql = "select t1.id, t1.title, t1.content, t1.created_at, t1.category_id, t2.category_name "
				+ "from diary t1 inner join category t2 on t1.category_id = t2.category_id where t1.id = ?";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				diary.setId(rs.getInt("id"));
				diary.setTitle(rs.getString("title"));
				diary.setContent(rs.getString("content"));
				diary.setCreatedAt(rs.getDate("created_at"));
				diary.setCategoryId(rs.getInt("category_id"));
				diary.setCategoryName(rs.getString("category_name"));
			}
			
		}
		
		return diary;
	}
	
	public int update(DiaryBean diary) throws SQLException, ClassNotFoundException {
		String sql = "update diary set title=?, content=?, created_at=? where id=?";
		int count = 0;
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, diary.getTitle());
			pstmt.setString(2, diary.getContent());
			pstmt.setDate(3, diary.getCreatedAt());
			pstmt.setInt(4, diary.getId());
			count = pstmt.executeUpdate();
			
			
		}
		return count;
	}
	
	public List<DiaryBean> getCategoryList() throws SQLException, ClassNotFoundException {
		String sql = "select * from category";
		List<DiaryBean> categoryList = new ArrayList<DiaryBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next() ) {
				DiaryBean category = new DiaryBean();
				
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				
				categoryList.add(category);
			}
		}
		return categoryList;
	}

}
