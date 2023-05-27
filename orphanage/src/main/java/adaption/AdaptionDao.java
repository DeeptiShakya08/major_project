package adaption;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.CloseResources;
import utils.DBConnection;
import utils.QueryUtil;

public class AdaptionDao {
	public static void adoptRequest(AdoptionReqBean adoptor) {
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm1 = null, pdsm2 = null;
		int cnt = 1;
		try {
			System.out.println("adopting request start");
			pdsm1 = con.prepareStatement(QueryUtil.ADOPT_REQUEST_QUERY);
			pdsm1.setString(1, adoptor.getEmail());
			pdsm1.setString(2, adoptor.getChildId());
			pdsm1.execute();
			pdsm2 = con.prepareStatement(QueryUtil.ADD_ADOPTION_QUERY);
			pdsm2.setString(cnt++, adoptor.getChildName());
			pdsm2.setString(cnt++, adoptor.getName());
			pdsm2.setDate(cnt++, new Date(System.currentTimeMillis()));
			pdsm2.setString(cnt++, adoptor.getEmail());
			pdsm2.setString(cnt++, adoptor.getAddress());
			pdsm2.setString(cnt++, adoptor.getChildId());
			pdsm2.setString(cnt++, "requested");
			pdsm2.execute();
			System.out.println("adopting requested successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, pdsm1);
			if (pdsm2 != null) {
				try {
					pdsm2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static List<AdoptionResBean> getRequestedChilds() {
		List<AdoptionResBean> result = new ArrayList<>();
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		ResultSet rs = null;
		try {
			pdsm = con.prepareStatement(QueryUtil.REQ_ADOPTION_CHILD_QUERY);
			rs = pdsm.executeQuery();
			while (rs.next()) {
				AdoptionResBean bean = new AdoptionResBean();
				bean.setName(rs.getString("name"));
				bean.setDob(rs.getDate("dob"));
				bean.setGender(rs.getString("gender"));
				bean.setChildId(rs.getString("child_pid"));
				bean.setDoj(rs.getDate("doj"));
				bean.setAdoptorMail(rs.getString("adaptor_mail"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, rs, pdsm);
		}
		return result;
	}
	public static void setAddaption(String[] childIds) {
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm1 = null, pdsm2 = null;
		try {
			for (String childId : childIds) {
				pdsm1 = con.prepareStatement(QueryUtil.SET_ADOPTION_QUERY);
				pdsm1.setString(1, childId);
				pdsm1.execute();
				pdsm2 = con.prepareStatement(QueryUtil.SET_ADOPTION_CHILD_QUERY);
				pdsm2.setString(1, childId);
				pdsm2.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, pdsm1);
			if (pdsm2 != null) {
				try {
					pdsm2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static List<AdoptionResponseBean> getResponseChild(String mail) {
		List<AdoptionResponseBean> result = new ArrayList<>();
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		ResultSet rs = null;
		try {
			System.out.println("Getting childs");
			pdsm = con.prepareStatement(QueryUtil.GET_RESPONSE_CHILD_QUERY);
			pdsm.setString(1, mail);
			rs = pdsm.executeQuery();
			while (rs.next()) {
				AdoptionResponseBean bean = new AdoptionResponseBean();
				bean.setName(rs.getString("child_name"));
				bean.setChildId(rs.getString("child_Id"));
				bean.setAdoptorName(rs.getString("adoptor_name"));
				bean.setDor(rs.getDate("child_doa"));
				bean.setAdoptionStatus(rs.getString("adoption_status"));
				result.add(bean);
			}
			System.out.println("Getting childs completed");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, rs, pdsm);
		}
		return result;
	}

}
