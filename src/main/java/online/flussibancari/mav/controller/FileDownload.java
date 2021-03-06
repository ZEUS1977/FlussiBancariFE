package online.flussibancari.mav.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import online.flussibancari.mav.constants.Constants;
 
@Controller
public class FileDownload{
    
	private static final Logger logger = LoggerFactory
			.getLogger(FileDownload.class);
	
	public FileDownload(){
		super();
	}

	@RequestMapping(value="/downloadTxt/{fileName}")
	public void getLogFile(@PathVariable("fileName") String fileName, HttpServletResponse response) throws Exception {
	    try {
	    	String rootPath = System.getProperty(Constants.CATALINA_HOME);
	        String filePathToBeServed = rootPath + File.separator + Constants.TEMP_DIR + File.separator + fileName + ".txt";
	    	if(rootPath ==null) {
		        	rootPath = System.getProperty(Constants.WILDFLY_HOME);
		        	filePathToBeServed = rootPath + File.separator + Constants.STANDALONE + File.separator
		        						+ Constants.TMP_DIR + File.separator + fileName + ".txt";
	    	}
	    	File fileToDownload = new File(filePathToBeServed);
	        InputStream inputStream = new FileInputStream(fileToDownload);
	        response.setContentType("application/force-download");
	        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".txt"); 
	        IOUtils.copy(inputStream, response.getOutputStream());
	        response.flushBuffer();
	        inputStream.close();
	    } catch (Exception e){
	        logger.debug("Request could not be completed at this moment. Please try again.");
	        e.printStackTrace();
	    }

	}
}
