package online.flussibancari.mav.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import online.flussibancari.mav.constants.Constants;

//@Service("uploadService")
public class FileUpload {
	
	private static final Logger logger = LoggerFactory
			.getLogger(FileUpload.class);
	
	public FileUpload(){
		super();
	}
	/**
	 * Take a multipart file and save it on a temp dir on server
	 * @param file
	 * @param type
	 * @return absulute path of file saved on server
	 */
	public String upload(MultipartFile file, String type){
		
		String name = type + Constants.INPUT_FACTOR_NAME + Calendar.getInstance().getTimeInMillis() + Constants.XLS_EXT; 
		File serverFile = null;
		try {
			byte[] bytes = file.getBytes();
			
			// Creating the directory to store file
			String rootPath = System.getProperty(Constants.CATALINA_HOME);
			File dir = new File(rootPath + File.separator + Constants.WEBAPPS_DIR + File.separator +  Constants.TMP_DIR);
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			serverFile = new File(dir.getAbsolutePath()
					+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			logger.info("Server File Location="
					+ serverFile.getAbsolutePath());

			logger.info("Hai caricato con successo il file= " + name);
		} catch (Exception e) {
			logger.error("Il caricamento del file non è andato a buon fine: " + name + " => " + e.getMessage());
		}
		return serverFile.getAbsolutePath();
	}
}
