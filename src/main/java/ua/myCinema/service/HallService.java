package ua.myCinema.service;

import java.util.List;

import ua.myCinema.entity.Hall;

public interface HallService {
	
void saveHall(Hall entity);
	
	void updateHall(Hall entity);
	
	void deleteHall(int hallId);
	
	Hall findHallById(int id);
	
	List<Hall> showAllHall();
	
	Hall findHallByHallName(String hallName);

}
