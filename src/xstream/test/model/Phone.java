package xstream.test.model;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias(value = "fone")
public class Phone {

	@XStreamAsAttribute
	private String ddd;
	@XStreamAsAttribute
	private String ddi;
	private String number;

	public Phone(String ddi, String ddd, String number) {
		this.ddd = ddd;
		this.ddi = ddi;
		this.setNumber(number);
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

}
