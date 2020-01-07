package org.fondazionejac.architetturasw;

import javax.validation.Valid;

import org.fondazionejac.architetturasw.dao.TicketDao;
import org.fondazionejac.architetturasw.entities.TicketGenerico;
import org.fondazionejac.architetturasw.entities.TicketSoftware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	TicketDao dao = new TicketDao();
	
	@Value("${spring.application.name}")
	String appName;

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("appName", appName);
		return "home";
	}

	@RequestMapping(value = "/printGenerico", method = RequestMethod.POST)
	public String printFormAttribute(@Valid @ModelAttribute("form") TicketGenerico bt, BindingResult result) {
		
		System.out.println(bt.toString() + "ciaos");
		dao.creaTicket(bt);
		
		
		return "home";
	}
	
	@RequestMapping(value = "/printSoftware", method = RequestMethod.POST)
	public String printFormAttribute(@Valid @ModelAttribute("form") TicketSoftware bt, BindingResult result) {

		dao.creaTicket(bt);
		
		System.out.println(bt.toString());
		return "home";
	}

	@RequestMapping(value = "/tipo", method = RequestMethod.POST)
	public String dispatch(@ModelAttribute("form") String form, @RequestParam String tipo, BindingResult result) {

				
		if (tipo.equals("Generico"))
			return "generico";

		return "software";
	}
}
