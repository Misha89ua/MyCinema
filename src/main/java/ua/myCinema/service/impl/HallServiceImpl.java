package ua.myCinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.myCinema.entity.Hall;
import ua.myCinema.repository.HallRepository;
import ua.myCinema.service.HallService;

@Service
public class HallServiceImpl implements HallService{
	
	private HallRepository hallRepository;
	
	@Autowired
	public HallServiceImpl(HallRepository hallRepository) {
		this.hallRepository = hallRepository;
	}

	@Override
	public void saveHall(Hall entity) {
		hallRepository.save(entity);
	}

	@Override
	public void updateHall(Hall entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHall(int Id) {
		hallRepository.delete(Id);
	}

	@Override
	public Hall findHallById(int id) {
		return hallRepository.findOne(id);
	}

	@Override
	public List<Hall> showAllHall() {
		return hallRepository.findAll();
	}

	@Override
	public Hall findHallByHallName(String hallName) {
		return hallRepository.findHallByHallName(hallName);
	}
	
	


}
