package roman.bannikov.therickandmorty.models.character

import android.graphics.Color

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

   override var selectedCharacter: Character = SAVED_CHARACTERS[0]
        set(value) {
            if (field != value) {
                field = value
                listeners.forEach { it(value) }
            }
        }

    private val listeners = mutableSetOf<CharacterListener>()


    companion object { //тут персонажи хранятся
        private val SAVED_CHARACTERS =
            listOf(Character(id = 100L, "Roman", "Human", "Male", "Alive"))
    }


    override fun getCharacterList(): List<Character> {
        return SAVED_CHARACTERS
    }

    override fun getById(id: Long): Character {
        return SAVED_CHARACTERS.first { it.id == id }
    }

    override fun addListener(listener: CharacterListener) {
        listeners += listener
        listener(selectedCharacter)
    }

    override fun removeListener(listener: CharacterListener) {
        listeners -= listener
    }


}
