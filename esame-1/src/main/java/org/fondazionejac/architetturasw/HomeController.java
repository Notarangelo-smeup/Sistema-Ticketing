package org.fondazionejac.architetturasw;

import java.util.List;

import org.fondazionejac.architetturasw.dao.TicketDao;
import org.fondazionejac.architetturasw.entities.BaseTicket;
import org.fondazionejac.architetturasw.entities.TicketGenerico;
import org.fondazionejac.architetturasw.entities.TicketSoftware;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String inserisciTicektGen(@ModelAttribute("form") TicketGenerico bt) {

		dao.creaTicket(bt);
		return "home";
	}

	@PostMapping("/printSoftware")
	public String inserisciTicketSof(@ModelAttribute("form") TicketSoftware bt) {

		dao.creaTicket(bt);
		return "home";
	}

	@PostMapping("/tipo")
	public String dispatch(@RequestParam String tipo, @RequestParam String cliente, Model model) {

		model.addAttribute("cliente", cliente);

		if (tipo.equals("Generico"))
			return "ins_gen";

		return "ins_sof";
	}

	@GetMapping("/lista")
	public String stampaLista() {

		return "ListaVero";
	}

	@GetMapping("/modifica/details{id}")
	public String modificaTicket(Model model, @RequestParam int id) {

		BaseTicket ticket = dao.findById(id);

		String type = (ticket.getDtype().equals("Generico")) ? "TicketGenerico" : "TicketSoftware";

		System.out.println(ticket);
		model.addAttribute(type, ticket);

		switch (ticket.getDtype()) {

		case "Generico":
			return "mod_gen";
		case "Software":
			return "mod_sof";

		}
		return "lista";
	}

	@PostMapping("/updateGen")
	public String updateGen(@ModelAttribute("form") TicketGenerico bt) {

		dao.update(bt);
		return "ListaVero";
	}

	@PostMapping("/updateSof")
	public String updateSof(@ModelAttribute("form") TicketSoftware bt) {

		dao.update(bt);
		return "ListaVero";
	}

}
