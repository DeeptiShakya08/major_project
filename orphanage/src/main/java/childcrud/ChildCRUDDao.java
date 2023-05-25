package childcrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import utils.CloseResources;
import utils.DBConnection;
import utils.QueryUtil;

public class ChildCRUDDao {
	public static void addChildToDb(AddChildBean child) {
		Date doj = new Date(System.currentTimeMillis());
		String childId = UUID.randomUUID().toString();
		Connection con = DBConnection.createConnection();
		int cnt = 1;
		PreparedStatement pdsm = null;
		try {
			pdsm = con.prepareStatement(QueryUtil.ADD_CHILD_QUERY);
			pdsm.setString(cnt++, child.getName());
			pdsm.setDate(cnt++, child.getDob());
			
			pdsm.setString(cnt++, child.getHairColour());
			pdsm.setString(cnt++, child.getGender());
			pdsm.setString(cnt++, childId);
			pdsm.setString(cnt++, null);
			pdsm.setDate(cnt++, doj);
			pdsm.setBoolean(cnt++,false);
			
			
			pdsm.execute();
			System.out.println("child added in db succesfully");
			/* name         | varchar(20) | YES  |     | NULL    |       |
| dob          | date        | YES  |     | NULL    |       |
| hair_colour  | varchar(10) | YES  |     | NULL    |       |
| gender       | varchar(10) | YES  |     | NULL    |       |
| child_pid    | varchar(10) | YES  |     | NULL    |       |
| image_url    | varchar(50) | YES  |     | NULL    |       |
| doj          | date        | YES  |     | NULL    |       |
| adoption_req*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, pdsm);
		}
	}

	public static List<ViewChildBean> getChilds() {
		List<ViewChildBean> childs = new ArrayList<ViewChildBean>();
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		ResultSet rs = null;
//		  ,child_pid ,image_url,
		try {
			pdsm = con.prepareStatement(QueryUtil.GET_CHILDS_QUERY);
			rs = pdsm.executeQuery();
			while (rs.next()) {
				ViewChildBean child = new ViewChildBean();
				child.setName(rs.getString("name"));
				System.out.println("name  = " + rs.getString("name"));
				child.setDob(rs.getDate("dob"));
				child.setDoj(rs.getDate("doj"));
				child.setAdaptionRequest(false);
//				child.setAdaptorMail(rs.getString("adaptor_mail"));
				child.setHairColour(rs.getString("hair_colour"));
				child.setGender(rs.getString("gender"));
				child.setChildId(rs.getString("child_pid"));
				System.out.println("childId = " + rs.getString("child_pid"));
				child.setImageUrl(null);
				childs.add(child);
				System.out.println("child displayed-==========>>>>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseResources.close(con, rs, pdsm);
		}
		return childs;
	}

	public static void deleteChild(String childId) {
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		try {
			pdsm = con.prepareStatement(QueryUtil.DELETE_CHILD_QUERY);
			pdsm.setString(1, childId);
			pdsm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
