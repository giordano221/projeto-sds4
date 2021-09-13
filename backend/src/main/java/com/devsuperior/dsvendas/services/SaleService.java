package com.devsuperior.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entitties.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService
{
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true) //Evita fazer lock no banco
	public Page<SaleDTO> findAll(Pageable pegeable)
	{
		// EVITAR BUSCAR OS VENDEDORES VARIAS VEZES (FICA EM CACHE)
		sellerRepository.findAll();
		
		Page<Sale> result = repository.findAll(pegeable);
		
		return result.map(x -> new SaleDTO(x));
	}

}
