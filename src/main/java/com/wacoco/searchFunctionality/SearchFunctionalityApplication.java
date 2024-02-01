package com.wacoco.searchFunctionality;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class SearchFunctionalityApplication {



	String mainUrl = "https://www.lens.org/lens/search/patent/list";

	public static void main(String[] args) throws IOException {
	
		//TODO remove mock code when done, from here..
		String keyWords = "Solar panel";
		List<String> flagList = new ArrayList<String>(
		);
		List<String> jurisdictionList = new ArrayList<String>(
		);
		List<String> applicantList = new ArrayList<String>(
		);
		List<String> inventorList = new ArrayList<String>(
		);
		List<String> ownerList = new ArrayList<String>(
		);
		List<String> docTypeList = new ArrayList<String>(
				Arrays.asList("Patent Application")
		);
		List<String> legalsList = new ArrayList<String>(
				Arrays.asList("Active")
		);
		List<String> bioList = new ArrayList<String>(
		);
		List<String> classificationList = new ArrayList<String>(
				Arrays.asList("A61p35/00", "A61p43/00", "Y02e60/10")
		);
		//TODO .. To here
		FilterController filterController = new FilterController(keyWords, "null", flagList,jurisdictionList,applicantList,inventorList,ownerList,legalsList,docTypeList,bioList, classificationList);

		System.out.println("https://www.lens.org/lens/search/patent/list" + filterModifier(filterController));

		try {
			String fileURL = "https://www.lens.org/lens/export/patent" + filterModifier(filterController);
			String savePath = "/Users/robert/Downloads/lens-export.csv";
			downloadCSVFile(fileURL, savePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String filterModifier(FilterController settings) {
		final String mainUrl = "";
		String filterResult = "";

		filterResult = mainUrl + settings.getKeyWord(settings.keyWord) + settings.getFlags(settings.flags) + settings.getJurisdicton(settings.jurisdicton) + settings.getApplicants(settings.applicants) + settings.getInventor(settings.inventor) + settings.getOwner(settings.owner) + settings.getDocumentType(settings.documentType) + settings.getLegalStatus(settings.legalStatus) + settings.getBiologicals(settings.biologicals) + settings.getClassifications(settings.classifications);

		return filterResult;
	}

	public static void downloadCSVFile(String fileURL, String savePath) throws Exception {
		URL url = new URL(fileURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");
		httpConn.setRequestProperty("Content-Type", "application/json");
		httpConn.setRequestProperty("Accept", "*/*");
		httpConn.setRequestProperty("Origin", "https://www.lens.org");
		httpConn.setDoOutput(true);

		// Send request payload, if necessary

		String jsonPayload = "{}"; // Adjust payload based on actual requirements
		try (OutputStream os = httpConn.getOutputStream()) {
			byte[] input = jsonPayload.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		int responseCode = httpConn.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			InputStream inputStream = httpConn.getInputStream();
			FileOutputStream outputStream = new FileOutputStream(savePath);

			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.close();
			inputStream.close();
			System.out.println("File downloaded to " + savePath);
		} else {
			System.out.println("No file to download. Server replied HTTP code: " + responseCode);
		}
		httpConn.disconnect();
	}

}


