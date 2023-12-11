package com.example.groupproject

class CountriesBank {

    private val africanCountries : Array<String> = arrayOf("Algeria", "Angola", "Benin",
        "Botswana", "Burkina Faso", "Burundi", "Cabo Verde", "Cameroon", "Cape Verde",
        "Central African Republic", "Chad", "Comoros", "Congo", "Democratic Republic of the Congo",
        "Djibouti", "Egypt", "Equatorial Guinea", "Eritrea", "Eswatini", "Ethiopia", "Gabon",
        "Gambia", "Ghana", "Guinea", "Guinea-Bissau", "Ivory Coast", "Kenya", "Lesotho",
        "Liberia", "Libya", "Madagascar", "Malawi", "Mali", "Mauritania", "Mauritius",
        "Morocco", "Mozambique", "Namibia", "Niger", "Nigeria", "Principe",
        "Republic of Côte d'Ivoire", "Republic of the Congo", "Rwanda", "Sao Tome", "Senegal",
        "Seychelles", "Sierra Leone", "Somalia", "South Africa", "South Sudan", "Sudan",
        "Swaziland", "Tanzania", "The Gambia", "Togo", "Tunisia", "Uganda", "Zambia", "Zimbabwe")

    private val asianCountries : Array<String> = arrayOf("Afghanistan", "Armenia", "Azerbaijan",
        "Bahrain", "Bangladesh", "Bhutan", "British Indian Ocean Territory", "Brunei", "Burma",
        "Cambodia", "China", "Cyprus", "East Timor", "Egypt", "Georgia", "Hong Kong", "India",
        "Indonesia", "Iran", "Iraq", "Israel", "Japan", "Jordan", "Kazakhstan", "Kuwait",
        "Kyrgyzstan", "Laos", "Lebanon", "Macau", "Malaysia", "Maldives", "Mongolia", "Myanmar",
        "Nepal", "North Korea", "Oman", "Pakistan", "Palestine", "Philippines", "Qatar",
        "Saudi Arabia", "Singapore", "South Korea", "Sri Lanka", "Syria", "Taiwan", "Tajikistan",
        "Thailand", "Timor-Leste", "Turkmenistan", "United Arab Emirates", "Uzbekistan", "Vietnam",
        "Yemen")

    private val europeanCountries : Array<String> = arrayOf("Albania", "Andorra", "Austria",
        "Belarus", "Belgium", "Bosnia and Herzegovina", "Bulgaria", "Croatia", "Cyprus",
        "Czech Republic", "Czechia", "Denmark", "Estonia", "Finland", "France", "Germany",
        "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Latvia", "Liechtenstein", "Lithuania",
        "Luxembourg", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands", "North Macedonia",
        "Norway", "Poland", "Portugal", "Romania", "Russia", "San Marino", "Serbia", "Slovakia",
        "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "United Kingdom",
        "Vatican City")

    private val northAmericanCountries : Array<String> = arrayOf("Antigua and Barbuda", "Bahamas",
        "Barbados", "Belize", "Canada", "Costa Rica", "Cuba", "Dominica", "Dominican Republic",
        "El Salvador", "Grenada", "Guatemala", "Haiti", "Honduras", "Jamaica", "Mexico",
        "Nicaragua", "Panama", "Saint Kitts and Nevis", "Saint Lucia",
        "Saint Vincent and the Grenadines", "Trinidad and Tobago", "United States",
        "United States of America")

    private val oceaniaCountries : Array<String> = arrayOf("Australia", "Fiji", "Kiribati",
        "Marshall Islands", "Micronesia", "Nauru", "New Zealand", "Palau", "Papua New Guinea",
        "Samoa", "Solomon Islands", "The Federated States of Micronesia", "Tonga", "Tuvalu",
        "Vanuatu")

    private val southAmericanCountries : Array<String> = arrayOf("Argentina", "Bolivia", "Brazil",
        "Chile", "Colombia", "Ecuador", "Guyana", "Paraguay", "Peru", "Suriname", "Uruguay",
        "Venezuela")

    fun countryToContinent(country : String) : String {
        return when (country) {
            in africanCountries -> "Africa"
            in asianCountries -> "Asia"
            in europeanCountries -> "Europe"
            in northAmericanCountries -> "N America"
            in oceaniaCountries -> "Oceania"
            in southAmericanCountries -> "S America"
            else -> "Unknown"
        }
    }
}