package edu.drexel.alan.bap.service;

public class ServiceException extends Exception {
	
	private final String message;
	private final Throwable causeBy;
	private final int errorCode;
	
	public ServiceException(String message) {
		this(message, null, 0);
	}
	
	public ServiceException(String message, Throwable causeBy) {
		this(message, causeBy, 0);
	}

	public ServiceException(String message, Throwable causeBy, int errorCode) {
		this.message = message;
		this.causeBy = causeBy;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getCauseBy() {
		return causeBy;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "ServiceException [message=" + message + ", causeBy=" + causeBy + ", errorCode=" + errorCode + "]";
	}

}
