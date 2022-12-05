package roman.bannikov.therickandmorty.models.character

/**
 * Simple in-memory implementation of [CharacterRepository]
 *
 * Вся реализация интерфейса CharacterRepository пока сводится к тому, что все персонажи пока просто
 * хранятся в памяти приложения. Но о данной конкретной реализации интерфейса CharacterRepository
 * вью-модель абсолютно ничего не знает. Вью-модель знает только сам интерфейс CharacterRepository,
 * а какая реализация будет у интерфейса CharacterRepository определяется в классе App.
 *
 */
class InMemoryCharacterRepository : CharacterRepository {

    override var selectedCharacterM: CharacterM = SAVED_CHARACTERMS[0]
        set(value) {
            if (field != value) {
                field = value
                listeners.forEach { it(value) }
            }
        }

    private val listeners = mutableSetOf<CharacterListener>()



    companion object { //тут персонажи хранятся


        private val SAVED_CHARACTERMS =
            listOf(
                CharacterM(
                    id = 100,
                    name = "Roman",
                    species = "Human",
                    gender = "Male",
                    status = "Alive",
                    image = "imageUrl",
                    )
            )
    }


    override fun getCharacterList(): List<CharacterM> {
        return SAVED_CHARACTERMS
    }

    override fun getById(id: Int): CharacterM {
        return SAVED_CHARACTERMS.first { it.id == id }
    }

    override fun addListener(listener: CharacterListener) {
        listeners += listener
        listener(selectedCharacterM)
    }

    override fun removeListener(listener: CharacterListener) {
        listeners -= listener
    }


}
