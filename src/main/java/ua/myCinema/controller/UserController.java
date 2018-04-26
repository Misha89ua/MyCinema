package ua.myCinema.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ua.myCinema.domain.FilmRequest;
import ua.myCinema.domain.HallRequest;
import ua.myCinema.domain.ImageRequest;
import ua.myCinema.domain.UserProfileEditorRequest;
import ua.myCinema.entity.Film;
import ua.myCinema.entity.Hall;
import ua.myCinema.entity.UserEntity;
import ua.myCinema.mapper.FilmMapper;
import ua.myCinema.mapper.HallMapper;
import ua.myCinema.mapper.UserMapper;
import ua.myCinema.service.FilmService;
import ua.myCinema.service.HallService;
import ua.myCinema.service.UserService;

@Controller
@RequestMapping({"/user"})
@SessionAttributes("userProfileEditor")
public class UserController {
	
	private UserService userService;
	private FilmService filmService;
	private HallService hallService;
	
	@Autowired
	public UserController(UserService userService, FilmService filmService, HallService hallService) {
		this.userService = userService;
		this.filmService = filmService;
		this.hallService = hallService;
	}
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	public String showProfile(Model model, Principal principal) throws IOException {
		UserEntity user = userService.findUserByEmail(principal.getName());
		model.addAttribute("userProfile", UserMapper.entityToUserProfileRequest(user));
		
		List<Film> films = filmService.showAllFilms();
		List<FilmRequest> requests = new ArrayList<>();
		for(int i = 0; i < films.size(); i++) {
			requests.add(FilmMapper.filmEntityToFilmRequest(films.get(i)));
		}
		for(int i = 0; i < requests.size(); i++) {
			String var = "film" + i;
			model.addAttribute(var, requests.get(i));
		}
		
		return "user/profile";
	}
	
	@GetMapping("/upload-image")
	public String showUploadImagePage(Model model, Principal principal) {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		ImageRequest request = new ImageRequest();
		request.setUserId(entity.getId());
		model.addAttribute("uploadModel", request);
		return "user/upload-image";
	}

	@PostMapping("/upload-image")
	public String saveImage(@ModelAttribute("uploadModel") ImageRequest request) throws IOException {
		UserEntity entity = userService.findUserById(request.getUserId());
		userService.uploadUserImage(request, entity);
		return "redirect:/user";
	}
	
	@GetMapping("/edit-user")
	public String showEditUser(Model model, Principal principal) {
		UserEntity user = userService.findUserByEmail(principal.getName());
		UserProfileEditorRequest request = UserMapper.entityToUserProfileEditorRequest(user);
		request.setVar("user");
		model.addAttribute("userProfileEditor", request);
		return "user/edit-user";
	}
	
	@PostMapping("/edit-user")
	public ModelAndView editUser(@Valid @ModelAttribute("userProfileEditor") UserProfileEditorRequest request, BindingResult br, Principal principal) {
		if(br.hasErrors()) {
			return new ModelAndView("user/edit-user");
		}
		userService.updateUser(UserMapper.userProfileEditorRequestToEntity(request));
		return new ModelAndView("redirect:/user");
	}
	
	@GetMapping("/films")
	public String showAllFilms(Model model) throws IOException {
		List<Film> films = filmService.showAllFilms();
		List<FilmRequest> requests = new ArrayList<>();
		for(int i = 0; i < films.size(); i++) {
			requests.add(FilmMapper.filmEntityToFilmRequest(films.get(i)));
		}
		model.addAttribute("films", requests);
		return "user/films";
	}
	
	@GetMapping("/film-profile/{filmId}")
	public String showFilmDeletePage(Model model, @PathVariable("filmId") int filmId) throws IOException {
		Film entity = filmService.findFilmById(filmId);
		FilmRequest request =  FilmMapper.filmEntityToFilmRequest(entity);
		model.addAttribute("filmRequest", request);		
		return "user/film-profile";
	}
	
	@GetMapping("/halls")
	public String showAllHalls(Model model) throws IOException {
		List<Hall> halls = hallService.showAllHall();
		List<HallRequest> requests = new ArrayList<>();
		for(int i = 0; i < halls.size(); i++) {
			requests.add(HallMapper.HallEntityToHallRequest(halls.get(i)));
		}
		model.addAttribute("halls", requests);
		return "user/halls";
	}
	
}
