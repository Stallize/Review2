package review.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import review.beans.Book;

public class BookUtils {
	 public static List<Book> queryProduct(Connection conn) throws SQLException {
	       String sql = "Select * from Book a ";
	       PreparedStatement pstm = conn.prepareStatement(sql);
	       ResultSet rs = pstm.executeQuery();
	       List<Book> list = new ArrayList<Book>();
	       while (rs.next()) {
	    	   String BookId = rs.getString("BookId");
	    	   String Title = rs.getString("Title");
	    	   String Author = rs.getString("Author");
	    	   int Release = rs.getInt("Release");
	    	   float Price = rs.getFloat("Price");
	    	   String Picture = rs.getString("Picture");
	    	   int PublisherId = rs.getInt("PublisherId");
	    	   int CategoryId = rs.getInt("CategoryId");
	           Book book = new Book();
	    	   book.setBookId(BookId);
	    	   book.setTitle(Title);
	    	   book.setAuthor(Author);
	    	   book.setRelease(Release);
	    	   book.setPrice(Price);
	    	   book.setPicture(Picture);
	    	   book.setPublisherId(PublisherId);
	    	   book.setCategoryId(CategoryId);
	           list.add(book);
	       }
	       return list;
	   }
	 	public static Book findBook(Connection conn, String BookId) throws SQLException{
	 		String sql = "Select a.BookId, a.Title, a.Author, a.Release, a.Price, a.Picture, a.PublisherId, a.CategoryId from Book a where a.BookId=?";
	 		PreparedStatement pstm = conn.prepareStatement(sql);
	 		pstm.setString(1, BookId);
	 		ResultSet rs = pstm.executeQuery();
	 		while (rs.next()) {
		    	   String Title = rs.getString("Title");
		    	   String Author = rs.getString("Author");
		    	   int Release = rs.getInt("Release");
		    	   float Price = rs.getFloat("Price");
		    	   String Picture = rs.getString("Picture");
		    	   int PublisherId = rs.getInt("PublisherId");
		    	   int CategoryId = rs.getInt("CategoryId");
		    	   Book book = new Book(BookId, Title, Author, Release, Price, Picture, PublisherId, CategoryId);
		    	   return book;
	 			
	 		}
	 		return null;
	 		
	 	}
	 
		public static void insertBook(Connection conn,Book book) throws SQLException {
			String sql = "Insert into Book(BookId, Title, Author, Release, Price, Picture, PublisherId, CategoryId) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, book.getBookId());
			pstm.setString(2, book.getTitle());
			pstm.setString(3, book.getAuthor());
			pstm.setInt(4, book.getRelease());
			pstm.setFloat(5, book.getPrice());
			pstm.setString(6, book.getPicture());
			pstm.setInt(7, book.getPublisherId());
			pstm.setInt(8, book.getCategoryId());
			pstm.executeUpdate();
		}

		public static void updateBook(Connection conn,Book book) throws SQLException {
			String sql = "Update Book set  Title=?, Author=?, Release=?, Price=?, Picture=?, PublisherId=?, CategoryId=? where BookId=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, book.getBookId());
			pstm.setString(2, book.getTitle());
			pstm.setString(3, book.getAuthor());
			pstm.setInt(4, book.getRelease());
			pstm.setFloat(5, book.getPrice());
			pstm.setString(6, book.getPicture());
			pstm.setInt(7, book.getPublisherId());
			pstm.setInt(8, book.getCategoryId());
			pstm.executeUpdate();
		}
		
		
		
		public static void deleteBook(Connection conn, String  BookId) throws SQLException {
			String sql = "Delete From Book Where BookId= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, BookId);
			pstm.executeUpdate();
		}
		
	
}
