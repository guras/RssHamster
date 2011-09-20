package pl.guras.transfers;

import pl.guras.utils.Downloader;

/**
 *
 * @author margorec
 */
public class DownloadTask implements Runnable {

	private String url;

	public DownloadTask(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		Long start = System.currentTimeMillis();
		try {
			Downloader.get(url);
		} catch (Exception e ) {
			throw new RuntimeException(e);
		}
		Long time = (System.currentTimeMillis() - start)/1000;
		System.out.println("Sciaganie : " + url + " trwalo: " + time.doubleValue() + "s");
	}



}
