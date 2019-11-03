package com.hola.luz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.hola.luz.pojo.Measure;
import com.hola.luz.pojo.MeasureAnomalous;
import com.hola.luz.properties.GeneralPropierties;

public class MeasureService {

	/**
	 * Tratamos la informacion de todos los usuarios, dividiendola por usuario 12 elementos , 
	 * haciendo la mediana y 
	 * comprobando resultados anomalos.
	 * @param lstMeasure
	 * @return
	 */
	public static List<MeasureAnomalous> clasifyAllClient (List<Measure> lstMeasure){

		List<MeasureAnomalous> result = new ArrayList<>();
		
		List<Measure> lstMeasureTemp;
		List<MeasureAnomalous> lstMeasureAnomalousClient;
		
		// Tratamos los elementos de 12 en 12 tal como nos hace suponer la prueba de que cada usuario esta correlativo y tiene 12 elementos.
		for (int i = 0; i < lstMeasure.size()  ; i = i + GeneralPropierties.NUMBER_OF_MONTH) {
		
			lstMeasureTemp = lstMeasure.subList(i, i + GeneralPropierties.NUMBER_OF_MONTH);	
			
			lstMeasureAnomalousClient = clasifyClient(lstMeasureTemp);
			
			result.addAll(lstMeasureAnomalousClient);
		}
		
		return (result);
	}
	
	/**
	 * Tratamos la informacion de un usuario.
	 * Hacemos la mediana.
	 * Y devolvemos resultados anomalos. 
	 * @param lstMeasure
	 * @return
	 */
	public static List<MeasureAnomalous> clasifyClient (List<Measure> lstMeasure){
		
		List<MeasureAnomalous> result = new ArrayList<MeasureAnomalous>();
		
		double median = calculateMedian(lstMeasure);
				
		final double median50Plus = (median/2) * 3;
		final double median50Less = median / 2;
		
		for (Measure measureTemp : lstMeasure) {
		
			Long readingTemp = measureTemp.getReading();
			
			if (readingTemp > median50Plus || readingTemp < median50Less) {
				
				MeasureAnomalous measureAnomalous = new MeasureAnomalous(measureTemp, median);
				
				result.add(measureAnomalous);
			}				
		}
		
		return (result);
	}
	
	/**
	 * Calculamos la mediana de los valores de la lista lstMeasure.
	 * @param lstMeasure
	 * @return
	 */
	public static double calculateMedian(List<Measure> lstMeasure) {
		
		List<Measure> lstMeasureTemp = new ArrayList<>(lstMeasure);
		
		Collections.sort(lstMeasureTemp,(Measure m1,Measure m2)-> m1.getReading().compareTo(m2.getReading()));

		// Hacemos la mediana.
		Long Measure5 =lstMeasureTemp.get(5).getReading();
		Long Measure6 =lstMeasureTemp.get(6).getReading();
		double result = (Measure5 + Measure6) / 2;
		
		return (result);
	}
	
	/**
	 * Imprimimos los resultados.
	 * @param lstMeasure
	 */
	public static void printResult(List<MeasureAnomalous> lstMeasureAnomalous) {
		
		
		System.out.println("+---------------+---------+------------+---------+");
		System.out.println("| Client        | Month   | Suspicious | Median  |");
		System.out.println("+---------------+---------+------------+---------+");
		
		for (MeasureAnomalous measureAnomalousTemp : lstMeasureAnomalous) {
			
			System.out.print("| " + measureAnomalousTemp.getClient());  
			System.out.print(" | " + measureAnomalousTemp.getPeriod());
			
			Long reading = measureAnomalousTemp.getReading();
			System.out.print(" | " + reading);
			
			String sReading = reading.toString();
			for (int i = sReading.length(); i < 10  ; i++) {
				System.out.print(" ");
			}
			
			Double median = measureAnomalousTemp.getMedian();
			System.out.print(" | " + median);
			
			String smedian = median.toString();
			for (int i = smedian.length(); i < 8  ; i++) {
				System.out.print(" ");
			}
			System.out.println("|");
			
		}
		
		System.out.println("+---------------+---------+------------+---------+");
	}
	
	
}
