package pl.guras.transfers;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author margorec
 */
public class DownloadExecutor {
	private static ExecutorService pool = Executors.newFixedThreadPool(2);

	private DownloadExecutor() {}

	public static void startDownload(Collection<String> urls) {
		Long start = System.currentTimeMillis();
		try {
			for(String url : urls) {
				pool.execute(new DownloadTask(url));
			}
		} finally {
			pool.shutdown();
			System.out.println("juz");
		}
	}

	
}