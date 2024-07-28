package com.codigorupestre.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codigorupestre.entity.SolicitudBecaEntity;
import com.codigorupestre.repository.SolicitudesBecasRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SolicitudesLBecasListener {
	
	@Autowired
	private SolicitudesBecasRepository repository;
	
	@RabbitListener(queues = "q.codigorupestre.becas.sep")
	public void recibirSolicitudesBecas(SolicitudBecaEntity solicitudBeca) {
		log.info("Solicitud de beca recibida {} ", solicitudBeca);
		repository.save(solicitudBeca);
	}

}