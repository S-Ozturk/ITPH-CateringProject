package com.project.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.catering.domain.Recepie;
import com.project.catering.controller.Recepie_IngredientService;

@Service
@Transactional
public class RecepieService {
	@Autowired
	private RecepieRepository recepieRepository;
	
	@Autowired
	private Recepie_IngredientService recepie_IngredientRepository;

	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public Recepie saveRecepie(Recepie recepie) {
		return recepieRepository.save(recepie);
	}
		
	//@PreAuthorize("isAuthenticated()")
	public Iterable<Recepie> getAllRecepies(){
		return recepieRepository.findAll();
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Iterable<Recepie> getRecepiesLike(String search){
		try {
            double d = Double.parseDouble(search);
            return recepieRepository.findByCaloriePerPortionLikeOrPortionPerRecepieLike(d, d);
        } catch (NumberFormatException e2) {
        	return recepieRepository.findByNameContainingOrUnitTypeContainingOrRecepieTypeContaining(search, search, search);
        }
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CHEF')")
	public void deleteRecepie(int id) {
		recepie_IngredientRepository.deleteRecepie_IngredientArray(recepie_IngredientRepository.getRecepie_IngredientByRecepie_id(id));
		recepieRepository.delete(getRecepieById(id));
	}
	
	//@PreAuthorize("isAuthenticated()")
	public Recepie getRecepieById(long articleId) {
		Recepie obj = recepieRepository.findById(articleId).get();
		return obj;
	}	
	
}
