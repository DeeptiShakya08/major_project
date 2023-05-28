package utils;

public class QueryUtil {

	public static final String ADD_CHILD_QUERY = "insert into m_orphanage_children values(?,?,?,?,?,?,?,?)";
	public static final String GET_CHILDS_QUERY = "select name,dob,hair_colour, gender ,child_pid ,image_url,doj, adation_request from m_orphanage_children";
	public static final String DELETE_CHILD_QUERY = "delete from m_orphanage_children where child_pid = ?";
	public static final String REGISTER_USER_QUERY = "insert into m_orphanage_users (name ,email,password, phone_no, type) values(?,?,?,?,?)";
	public static final String USER_AUTH_QUERY = "select name from m_orphanage_users where email = ? and password = ? and type = ?";
	public static final String SET_DONATION_QUERY = "insert into m_orphanage_donation (donor_name, donor_email, donor_address,donation_item, no_of_items, message) values(?,?,?,?,?,?)";
	public static final String GET_ITEM_QUERY = "select donation_item,no_of_items from m_orphanage_donation where donor_email = ?";
	public static final String ADOPT_REQUEST_QUERY = "update m_orphanage_children set adation_request = true ,adaptor_mail = ? where child_pid = ?";
	public static final String ADD_ADOPTION_QUERY = "insert into m_orphan_adoption (child_name,adoptor_name,child_doa,adoptor_email,adoptor_address,child_id,adoption_status) values (?,?,?,?,?,?,?)";
	public static final String REQ_ADOPTION_CHILD_QUERY = "select name,dob,gender,child_pid,doj,adaptor_mail from m_orphanage_children where adation_request = true and is_adopted = false";
	public static final String SET_ADOPTION_QUERY = "update m_orphan_adoption set adoption_status = 'done' where child_id = ?";
	public static final String SET_ADOPTION_CHILD_QUERY = "update m_orphanage_children set is_adopted = true where child_pid = ?";
	public static final String GET_RESPONSE_CHILD_QUERY = "select child_name, child_id, child_doa, adoptor_name, adoption_status from m_orphan_adoption where adoptor_email = ?";
	public static final String GET_ADOPTED_CHILDS_QUERY = "select name,dob,hair_colour, gender ,child_pid ,image_url,doj, adation_request,adaptor_mail from m_orphanage_children where is_adopted = true";
	public static final String GET_USER_DETAILS_QUERY = "select name,email,phone_no from m_orphanage_users where type = ?";
	public static final String GET_CHILDS_FOR_ADOPTION_QUERY = "select name,dob,hair_colour, gender ,child_pid ,image_url,doj, adation_request from m_orphanage_children where is_adopted = false";
	public static final String ADD_EVENT_QUERY = "insert into m_orphanage_events ( event_name, event_image_url, volunteer, participants, event_description,event_date) values (?,?,?,?,?,?)";
	public static final String GET_EVENTS_QUERY = "select event_name,event_image_url,event_description,event_date from m_orphanage_events where event_date <= ?";
	public static final String ADD_TICKET_QUERY = "insert into t_orphanage_tickets (name, email, eventname, ticket_quantity, pay_method, ticket_id ,ticket_date) values (?,?,?,?,?,?,?)";
	public static final String GET_TICKET_QUERY = "select name, email, eventname, ticket_quantity, pay_method, ticket_id ,ticket_date from t_orphanage_tickets";
}