package pl.guras.xml;

import rss.ObjectFactory;
import rss.Rss;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Parser {

	private JAXBContext context;
	private ObjectFactory objectFactory;

	public Parser() throws JAXBException{
		context = JAXBContext.newInstance("rss");
		objectFactory = new ObjectFactory();
	}
	
	public Rss unmarshall(String filePath) throws JAXBException, Exception {
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Rss rss = (Rss) unmarshaller.unmarshal(new File(filePath));
		
		return rss;
	}
}
