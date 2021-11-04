package com.devsuperior.desvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.desvendas.dto.SellerDTO;
import com.devsuperior.desvendas.services.SellerService;

@RestController
@RequestMapping(value = "/selers")
public class SellerControler {

	@Autowired
	private SellerService service ;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAllSellers(){
		
		List<SellerDTO> seller = service.findAll();
		
		return ResponseEntity.ok(seller) ;
	}
	
}
