package com.example.groupproject

class WordleBank {

    private val noneGenBank : Array<String> = arrayOf("About", "Above", "Abuse",
        "Actor", "Acute", "Admit", "Adopt", "Adult", "After", "Again", "Agent", "Agree",
        "Ahead", "Alarm", "Album", "Alert", "Alike", "Alive", "Allow", "Alone", "Along",
        "Alter", "Among", "Anger", "Angle", "Angry", "Apart", "Apple", "Apply", "Arena",
        "Argue", "Arise", "Array", "Aside", "Asset", "Audio", "Audit", "Avoid", "Award",
        "Aware", "Badly", "Baker", "Bases", "Basic", "Basis", "Beach", "Began", "Begin",
        "Begun", "Being", "Below", "Bench", "Billy", "Birth", "Black", "Blame", "Blind",
        "Block", "Blood", "Board", "Boost", "Booth", "Bound", "Brain", "Brand", "Bread",
        "Break", "Breed", "Brief", "Bring", "Broad", "Broke", "Brown", "Build", "Built",
        "Buyer", "Cable", "Calif", "Carry", "Catch", "Cause", "Chain", "Chair", "Chart",
        "Chase", "Cheap", "Check", "Chest", "Chief", "Child", "China", "Chose", "Civil",
        "Claim", "Class", "Clean", "Clear", "Click", "Clock", "Close", "Coach", "Coast",
        "Could", "Count", "Court", "Cover", "Craft", "Crash", "Cream", "Crime", "Cross",
        "Crowd", "Crown", "Curve", "Cycle", "Daily", "Dance", "Dated", "Dealt", "Death",
        "Debut", "Delay", "Depth", "Doing", "Doubt", "Dozen", "Draft", "Drama", "Drawn",
        "Dream", "Dress", "Drill", "Drink", "Drive", "Drove", "Dying", "Eager", "Early",
        "Earth", "Eight", "Elite", "Empty", "Enemy", "Enjoy", "Enter", "Entry", "Equal",
        "Error", "Event", "Every", "Exact", "Exist", "Extra", "Faith", "False", "Fault",
        "Fibre", "Field", "Fifth", "Fifty", "Fight", "Final", "First", "Fixed", "Flash",
        "Fleet", "Floor", "Fluid", "Focus", "Force", "Forth", "Forty", "Forum", "Found",
        "Frame", "Frank", "Fraud", "Fresh", "Front", "Fruit", "Fully", "Funny", "Giant",
        "Given", "Glass", "Globe", "Going", "Grace", "Grade", "Grand", "Grant", "Grass",
        "Great", "Green", "Gross", "Group", "Grown", "Guard", "Guess", "Guest", "Guide",
        "Happy", "Harry", "Heart", "Heavy", "Hence", "Horse", "Hotel", "House", "Human",
        "Ideal", "Image", "Index", "Inner", "Input", "Irony", "Issue", "Joint", "Judge",
        "Juice", "Known", "Label", "Large", "Laser", "Later", "Laugh", "Layer", "Learn",
        "Lease", "Least", "Leave", "Legal", "Level", "Light", "Limit", "Local", "Logic",
        "Loose", "Lower", "Lucky", "Lunch", "Lying", "Magic", "Major", "Maker", "March",
        "Match", "Mayor", "Meant", "Media", "Metal", "Might", "Minor", "Minus", "Mixed",
        "Model", "Money", "Month", "Moral", "Motor", "Mount", "Mouse", "Mouth", "Movie",
        "Music", "Needs", "Never", "Newly", "Night", "Noise", "North", "Noted", "Novel",
        "Nurse", "Occur", "Ocean", "Offer", "Often", "Order", "Other", "Ought", "Paint",
        "Panel", "Paper", "Party", "Peace", "Phase", "Phone", "Photo", "Piece", "Pilot",
        "Pitch", "Place", "Plain", "Plane", "Plant", "Plate", "Point", "Pound", "Power",
        "Press", "Price", "Pride", "Prime", "Print", "Prior", "Prize", "Proof", "Proud",
        "Prove", "Queen", "Quick", "Quiet", "Quite", "Radio", "Raise", "Range", "Rapid",
        "Ratio", "Reach", "Ready", "Refer", "Right", "Rival", "River", "Roman", "Rough",
        "Round", "Route", "Royal", "Rural", "Scale", "Scene", "Scope", "Score", "Sense",
        "Serve", "Seven", "Shall", "Shape", "Share", "Sharp", "Sheet", "Shelf", "Shell",
        "Shift", "Shirt", "Shock", "Shoot", "Short", "Shown", "Sight", "Since", "Sixth",
        "Sixty", "Sized", "Skill", "Sleep", "Slide", "Small", "Smart", "Smile", "Smith",
        "Smoke", "Solid", "Solve", "Sorry", "Sound", "South", "Space", "Spare", "Speak",
        "Speed", "Spend", "Spent", "Split", "Spoke", "Sport", "Staff", "Stage", "Stake",
        "Stand", "Start", "State", "Steam", "Steel", "Stick", "Still", "Stock", "Stone",
        "Stood", "Store", "Storm", "Story", "Strip", "Stuck", "Study", "Stuff", "Style",
        "Sugar", "Suite", "Super", "Sweet", "Table", "Taken", "Taste", "Taxes", "Teach",
        "Teeth", "Texas", "Thank", "Theft", "Their", "Theme", "There", "These", "Thick",
        "Thing", "Think", "Third", "Those", "Three", "Threw", "Throw", "Tight", "Times",
        "Tired", "Title", "Today", "Topic", "Total", "Touch", "Tough", "Tower", "Track",
        "Trade", "Train", "Treat", "Trend", "Trial", "Tried", "Tries", "Truck", "Truly",
        "Trust", "Truth", "Twice", "Under", "Undue", "Union", "Unity", "Until", "Upper",
        "Upset", "Urban", "Usage", "Usual", "Valid", "Value", "Video", "Virus", "Visit",
        "Vital", "Voice", "Waste", "Watch", "Water", "Wheel", "Where", "Which", "While",
        "White", "Whole", "Whose", "Woman", "World", "Worry", "Worse", "Worst", "Worth",
        "Would", "Wound", "Write", "Wrong", "Wrote", "Yield", "Young", "Youth")


    private val christmasBank : Array<String> = arrayOf("Angel", "Bells", "Bough",
        "Candy", "Carol", "Cheer", "Claus", "Comet", "Crown", "Cupid", "Elves", "Fairy",
        "Frost", "Gifts", "Glove", "Gnome", "Green", "Holly", "Jolly", "Merry", "Movie",
        "Myrrh", "Santa", "Scarf", "Snowy", "Vixen", "White")

    private val allUniqueBank : Array<String> = arrayOf("Abode", "Adopt", "Brake",
        "Brave", "Break", "Cabin", "Chain", "Chase", "Cover", "Crate", "Crave", "Dream",
        "Eight", "Eland", "Extra", "Faint", "Fight", "Flake", "Flare", "Focal", "Focus",
        "Frail", "Grail", "Great", "Haste", "Hover", "Image", "Lover", "Might", "Night",
        "Noise", "Paint", "Paste", "Poise", "Quail", "Right", "Satin", "Sedan", "Shale",
        "Sight", "Stare", "Steam", "Trace", "Train", "Urban", "Vocal", "Voice", "Waste",
        "Whale", "White", "Yacht", "Zebra")

    private val noCharEBank : Array<String> = arrayOf("About", "Actor", "Again",
        "Album", "Along", "Among", "April", "Asian", "Award", "Birth", "Black", "Board",
        "Books", "Brown", "Built", "Child", "China", "Civil", "Class", "Clubs", "Coach",
        "Color", "Could", "Court", "David", "Drama", "Dutch", "Films", "Final", "First",
        "Found", "Front", "Goals", "Going", "Grand", "Group", "Hours", "Human", "India",
        "Irish", "Italy", "Japan", "Known", "Light", "Local", "Major", "March", "Match",
        "Minor", "Mount", "Music", "Night", "North", "Paris", "Parts", "Party", "Plant",
        "Plays", "Point", "Radio", "Right", "Roman", "Round", "Royal", "Saint", "Short",
        "Shown", "Shows", "Small", "Smith", "Songs", "South", "Spain", "Staff", "Start",
        "Still", "Story", "Study", "Third", "Total", "Track", "Union", "Units", "Until",
        "Using", "Which", "Woman", "Works", "World", "Would", "Yards", "Young")

    private val africaWordBank : Array<String> = arrayOf("Addis", "Aksum", "Aswan",
        "Atlas", "Cairo", "Congo", "Dakar", "Diani", "Dinka", "Fanta", "Freet", "Ghana",
        "Kenya", "Kilwa", "Kongo", "Kwait", "Lagos", "Maize", "Mamba", "Maori", "Maser",
        "Mozam", "Mummy", "Niger", "Nomad", "Nubia", "Oasis", "Oromo", "Rabat", "Sahel",
        "Samba", "Seren", "Shaka", "Sinai", "Sudan", "Swazi", "Timba", "Timor", "Togol",
        "Zaire", "Zebra")

    private val asiaWordBank : Array<String> = arrayOf("Ankor", "Balis", "Bazar",
        "Bhaji", "Bhakt", "Bhils", "Bhuta", "Borne", "China", "Delhi", "Dubai", "Fijis",
        "Fujiy", "Ganga", "Hanoi", "India", "Kimch", "Laosy", "Macau", "Malay", "Mings",
        "Mysus", "Naidu", "Nepal", "Nizwa", "Omanu", "Osaka", "Petra", "Qatar", "Ramen",
        "Seoul", "Siamy", "Sushi", "Teher", "Thaiy", "Tibet", "Tokyo", "Ulaan", "Urumq",
        "Uzbek", "Yangt", "Yemen")

    private val europeWordBank : Array<String> = arrayOf("Bread", "Crepe", "Elgin",
        "Greek", "Malta", "Milan", "Minsk", "Paris", "Pasta", "Pizza", "Sofia", "Spain",
        "Swiss", "Wales")

    private val northAmericaWordBank : Array<String> = arrayOf("Apple", "Aspen",
        "Beach", "Cider", "Coast", "Creek", "Elgin", "Fargo", "Haiti", "Haven", "Idaho",
        "Maine", "Maple", "Miami", "Oasis", "Pecan", "Salem", "Salsa", "Texas", "Vegas",
        "Yukon")

    private val oceaniaWordBank : Array<String> = arrayOf("Anzac", "Aroha", "Atoll",
        "Bondi", "Canoe", "Coast", "Coral", "Great", "Kauri", "Koala", "Maori", "Marae",
        "Moana", "Nauru", "Ocean", "Opera", "Palau", "Perth", "Samoa", "Tonga", "Totem",
        "Uluru")

    private val southAmericanWordBank : Array<String> = arrayOf("Acari", "Andes",
        "Arepa", "Bahia", "Beach", "Bossa", "Cacao", "Canav", "Canto", "Capoe", "Cevic",
        "Chile", "Churr", "Copac", "Coral", "Cusco", "Cuzco", "Dance", "Forro", "Guava",
        "Iguaz", "Juaze", "Maria", "Mocha", "Norte", "Pacha", "Pampa", "Panty", "Parag",
        "Parai", "Pisco", "Porto", "Queso", "Quito", "Salsa", "Samba", "Santa", "Serra",
        "South", "Sugar", "Tango", "Tropi", "Water")

    fun wordPicker(bankName : String?) : String {
        return when (bankName) {
            "None/Gen" -> noneGenBank.random()
            "Christmas" -> christmasBank.random()
            "All Unique" -> allUniqueBank.random()
            "No Char E" -> noCharEBank.random()
            "Africa" -> africaWordBank.random()
            "Asia" -> asiaWordBank.random()
            "Europe" -> europeWordBank.random()
            "N America" -> northAmericaWordBank.random()
            "Oceania" -> oceaniaWordBank.random()
            "S America" -> southAmericanWordBank.random()
            else -> "ERROR"
        }
    }
}