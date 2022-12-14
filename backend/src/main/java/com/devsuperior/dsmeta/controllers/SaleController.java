package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;

/// Responsável por fornecer nosso endpoints, para que nosso front end possa enviar requisições

@RestController
@RequestMapping(value="/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	
	///Sintaxe da requisição http://localhost:8080/sales?minDate=2021-11-01&maxDate=2021-12-31
	
	@GetMapping
	public Page<Sale> findSales( 
			
			// requestParam value é o que recebemos, e caso não venha nada define vazio 
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable // Pageable ele retorna um padrão de 20 registros
								){ 
		return service.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
