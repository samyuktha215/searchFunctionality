function addTag(tagSystemId) {
    var tagInput = document.getElementById(tagSystemId.replace("-tags", "-input"));
    var tagContainer = document.getElementById(tagSystemId.replace("-tags", "-tag-container"));

    if (tagInput && tagContainer && tagInput.value.trim() !== "") {
        // Check if it is the Keyword tag system
        if (tagSystemId === "keyword-tags") {
            // Remove existing keyword if present
            var existingKeywordTag = tagContainer.querySelector(".tag");
            if (existingKeywordTag) {
                existingKeywordTag.parentNode.removeChild(existingKeywordTag);
            }
        } else {
            // Check if the number of tags is already four
            var existingTags = tagContainer.getElementsByClassName("tag");
            if (existingTags.length >= 4) {
                // Do not allow more than four tags
                return;
            }
        }

        // Add the new tag
        var tag = document.createElement("div");
        tag.className = "tag";
        tag.innerHTML = `<span>${tagInput.value}</span> <span onclick="removeTag(this)">x</span>`;
        tagContainer.appendChild(tag);
        tagInput.value = "";
    }
}

function removeTag(removeButton) {
    var tag = removeButton.parentNode;
    tag.parentNode.removeChild(tag);
}

const flagMap = new Map([
["Has Title"],
["Has Abstract"],
["Has Description"],
["Has Full Text"],
["Has Granted Patent"],
["Has Grant Event"],
["Has National Phase"],
["Has Legal Events"],
["Has DOCDB"],
["Has Applicant"],
["Has Owner"],
["Has Inventor"],
["Has Agent"],
["Has Examiner"],
["Has Sequence Listing"],
["Cited By Patent"],
["Cities NPL"]
]);

// Function to populate the dropdown options
function populateDropdown() {
    const flagsDropdown = document.getElementById("flags-dropdown");

    // Clear existing options
    flagsDropdown.innerHTML = "";

    // Add options for each country
    flagMap.forEach((code, name) => {
        const option = document.createElement("option");
        option.value = code;
        option.text = name;
        flagsDropdown.appendChild(option);
    });
}

// Function to add flag tags
function addFlagTag(tagSystemId) {
    const flagsDropdown = document.getElementById("flags-dropdown");
    const tagContainer = document.getElementById(tagSystemId.replace("-tags", "-tag-container"));

    if (flagsDropdown && tagContainer && flagsDropdown.value.trim() !== "") {
        // Check if the number of tags is already four
        var existingTags = tagContainer.getElementsByClassName("tag");
        if (existingTags.length >= 4) {
            // Do not allow more than four tags
            return;
        }

        // Add the new flag
        const tag = document.createElement("div");
        tag.className = "tag";
        tag.innerHTML = `<span>${flagsDropdown.options[flagsDropdown.selectedIndex].text}</span> <span onclick="removeTag(this)">x</span>`;
        tagContainer.appendChild(tag);
        flagsDropdown.value = "";

        // Populate the dropdown again after adding a tag
        populateDropdown();
    }
}

// Initial population of the dropdown
populateDropdown();

const jurisdictionMap = [
   ["China"],
["European Patents"],
["WO - WIPO"],
["Japan"],
["Korea, Republic of"],
["United Kingdom"],
["Taiwan"],
["Canada"],
["Germany"],
["Australia"],
["Spain"],
["France"],
["Russia"],
["Austria"],
["Poland"],
["Mexico"],
["Hong Kong"],
["Ukraine"],
["Hungary"],
["Soviet Union"],
["Israel"],
["Malaysia"],
["South Africa"],
["Italy"],
["India"],
["Singapore"],
["Denmark"],
["Romania"],
["Philippines"],
["Netherlands"],
["Sweden"],
["Switzerland"],
["New Zealand"],
["Brazil"],
["Bulgaria"],
["Greece"],
["Finland"],
["Portugal"],
["Norway"],
["Czech Republic"],
["Ireland"],
["Slovakia"],
["Belgium"],
["Eurasian Patents"],
["Czechoslovakia"],
["Slovenia"],
["Yugoslavia/Serbia and Montenegro"],
["Luxembourg"],
["Serbia"],
["Croatia"],
["Lithuania"],
["Latvia"],
["Moldova"],
["Saudi Arabia"],
["Turkey"],
["Argentina"],
["ARIPO Patents"],
["Georgia"],
["Tunisia"],
["Jordan"],
["Egypt"],
["Indonesia"],
["Cyprus"],
["Estonia"],
["Cuba"],
["Morocco"],
["Costa Rica"],
["German Democratic Republic"],
["OAPI Patents"],
["Chile"],
["Malta"],
["Zimbabwe"],
["Peru"],
["Colombia"],
["Iceland"],
["San Marino"],
["Algeria"],
["Ecuador"],
["GCC Patents"],
["Montenegro"],
["Malawi"],
["Tajikistan"],
["Zambia"]
    // ... Add the rest of the countries ...
];

// Function to populate the jurisdiction dropdown options
function populateJurisdictionDropdown() {
    const jurisdictionDropdown = document.getElementById("jurisdiction-dropdown");

    // Clear existing options
    jurisdictionDropdown.innerHTML = "";

    // Add options for each country
    jurisdictionMap.forEach((country) => {
        const option = document.createElement("option");
        option.value = country;
        option.text = country;
        jurisdictionDropdown.appendChild(option);
    });
}

// Initial population of the jurisdiction dropdown
populateJurisdictionDropdown();