package xstream.test.converter;
import xstream.test.model.Phone;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class PhoneAttributesConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		return Phone.class.equals(type);
	}

	@Override
	public void marshal(Object instance, HierarchicalStreamWriter writer, MarshallingContext context) {
		Phone phone = (Phone) instance;
		writer.addAttribute("ddi", phone.getDdi());
		writer.addAttribute("ddd", phone.getDdd());
		writer.setValue(phone.getNumber());

	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
		return null;
	}

}
