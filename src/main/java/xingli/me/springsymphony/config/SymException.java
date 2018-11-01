package xingli.me.springsymphony.config;

/**
 * @author xingli13
 * @date 2018/11/1
 */
public class SymException extends RuntimeException {
	String ec;

	public SymException(String ec) {
		this(ec, ErrorMsg.getSymMsg(ec));
	}

	public SymException(String ec, String em) {
		super(em);
		this.ec = ec;
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

	public String getEc() {
		return ec;
	}

	public void setEc(String ec) {
		this.ec = ec;
	}
}
