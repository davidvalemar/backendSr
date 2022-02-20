package com.cuscatlan.backendsr.mobile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cuscatlan.backendsr.lib.util.Utilities;
import com.cuscatlan.backendsr.mobile.clients.MarvelClient;
import com.cuscatlan.backendsr.mobile.entities.TransactionLog;

@Service
public class MarvelService {

	@Autowired
	private MarvelClient marvelClient;

	public ResponseEntity<String> getCharacterByName(String characterName, String comics, String series, String uuid) throws Exception {
		return marvelClient.getCharacterByName(characterName, comics, series);		
	}
		
	public ResponseEntity<String> getComicByTitle(String title , String uuid) throws Exception {		
		return marvelClient.getComicByTitle(title );
	}
	
	public ResponseEntity<String> getCharactersByComicId(String comicId, String characterName , String uuid){
		return marvelClient.getCharactersByComicId(comicId, characterName);
	}
	
	public ResponseEntity<String> getCharactersBySeriesId(String seriesId, String characterName , String uuid){
		return marvelClient.getCharactersBySerie(seriesId, characterName);
	}	
	// primero validar que tenga personaje para buscar los comic asociados
	public ResponseEntity<String> getComicsByCharacterId(String characterId, String comicName, String uuid ) throws Exception {
		return marvelClient.getComicsByCharacterId(characterId, comicName);
	}
	
	public ResponseEntity<String> getImageandDescByCharacter(String characterName, String uuid) throws Exception {
		return marvelClient.getImageandDescByCharacter(characterName);
	}
	
	
	public ResponseEntity<String> getComicListByCommicName(String comicName, String uuid) throws Exception {
		return marvelClient.getComicListByCommicName(comicName);
	}
	
	public ResponseEntity<String> getComicById(String comicId, String uuid) throws Exception {
		return marvelClient.getComicById(comicId);
	}
	
	public ResponseEntity<String> getComicByCreator(String firstName, String middleName, String lastName, String uuid) throws Exception {
	
	return marvelClient.getComicByCreator(firstName, middleName, lastName);
	}
	
	public ResponseEntity<String> getImagesAllCharacters(String characterName, String uuid, int limit, int offset) throws Exception {
		return marvelClient.getImagesAllCharacters(limit, offset);
	}
	
	public ResponseEntity<TransactionLog> saveLog(TransactionLog request) {
		return marvelClient.saveLog(request);
	}
	
}