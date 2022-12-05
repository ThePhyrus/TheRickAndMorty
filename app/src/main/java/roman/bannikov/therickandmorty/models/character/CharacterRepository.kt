package roman.bannikov.therickandmorty.models.character

import roman.bannikov.foundation.model.Repository


typealias CharacterListener = (CharacterM) -> Unit


/**
 * Repository interface example.
 *
 * Provides access to the available colors and current selected color.
 *
 * Наследуется от класса Repository из пакета foundation и поределяет список действий, полей,
 * будут доступны для этого репозитория. Именно этот (CharacterRepository) интерфейс будет
 * использоваться для конструктора вью-модели, которая будет работать с CharacterRepository. А уже
 * конкретная реализация CharacterRepository (пока одна и называется InMemoryCharacterRepository)
 * реализует interface CharacterRepository... Сам-то понял, что сказал??.
 */
interface CharacterRepository : Repository {

    var selectedCharacterM: CharacterM

    /**
     * Get the list of all characters that may be chosen by the user.
     */
    fun getCharacterList(): List<CharacterM>

    /**
     * Get the character by its ID
     */
    fun getById(id: Long): CharacterM

    /**
     * Listen for the changes.
     * The listener is triggered immediately with the current value when calling this method.
     */
    fun addListener(listener: CharacterListener)

    /**
     * Stop listening for the changes
     */
    fun removeListener(listener: CharacterListener)

}