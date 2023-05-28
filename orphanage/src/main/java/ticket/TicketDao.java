package ticket;

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

public class TicketDao {

	public static String bookTiket(TicketReqBean ticket) {
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		String ticketId = UUID.randomUUID().toString();
		try {
			System.out.println("Adding ticket details in db");
			int cnt = 1;
//			name, email, eventname, ticket_quantity, pay_method, ticket_id ,ticket_date
//			
			pdsm = con.prepareStatement(QueryUtil.ADD_TICKET_QUERY);
			pdsm.setString(cnt++, ticket.getName());
			System.out.println(" name = "+ticket.getName());
			pdsm.setString(cnt++, ticket.getEmail());
			System.out.println("Ticket mail"+ticket.getEmail());
			pdsm.setString(cnt++, ticket.getEventName());
			System.out.println("Event name"+ticket.getEventName());
			pdsm.setInt(cnt++, ticket.getNoOfTickets());
			System.out.println("No of ticket"+ticket.getNoOfTickets());
			pdsm.setString(cnt++, ticket.getPayMethod());
			System.out.println("pay method = "+ticket.getPayMethod());
			pdsm.setString(cnt++, ticketId);
			System.out.println("ticket id = "+ticketId);
			pdsm.setDate(cnt++, new Date(System.currentTimeMillis()));
			pdsm.execute();
			System.out.println("Ticket details added successfully in Db");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, pdsm);
		}
		return ticketId;
	}

	public static List<TicketReqBean> getTickets() {
		Connection con = DBConnection.createConnection();
		PreparedStatement pdsm = null;
		ResultSet rs = null;
		List<TicketReqBean> tickets = new ArrayList<>();
		try {
			pdsm = con.prepareStatement(QueryUtil.GET_TICKET_QUERY);
			rs = pdsm.executeQuery();
			System.out.println("Getting tickets");
			while (rs.next()) {
				TicketReqBean ticket = new TicketReqBean();
				ticket.setName(rs.getString("name"));
				ticket.setEmail(rs.getString("email"));
				ticket.setEventName(rs.getString("eventname"));
				ticket.setNoOfTickets(rs.getInt("ticket_quantity"));
				ticket.setPayMethod(rs.getString("pay_method"));
				ticket.setTicketId(rs.getString("ticket_id"));
				ticket.setTicketDate(rs.getDate("ticket_date"));
				tickets.add(ticket);
			}
			System.out.println("Ticket gets success");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseResources.close(con, rs, pdsm);
		}
		return tickets;
	}

}
