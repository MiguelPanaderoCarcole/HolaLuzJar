package com.hola.luz.factory;

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
	static public ReadFileServiceInterface factoryReadFile (String nameFile) {
		
		ReadFileServiceInterface result = null;
		
		nameFile.toLowerCase();

		if (nameFile.endsWith(GeneralPropierties.XML)) {
			
			result = new ReadFileXMLService();
			
		} else if (nameFile.endsWith(GeneralPropierties.CSV)) {
			
			result = new ReadFileCSVService();
		} else {
			
			System.out.println("Factory.ReadFileServiceAbstract: " + GeneralPropierties.ERROR_NOT_PUT_EXTENSION);
		}
		
		return (result);
	};
}
