package utils;
/* name         | varchar(20) | YES  |     | NULL    |       |
| dob          | date        | YES  |     | NULL    |       |
| hair_colour  | varchar(10) | YES  |     | NULL    |       |
| gender       | varchar(10) | YES  |     | NULL    |       |
| child_pid    | varchar(10) | YES  |     | NULL    |       |
| image_url    | varchar(50) | YES  |     | NULL    |       |
| doj          | date        | YES  |     | NULL    |       |
| adoption_req*/

public class QueryUtil {

	public static final String ADD_CHILD_QUERY = "insert into m_orphanage_children values(?,?,?,?,?,?,?,?)";

	public static final String GET_CHILDS_QUERY = "select name,dob,hair_colour, gender ,child_pid ,image_url,doj, adoption_request from m_orphanage_children";
	public static final String DELETE_CHILD_QUERY = "delete from m_orphanage_children where child_pid = ?";
}