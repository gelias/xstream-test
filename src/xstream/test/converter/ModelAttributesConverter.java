package xstream.test.converter;
import xstream.test.model.Model;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

class ModelAttributesConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		return false;
	}

	@Override
	public void marshal(Object instance, HierarchicalStreamWriter writer, MarshallingContext context) {
		Model model = (Model) instance;
		writer.addAttribute("size", model.getSize().toString());
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
		return null;
	}

}
