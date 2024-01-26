package com.wacoco.searchFunctionality;

import java.util.List;
import java.util.Map;

public class FilterSettings {

    String keyWord;
    String dateRange;
    List<String> flags;
    String jurisdicton;
    String applicants;
    String inventors;
    String owners;
    String agentsAndAttorneys;
    String legalStatus;
    String documentType;
    String citedWorks;
    String biologicals;
    String classifications;

    public FilterSettings(String keyWord, String dateRange, List<String> flags, String jurisdicton, String applicants, String inventors, String owners, String agentsAndAttorneys, String legalStatus, String documentType, String citedWorks, String biologicals, String classifications) {
        this.keyWord = keyWord;
        this.dateRange = dateRange;
        this.flags = flags;
        this.jurisdicton = jurisdicton;
        this.applicants = applicants;
        this.inventors = inventors;
        this.owners = owners;
        this.agentsAndAttorneys = agentsAndAttorneys;
        this.legalStatus = legalStatus;
        this.documentType = documentType;
        this.citedWorks = citedWorks;
        this.biologicals = biologicals;
        this.classifications = classifications;
    }


    public String getKeyWord() {
        String result = "?q=" + keyWord;
        return result;
    }

    //TODO "Publish Date To, Filing Date From, Filing Date To" need to be added and logic around it.
    public String getDateRange() {
        String result = "&publishedDate.from=" + dateRange;
        return result;
    }

    public String getFlags(List<String> flag) {
        StringBuilder result = new StringBuilder("");
        final Map<String, String> FLAG_MAP = Map.ofEntries(
                Map.entry("Has Title", "&hasTitle="),
                Map.entry("Has Abstract", "&hasAbstract="),
                Map.entry("Has Description", "&hasDescription="),
                Map.entry("Has Full Text", "&hasFullText="),
                Map.entry("Has Granted Patent", "&hasGrantedPatent="),
                Map.entry("Has Grant Event", "&hasGrantEvent="),
                Map.entry("Has National Phase", "&hasNationalPhase="),
                Map.entry("Has Legal Events", "&hasInpadoc="),
                Map.entry("Has DOCDB", "&hasDocdb="),
                Map.entry("Has Applicant", "&hasApplicant="),
                Map.entry("Has Owner", "&hasOwner="),
                Map.entry("Has Inventor", "&hasInventor="),
                Map.entry("Has Agent", "&hasAgent="),
                Map.entry("Has Examiner", "&hasExaminer="),
                Map.entry("Has Sequence Listing", "&hasSequenceListing="),
                Map.entry("Cited By Patent", "&citedByPatent="),
                Map.entry("Cities NPL", "&citiesNpl=")
        );

        for (int i = 0; i < flag.size(); i++) {
            result.append(FLAG_MAP.getOrDefault(flag.get(i), null) + "true");
        }

        return result.toString();
    }


    public String getJurisdicton() {
        String result;

        result = "&j.must=" + jurisdicton;

        return result;
    }

    public String getApplicants() {
        return applicants;
    }

    public String getInventors() {
        return inventors;
    }

    public String getOwners() {
        return owners;
    }

    public String getAgentsAndAttorneys() {
        return agentsAndAttorneys;
    }

    public String getLegalStatus() {
        return legalStatus;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getCitedWorks() {
        return citedWorks;
    }



    public String getBiologicals() {
        return biologicals;
    }


    public String getClassifications() {
        return classifications;
    }
}
//Taking search term input from console
//		Scanner scanner = new Scanner(System.in);
//	System.out.println("Please enter the search term.");
//	String searchTerm = scanner.nextLine();