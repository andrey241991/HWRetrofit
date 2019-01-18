package com.example.home_pc.hw_retrofit.ui.mainactivity.view.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerItemDecorator: RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.top = 15
        outRect.right = 15
        outRect.left = 15
    }
}