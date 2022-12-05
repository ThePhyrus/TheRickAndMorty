package roman.bannikov.therickandmorty.models.character

data class CharacterM(
    val id: Int,                       // The id of the character
    val name: String,                  // The name of the character
    val species: String,               // The species of the character
    val gender: String,                // The gender of the character ('Female', 'Male', 'Genderless' or 'unknown')
    val status: String,                // The status of the character ('Alive', 'Dead' or 'unknown')
    val image: String,                 // Link to the character's image (300x300px)
//    val type: String,                  // The type or subspecies of the character
//    val created: String,               // Time at which the character was created in the database
//    val episode: List<String>,         // List of episodes in which this character appeared
//    val origin: Map<String, String>,   // Name and link to the character's origin location
//    val location: Map<String, String>, // Name and link to the character's last known location endpoint
//    val url: String,                   // Link to the character's own URL endpoint
//
)

