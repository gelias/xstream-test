package xstream.test.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias(value = "catalog")
public class Model {

	@XStreamAsAttribute
	private Long size;

	@XStreamAsAttribute
	private List<Phone> phones;

	@XStreamOmitField
	private Long age = 0L;

	public Model(Long size, List<Phone> phones) {
		this.age = size;
		this.setSize(size);
		this.setPhones(phones);
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getSize() {
		return size;
	}
}
