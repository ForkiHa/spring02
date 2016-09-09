package spring.model;

public class Item {
	private String filename;
	private String filePath;
	private int fileSize;
	
	public Item(){
		
	}
	public Item(String filename, String filePath, int fileSize) {
		super();
		this.filename = filename;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	

}
