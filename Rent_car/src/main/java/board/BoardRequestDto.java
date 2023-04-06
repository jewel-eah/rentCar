package board;

public class BoardRequestDto {

	private int writeCode;
	private String writer;
	private String grade;
	private String title;
	private String text;
	private String subject;
	private String registeredDate;
	private String modifiedDate;

	public BoardRequestDto(int writeCode, String writer, String grade, String title, String text, String subject,
		String registeredDate, String modifiedDate) {
		this.writeCode = writeCode;
		this.writer = writer;
		this.grade = grade;
		this.title = title;
		this.text = text;
		this.subject = subject;
		this.registeredDate = registeredDate;
		this.modifiedDate = modifiedDate;
	}

	public int getWriteCode() {
		return writeCode;
	}

	public void setWriteCode(int writeCode) {
		this.writeCode = writeCode;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
