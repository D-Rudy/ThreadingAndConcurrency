package com.rdz.concurrency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

public class PageDownloader implements Runnable {

	String[] urlsList;

	public PageDownloader(String[] urlsList) {
		this.urlsList = urlsList;
	}

	@Override
	public void run() {

		try {
			for (String urlString : urlsList) {

				if (Thread.currentThread().isInterrupted()) {
					throw new InterruptedException(Thread.currentThread().getName() + " interrompu");
				}

				URL url = new URL(urlString);
				String fileName = urlString.substring(urlString.lastIndexOf("/") + 1).trim() + ".html";
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

				String line;
				while ((line = reader.readLine()) != null) {
					writer.write(line);
				}
				System.out.println("Page téléchargée: " + fileName);

				writer.close();
//				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String[] urls = new String[] { "https://www.deepl.com/translator", "https://support.deepl.com/hc/fr",
				"https://support.deepl.com/hc/fr/categories/11849287834524-API-de-DeepL",
				"https://www.deepl.com/fr/press",
				"https://support.deepl.com/hc/fr/articles/10801212958876-Mode-%C3%A9dition-pour-la-traduction-de-documents",
				"https://www.deepl.com/fr/app", "https://static.deepl.com/files/press/companyProfile_FR.pdf",
				"https://www.deepl.com/fr/privacy", "https://www.deepl.com/fr/pro-data-security",
				"https://www.deepl.com/fr/features", "https://jobs.deepl.com/career-hub",
				"https://www.deepl.com/fr/integrations" };

		Thread downloaderOne = new Thread(new PageDownloader(Arrays.copyOfRange(urls, 0, urls.length)));

		try {

			long startTime = System.currentTimeMillis();
			downloaderOne.start();

			downloaderOne.join();
			long endTime = System.currentTimeMillis();

			System.out.println("Temps total: " + (endTime - startTime) / 1000 + "s");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("**********************\n");
		downloaderOne = new Thread(new PageDownloader(Arrays.copyOfRange(urls, 0, 6)));
		Thread downloaderTwo = new Thread(new PageDownloader(Arrays.copyOfRange(urls, 6, urls.length)));

		try {

			long startTime = System.currentTimeMillis();
			downloaderOne.start();
			downloaderTwo.start();

			Thread.sleep(10);
			downloaderOne.interrupt();
			downloaderTwo.join();

			long endTime = System.currentTimeMillis();

			System.out.println("Temps total: " + (endTime - startTime) / 1000 + "s");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
