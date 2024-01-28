package com.wacoco.searchFunctionality;

import java.util.List;

public class FilterController {

    String keyWord;
    String dateRange;
    List<String> flags;
    List<String> jurisdicton;
    List<String>  applicants;
    List<String> inventor;
    List<String> owner;
    List<String> legalStatus;
    List<String> documentType;
    List<String> biologicals;
    List<String> classifications;

    public FilterController(String keyWord, String dateRange, List<String> flags, List<String> jurisdicton, List<String>  applicants, List<String> inventor, List<String> owner, List<String> legalStatus, List<String> documentType, List<String> biologicals, List<String> classifications) {
        this.keyWord = keyWord;
        this.dateRange = dateRange;
        this.flags = flags;
        this.jurisdicton = jurisdicton;
        this.applicants = applicants;
        this.inventor = inventor;
        this.owner = owner;
        this.legalStatus = legalStatus;
        this.documentType = documentType;
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

    //TODO Store maps in another way
    public String getFlags(List<String> flag) {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < flag.size(); i++) {
            result.append(FilterConfig.FLAG_MAP.getOrDefault(flag.get(i), null) + "true");
        }

        return result.toString();
    }

    //TODO Store maps in another way
    public String getJurisdicton(List<String> countries) {
        StringBuilder result = new StringBuilder("");



        for (int i = 0; i <countries.size(); i++) {
            result.append("&j.must="+ FilterConfig.COUNTRIES_MAP.getOrDefault(countries.get(i), null));
        }
        return result.toString();
        }


    public String getApplicants(List<String> applicantsList) {
        StringBuilder resultUnModified = new StringBuilder("");

        for (int i = 0; i < applicantsList.size(); i++) {
            resultUnModified.append("&applicant.must=" + applicantsList.get(i));
        }

        String resultModified = resultUnModified.toString().replace(" ", "%20");;

        return resultModified;
    }

    public String getInventor(List<String> inventorList) {
        StringBuilder resultUnModified = new StringBuilder("");

        for (int i = 0; i < inventorList.size(); i++) {
            resultUnModified.append("&inventor.must=" + inventorList.get(i));
        }

        String resultModified = resultUnModified.toString().replace(" ", "%20");;

        return resultModified;
    }

    public String getOwner(List<String> ownerList) {
        StringBuilder resultUnModified = new StringBuilder("");

        for (int i = 0; i < ownerList.size(); i++) {
            resultUnModified.append("&owner.must=" + ownerList.get(i));
        }

        String resultModified = resultUnModified.toString().replace(" ", "%20");;

        return resultModified;
    }

    //TODO Store maps in another way
    public String getLegalStatus(List<String> legals) {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i <legals.size(); i++) {
            result.append("&patentStatus.must="+ FilterConfig.LEGALSTATUS_MAP.getOrDefault(legals.get(i), null));
        }
        return result.toString();
    }

    //TODO Store maps in another way
    public String getDocumentType(List<String> docTypes) {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i <docTypes.size(); i++) {
            result.append("&types.must="+ FilterConfig.DOCTYPE_MAP.getOrDefault(docTypes.get(i), null));
        }


        return result.toString();
    }

    public String getBiologicals(List<String> bioList) {
        StringBuilder resultUnModified = new StringBuilder("");

        for (int i = 0; i < bioList.size(); i++) {
            resultUnModified.append("&sequenceName.must=" + bioList.get(i));
        }

        String resultModified = resultUnModified.toString().replace(" ", "%20");

        return resultModified;
    }

    //TODO make sure
    public String getClassifications(List<String> classificationList) {
        StringBuilder resultUnModified = new StringBuilder("");

        for (int i = 0; i < classificationList.size(); i++) {
            resultUnModified.append("&classCpc.must=" + classificationList.get(i));
        }

        String resultModified = resultUnModified.toString().replace(" ", "%20");

        return resultModified;
    }
}