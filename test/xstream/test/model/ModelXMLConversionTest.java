package xstream.test.model;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import xstream.test.converter.ModelAttributesConverter;
import xstream.test.converter.PhoneAttributesConverter;
import xstream.test.model.Model;
import xstream.test.model.Phone;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ModelXMLConversionTest {

	private XStream xstream;
	private Model model;

	@Before
	public void setUp() throws Exception {
		this.xstream = new XStream(new DomDriver());
		this.model = new Model(Long.valueOf(10), Arrays.asList(new Phone("55", "51", "98765443"), new Phone("55", "48", "87654321")));
	}

	@Test
	public void shouldConvertPOJOWithListAsAFieldAndUsingAliasToRenameClassNames() {

		xstream.alias("fone", Phone.class);
		xstream.alias("catalog", Model.class);
		String xml = xstream.toXML(model);
		assertTrue("Should have Model tag", xml.contains("<catalog>"));
		assertTrue("Should have a list of Phone", xml.contains("<fone>"));

	}

	@Test
	public void shouldConvertPOJOWithListAsAField() {

		String xml = xstream.toXML(model);
		assertTrue("Should have Model tag", xml.contains("<Model>"));
		assertTrue("Should have a list of Phone", xml.contains("<phones class=\"java.util.Arrays$ArrayList\">"));
		assertTrue("Should have Phone tag", xml.contains("<Phone>"));
	}

	@Test
	public void shouldProcessXStreamAnnotations() {

		String xml = "<catalog><size>100</size><age>10</age><phones><fone><ddd>51</ddd><ddi>234342</ddi></fone></phones></catalog>";
		Class[] classes = { Model.class, Phone.class };
		this.xstream.processAnnotations(classes);

		Model model = (Model) this.xstream.fromXML(xml);
		model.toString();

	}

	@Test
	public void shouldUseConverterToUseXMLWithAttributes() {

		this.xstream.alias("phone", Phone.class);
		this.xstream.omitField(Model.class, "age");
		this.xstream.addImplicitArray(Model.class, "phones");
		this.xstream.registerConverter(new ModelAttributesConverter());
		this.xstream.registerConverter(new PhoneAttributesConverter());

		String xml = this.xstream.toXML(model);
		System.out.println(xml);
		assertTrue("Should build phone tag with attributes", xml.contains("<phone ddi=\"55\" ddd=\"51\">98765443</phone>"));
		assertTrue("Should build phone tag with attributes", xml.contains("<phone ddi=\"55\" ddd=\"48\">87654321</phone>"));
	}
}
