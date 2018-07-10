package online.flussibancari.mav.service;

import java.io.File;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import online.flussibancari.cbi.mav.service.CBIMAVFlatService;
import online.flussibancari.cbi.mav.service.CBIMAVFlatServiceImpl;
import online.flussibancari.mav.constants.Constants;
import online.flussibancari.mav.model.OutputFile;

//@Service("creatorService")
public class CBIMAVCreator {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CBIMAVCreator.class);

	public CBIMAVCreator(){
		super();
	}
	
	public OutputFile generate(String inputPath){
		CBIMAVFlatService service = new CBIMAVFlatServiceImpl();
		String rootPath = System.getProperty(Constants.CATALINA_HOME);
		String outputName =  Constants.OUT_MAV_PREFIX +  Calendar.getInstance().getTimeInMillis() + ".txt";
		String outputPath = rootPath + File.separator + Constants.TEMP_DIR + File.separator + outputName;
		if(rootPath == null) {
			rootPath = System.getProperty(Constants.WILDFLY_HOME);
			outputPath = rootPath + File.separator + Constants.STANDALONE + 
					 	File.separator + Constants.TMP_DIR + File.separator + outputName;
		}
			
		OutputFile out = new OutputFile();
		out.setServerPath(outputPath);
		out.setFileName(outputName);
		out.setType(Constants.TYPE_MAV);
		try{
			service.manageSteps(inputPath, outputPath);
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return out;
	}
}
