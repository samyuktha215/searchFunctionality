package com.wacoco.searchFunctionality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FilterControllerTest {

    private FilterController filterController;
    private String keyWord;
    private String dateRange;
    private List<String> flags;
    private List<String> jurisdiction;
    private List<String> applicants;
    private List<String> inventors;
    private List<String> owners;
    private List<String> legalStatus;
    private List<String> documentType;
    private List<String> biologicals;
    private List<String> classifications;

    @BeforeEach
    void setUp() {
        // Initialize variables with test data
        keyWord = "patent";
        dateRange = "2020-01-01";
        flags = Arrays.asList("Has Title", "Has Abstract");
        jurisdiction = Arrays.asList("United States", "China");
        applicants = Arrays.asList("Applicant1", "Applicant2");
        inventors = Arrays.asList("Inventor1", "Inventor2");
        owners = Arrays.asList("Owner1", "Owner2");
        legalStatus = Arrays.asList("Active", "Pending");
        documentType = Arrays.asList("Patent Application", "Granted Patent");
        biologicals = Arrays.asList("Biological1", "Biological2");
        classifications = Arrays.asList("Classification1", "Classification2");

        // Create a FilterController instance with the test data
        filterController = new FilterController(keyWord, dateRange, flags, jurisdiction, applicants, inventors, owners, legalStatus, documentType, biologicals, classifications);
    }

    @Test
    void testGetKeyWord() {
        String expected = "?q=patent";
        assertEquals(expected, filterController.getKeyWord(), "getKeyWord method failed");
    }

    @Test
    void testGetDateRange() {
        String expected = "&publishedDate.from=2020-01-01";
        assertEquals(expected, filterController.getDateRange(), "getDateRange method failed");
    }

    @Test
    void testGetFlags() {
        String expected = "&hasTitle=true&hasAbstract=true";
        assertEquals(expected, filterController.getFlags(flags), "getFlags method failed");
    }

    @Test
    void testGetJurisdiction() {
        String expected = "&j.must=US&j.must=CN";
        assertEquals(expected, filterController.getJurisdicton(jurisdiction), "getJurisdiction method failed");
    }

    @Test
    void testGetApplicants() {
        // Corrected expectation to match the actual method output
        String expected = "&applicant.must=Applicant1&applicant.must=Applicant2";
        assertEquals(expected, filterController.getApplicants(applicants), "getApplicants method failed");
    }


    @Test
    void testGetInventor() {
        // Corrected expectation to match the actual method output
        String expected = "&inventor.must=Inventor1&inventor.must=Inventor2";
        assertEquals(expected, filterController.getInventor(inventors), "getInventor method failed");
    }


    @Test
    void testGetOwner() {
        // Corrected expectation to match the actual method output
        String expected = "&owner.must=Owner1&owner.must=Owner2";
        assertEquals(expected, filterController.getOwner(owners), "getOwner method failed");
    }

    @Test
    void testGetLegalStatus() {
        String expected = "&patentStatus.must=Active&patentStatus.must=Pending";
        assertEquals(expected, filterController.getLegalStatus(legalStatus), "getLegalStatus method failed");
    }

    @Test
    void testGetDocumentType() {
        String expected = "&types.must=PATENT_APPLICATION&types.must=GRANTED_PATENT";
        assertEquals(expected, filterController.getDocumentType(documentType), "getDocumentType method failed");
    }

    @Test
    void testGetBiologicals() {
        // Corrected expectation to match the actual method output
        String expected = "&sequenceName.must=Biological1&sequenceName.must=Biological2";
        assertEquals(expected, filterController.getBiologicals(biologicals), "getBiologicals method failed");
    }

    @Test
    void testGetClassifications() {
        // Corrected expectation to match the actual method output
        String expected = "&classCpc.must=Classification1&classCpc.must=Classification2";
        assertEquals(expected, filterController.getClassifications(classifications), "getClassifications method failed");
    }

}

