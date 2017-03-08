package online.flussibancari.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import online.flussibancari.constants.Constants;
import online.flussibancari.model.OutputFile;
import online.flussibancari.service.CBIMAVCreator;
import online.flussibancari.service.FileUpload;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class MAVManager{

	private static final Logger logger = LoggerFactory
			.getLogger(MAVManager.class);

	@RequestMapping(value = "/MAVManager", method = RequestMethod.GET)
	public String mavHome() {
		return "/MAVManager";
	}
	
	/**
	 * Upload single file using Spring Controller
	 *
	 */
	@RequestMapping(value = "/MAVManager", method = RequestMethod.POST)
	public ModelAndView convertionFileHandler(@RequestParam("file") MultipartFile file) {
		//TODO: gestire estensione xlsx
		String excelPath = StringUtils.EMPTY;
		String cbiName = StringUtils.EMPTY;
		String cbiURL = StringUtils.EMPTY;
		OutputFile out = null;
		if (!file.isEmpty()) {
			FileUpload uploadService = new FileUpload();
			excelPath = uploadService.upload(file, Constants.TYPE_MAV);
			
			CBIMAVCreator creatorService = new CBIMAVCreator();
			out = creatorService.generate(excelPath);
		} else {
			logger.info("Il caricamento del file: " + excelPath + ", non è andato a buon fine in quanto vuoto");
		}
		return new ModelAndView("risultato", "out", out);
	}
}