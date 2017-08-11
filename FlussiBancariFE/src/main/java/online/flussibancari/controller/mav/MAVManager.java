package online.flussibancari.controller.mav;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import online.flussibancari.mav.constants.Constants;
import online.flussibancari.mav.model.OutputFile;
import online.flussibancari.mav.service.CBIMAVCreator;
import online.flussibancari.mav.service.FileUpload;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class MAVManager{

	private static final Logger logger = LoggerFactory
			.getLogger(MAVManager.class);
	
	//@Autowired
	FileUpload uploadService;
	
	//@Autowired
	CBIMAVCreator creatorService;

	public MAVManager(){
		super();
		uploadService = new FileUpload();
		creatorService = new CBIMAVCreator();
	}
	
	@RequestMapping(value = "/MAVManager", method = RequestMethod.GET)
	public String mavHome() {
		return "/MAVManager";
	}
	
	/**
	 * Upload single file using Spring Controller
	 *
	 */
	@RequestMapping(value = "/MAVManagerExcelLoad", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public ModelAndView convertionFileHandler(@RequestParam("file") MultipartFile file) {
		//TODO: gestire estensione xlsx
		String excelPath = StringUtils.EMPTY;
		OutputFile out = null;
		try {
			if (!file.isEmpty()) {
				excelPath = uploadService.upload(file, Constants.TYPE_MAV);
				out = creatorService.generate(excelPath);
			} else {
				logger.info("Il caricamento del file: " + excelPath + ", non è andato a buon fine in quanto vuoto");
			}
		}catch (Exception e) {
			logger.error("Errore nel caricamento del File",e);
		}
		return new ModelAndView("risultato", "out", out);
	}
}