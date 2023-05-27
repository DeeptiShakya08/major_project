package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.CloseResources;
import utils.DBConnection;
import utils.QueryUtil;

public class RegisterDao {
	public static void registerUser(RegisterBean user, String type) {
		user.setType(type);
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		try {
			int cnt = 1;
//		name ,emial,password, phone_no, type
			pdsm = con.prepareStatement(QueryUtil.REGISTER_USER_QUERY);
			pdsm.setString(cnt++, user.getName());
			pdsm.setString(cnt++, user.getEmail());
			pdsm.setString(cnt++, user.getcPassword());
			pdsm.setString(cnt++, user.getPhoneNo());
			pdsm.setString(cnt++, user.getType());
			pdsm.execute();
			System.out.println("donoe registered sucessfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, pdsm);
		}
	}

	public static String authUser(String email, String password, String type) {
		String name = "";
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		ResultSet rs = null;
		try {
			pdsm = con.prepareStatement(QueryUtil.USER_AUTH_QUERY);
			pdsm.setString(1, email);
			pdsm.setString(2, password);
			pdsm.setString(3, type);
			rs = pdsm.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
			}
			System.out.println("name from db = " + name);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "";
		} finally {
			CloseResources.close(con, rs, pdsm);
		}
		return name;
	}

	public static  List<UserDetailBean> getUserDetail(String type) {
		List<UserDetailBean> result = new ArrayList<UserDetailBean>();
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		ResultSet rs = null;
		try {
			pdsm = con.prepareStatement(QueryUtil.GET_USER_DETAILS_QUERY);
			pdsm.setString(1, type);
			rs = pdsm.executeQuery();
			while (rs.next()) {
				UserDetailBean bean = new UserDetailBean();
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPhoneNo(rs.getString("phone_no"));
				result.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseResources.close(con, rs, pdsm);
		}
		return result;
	}
}
