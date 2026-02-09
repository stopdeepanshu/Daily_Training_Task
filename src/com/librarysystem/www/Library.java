package com.librarysystem.www;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Library {

	public static void addMember(Member member) throws SQLException {
		String memName = member.getMemberName();
		int memId = member.getMemberId();
		String memAdd = member.getMemberAddress();

		String query = "Insert into member values(?,?,?)";
		PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(query);

		pstmt.setInt(1, memId);
		pstmt.setString(2, memName);
		pstmt.setString(3, memAdd);

		// System.out.println(!pstmt.execute());

		pstmt.execute();

	}

	public static boolean deleteMember(int id) throws SQLException {

		String query = "delete from member where member_id=?";
		PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(query);

		pstmt.setInt(1, id);
		int rows = pstmt.executeUpdate();

		return rows > 0;
	}

}
