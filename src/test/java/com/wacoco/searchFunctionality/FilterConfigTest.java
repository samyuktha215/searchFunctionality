package com.wacoco.searchFunctionality;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilterConfigTest {

    @Test
    void testCountriesMapContainsKeyValues() {
        // Verify the map is not null
        assertNotNull(FilterConfig.COUNTRIES_MAP, "COUNTRIES_MAP should not be null");

        // Test a varied selection of countries
        assertEquals("US", FilterConfig.COUNTRIES_MAP.get("United States"), "United States mapping is incorrect");
        assertEquals("GB", FilterConfig.COUNTRIES_MAP.get("United Kingdom"), "United Kingdom mapping is incorrect");
        assertEquals("IN", FilterConfig.COUNTRIES_MAP.get("India"), "India mapping is incorrect");
        assertEquals("JP", FilterConfig.COUNTRIES_MAP.get("Japan"), "Japan mapping is incorrect");
    }

    @Test
    void testLegalStatusMapContainsKeyValues() {
        // Verify the map is not null
        assertNotNull(FilterConfig.LEGALSTATUS_MAP, "LEGALSTATUS_MAP should not be null");

        // Test a varied selection of legal statuses
        assertEquals("Active", FilterConfig.LEGALSTATUS_MAP.get("Active"), "Active status mapping is incorrect");
        assertEquals("Pending", FilterConfig.LEGALSTATUS_MAP.get("Pending"), "Pending status mapping is incorrect");
        assertEquals("Expired", FilterConfig.LEGALSTATUS_MAP.get("Expired"), "Expired status mapping is incorrect");
    }

    @Test
    void testDocTypeMapContainsKeyValues() {
        // Verify the map is not null
        assertNotNull(FilterConfig.DOCTYPE_MAP, "DOCTYPE_MAP should not be null");

        // Test a varied selection of document types
        assertEquals("PATENT_APPLICATION", FilterConfig.DOCTYPE_MAP.get("Patent Application"), "Patent Application mapping is incorrect");
        assertEquals("GRANTED_PATENT", FilterConfig.DOCTYPE_MAP.get("Granted Patent"), "Granted Patent mapping is incorrect");
        assertEquals("SEARCH_REPORT", FilterConfig.DOCTYPE_MAP.get("Search Report"), "Search Report mapping is incorrect");
    }

    @Test
    void testFlagMapContainsKeyValues() {
        // Verify the map is not null
        assertNotNull(FilterConfig.FLAG_MAP, "FLAG_MAP should not be null");

        // Test a varied selection of flags
        assertEquals("&hasFullText=", FilterConfig.FLAG_MAP.get("Has Full Text"), "Has Full Text flag mapping is incorrect");
        assertEquals("&hasInventor=", FilterConfig.FLAG_MAP.get("Has Inventor"), "Has Inventor flag mapping is incorrect");
        assertEquals("&hasApplicant=", FilterConfig.FLAG_MAP.get("Has Applicant"), "Has Applicant flag mapping is incorrect");
    }
}

