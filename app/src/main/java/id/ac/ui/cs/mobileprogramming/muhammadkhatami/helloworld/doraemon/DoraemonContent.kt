package id.ac.ui.cs.mobileprogramming.muhammadkhatami.helloworld.doraemon

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DoraemonContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DoraemonItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DoraemonItem> = HashMap()

    private val ITEM_DORAEMON_DICTIONARY: MutableMap<String, String> = HashMap()

    private val COUNT = 5

    init {
        generateDoraemonDictionary()
        var position = 1
        for ((title, doraemonContent) in ITEM_DORAEMON_DICTIONARY) {
            addItem(createDoraemonItem(position, title, doraemonContent))
            position++
        }
    }

    private fun generateDoraemonDictionary() {
        ITEM_DORAEMON_DICTIONARY["Take-copter"] = "Take-copter or Bamboo Copter (\"The Hopter\" " +
                "in the US English dub and manga) is the most frequently used gadget in the " +
                "Doraemon series. The name combines the words take tombo (bamboo dragonfly, the " +
                "Japanese name for bamboo-copter), and herikoputa, meaning helicopter. The " +
                "bamboo-copter is one of the most-if not the most-used gadgets in the series. " +
                "It was used to be called \"heri-tombo\""
        ITEM_DORAEMON_DICTIONARY["Anywhere Door"] = "The Anywhere Door (Dokodemo Door in " +
                "Japanese, and Anywhere Door in English) is one of the most popular and frequently" +
                " used gadgets in the series. It basically resembles a pink door. Its prime " +
                "function is to transport the user to whatever location they desire by walking " +
                "through it. Dokodemo Doors vary in their design, but their function is the same."
        ITEM_DORAEMON_DICTIONARY["Copying-Toast"] = "Copying Toast (暗記 パン Anki Pan, lit. " +
                "\"Memorization Bread\") or Memory Bread in the English dub, is a gadget that " +
                "resembles a typical, single-loaf of plain bread. It allows the user to memorize " +
                "any contents 'printed' on it."
        ITEM_DORAEMON_DICTIONARY["Big Light"] = "Big Light, known as the Magnify Ray in the " +
                "English dub, is a gadget of Doraemon's. It is a flashlight which is capable of " +
                "increasing the size of anything, therefore it's used to turn objects or people " +
                "large. It is used in many episodes."
        ITEM_DORAEMON_DICTIONARY["Time Machine"] = "The time machine is the primary means of " +
                "time travel in the Doraemon series. Using it, one can travel through both time " +
                "and space, usually by traveling in a \"tunnel\" of space-time.\n" +
                "One may decide the portal of access of one's time machine, homologous " +
                "to a pier or parking place in common transport."
    }

    private fun addItem(item: DoraemonItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createDoraemonItem(position: Int, title: String, doraemonContent: String): DoraemonItem {
        return DoraemonItem(position.toString(), title, doraemonContent)
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DoraemonItem(val id: String, val title: String, val doraemonContent: String) {
        override fun toString(): String = title
    }
}