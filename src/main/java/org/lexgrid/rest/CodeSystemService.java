package org.lexgrid.rest;

import static spark.Spark.*;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CodeSystemService {
	
    public static void main(String[] args) {	
        get("/codesystemversions", (request, response) -> {
            response.status(200);
            response.type("application/json");
        return readFile("file:///Users/m029206/Documents/workspace/org.lexgrid.rest/src/main/resources/codesystemversions/codesystemversions.json", Charset.defaultCharset()); });
    }
    
    static String readFile(String path, Charset encoding) 
    		{
    		  byte[] encoded = null;
			try {
				encoded = Files.readAllBytes(Paths.get(URI.create(path)));
			} catch (IOException e) {
				e.printStackTrace();
			}
    		  return new String(encoded, encoding);
    		}
}
