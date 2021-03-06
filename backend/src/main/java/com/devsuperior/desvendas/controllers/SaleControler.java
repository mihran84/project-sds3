package com.devsuperior.desvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.desvendas.dto.SaleDTO;
import com.devsuperior.desvendas.dto.SalesSuccessDTO;
import com.devsuperior.desvendas.dto.SalesSumDTO;
import com.devsuperior.desvendas.dto.SellerDTO;
import com.devsuperior.desvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleControler {

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pagable) {

		Page<SaleDTO> sales = service.findAll(pagable);

		return ResponseEntity.ok(sales);
	}
	
	@GetMapping(value = "sum-by-seller")
	public ResponseEntity<List<SalesSumDTO>> ammountGroupedBySeller(){
		
		List<SalesSumDTO> result = service.ammountGroupedBySeller();
		
		return ResponseEntity.ok(result) ;
	}
	
	
	@GetMapping(value = "success-by-seller")
	public ResponseEntity<List<SalesSuccessDTO>> successGroupBySeller(){
		
		List<SalesSuccessDTO> result = service.successGroupBySeller();
		
		return ResponseEntity.ok(result) ;
	}
	

}
