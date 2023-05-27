package events;

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

public class EventsDao {

	public static void addEvent(EventBean event) {
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		try {
			int cnt = 1;
			pdsm = con.prepareStatement(QueryUtil.ADD_EVENT_QUERY);
			pdsm.setString(cnt++, event.getEventName());
			pdsm.setString(cnt++, event.getImageURL().getOriginalFilename());
			pdsm.setString(cnt++, event.getVolunteerName());
			pdsm.setInt(cnt++, event.getNoParticipants());
			pdsm.setString(cnt++, event.getDesc());
			pdsm.setDate(cnt++, new Date(System.currentTimeMillis()));
			pdsm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, pdsm);
		}
	}

	public static List<EventBean> getAllEvents() {
		List<EventBean> result = new ArrayList<>();
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		ResultSet rs = null;
		try {
			pdsm = con.prepareStatement(QueryUtil.GET_EVENTS_QUERY);
			pdsm.setDate(1, new Date(System.currentTimeMillis()));
			rs = pdsm.executeQuery();
			while (rs.next()) {
				EventBean event = new EventBean();
				event.setEventName(rs.getString("event_name"));
				event.setUrl("/images/"+rs.getString("event_image_url"));
				event.setDesc(rs.getString("event_description"));
				event.setEventDate(rs.getDate("event_date"));
				result.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, rs, pdsm);
		}
		return result;
	}

}
