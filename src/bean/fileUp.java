package bean;

public class fileUp {
	private String ID;
	private String Path;
	private String File;
	private String username;
	private String time;
	private String pdfName;
	private String pdfPath;
	public fileUp(String ID, String Path, String filename, String userName,String time,String pdfName,String pdfPath) {
		this.ID = ID;
		this.Path = Path;
		this.File = filename;
		this.username = userName;
		this.time = time;
		this.pdfName = pdfName;
		this.pdfPath = pdfPath;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getFile() {
		return File;
	}
	public void setFile(String file) {
		File = file;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPdfName() {
		return pdfName;
	}
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}
	public String getPdfPath() {
		return pdfPath;
	}
	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

}
