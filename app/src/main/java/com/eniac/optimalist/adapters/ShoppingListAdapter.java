package com.eniac.optimalist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.eniac.optimalist.R;
import com.eniac.optimalist.database.model.ShoppingList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.MyViewHolder> {

    private Context context;
    private List<ShoppingList> shoppingLists;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView shoppingList;
        public TextView dot;
        public TextView timestamp;

        public MyViewHolder(View view) {
            super(view);
            shoppingList = view.findViewById(R.id.shopping_list);
            dot = view.findViewById(R.id.dot);
            timestamp = view.findViewById(R.id.timestamp);
        }
    }


    public ShoppingListAdapter(Context context, List<ShoppingList> shoppingLists) {
        this.context = context;
        this.shoppingLists = shoppingLists;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ShoppingList shoppingList = shoppingLists.get(position);

        holder.shoppingList.setText(shoppingList.getTitle());

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(shoppingList.getCreatedAt()));
    }

    @Override
    public int getItemCount() {
        return shoppingLists.size();
    }

    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("d MMM yyyy - HH:mm:ss");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }
}
