package com.hola.luz.HolaLuzJar;

import java.util.ArrayList;
import java.util.List;

import com.hola.luz.pojo.Measure;
import com.hola.luz.pojo.MeasureAnomalous;
import com.hola.luz.service.MeasureService;

import junit.framework.TestCase;

public class MeasureServiceTest extends TestCase{

	Measure measure01 = new Measure("583ef6329d7b9", "2016-01", 49L);
	Measure measure02 = new Measure("583ef6329d7b9", "2016-12", 151L);
	
	
	public MeasureServiceTest( String testName )
    {
        super( testName );
    }
	   
	  
	  
    public void testClasifyAllClient (){
    	
    	List<Measure> lstMeasure = createListTest();
    	
    	List<MeasureAnomalous> lstMeasureAnomalous = MeasureService.clasifyClient(lstMeasure);
    	
    	MeasureAnomalous measureAnomalous01 = new MeasureAnomalous(measure01, 100L);
    	MeasureAnomalous measureAnomalous02 = new MeasureAnomalous(measure02, 100L);
    	
    	// Comprobamos que solo devuelva 2 valores el 2016-01 e 49 y el 2016-12 de 151.
    	assertEquals( 2 , lstMeasureAnomalous.size());
    	
    	// Comprovamos que la mediana sea 100.
    	assertEquals( 100D, lstMeasureAnomalous.get(0).getMedian());
    	
    	// Comprovamos que ha devuelto los dos valores sospechosos esperados.
    	assertEquals(measureAnomalous01, lstMeasureAnomalous.get(0));
    	assertEquals(measureAnomalous02, lstMeasureAnomalous.get(1));
    }
    
  
    public void testCalculateMedian() {
    	
    	List<Measure> lstMeasure = createListTest();
    	
    	double median = MeasureService.calculateMedian(lstMeasure);
    	
    	// Comprovamos que la mediana sea 100.
    	assertEquals( 100D, median);
    }
    
    private List<Measure> createListTest(){
    	
    	List<Measure> result = new ArrayList<Measure>();
    	
    	result.add(measure01);
    	result.add(new Measure("583ef6329d7b9", "2016-02", 50L));
    	result.add(new Measure("583ef6329d7b9", "2016-03", 98L));
    	result.add(new Measure("583ef6329d7b9", "2016-04", 99L));
    	result.add(new Measure("583ef6329d7b9", "2016-05", 100L));
    	result.add(new Measure("583ef6329d7b9", "2016-06", 101L));
    	result.add(new Measure("583ef6329d7b9", "2016-07", 99L));
    	result.add(new Measure("583ef6329d7b9", "2016-08", 100L));
    	result.add(new Measure("583ef6329d7b9", "2016-09", 101L));
    	result.add(new Measure("583ef6329d7b9", "2016-10", 102L));
    	result.add(new Measure("583ef6329d7b9", "2016-11", 150L));
    	result.add(measure02);
    	
    	return (result);
    }
	
}
