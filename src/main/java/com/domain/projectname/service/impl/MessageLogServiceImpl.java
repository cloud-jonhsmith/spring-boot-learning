package com.domain.projectname.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.domain.projectname.service.MessageLogService;

@Service("messagelog")
public class MessageLogServiceImpl implements MessageLogService {
	
	private static final Log LOG = LogFactory.getLog(MessageLogServiceImpl.class);

	@Override
	public String messageLog() {
		// TODO Auto-generated method stub
		String mensaje = "Hola amigos, este es un mensaje desde la implementación de la interface";
		LOG.info("HELLO FROM MessageLogServiceImpl");
		return mensaje;
	}

}
