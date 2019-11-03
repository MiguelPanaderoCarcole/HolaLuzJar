package com.hola.luz.factory;

import com.hola.luz.exception.ExceptionRead;
import com.hola.luz.properties.GeneralPropierties;
import com.hola.luz.service.ReadFileXMLService;
import com.hola.luz.service.ReadFileCSVService;
import com.hola.luz.service.ReadFileServiceInterface;

public class Factory {

	
	/**
	 * Comprovamos si podemos leer el objeto y devolvemos el servicio que corresponda para leerlo.
	 * @param nameFile
	 * @return
	 */
	static public ReadFileServiceInterface factoryReadFile (String nameFile) throws ExceptionRead {
		
		ReadFileServiceInterface result = null;
		
		nameFile.toLowerCase();

		if (nameFile.endsWith(GeneralPropierties.XML)) {
			
			result = new ReadFileXMLService();
			
		} else if (nameFile.endsWith(GeneralPropierties.CSV)) {
			
			result = new ReadFileCSVService();
		} else {
			
			String s = "Factory.ReadFileServiceAbstract: " + GeneralPropierties.ERROR_NOT_PUT_EXTENSION;
			throw new ExceptionRead(s);
		}
		
		return (result);
	};
}
