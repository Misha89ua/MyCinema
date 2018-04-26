package ua.myCinema.mapper;

import ua.myCinema.domain.HallRequest;
import ua.myCinema.entity.Hall;

public interface HallMapper {
	
	public static Hall hallAddRequestToHallEntity(HallRequest request) {
		Hall hallEntity = new Hall();
		hallEntity.setHallName(request.getHallName());
		hallEntity.setNumberOfSeats(request.getNumberOfSeats());
		return hallEntity;
	}
	
	public static HallRequest HallEntityToHallRequest(Hall hallEntity) {
		HallRequest request = new HallRequest();
		request.setId(hallEntity.getId());
		request.setHallName(hallEntity.getHallName());
		request.setNumberOfSeats(hallEntity.getNumberOfSeats());
		return request;
	}

}
