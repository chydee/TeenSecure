package com.j0t1m4.teensecure.views.adapters

import androidx.recyclerview.widget.RecyclerView

interface ItemMoveCallback {
    interface ItemTouchHelperContract {
        fun onRowMoved(fromPosition: Int, toPosition: Int)
        fun onRowSelected(myViewHolder: RecyclerView.ViewHolder?)
        fun onRowClear(myViewHolder: RecyclerView.ViewHolder?)
    }
}