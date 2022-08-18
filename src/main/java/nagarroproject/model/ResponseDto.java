package nagarroproject.model;


public class ResponseDto {

	private String status;
	private Object message;
	public ResponseDto(String status, Object message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ResponseDto() {
	
		// TODO Auto-generated constructor stub
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResponseDto [status=" + status + ", message=" + message + "]";
	}
	
	
	
	
	

	
	
	
	
	
}
