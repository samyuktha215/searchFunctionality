package com.wacoco.searchFunctionality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Filter;

@SpringBootApplication
public class SearchFunctionalityApplication {



	String mainUrl = "https://www.lens.org/lens/search/patent/list";

	public static void main(String[] args) throws IOException {

		//TODO remove mock code here when ready
		List<String> flagList = new ArrayList<String>(
				Arrays.asList("Has Title", "Has Abstract", "Has Legal Events")
		);

		FilterSettings filterSettings = new FilterSettings("Battery", "null", flagList,"null","null","null","null","null","null","null","null","null", "null");

		System.out.println(filterModifier(filterSettings));

	}


	public static String filterModifier(FilterSettings settings) {
		final String mainUrl = "https://www.lens.org/lens/search/patent/list";
		String filterResult = "";

		filterResult = mainUrl + settings.getKeyWord() + settings.getFlags(settings.flags);

		return filterResult;
	}
}


