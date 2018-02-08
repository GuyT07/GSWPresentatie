package com.gsw.presentatie.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsw.presentatie.domain.Trein;
import com.gsw.presentatie.domain.Wagon;

@Service
@Transactional
public class TreinService {
	
	@Autowired
	private TreinRepository treinRepository;

	// Sla ook een wagon op ter illustratie
	// voorbeeld: POST http://localhost:8082/api/trein
	public Trein save(Trein trein){
		List<Wagon> wagons = new ArrayList<Wagon>();
		wagons.add(new Wagon().setName("Add extra wagon for save"));
		trein.setWagons(wagons);
		return treinRepository.save(trein);
	}
	
	// Omdat er een mapping gemaakt is naar de wagons zullen deze ook terugkomen bij het opvragen van een trein
	// voorbeeld: GET http://localhost:8082/api/trein/1 
	public Trein findById(Long id) {
		return treinRepository.findOne(id);
	}

	// Hier komen de treinen terug + de wagons die er bij horen
	// voorbeeld: GET http://localhost:8082/api/trein
	public Iterable <Trein> findAll(){
		Iterable <Trein> result = treinRepository.findAll();
		return result;
	}
	
	// Geef enkel wagons terug voor trein
	// voorbeeld: GET http://localhost:8082/api/trein/wagons/1 
	public List<Wagon> getWagon(Long id){
		Trein trein = this.findById(id);
		return trein.getWagons();
	}
	
	// Geeft de treinen terug die de ingegeven string bevatten
	// voorbeeld: GET http://localhost:8082/api/trein/guess/l
	public List<Trein> guessTrainBrand(final String brand){
		return treinRepository.findByMerkContaining(brand);
	} 
}
