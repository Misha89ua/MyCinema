package ua.myCinema.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.myCinema.domain.FilmRequest;
import ua.myCinema.domain.HallRequest;
import ua.myCinema.domain.RegisterRequest;
import ua.myCinema.domain.RegisterRequest1;
import ua.myCinema.entity.Film;
import ua.myCinema.mapper.FilmMapper;
import ua.myCinema.mapper.HallMapper;
import ua.myCinema.mapper.UserMapper;
import ua.myCinema.service.FilmService;
import ua.myCinema.service.UserService;
import ua.myCinema.service.utils.TokenGenerator;

@Controller
public class BaseController {
	
	private String userEmail;
	
	@Autowired private UserService userService;
	@Autowired private FilmService filmService;
	
	@GetMapping({"/", "/home"})
	public String showHome(Model model) throws IOException {
		List<Film> films = filmService.showAllFilms();
		List<FilmRequest> requests = new ArrayList<>();
		for(int i = 0; i < films.size(); i++) {
			requests.add(FilmMapper.filmEntityToFilmRequest(films.get(i)));
		}
		for(int i = 0; i < requests.size(); i++) {
			String var = "film" + i;
			model.addAttribute(var, requests.get(i));
		}
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/register-1")
	public String showRegister(Model model) {
		model.addAttribute("userModel", new RegisterRequest1());
		return "register-1";
	}
	
	@PostMapping("/register-1")
	public String mailConfirmation(@Valid @ModelAttribute("userModel") RegisterRequest1 request, BindingResult br) {
		if(br.hasErrors()) {
			return "register-1";
		}
		String token = TokenGenerator.generate();
		userService.sendMailWithToken(token, request);
		userEmail = request.getEmail();
		request.setToken(token);
		return "register-2"; 
	}
	
	@GetMapping("/register-2")
	public String showRegister2(Model model) {
		model.addAttribute("userModel", new RegisterRequest1());
		return "register-2";
	}
	
	@PostMapping("/register-2")
	public String kodeConfirmation(@Valid @ModelAttribute("userModel") RegisterRequest1 request, BindingResult br) {
		if(br.hasErrors()) {
			return "register-2";
		}
		return "redirect:register-3"; 
	}
	
	@GetMapping("/register-3")
	public String showRegister3(Model model) {
		RegisterRequest request = new RegisterRequest();
		request.setEmail(userEmail);
		model.addAttribute("userModel", request);
		return "register-3";
	}
	
	@PostMapping("/register-3")
	public ModelAndView saveUser(@Valid @ModelAttribute("userModel") RegisterRequest request, BindingResult br) {
		if(br.hasErrors()) {
			return new ModelAndView("register-3");
		}
		try {
		userService.saveUser(UserMapper.registerToEntity(request));
		}catch (Exception e) {
			return new ModelAndView("register-3", "error", "Користувач не зберігся!");
		}
		return new ModelAndView("redirect:/login");
	}		
	
	@GetMapping("/test-page")
	public String showTestPage() {
		return "test-page";
	}
}