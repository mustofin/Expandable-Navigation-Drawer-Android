package com.mustofin.expandablenavigationdrawer.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mustofin.expandablenavigationdrawer.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miki on 7/7/17.
 */

public class NavMenuAdapter extends ExpandableRecyclerViewAdapter<TitleViewHolder, SubTitleViewHolder> {
    private Context context;
    private MenuItemClickListener mListener;
    public String selectedItemParent = "";
    public String selectedItemChild = "";
    public ArrayList<String> isExpandList = new ArrayList<>();

    public NavMenuAdapter(Context context, List<? extends ExpandableGroup> groups, Activity activity) {
        super(groups);
        this.context = context;
        this.mListener = (MenuItemClickListener) activity;
    }

    @Override
    public TitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nav_menu_item, parent, false);
        TitleViewHolder holder = new TitleViewHolder(view, this);
        holder.setIsRecyclable(false);
        return holder;
    }

    @Override
    public SubTitleViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nav_submenu_item, parent, false);
        SubTitleViewHolder holder = new SubTitleViewHolder(view);
        holder.setIsRecyclable(false);
        return holder;
    }

    @Override
    public void onBindChildViewHolder(final SubTitleViewHolder holder, final int flatPosition,
                                      ExpandableGroup group, final int childIndex) {
        final TitleMenu menu = ((TitleMenu) group);
        final SubTitle subTitle = menu.getItems().get(childIndex);

        if(selectedItemChild.equals(subTitle.getName()))
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorGrayLight));
        else
            holder.itemView.setBackgroundColor(Color.WHITE);


        holder.setSubTitletName(subTitle.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedItemParent = menu.getTitle();
                selectedItemChild = subTitle.getName();
                mListener.onMenuItemClick(subTitle.getName());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onBindGroupViewHolder(final TitleViewHolder holder, final int flatPosition, ExpandableGroup group) {
        final TitleMenu menu = (TitleMenu) group;

        if(selectedItemParent.equals(menu.getTitle()))
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        else
            holder.itemView.setBackgroundColor(Color.WHITE);

        holder.setGenreTitle(context, menu);

        if (menu.getItems().size() < 1){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedItemParent = menu.getTitle();
                    selectedItemChild = "";
                    mListener.onMenuItemClick(menu.getTitle());
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface MenuItemClickListener{
        void onMenuItemClick(String itemString);
    }
}
