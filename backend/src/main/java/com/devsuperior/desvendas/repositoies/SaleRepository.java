package com.devsuperior.desvendas.repositoies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.desvendas.dto.SalesSuccessDTO;
import com.devsuperior.desvendas.dto.SalesSumDTO;
import com.devsuperior.desvendas.entites.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("select new com.devsuperior.desvendas.dto.SalesSuccessDTO(obj.seller , sum (obj.visited) , sum(obj.deals) ) "
			+ "  from Sale as obj group by  obj.seller ")
	 List<SalesSuccessDTO> successGroupBySeller() ;
	 
	
	@Query("select new com.devsuperior.desvendas.dto.SalesSumDTO(obj.seller , sum (obj.amount) ) "
			+ "  from Sale as obj group by  obj.seller ")
	List<SalesSumDTO> ammountGroupedBySeller() ;
}
