# Read with jackson-dataformat-xml file using jaxb generated classes

This project is an example on how use jaxb generation from xsd and read using [jackson-dataformat-xml](https://github.com/FasterXML/jackson-dataformat-xml)

# Setup and run

Clone this repository and use maven install.
All tests should be passed (green)

# Description

Select a xsd schema definition [see example](src/main/resources/specifiche_funzionali_siad_esempio_xml_flusso.xsd) for an [xml file](src/main/resources/example.xml) and generate, using eclipse default generator, corresponding [model file](src/main/java/it/test/model).

Now the problem is: using jackson-dataformat-xml, read the xml file, and unmarshalling it to corresponding generated classes. I've done [some test](src/test/java/MapperTest.java) and found the following solution:

	@Test
	public void jaxbAnnotatorIntrospectorTest()
			throws JsonParseException, JsonMappingException, IOException, XMLStreamException {
		XmlMapper mapper = new XmlMapper();
		//SOLUTION: set JaxbAnnotationIntrospector!
		mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(TypeFactory.defaultInstance()));
		File f = new File(this.getClass().getResource("example.xml").getFile());

		FlsAssDom1 read = mapper.readValue(f, FlsAssDom1.class);

		assertTrue(read != null && read.getResidenza().get(0).getASL().equals("123"));
	}

The line that made the trick is mapper.setAnnotationIntrospector() setting the default JaxbAnnotationIntrospector. If you run the tests ( and debug them ) you can see that other solutions does not work, but this works!

# License

see LICENSE file

# Thanks

Many thanks to Tatu Saloranta that comes with the solution [in this group](https://groups.google.com/forum/#!topic/jackson-user/nzbKfSLhty4) 
 