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
@RequestMapping("/series")
@Slf4j
public class SerieApi {
	
	@Autowired
	private MarvelBusiness marvelBusiness;
	
	/*
	 * Consulta personajes por nombre de comic para luego  obtener los personajes del comic
	 */
	@GetMapping()
	public ResponseEntity<?> getCharactersBySerie(@PathVariable("seriesId") String seriesId, @RequestParam(name = "name") String characterName){
		String uuid= Utilities.getUuid();
		ResponseEntity<?> result = null;
		try {
			
			result = marvelBusiness.getCharactersBySeriesId(seriesId, characterName, uuid);
		}catch(Exception e) {
			
			log.error("Error {}", e.getMessage(),e);
			result = new ResponseEntity<>("Error consultando API Marvel",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	

}