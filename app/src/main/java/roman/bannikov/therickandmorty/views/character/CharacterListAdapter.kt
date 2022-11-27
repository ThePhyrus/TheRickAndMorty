package roman.bannikov.therickandmorty.views.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import roman.bannikov.therickandmorty.databinding.ItemCharacterCardBinding
import roman.bannikov.therickandmorty.model.character.TheCharacter
import roman.bannikov.therickandmorty.views.character.CharacterListAdapter.Listener


/**
 * Adapter for displaying the list of available colors
 * @param listener callback which notifies about user actions on items in the list, see [Listener] for details.
 */
class CharacterListAdapter(
    private val listener: Listener
) : RecyclerView.Adapter<CharacterListAdapter.Holder>(), View.OnClickListener {

    var items: List<TheCharacter> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onClick(v: View) {
        val item = v.tag as TheCharacter
        listener.onCardClick(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterCardBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener(this)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val character = items[position]
        with(holder.binding) {
            root.tag = character
            tvCharacterName.text = character.name

        }
    }

    override fun getItemCount(): Int = items.size

    class Holder(
        val binding: ItemCharacterCardBinding
    ) : RecyclerView.ViewHolder(binding.root)


    interface Listener {
        /**
         * Called when user chooses the specified color
         * @param namedColor color chosen by the user
         */
        fun onCardClick(character: TheCharacter)
    }

}