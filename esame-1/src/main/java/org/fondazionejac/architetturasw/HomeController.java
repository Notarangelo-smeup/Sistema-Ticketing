package org.fondazionejac.architetturasw;

import java.util.List;

import org.fondazionejac.architetturasw.dao.TicketDao;
import org.fondazionejac.architetturasw.entities.BaseTicket;
import org.fondazionejac.architetturasw.entities.TicketGenerico;
import org.fondazionejac.architetturasw.entities.TicketSoftware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	TicketDao dao = new TicketDao();

	@GetMapping("/")
	public String homePage(Model model) {
		return "home";
	}

	@PostMapping("/printGenerico")
	public String printFormAttribute(@ModelAttribute("form") TicketGenerico bt) {

		dao.creaTicket(bt);
		return "home";
	}

	@PostMapping("/printSoftware")
	public String printFormAttribute(@ModelAttribute("form") TicketSoftware bt) {

		dao.creaTicket(bt);
		return "home";
	}

	@PostMapping("/tipo")
	public String dispatch(@RequestParam String tipo, @RequestParam String cliente, Model model) {

		model.addAttribute("cliente", cliente);

		if (tipo.equals("Generico"))
			return "generico";

		return "software";
	}

	@GetMapping("/lista")
	public String stampaTicket(Model model) {

		List<BaseTicket> tickets = dao.findAll();
		model.addAttribute("tickets", tickets);

		return "lista";
	}

	@GetMapping("/modifica/details{id}")
	public String modificaTicket(Model model, @RequestParam("id") String id) {

		int intID = Integer.parseInt(id);
		BaseTicket ticket = dao.findById(intID);
		
		String type = (ticket.getDtype().equals("Generico"))? "TicketGenerico" : "TicketSoftware";
		
		model.addAttribute(type, ticket);

		switch (ticket.getDtype()) {

		case "Generico":
			return "modificaGen";
		case "Software":
			return "modificaSof";

		}
		return "lista";
	}
	
	@PostMapping("/updateGen")
	public String updateGen(@ModelAttribute("form") TicketGenerico bt) {

		dao.update(bt);
		return "home";
	}
	
	@PostMapping("/updateSof")
	public String updateSof(@ModelAttribute("form") TicketSoftware bt) {

		dao.update(bt);
		return "home";
	}

}
