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

import ua.myCinema.domain.FilmAddRequest;
import ua.myCinema.domain.FilmRequest;
import ua.myCinema.domain.HallRequest;
import ua.myCinema.domain.ImageRequest;
import ua.myCinema.domain.UserProfileEditorRequest;
import ua.myCinema.domain.UserProfileRequest;
import ua.myCinema.entity.Film;
import ua.myCinema.entity.Hall;
import ua.myCinema.entity.UserEntity;
import ua.myCinema.mapper.FilmMapper;
import ua.myCinema.mapper.HallMapper;
import ua.myCinema.mapper.UserMapper;
import ua.myCinema.service.FilmService;
import ua.myCinema.service.HallService;
import ua.myCinema.service.PersonService;
import ua.myCinema.service.UserService;
import ua.myCinema.service.utils.CustomFileUtils;

@Controller
//@RequestMapping({"/admin"})
@SessionAttributes({"userProfileEditor", "filmRequest"}) 
public class AdminController {
	
	private UserService userService;
	private FilmService filmService;
	private HallService hallService;
	

	@Autowired
	public AdminController(UserService userService, FilmService filmService, HallService hallService) {
		this.userService = userService;
		this.filmService = filmService;
		this.hallService = hallService;
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	public String showProfile(Model model, Principal principal) throws IOException {
		UserEntity user = userService.findUserByEmail(principal.getName());
		model.addAttribute("userProfile", UserMapper.entityToUserProfileRequest(user));
		return "redirect:user";
	}

	
//	____________________________________work with users_______________________________
	@GetMapping("/admin/users")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showAllUsers(Model model) throws IOException {
		List<UserEntity> userEntities = userService.showAllUsers();
		List<UserProfileRequest> requests = new ArrayList<>();
		for(int i = 0; i < userEntities.size(); i++) {
			requests.add(UserMapper.entityToUserProfileRequest(userEntities.get(i)));
		}
		model.addAttribute("users", requests);		
		return "admin/users";
	}
			
	@GetMapping("/admin/edit-user/{userId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showUserEditPage(Model model, @PathVariable("userId") int userId) {
		UserEntity entity = userService.findUserById(userId);
		UserProfileEditorRequest request =  UserMapper.entityToUserProfileEditorRequest(entity);
		request.setVar("admin");
		model.addAttribute("userProfileEditor", request);
		return "user/edit-user";
	}
	
	@PostMapping("/admin/edit-user")
	public String editUser(@Valid @ModelAttribute("userProfileEditor") UserProfileEditorRequest request, BindingResult br, Principal principal) {
		if(br.hasErrors()) {
			return "user/edit-user" ;
		}
		userService.updateUser(UserMapper.userProfileEditorRequestToEntity(request));
		return "redirect:admin/user-profile/" + request.getId();
	}		
	
	@GetMapping("/admin/user-profile/{userId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showUserProfilePage(Model model, @PathVariable("userId") int userId) throws IOException {
		UserEntity entity = userService.findUserById(userId);
		UserProfileRequest request =  UserMapper.entityToUserProfileRequest(entity);
		model.addAttribute("userProfile", request);
		return "admin/user-profile";
	}
	
	@GetMapping("/admin/upload-user-image/{userId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showUploadImagePage(Model model, @PathVariable("userId") int userId) {
		ImageRequest request = new ImageRequest();
		request.setUserId(userId);
		model.addAttribute("uploadModel", request);
		return "admin/upload-user-image";
	}

	@PostMapping("/admin/upload-user-image")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String saveImage(@ModelAttribute("uploadModel") ImageRequest request) throws IOException {
		UserEntity entity = userService.findUserById(request.getUserId());
		userService.uploadUserImage(request, entity);
		return "redirect:admin/user-profile/" + entity.getId();
	}
	
	@GetMapping("/admin/delete-user/{userId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showUserDeletePage(Model model, @PathVariable("userId") int userId) {
		UserEntity entity = userService.findUserById(userId);
		UserProfileEditorRequest request =  UserMapper.entityToUserProfileEditorRequest(entity);
		model.addAttribute("user", request);		
		return "admin/delete-user";
	}
	
	@GetMapping("/admin/delete-user-confirm/{userId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String userDelete(@PathVariable("userId") int userId) {	
		userService.deleteUser(userId);
		return "redirect:/admin/users";
	}

	
//	_______________________________________work with films__________________________
	
	@GetMapping("/admin/film-add")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showFilmAddPage(Model model) {
		model.addAttribute("filmRequest", new FilmAddRequest());
		return "admin/film-edit-add";
	}
	
	@PostMapping("/admin/film/add")
	public String filmAdd(@Valid @ModelAttribute("filmRequest") FilmAddRequest request, BindingResult br) throws IOException {
		if(br.hasErrors()) {
			return ("admin/film-edit-add");
		}
		filmService.saveFilm(FilmMapper.filmAddRequestToFilmEntity(request));
		request.setImage(CustomFileUtils.getImage("films", "", ""));
		return "user/film-profile";
	}
	

	
	@GetMapping("/admin/film-edit/{filmId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showFilmEditPage(Model model, @PathVariable("filmId") int filmId) throws IOException {
		Film filmEntity = filmService.findFilmById(filmId);
		FilmRequest filmRequest = FilmMapper.filmEntityToFilmRequest(filmEntity);
		model.addAttribute("filmRequest", filmRequest);
		return "admin/film-edit-add";
	}
	
	@PostMapping("/admin/film/edit")
	public String filmEdit (@Valid @ModelAttribute("filmRequest") FilmRequest request, BindingResult br) {
		if(br.hasErrors()) {
			return ("admin/film-edit-add");
		}
		filmService.updateFilm(FilmMapper.filmRequestToFilmEntity(request));
		return ("user/film-profile");
	}	
	
	@GetMapping("/admin/films")
	public String showAllFilms(Model model) throws IOException {
		List<Film> films = filmService.showAllFilms();
		List<FilmRequest> requests = new ArrayList<>();
		for(int i = 0; i < films.size(); i++) {
			requests.add(FilmMapper.filmEntityToFilmRequest(films.get(i)));
		}
		model.addAttribute("films", requests);
		return "admin/films";
	}
	
	@GetMapping("/admin/film-delete/{filmId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showFilmDeletePage(Model model, @PathVariable("filmId") int filmId) throws IOException {
		Film entity = filmService.findFilmById(filmId);
		FilmRequest request =  FilmMapper.filmEntityToFilmRequest(entity);
		model.addAttribute("film", request);		
		return "admin/film-delete";
	}
	
	@GetMapping("/admin/film-delete-confirm/{filmId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String filmDelete(@PathVariable("filmId") int filmId) {	
		filmService.deleteFilm(filmId);
		return "redirect:/admin/films";
	}
	
	@GetMapping("/admin/upload-film-image/{filmId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showUploadFilmImagePage(Model model, @PathVariable("filmId") int filmId) {
		ImageRequest request = new ImageRequest();
		request.setUserId(filmId);
		model.addAttribute("uploadModel", request);
		return "admin/upload-film-image";
	}

	@PostMapping("/admin/upload-film-image")
	public String saveFilmImage(@ModelAttribute("uploadModel") ImageRequest request) throws IOException {
		Film entity = filmService.findFilmById(request.getUserId());
		filmService.uploadFilmImage(request, entity);
		return "redirect:/user/film-profile/" + entity.getId();
	}
	
	
	
//	_______________________________________work with halls__________________________
	
	
	@GetMapping("/admin/hall-add")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showHallAddPage(Model model) {
		model.addAttribute("hallRequest", new HallRequest());
		return "admin/hall-add";
	}
	
	@PostMapping("/admin/hall-add")
	public String hallAdd(@Valid @ModelAttribute("hallRequest") HallRequest request, BindingResult br) {
		if(br.hasErrors()) {
			return ("admin/hall-add");
		}
		hallService.saveHall(HallMapper.hallAddRequestToHallEntity(request));
		return ("user/hall-profile");
	}
	
	@GetMapping("/admin/hall-delete/{hallId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String showHallDeletePage(Model model, @PathVariable("hallId") int hallId) throws IOException {
		Hall entity = hallService.findHallById(hallId);
		HallRequest request =  HallMapper.HallEntityToHallRequest(entity);
		model.addAttribute("hall", request);		
		return "admin/hall-delete";
	}
	
	@GetMapping("/admin/hall-delete-confirm/{hallId}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String hallDelete(@PathVariable("hallId") int hallId) {	
		hallService.deleteHall(hallId);
		return "redirect:/user/halls";
	}

	
}
