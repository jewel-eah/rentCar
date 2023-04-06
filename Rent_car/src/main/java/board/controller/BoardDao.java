package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.DBManager;
import board.Board;
import board.BoardRequestDto;

public class BoardDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDao() {
	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getIstance() {
		return instance;
	}

	// c
	public void createBoard(BoardRequestDto boardDto) {
		Board board = new Board(boardDto);

		this.conn = DBManager.getConnection();
		if (this.conn != null) { 								// current_timestamp()
			String sql = "INSERT INTO board VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, board.getWriteCode());
				this.pstmt.setString(2, board.getWriter());
				this.pstmt.setString(3, board.getGrade());
				this.pstmt.setString(4, board.getTitle());
				this.pstmt.setString(5, board.getTitle());
				this.pstmt.setString(6, board.getText());
				this.pstmt.setString(7, board.getRegisteredDate());
				this.pstmt.setString(8, board.getModifiedDate());

				this.pstmt.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// r
	public ArrayList<Board> getBoardAll(){
		ArrayList<Board> list = new ArrayList<Board>();
		
		this.conn = DBManager.getConnection();
		
		if(this.conn != null) {
			String sql = "SELECT * FROM board ORDER BY modified_date";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int writeCode = this.rs.getInt(1);
					String writer = this.rs.getString(2);
					String grade = this.rs.getString(3);
					String title = this.rs.getString(4);
					String text = this.rs.getString(5);
					String subject = this.rs.getString(6);
					String registeredDate = this.rs.getString(7);
					String modifiedDate = this.rs.getString(8);
					
					Board board = new Board(writeCode, writer, grade, title, text, subject, registeredDate, modifiedDate);
					list.add(board);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	// u
	
	
	// d
}
