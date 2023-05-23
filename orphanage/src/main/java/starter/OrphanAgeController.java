package starter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
		
    @RequestMapping("/Event")
    public String event() {
    	return "Event";
   
	}
	
}

