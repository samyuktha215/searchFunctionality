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


    public String getKeyWord(String keyword) {
        StringBuilder result = new StringBuilder();
        result.append("?q=" + keyword.replace(" ", "%20"));
        return result.toString();
    }

    //TODO "Publish Date To, Filing Date From, Filing Date To" need to be added and logic around it.
    public String getDateRange() {
        String result = "&publishedDate.from=" + dateRange;
        return result;
    }

    //TODO Store maps in another way
    public String getFlags(List<String> flag) {
        StringBuilder result = new StringBuilder("");

        if(flag.isEmpty() == false){
            for (int i = 0; i < flag.size(); i++) {

                result.append(FilterConfig.FLAG_MAP.getOrDefault(flag.get(i), "") + "true");
            }
        } else {
            result.setLength(0);
        }

        return result.toString();
    }

    //TODO Store maps in another way
    public String getJurisdicton(List<String> countries) {
        StringBuilder result = new StringBuilder("");


        if(countries.isEmpty() == false) {
            for (int i = 0; i <countries.size(); i++) {
                result.append("&j.must="+ FilterConfig.COUNTRIES_MAP.getOrDefault(countries.get(i), ""));
            }
        } else{
            result.setLength(0);
        }
        return result.toString();
        }


    public String getApplicants(List<String> applicantsList) {
        StringBuilder result = new StringBuilder("");
        if(applicantsList.isEmpty() == false) {
            for (int i = 0; i < applicantsList.size(); i++) {
                result.append("&applicant.must=" + applicantsList.get(i));
            }

            result.toString().replace(" ", "%20");
        } else {

        }
        return result.toString();
    }

    public String getInventor(List<String> inventorList) {
        StringBuilder result = new StringBuilder("");

        if(inventorList.isEmpty() == false) {
            for (int i = 0; i < inventorList.size(); i++) {
                result.append("&inventor.must=" + inventorList.get(i));
            }

            result.toString().replace(" ", "%20");
        } else {
            result.setLength(0);
        }

        return result.toString();
    }

    public String getOwner(List<String> ownerList) {
        StringBuilder result = new StringBuilder("");
        if(ownerList.isEmpty() == false) {
            for (int i = 0; i < ownerList.size(); i++) {
                result.append("&owner.must=" + ownerList.get(i));
            }
            result.toString().replace(" ", "%20");
        }   else {
            result.setLength(0);
        }
        return result.toString();
    }


    public String getLegalStatus(List<String> legals) {
        StringBuilder result = new StringBuilder("");
        if (legals.isEmpty() == false) {
            for (int i = 0; i <legals.size(); i++) {
                result.append("&patentStatus.must="+ FilterConfig.LEGALSTATUS_MAP.getOrDefault(legals.get(i), ""));
            }
        } else {
            result.setLength(0);
        }
        return result.toString();
    }


    public String getDocumentType(List<String> docTypes) {
        StringBuilder result = new StringBuilder("");
        if (docTypes.isEmpty() == false) {
            for (int i = 0; i <docTypes.size(); i++) {
                result.append("&types.must="+ FilterConfig.DOCTYPE_MAP.getOrDefault(docTypes.get(i), ""));
            }
        } else {
            result.setLength(0);
        }

        return result.toString();
    }

    public String getBiologicals(List<String> bioList) {
        StringBuilder result = new StringBuilder("");
        if (bioList.isEmpty() == false) {
            for (int i = 0; i < bioList.size(); i++) {
                result.append("&sequenceName.must=" + bioList.get(i));
            }
            result.toString().replace(" ", "%20");
        } else {
            result.setLength(0);
        }

        return result.toString();
    }

    public String getClassifications(List<String> classificationList) {
        StringBuilder result = new StringBuilder("");
        if (classificationList.isEmpty() == false) {
            for (int i = 0; i < classificationList.size(); i++) {
                result.append("&classCpc.must=" + classificationList.get(i));
            }
             result.toString().replace(" ", "%20");
        } else {
            result.setLength(0);
        }

        return result.toString();
    }
}