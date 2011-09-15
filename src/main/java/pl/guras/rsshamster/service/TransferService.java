package pl.guras.rsshamster.service;

import org.jboss.annotation.ejb.Service;
import pl.guras.xml.Parser;
import pl.guras.transfers.Downloader;
import rss.Rss;

@Service(objectName = "pl.guras.rsshamster:service=TransferService")
public class TransferService implements TransferServiceMBean {

	public static final String FILE_PATH = "src/test/samples/feed.rss";

	@Override
	public void startTransfer() throws Exception {
		Downloader.get("http://whiskyblog.pl/feed/", FILE_PATH);

		Parser parser = new Parser();
		Rss rss = parser.unmarshall(FILE_PATH);
	}
}
