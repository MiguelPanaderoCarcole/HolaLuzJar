package com.hola.luz.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.hola.luz.exception.ExceptionRead;
import com.hola.luz.pojo.Measure;
import com.hola.luz.properties.GeneralPropierties;

public class ReadFileCSVService implements ReadFileServiceInterface {

	/**
	 * Leemos los fichero del fichero csv para recogerlos en objetos Measure.
	 */
	@Override
	public List<Measure> readFile(File file) throws ExceptionRead {
		
		List<Measure> result = new ArrayList<Measure>();

		try {
			
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
	
			line = bufferedReader.readLine();
			// Saltamos la primera linea que es la que nos da los nombres de los campos.
			line = bufferedReader.readLine();
			String[] lines;
			
			while(line != null)
			{
				lines = line.split(",");
	
			    String client = lines[0];
				
				String period = lines[1];
					
				String sReading  = lines[2];
				Long reading = Long.valueOf(sReading);
				
				Measure measure = new Measure(client, period, reading);
	
				result.add(measure);
				
			    line = bufferedReader.readLine();         
			}
	
			fileReader.close();
		
		} catch(Exception e) {
			
			String s = "ReadFileXMLService.readFile: " + GeneralPropierties.ERROR_READING_FILE + " CSV";
			throw new ExceptionRead(s, e);
		}
		
		return (result);
	}

}
