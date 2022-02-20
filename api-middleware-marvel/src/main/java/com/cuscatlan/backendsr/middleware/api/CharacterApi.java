package com.cuscatlan.backendsr.middleware.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuscatlan.backendsr.lib.util.Utilities;
import com.cuscatlan.backendsr.middleware.api.business.MarvelBusiness;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/characters")
@Slf4j
public class CharacterApi {
	
	
	@Autowired
	private MarvelBusiness marvelBusiness;
	
	/**
	 *  Consulta personaje por nombre tambien usado para obtener las imagenes de cada personaje
	 * @param name
	 * @return
	 */
	@GetMapping("")
	public ResponseEntity<?> getCharacterByName(@RequestParam(name = "name") String name){
		String uuid= Utilities.getUuid();
		ResponseEntity<?> result = null;
		try {
			
			result = marvelBusiness.getCharacterByName(name, uuid);
		}catch(Exception e) {
			
			log.error("Error {}", e.getMessage(),e);
			result = new ResponseEntity<>("Error consultando API Marvel",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@GetMapping("/characters/{characterId}/comics")
	public ResponseEntity<?> getCharactersByComicId(@PathVariable("characterId") String characterId,@RequestParam(name = "title") String title){
		String uuid= Utilities.getUuid();
		ResponseEntity<?> result = null;
		try {
			
			result = marvelBusiness.getComicsByCharacterId(characterId,title,uuid);
		}catch(Exception e) {
			
			log.error("Error {}", e.getMessage(),e);
			result = new ResponseEntity<>("Error consultando API Marvel",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}


}