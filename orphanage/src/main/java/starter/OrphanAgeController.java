package starter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import adaption.AdaptionDao;
import adaption.AdoptionReqBean;
import adaption.AdoptionResBean;
import adaption.AdoptionResponseBean;
import childcrud.AddChildBean;
import childcrud.ChildCRUDDao;
import childcrud.ViewChildBean;
import donation.DonationBean;
import donation.DonationDao;
import donation.DonationItemBean;
import events.EventBean;
import events.EventService;
import events.EventsDao;
import register.RegisterBean;
import register.RegisterDao;
import register.UserDetailBean;
import ticket.TicketDao;
import ticket.TicketReqBean;
import utils.CacheUtil;
import utils.MailSender;

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
		return "TicketRegister";
	}

	@RequestMapping("/RegisterChild")
	public String getRegister() {
		return "RegisterChild";
	}

	@RequestMapping("RegisterChildDetail")
	public String getChild(AddChildBean child, Model model) {
		ChildCRUDDao.addChildToDb(child);
		model.addAttribute("action", "Child Registered Successfully!");
		return "success";
	}

	@RequestMapping("GetChildsForAdoption")
	public String getChildsForAdaption(Model model) {
		List<ViewChildBean> data = ChildCRUDDao.getChildForAdaption();
		model.addAttribute("data", data);
		return "ViewChilds";
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
		model.addAttribute("action", "child deleted successfully!");
		return "success";
	}

	@RequestMapping("/DeleteForm")
	public String deleteForm() {
		return "DeleteChild";
	}

	@RequestMapping("/registration")
	public String registration() {
		return "RegistrationForm";
	}

	@RequestMapping("/DonorLogin")
	public String donorLogin() {
		return "DonorLogin";
	}

	@RequestMapping("/DonorRegistration")
	public String donorRegistration() {
		return "DonorRegistration";
	}

	@RequestMapping("/AdoptorLogin")
	public String adaptorLogin() {
		System.out.println("adoptor login");
		return "AdoptorLogin";
	}

	@RequestMapping("/AdoptorRegister")
	public String adaptorRegister() {
		return "AdoptorRegister";
	}

	@RequestMapping("/RegisterDonor")
	public String donorAuth(RegisterBean donor) {
		RegisterDao.registerUser(donor, "Donor");
		return "home";
	}

	@RequestMapping("AdminAuth")
	public String adminAuth(String email, String password, Model model) {
		if (email.equals("deepshakya609@gmail.com") && password.equals("12345")) {
			return "AdminFeatures";
		}
		model.addAttribute("errorMessage", "Credentials not matched try again");
		return "AdminLogin";
	}

	@RequestMapping("/RegisterAdopter")
	public String donorRegister(RegisterBean adopter) {
		System.out.println("Regerstering adopter");
		RegisterDao.registerUser(adopter, "Adoptor");
		return "home";
	}

	@RequestMapping("/AdopterAuth")
	public String adoptorAuth(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {
		System.out.println("adopter auth");
		String name = RegisterDao.authUser(email, password, "Adoptor");
		System.out.println("name from auth = " + name);
		if (name == null || name.length() <= 0) {
			model.addAttribute("errorMessage", "Credentials not matched try again");
			return "AdoptorLogin";
		}
		CacheUtil.setAdoptorMail(email);
		CacheUtil.setAdoptorPassword(password);
		return "AdoptionPage";
	}

	@RequestMapping("/DonorAuth")
	public String donorAuth(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {
		String name = RegisterDao.authUser(email, password, "Donor");
		if (name == null || name.length() <= 0) {
			model.addAttribute("errorMessage", "Credentials not matched try again");
			return "DonorLogin";
		}
		CacheUtil.setDonorMail(email);
		return "DonationPage";
	}

	@RequestMapping("/DonationForm")
	public String donationForm() {
		return "DonationForm";
	}

	@RequestMapping("/Donation")
	public String donation(DonationBean donation, Model model) {
		System.out.println(donation);
		if (!donation.getEmail().equals(CacheUtil.getDonorMail())) {
			model.addAttribute("errorMessage", "Email not matched please enter correct one");
			return "DonationForm";
		}
		DonationDao.setDonateItem(donation);
		model.addAttribute("action", "Donation successfully");
		return "success";
	}

	@RequestMapping("/ViewDonation")
	public String viewDonation(Model model) {
		System.out.println("Donor mail = " + CacheUtil.getDonorMail());
		List<DonationItemBean> data = DonationDao.getDonationItem(CacheUtil.getDonorMail());
		if (data.size() == 0) {
			model.addAttribute("errorMessage", "Nothing to show");
		}
		model.addAttribute("data", data);
		return "ViewDonation";
	}

	@RequestMapping("AdoptChildForm")
	public String adoptChildForm() {
		return "AdoptChildForm";
	}

	@RequestMapping("RequestAdoption")
	public String requestAdotpion(AdoptionReqBean request, Model model) {
		AdaptionDao.adoptRequest(request);
		model.addAttribute("action", "Adoption requested successfully");
		return "success";
	}

	@RequestMapping("ViewRequest")
	public String viewRequest(Model model) {
		List<AdoptionResBean> data = AdaptionDao.getRequestedChilds();
		model.addAttribute("data", data);
		return "ViewRequest";
	}

	@RequestMapping("ResponseAdaption")
	public String responseAdaption(@RequestParam("childIds") String[] childIds) {
		AdaptionDao.setAddaption(childIds);
		return "success";
	}

	@RequestMapping("AdoptionStatus")
	public String adoptionStatus(Model model) {
		List<AdoptionResponseBean> data = AdaptionDao.getResponseChild(CacheUtil.getAdoptorMail());
		if (data.size() == 0) {
			model.addAttribute("errorMessage", "Nothing to show");
		}
		model.addAttribute("data", data);
		return "AdoptionResponse";
	}

	@RequestMapping("GetAdoptedChild")
	public String getAdopted(Model model) {
		List<ViewChildBean> data = ChildCRUDDao.getAddptedChild();
		model.addAttribute("data", data);
		return "AdoptedChilds";
	}

	@RequestMapping("GetDonors")
	public String getDonors(Model model) {
		List<UserDetailBean> data = RegisterDao.getUserDetail("Donor");
		model.addAttribute("user", "Donor details");
		model.addAttribute("data", data);
		return "UserDetails";
	}

	@RequestMapping("GetAdoptors")
	public String getAdoptors(Model model) {
		List<UserDetailBean> data = RegisterDao.getUserDetail("Adoptor");
		model.addAttribute("user", "Adoptor details");
		model.addAttribute("data", data);
		return "UserDetails";
	}

	@RequestMapping("Image")
	public String image() {
		return "Image";
	}

	@RequestMapping("AboutUs")
	public String aboutUs() {
		return "AboutUs";
	}

	@PostMapping("/GetImage")
	static String saveImage(@RequestParam("image") MultipartFile image, @RequestParam("name") String name) {
		System.out.println("name = " + name);
		System.out.println("image name = " + image.getOriginalFilename().toString());
		String folder = "src/main/resources/static/images";
		try {
			byte[] bytes = image.getBytes();
			Path directoryPath = Paths.get(folder);
			if (!Files.exists(directoryPath)) {
				Files.createDirectories(directoryPath);
			}
			Path filePath = directoryPath.resolve(image.getOriginalFilename());
			Files.write(filePath, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@RequestMapping("AddEvent")
	public String addEvent(EventBean event, Model model) {
		EventService.processEvent(event);
		System.out.println("processing event");
		model.addAttribute("action", "Event addedd successfully");
		return "success";
	}

	@RequestMapping("EventForm")
	public String eventForm() {
		return "AddEvent";
	}

	@RequestMapping("GetEvents")
	public String getEvents(Model model) {
		System.out.println("getting events");
		List<EventBean> events = EventsDao.getAllEvents();
		for (EventBean bean : events) {
			System.out.println(bean.toString());
		}
		model.addAttribute("events", events);
		return "ViewEvent";
	}

	@RequestMapping("BookTicket")
	public String bookTicket(TicketReqBean ticket, Model model) {
		String ticketNo = TicketDao.bookTiket(ticket);
		model.addAttribute("action", "Ticket booked successfully with ticket no" + ticketNo);
		return "success";
	}

	@RequestMapping("GetTicket")
	public String getTickets(Model model) {
		List<TicketReqBean> tickets = TicketDao.getTickets();
		if (tickets.size() == 0) {
			model.addAttribute("errorMessage", "Nothing to show");
			return "ViewTickets";
		}
		model.addAttribute("data", tickets);
		return "ViewTickets";
	}

	@RequestMapping("VolunteerPage")
	public String volunteerPage() {
		return "VolunteerPage";
	}

	@RequestMapping("VolunteerLoginForm")
	public String volunteerForm() {
		return "VolunteerLogin";
	}

	@RequestMapping("VolunteerRegisterForm")
	public String volunteerRegisterForm() {
		return "VolunteerRegister";
	}

	@RequestMapping("VolunteerAuth")
	public String volunteerAuth(String email, String password) {
		RegisterDao.authUser(email, password, "Volunteer");
		return "VolunteerPage";
	}

	@RequestMapping("VolunteerRegistration")
	public String volunteerRegister(RegisterBean volunteer, Model model) {
		RegisterDao.registerUser(volunteer, "Volunteer");
		model.addAttribute("action", "Volunteer Registered Successfulyy");
		return "success";
	}

	@RequestMapping("ContactUsAdmin")
	public String contactData(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("msg") String msg, Model model) {
		MailSender.sendMail("Contact from " + name, msg, "deepshakya609@gmail.com");
		model.addAttribute("action", "Contacted sucessfully");
		return "success";
	}

	@RequestMapping("ViewVolunteer")
	public String viewVolunteer(Model model) {
		List<UserDetailBean> data = RegisterDao.getUserDetail("Volunteer");
		model.addAttribute("user", "Volunteer details");
		model.addAttribute("data", data);
		return "UserDetails";
	}
}
