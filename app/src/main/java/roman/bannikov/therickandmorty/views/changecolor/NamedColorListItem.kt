package roman.bannikov.therickandmorty.views.changecolor

import roman.bannikov.therickandmorty.model.colors.NamedColor

/**
 * Represents list item for the color; it may be selected or not
 */
data class NamedColorListItem(
    val namedColor: NamedColor,
    val selected: Boolean
)