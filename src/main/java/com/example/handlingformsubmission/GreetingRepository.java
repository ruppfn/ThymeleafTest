package com.example.handlingformsubmission;

import com.example.handlingformsubmission.Greeting;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Integer>{

	Greeting findById(int id);
	List<Greeting> findAll();

}
