package starter;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import childcrud.AddChildBean;
import childcrud.ChildCRUDDao;
import childcrud.ViewChildBean;

@Controller
public class OrphanAgeController {

	@RequestMapping("/AdminLogin")
	public String login() {
		return "AdminLogin";
	}

	@RequestMapping("/DonarFeature")
	public String donarfeature() {
		return "DonorFeature";
	}

	@RequestMapping("/AdminFeatures")
	public String adminfeatures() {
		return "AdminFeatures";
	}

	@RequestMapping("/index")
	public String index() {
		return "home";
	}

	@RequestMapping("/DonationPage")
	public String donationpage() {
		return "DonationPage";
	}

	@RequestMapping("/AdoptionFeature")
	public String adoptionfeature() {
		return "AdoptionFeature";
	}

	@RequestMapping("/AdoptionPage")
	public String adoptionpage() {
		return "AdoptionPage";
	}

	@RequestMapping("/ContactUs")
	public String contactus() {
		return "ContactUs";
	}

	@RequestMapping("/Events")
	public String event() {
		return "Events";

	}

	@RequestMapping("/login")
	public String loginform() {
		return "login";
	}

	@RequestMapping("UpcomingEvents")
	public String upcomingEvent() {
		return "UpcomingEvents";
	}

	@RequestMapping("RegisterTicket")
	public String registerTicket() {
		return "RegisterandTickets";
	}

	@RequestMapping("/RegisterChild")
	public String getRegister() {
		return "RegisterChild";
	}

	@RequestMapping("RegisterChildDetail")
	public String getChild(AddChildBean child) {
		ChildCRUDDao.addChildToDb(child);
		return "index";
	}

	@RequestMapping("/GetChilds")
	public String getChilds(Model model) {
		List<ViewChildBean> data = ChildCRUDDao.getChilds();
		System.out.println(data.toString());
		model.addAttribute("data", data);
		return "ViewChilds";
	}

	@RequestMapping("/DeteteChild")
	public String delete(String childId, Model model) {
		ChildCRUDDao.deleteChild(childId);
		model.addAttribute("message", "child deleted successfully!");
		return "success";
	}

	@RequestMapping("/DeleteForm")
	public String deleteForm() {
		return "DeleteChild";
	}

}
