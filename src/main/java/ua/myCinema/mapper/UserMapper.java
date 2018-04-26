package ua.myCinema.mapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.myCinema.domain.RegisterRequest;
import ua.myCinema.domain.UserProfileEditorRequest;
import ua.myCinema.domain.UserProfileRequest;
import ua.myCinema.entity.UserEntity;
import ua.myCinema.entity.enumeration.Role;
import ua.myCinema.service.UserService;
import ua.myCinema.service.utils.CustomFileUtils;

public interface UserMapper {

	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getEmail(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	public static UserEntity registerToEntity(RegisterRequest request) {
		UserEntity entity = new UserEntity();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setDateOfBirdth(Calendar.getInstance());
		entity.setRole(Role.ROLE_USER);
		return entity;
	}
	
//	public static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols(){  // для наступного метода
//
//		private static final long serialVersionUID = -2920955731703020394L;
//
//		@Override
//        public String[] getMonths() {
//            return new String[]{"січня", "лютого", "березня", "квітня", "травня", "червня",
//                "липня", "серпня", "вересня", "жовтня", "листопада", "грудня"};
//        }     
//    };
    
	public static UserProfileRequest entityToUserProfileRequest(UserEntity entity) throws IOException {
		UserProfileRequest request = new UserProfileRequest();
		request.setId(entity.getId());
		request.setEmail(entity.getEmail());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		request.setDateOfBirdth(dateFormat.format(entity.getDateOfBirdth().getTime()));
		request.setAge(UserService.calculationUserAge(entity.getDateOfBirdth()));
		request.setImage(CustomFileUtils.getImage("users", "user_" + entity.getId(),entity.getImagePath()));
		request.setRole(entity.getRole());
		return request;	
	}
	
	public static UserProfileEditorRequest entityToUserProfileEditorRequest(UserEntity entity) {
		UserProfileEditorRequest request = new UserProfileEditorRequest();
		request.setId(entity.getId());
		request.setEmail(entity.getEmail());
		request.setPassword(entity.getPassword());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setDateOfBirdthYear(entity.getDateOfBirdth().get(Calendar.YEAR));          
		request.setDateOfBirdthMonth(entity.getDateOfBirdth().get(Calendar.MONTH) + 1);
		request.setDateOfBirdthDay(entity.getDateOfBirdth().get(Calendar.DAY_OF_MONTH));
		request.setImagePath(entity.getImagePath());
		request.setRole(entity.getRole());
		return request;
		
	}
	
	public static UserEntity userProfileEditorRequestToEntity(UserProfileEditorRequest request) {
		UserEntity entity = new UserEntity();
		entity.setId(request.getId());
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		Calendar dob = new GregorianCalendar(request.getDateOfBirdthYear(), request.getDateOfBirdthMonth() - 1, request.getDateOfBirdthDay()); 		
		entity.setDateOfBirdth(dob);
		entity.setImagePath(request.getImagePath());
		entity.setRole(request.getRole());
		return entity;
	}
	
}
