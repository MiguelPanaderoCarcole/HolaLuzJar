package com.hola.luz.HolaLuzJar;

import java.io.File;
import java.util.List;

import com.hola.luz.exception.ExceptionRead;
import com.hola.luz.factory.Factory;
import com.hola.luz.pojo.Measure;
import com.hola.luz.pojo.MeasureAnomalous;
import com.hola.luz.properties.GeneralPropierties;
import com.hola.luz.service.MeasureService;
import com.hola.luz.service.ReadFileServiceInterface;

public class App 
{
    public static void main( String[] args )
    {
    	
    	if (args.length > 0) {
    	
	    	String pathFile = args[0];
	    	
	    	File file = new File(pathFile);
	    			 
			if (file.exists()) {
	    		
				String nameFile = file.getName();
				ReadFileServiceInterface readFileServiceInterface = Factory.factoryReadFile(nameFile);
					
				if (readFileServiceInterface != null) {
					
					try {
					List<Measure> lstMesure = readFileServiceInterface.readFile(file);
					
					List<MeasureAnomalous> lstMeasureAnomalous = MeasureService.clasifyAllClient(lstMesure);
					
					MeasureService.printResult(lstMeasureAnomalous);
					} catch (ExceptionRead e) {
					
						System.out.println(e.getMessage());		
					}
				}
				
			} else {
			
				System.out.println("App.main: " + GeneralPropierties.ERROR_NOT_EXIST_FILE_IN + " " + pathFile);			
			}	
    	} else {
			System.out.println("App.main: " + GeneralPropierties.ERROR_ADD_PATH);
		}	
    	
    }
}
