package roman.bannikov.therickandmorty.models.character

data class Character(
    val id: Long,
    val name:String,
    val species:String,
    val gender:String,
    val status:String,
)