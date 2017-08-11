package online.flussibancari.mav.form;

import org.springframework.web.multipart.MultipartFile;

public class MAVForm {

	private MultipartFile file;
	
	private String fileName;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}



	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "MAVForm [file=" + file + ", fileName=" + fileName + "]";
	}
}
