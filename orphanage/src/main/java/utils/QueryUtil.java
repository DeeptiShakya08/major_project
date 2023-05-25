package utils;

public class QueryUtil {

	public static final String ADD_CHILD_QUERY = "insert into m_orphanage_children values(?,?,?,?,?,?,?)";

	public static final String GET_CHILDS_QUERY = "select name,dob,hair_colour, gender ,child_pid ,image_url,doj, adation_request,adaptor_mail from m_orphanage_children";
	public static final String DELETE_CHILD_QUERY = "delete from m_orphanage_children where child_pid = ?";
}