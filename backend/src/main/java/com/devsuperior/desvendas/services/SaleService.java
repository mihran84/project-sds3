package com.devsuperior.desvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desvendas.dto.SaleDTO;
import com.devsuperior.desvendas.dto.SalesSuccessDTO;
import com.devsuperior.desvendas.dto.SalesSumDTO;
import com.devsuperior.desvendas.entites.Sale;
import com.devsuperior.desvendas.repositoies.SaleRepository;
import com.devsuperior.desvendas.repositoies.SellerRepository;


@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		
		sellerRepository.findAll();
		
		Page<Sale> sales =  repository.findAll(pageable);

		return sales.map(x -> new SaleDTO(x));

	}
	
	@Transactional(readOnly = true)
	public List<SalesSumDTO> ammountGroupedBySeller() {
		 
		 return repository.ammountGroupedBySeller();
		 
		 
	 }
	
	@Transactional(readOnly = true)
	public List<SalesSuccessDTO> successGroupBySeller() {
		 
		 return repository.successGroupBySeller();
		 
		 
	 }

}
