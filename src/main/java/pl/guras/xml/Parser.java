package pl.guras.xml;

import generated.ObjectFactory;
import generated.Rss;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Parser {

	private JAXBContext context;
	private ObjectFactory objectFactory;

	public Parser() throws JAXBException{
		context = JAXBContext.newInstance("generated");
		objectFactory = new ObjectFactory();
	}

	public Rss unmarshall(String filePath) throws JAXBException, Exception {
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Rss feed = (Rss) unmarshaller.unmarshal(new File(filePath));

		return feed;
	}
}
