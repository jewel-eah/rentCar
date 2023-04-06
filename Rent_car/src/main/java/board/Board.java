package board;

public class Board {

	private int writeCode;
	private String writer;
	private String grade;
	private String title;
	private String text;
	private String subject;
	private String registeredDate;
	private String modifiedDate;
	
	public Board(int writeCode, String writer, String grade, String title, String text, String subject, String registeredDate, String modifiedDate) {
		this.writeCode = writeCode;
		this.writer = writer;
		this.grade = grade;
		this.title = title;
		this.text = text;
		this.subject = subject;
		this.registeredDate = registeredDate;
		this.modifiedDate = modifiedDate;
	}
	
	public Board(BoardRequestDto boardDto) {

	}

	public int getWriteCode() {
		return writeCode;
	}

	public String getWriter() {
		return writer;
	}

	public String getGrade() {
		return grade;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getSubject() {
		return subject;
	}

	public String getRegisteredDate() {
		return registeredDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}
	
	
	
}
