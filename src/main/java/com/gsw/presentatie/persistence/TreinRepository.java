package com.gsw.presentatie.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gsw.presentatie.domain.Trein;

@Repository
public interface TreinRepository extends CrudRepository <Trein, Long> {
	
	List<Trein> findByMerkContaining(final String brand);
	
}
