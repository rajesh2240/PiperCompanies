package library.location.freedocast.com.myapplication.movieslist

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EqualSpacingItemDecoration() : RecyclerView.ItemDecoration() {
    private var spacing: Int = 10
    private var displayMode: Int = 0

    companion object {
        val HORIZONTAL: Int
            get() = 0
        val VERTICAL: Int
            get() = 1
        val GRID: Int
            get() = 2
    }

    constructor(spacing: Int, displayMode: Int) : this() {
        this.spacing = spacing
        this.displayMode = displayMode
    }

    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildViewHolder(view).adapterPosition
        val itemCount = state.itemCount
        val layoutManager: RecyclerView.LayoutManager = parent.layoutManager!!
        setSpacingForDirection(outRect, layoutManager, position, itemCount)
    }

    private fun setSpacingForDirection(
        outRect: Rect, layoutManager: RecyclerView.LayoutManager,
        position: Int,
        itemCount: Int
    ) {

        // Resolve display mode automatically
        if (displayMode == -1) {
            displayMode = resolveDisplayMode(layoutManager)
        }

        when (displayMode) {
            HORIZONTAL -> {
                outRect.left = this.spacing
                if (position == itemCount - 1) {
                    outRect.right = this.spacing
                } else {
                    outRect.right = 0
                }
                outRect.top = this.spacing
                outRect.bottom = this.spacing
            }

            VERTICAL -> {
                outRect.left = this.spacing
                outRect.right = this.spacing
                outRect.top = this.spacing
                if (position == itemCount - 1) {
                    outRect.bottom = this.spacing
                } else {
                    outRect.bottom = 0
                }
            }

            GRID -> {
                if (layoutManager !is GridLayoutManager) {
                    val gridLayoutManager: GridLayoutManager = layoutManager as GridLayoutManager
                    val cols = gridLayoutManager.spanCount
                    val rows = itemCount / cols

                    outRect.left = spacing
                    if (cols == cols - 1) {
                        outRect.right = spacing
                    } else {
                        outRect.right = 0
                    }
                    if (cols == rows - 1) {
                        outRect.bottom = spacing
                    } else {
                        outRect.bottom = 0
                    }
                    outRect.top = spacing
                }
            }
        }
    }

    private fun resolveDisplayMode(layoutManager: RecyclerView.LayoutManager): Int {
        if (layoutManager !is GridLayoutManager) return GRID
        if (layoutManager.canScrollHorizontally()) return HORIZONTAL
        return VERTICAL
    }

}