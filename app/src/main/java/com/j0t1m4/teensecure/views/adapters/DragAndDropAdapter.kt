package com.j0t1m4.teensecure.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.j0t1m4.teensecure.R

class DragAndDropAdapter(
    private val items: MutableList<String>
) : RecyclerView.Adapter<DragAndDropAdapter.DragViewHolder>(), ItemMoveCallback.ItemTouchHelperContract {

    inner class DragViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.draggableItemText)

        fun bind(item: String) {
            textView.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_draggable, parent, false)
        return DragViewHolder(view)
    }

    override fun onBindViewHolder(holder: DragViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    // Handle item movement during drag-and-drop
    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                items[i] = items.set(i + 1, items[i])
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                items[i] = items.set(i - 1, items[i])
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(myViewHolder: RecyclerView.ViewHolder?) {
        // Highlight or animate the selected row
    }

    override fun onRowClear(myViewHolder: RecyclerView.ViewHolder?) {
        // Clear the highlighting or animation when the row is dropped
    }

    // Method to return the current list of items (updated order)
    fun getItems(): List<String> {
        return items
    }
}
