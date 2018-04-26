package ua.myCinema.service;

import java.io.IOException;
import java.security.Principal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import ua.myCinema.domain.ImageRequest;
import ua.myCinema.domain.RegisterRequest1;
import ua.myCinema.entity.UserEntity;

public interface UserService {

	void saveUser(UserEntity entity);
	
	void updateUser(UserEntity entity);
	
	void deleteUser(int userId);
	
	UserEntity findUserById(int id);
	
	UserEntity findUserByEmail(String email);
	
	List<UserEntity> showAllUsers();
	
	void sendMailWithToken(String token, RegisterRequest1 request);
	
	void uploadUserImage(ImageRequest request, UserEntity entity) throws IOException;
	
	static int calculationUserAge(Calendar dateOfBirdth) {
		 Calendar currentDate = Calendar.getInstance(); // поточна дата
	        Calendar enteredData = new GregorianCalendar(); // дата народження
	       
	        enteredData = dateOfBirdth;  
	        int year =  (currentDate.get(Calendar.YEAR) - enteredData.get(Calendar.YEAR));
	        int month = (currentDate.get(Calendar.MONTH) - enteredData.get(Calendar.MONTH));
	        int day = (currentDate.get(Calendar.DAY_OF_MONTH) - enteredData.get(Calendar.DAY_OF_MONTH));
	        
	        if(day < 0) {
	           month = month - 1;
	        } 
	        if(month < 0) {
	           year = year - 1;
	           month = 12 + month;
	        }
	        return year;
	}
}
