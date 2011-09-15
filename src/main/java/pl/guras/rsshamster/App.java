package pl.guras.rsshamster;

import rss.Rss;


import pl.guras.xml.Parser;

public class App {
	
	public static final String FILE_PATH = "src/test/samples/feed.rss";
	
    public static void main( String[] args ) throws Exception {
		Parser parser = new Parser();
		Rss rss = parser.unmarshall(FILE_PATH);
		System.out.println(rss.getVersion().intValue());
    }
}
