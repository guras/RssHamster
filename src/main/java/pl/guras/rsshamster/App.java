package pl.guras.rsshamster;

import generated.Rss;
import generated.RssChannel.RssChannelAnyItem;
import generated.RssChannel.RssChannelTitleOrLinkOrDescriptionItem;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import pl.guras.transfers.DownloadExecutor;
import pl.guras.utils.Constants;
import pl.guras.utils.Text;
import pl.guras.xml.Parser;

public class App {

	public static final String FILE_PATH = "src/test/samples/feed.rss";

	private static final List<String> feeds = new LinkedList<String>();

	public static void main(String[] args) throws Exception {
		feeds.add("http://dietki.eu/feed/");
		feeds.add("http://mackofff.waw.pl/");
		feeds.add("http://feeds.feedburner.com/ITTechBlog/");
		feeds.add("http://oldfield-media.blogspot.com/");
		feeds.add("http://www.wegeblog.pl/");
		feeds.add("http://www.matematykafinansowa.pl");
		feeds.add("http://smallbiznes.pl/");
		feeds.add("http://fotomator.blogspot.com/");
		feeds.add("http://muzykoterapia-muzykoterapia.blogspot.com/");
		feeds.add("http://dnadesign.pl/");
		feeds.add("http://wynajembiur.wordpress.com");
		feeds.add("http://i-naturalnie.blogspot.com/");
		feeds.add("http://turcjapopolsku.blogspot.com");
		feeds.add("http://ittechnology.info");
		feeds.add("http://doradca-fachowy.blogspot.com");
		feeds.add("http://msppakt.blox.pl");
		feeds.add("http://maly-podroznik.com.pl/");
		feeds.add("http://half-of-the-moon.blogspot.com/");
	
		//DownloadExecutor.startDownload(feeds);

		Parser parser = new Parser();
		System.out.println("Parsuje : " + feeds.get(0));
		Rss feed = parser.unmarshall(Constants.FILES_PATH + Text.normalize(feeds.get(0)));

		int i = 0;
		for (RssChannelTitleOrLinkOrDescriptionItem item : feed.getChannel().getTitleOrLinkOrDescriptionItems()) {
			System.out.println(i);
			System.out.println(item.getItemDescription());
			System.out.println(item.getItemTitle());
			System.out.println(item.getItemTextInput());
			System.out.println(item.getItemDocs());
			System.out.println(item.getItemCategory());
			System.out.println(item.getItemLink());
			i++;

		}

		
	}
}
