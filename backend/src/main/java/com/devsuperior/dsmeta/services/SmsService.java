package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	//Value pega das variáveis de ambiente definida em application.properties
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository salerepository;

	public void sendSms(Long saleId) {
		//Por se tratar de uma classe que herda o JPA, funções como findById e get são integradas
		//date e sellerName são exatamente as colunas da nossa tabela do banco de dados
		Sale sale = salerepository.findById(saleId).get();
		
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		
		String msg = "O Vendedor: " + sale.getSellerName() + " foi destaque em " + date 
				+ " com um total de R$ " + String.format("%.2f", sale.getAmount());
				
		// Direto na pasta do projeto(dsmeta -> run As -> run As configuration -> enverioment, e la estão as
		//configurações das variáveis, que inclusive pegamos da plataforma da twillo na pagina inicial da
		//nossa conta
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}