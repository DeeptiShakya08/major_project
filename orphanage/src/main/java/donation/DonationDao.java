package donation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.CloseResources;
import utils.DBConnection;
import utils.QueryUtil;

public class DonationDao {
	public static void setDonateItem(DonationBean donation) {
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		try {
			int cnt = 1;
			System.out.println("start donating");
			pdsm = con.prepareStatement(QueryUtil.SET_DONATION_QUERY);
//			donor_name, donor_email, donor_address, no_of_items, message
			pdsm.setString(cnt++, donation.getName());
			pdsm.setString(cnt++, donation.getEmail());
			pdsm.setString(cnt++, donation.getAddress());
			pdsm.setString(cnt++, donation.getItemName());
			pdsm.setInt(cnt++, donation.getAmountOrNoOfItems());
			pdsm.setString(cnt++, donation.getMessage());
			pdsm.execute();
			System.out.println("done donation");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, pdsm);
		}
	}

	public static List<DonationItemBean> getDonationItem(String email) {
		List<DonationItemBean> resultList = new ArrayList<>();

		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		ResultSet rs = null;
		try {
			System.out.println("Geting donating items");
			pdsm = con.prepareStatement(QueryUtil.GET_ITEM_QUERY);
			pdsm.setString(1, email);
			rs = pdsm.executeQuery();
			while (rs.next()) {
				DonationItemBean result = new DonationItemBean();
				result.setDonationItem(rs.getString(1));
				result.setNoOfItemOrAmount(rs.getInt(2));
				resultList.add(result);
			}
			System.out.println("Donated items fetched successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, rs, pdsm);
		}
		return resultList;

	}
}
