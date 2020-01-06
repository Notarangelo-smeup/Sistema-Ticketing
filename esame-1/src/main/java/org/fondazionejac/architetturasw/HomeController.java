package org.fondazionejac.architetturasw;

import javax.validation.Valid;

import org.fondazionejac.architetturasw.entities.BaseTicket;
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

	@Value("${spring.application.name}")
	String appName;

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("appName", appName);
		return "home";
	}

	@RequestMapping(value = "/print", method = RequestMethod.POST)
	public String printFormAttribute(@Valid @ModelAttribute("form") BaseTicket bt, BindingResult result) {

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
