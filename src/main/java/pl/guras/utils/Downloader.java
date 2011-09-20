package pl.guras.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.apache.log4j.Logger;

public class Downloader {

	private static final Logger LOG = Logger.getLogger(Downloader.class);

	public static void get(String address) throws MalformedURLException, IOException {
		download(address,  URLEncoder.encode(address, "UTF-8"));
	}

	public static void get(String address, String filename) throws MalformedURLException, IOException {
		download(address, filename);
	}

	private static void download(String address, String filename) throws MalformedURLException, IOException {
		URLConnection connection = configureConnection(address);
		logConnectionData(connection);

		BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(Constants.FILES_PATH + filename));
		int i;
		
		try {
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			System.out.println("Polaczenie zamkni?te");
		}
	}

	private static URLConnection configureConnection(String address) throws MalformedURLException, IOException {
		URL url = new URL(address);
		URLConnection connection = url.openConnection();

		connection.setConnectTimeout(Constants.CONNECTION_TIMEOUT);
		connection.setReadTimeout(Constants.READ_TIMEOUT);
		connection.setRequestProperty(Constants.USER_AGENT_NAME, Constants.USER_AGENT_VALUE);

		return connection;
	}

	private static void logConnectionData(URLConnection connection) {
		LOG.info("Url:" + connection.getURL().toString());
		LOG.info("ContentType:" + connection.getContentType());
		LOG.info("LastModified:" + connection.getLastModified());
		LOG.info("ContentLength:" + connection.getContentLength());
		LOG.info("ContentEncoding:" + connection.getContentEncoding());
	}
}
