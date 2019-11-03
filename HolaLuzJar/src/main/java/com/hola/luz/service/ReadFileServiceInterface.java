package com.hola.luz.service;

import java.io.File;
import java.util.List;

import com.hola.luz.exception.ExceptionRead;
import com.hola.luz.pojo.Measure;

public interface ReadFileServiceInterface {

	public abstract  List<Measure> readFile(File file) throws ExceptionRead;
	
}
