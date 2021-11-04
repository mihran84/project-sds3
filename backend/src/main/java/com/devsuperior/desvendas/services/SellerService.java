package com.devsuperior.desvendas.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desvendas.dto.SellerDTO;
import com.devsuperior.desvendas.entites.Seller;
import com.devsuperior.desvendas.repositoies.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findAllSeller() {

		List<Seller> sellers = repository.findAll();
		return	sellers.stream().map(x ->new SellerDTO(x)).collect(Collectors.toList());
	

	}
}
