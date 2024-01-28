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
		List<String> flagList = new ArrayList<String>(
				Arrays.asList("Has Title", "Has Abstract", "Has Legal Events")
		);
		List<String> jurisdictionList = new ArrayList<String>(
				Arrays.asList("Poland", "Mexico", "Hungary")
		);
		List<String> applicantList = new ArrayList<String>(
				Arrays.asList("Lg Energy Solution LTD", "Lg Chemical LTD", "Intel Corp")
		);
		List<String> inventorList = new ArrayList<String>(
				Arrays.asList("Robert Kaya", "Bassam", "Mikael Wallin")
		);
		List<String> ownerList = new ArrayList<String>(
				Arrays.asList("International Business Machines Corporation", "Samsung Electronics Co LTD", "Microsoft Technology Licensing LLC")
		);
		List<String> docTypeList = new ArrayList<String>(
				Arrays.asList("Patent Application", "Granted Patent", "Limited Patent")
		);
		List<String> legalsList = new ArrayList<String>(
				Arrays.asList("Active", "Pending", "Expired")
		);
		List<String> bioList = new ArrayList<String>(
				Arrays.asList("Unknown/Artificial", "Homo sapiens", "Mus musculus")
		);
		List<String> classificationList = new ArrayList<String>(
				Arrays.asList("A61p35/00", "A61p43/00", "Y02e60/10")
		);
		//TODO .. To here
		FilterController filterController = new FilterController("Battery", "null", flagList,jurisdictionList,applicantList,inventorList,ownerList,legalsList,docTypeList,bioList, classificationList);

		System.out.println(filterModifier(filterController));



		try {
			//Todo Change to dynamic URL
			String fileURL = "https://www.lens.org/lens/export/patent?q=battery&st=true&e=false&f=false&l=en";
			//TODO Change savePath to correct adress or database
			String savePath = "/Users/robert/Downloads/lens-export.csv";
			downloadCSVFile(fileURL, savePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String filterModifier(FilterController settings) {
		final String mainUrl = "https://www.lens.org/lens/search/patent/list";
		String filterResult = "";

		filterResult = mainUrl + settings.getKeyWord() + settings.getFlags(settings.flags) + settings.getJurisdicton(settings.jurisdicton) + settings.getApplicants(settings.applicants) + settings.getInventor(settings.inventor) + settings.getOwner(settings.owner) + settings.getDocumentType(settings.documentType) + settings.getLegalStatus(settings.legalStatus) + settings.getBiologicals(settings.biologicals) + settings.getClassifications(settings.classifications);

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


