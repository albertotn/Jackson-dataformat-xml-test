import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import it.test.model.FlsAssDom1;

public final class MapperTest {

	@Test(expected = UnrecognizedPropertyException.class)
	public void simpleMapperTest() throws JsonParseException, JsonMappingException, IOException {
		XmlMapper mapper = new XmlMapper();
		File f = new File(this.getClass().getResource("example.xml").getFile());

		FlsAssDom1 read = mapper.readValue(f, FlsAssDom1.class);

		assertTrue(read != null);
	}

	@Test(expected = MismatchedInputException.class)
	public void caseInsensitiveFeatureMapperTest() throws JsonParseException, JsonMappingException, IOException {
		XmlMapper mapper = new XmlMapper();
		mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
		File f = new File(this.getClass().getResource("example.xml").getFile());

		FlsAssDom1 read = mapper.readValue(f, FlsAssDom1.class);

		assertTrue(read != null);
	}

	@Test
	public void jaxbUnMarshallTest() throws JAXBException {
		XmlMapper mapper = new XmlMapper();
		mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
		File f = new File(this.getClass().getResource("example.xml").getFile());

		JAXBContext jaxbContext = JAXBContext.newInstance(FlsAssDom1.class);
		FlsAssDom1 read = (FlsAssDom1) jaxbContext.createUnmarshaller().unmarshal(f);

		assertTrue(read != null && read.getResidenza().get(0).getASL().equals("123"));
	}

	@Test
	public void jaxbAnnotatorIntrospectorTest()
			throws JsonParseException, JsonMappingException, IOException, XMLStreamException {
		XmlMapper mapper = new XmlMapper();
		// SOLUTION: set JaxbAnnotationIntrospector!
		mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(TypeFactory.defaultInstance()));
		File f = new File(this.getClass().getResource("example.xml").getFile());

		FlsAssDom1 read = mapper.readValue(f, FlsAssDom1.class);

		assertTrue(read != null && read.getResidenza().get(0).getASL().equals("123"));
	}

}
