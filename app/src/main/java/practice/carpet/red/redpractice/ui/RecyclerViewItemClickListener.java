package practice.carpet.red.redpractice.ui;

import android.view.View;

/**
 * Created by nitish on 20/2/18.
 */

public interface RecyclerViewItemClickListener {
    void onItemClick(View view, int position);
    void onItemLongClick(View view, int position);
}
