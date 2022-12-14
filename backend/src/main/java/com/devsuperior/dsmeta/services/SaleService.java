package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

// Classe reponsável por todas as operações de venda, no caso do nosso sistema.

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	// Pageable ele retorna um padrão de 20 registros
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){ 
		//Tratamento caso a requisição vem sem as datas(Para não dar erro para o usuário)
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()); // Pega data do sistema
		
		//Recebemos as datas como String do front, aqui convertemos pro tipo LocalDate
		// Se data minima vier vazio pegamos data atual - 365 dias
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		// Usamos expressão condicional ternária
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, pageable);
	}
}
