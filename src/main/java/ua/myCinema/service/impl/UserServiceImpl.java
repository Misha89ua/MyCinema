

package ua.myCinema.service.impl;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.myCinema.domain.ImageRequest;
import ua.myCinema.domain.RegisterRequest1;
import ua.myCinema.domain.mail.Mail;
import ua.myCinema.entity.UserEntity;
import ua.myCinema.repository.UserRepository;
import ua.myCinema.service.EmailService;
import ua.myCinema.service.UserService;
import ua.myCinema.service.utils.CustomFileUtils;

@Service
public class UserServiceImpl implements UserService {
	
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private EmailService emailService;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, EmailService emailService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.emailService = emailService;
	}

	@Override
	@Transactional
	public void saveUser(UserEntity entity) {
		String password = entity.getPassword();
		entity.setPassword(passwordEncoder.encode(password));
		
		userRepository.save(entity);
		CustomFileUtils.createFolder("users", "user_" + entity.getId());
	}

	@Override
	public void updateUser(UserEntity entity) {
		userRepository.save(entity);
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.delete(userId);	
	}

	@Override
	public UserEntity findUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public List<UserEntity> showAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void sendMailWithToken(String token, RegisterRequest1 request) {
		Mail mail = new Mail();
		mail.setTo(request.getEmail());
		mail.setSubject("Check register on My Cinema");
		mail.setContent("Ваш код для підтвердження: " + token);
		
		emailService.sendMessage(mail);
	}

	@Override
	public void uploadUserImage(ImageRequest request, UserEntity entity) throws IOException {
		entity.setImagePath(request.getFile().getOriginalFilename());
		CustomFileUtils.createImage("users", "user_" + entity.getId(), request.getFile());
		this.updateUser(entity);
	}
}
