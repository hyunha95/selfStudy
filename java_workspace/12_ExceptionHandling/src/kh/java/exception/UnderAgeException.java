package kh.java.exception;

/**
 * 커스텀 예외클래스
 * - 비지니스 로직을 잘 설명할 수 있는 예외를 직접 만들 수 있다.
 * 
 * 1. checked exception(예외처리 강제화) : extends Exception
 * 2. unchecked exception : extends RuntimeException
 *
 */

public class UnderAgeException extends RuntimeException{

	public UnderAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnderAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnderAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnderAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnderAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
