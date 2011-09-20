package pl.guras.rsshamster;

import java.util.LinkedList;
import java.util.List;
import pl.guras.transfers.DownloadExecutor;

public class App {

	//public static final String FILE_PATH = "src/test/samples/feed.rss";

	private static final List<String> feeds = new LinkedList<String>();

	public static void main(String[] args) throws Exception {
//		Parser parser = new Parser();
//		Rss rss = parser.unmarshall(FILE_PATH);

		feeds.add("http://mackofff.waw.pl/");
		feeds.add("http://ittechblog.pl");
		feeds.add("http://oldfield-media.blogspot.com/");
		feeds.add("http://www.wegeblog.pl/");
		feeds.add("http://www.matematykafinansowa.pl");
		feeds.add("http://smallbiznes.pl/");
		feeds.add("http://fotomator.blogspot.com/");
		feeds.add("http://muzykoterapia-muzykoterapia.blogspot.com/");
		feeds.add("http://www.blogofilmach.pl");
		feeds.add("http://dnadesign.pl/");
		feeds.add("http://dietki.eu");
		feeds.add("http://wynajembiur.wordpress.com");
		feeds.add("http://i-naturalnie.blogspot.com/");
		feeds.add("http://turcjapopolsku.blogspot.com");
		feeds.add("http://ittechnology.info");
		feeds.add("http://doradca-fachowy.blogspot.com");
		feeds.add("http://msppakt.blox.pl");
		feeds.add("http://maly-podroznik.com.pl/");
		feeds.add("http://half-of-the-moon.blogspot.com/");
	
		DownloadExecutor.startDownload(feeds);
	}
}
