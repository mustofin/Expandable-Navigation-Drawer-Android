package com.mustofin.expandablenavigationdrawer.data;

import com.mustofin.expandablenavigationdrawer.R;
import com.mustofin.expandablenavigationdrawer.fragment.BerandaFragment;
import com.mustofin.expandablenavigationdrawer.fragment.NotifikasiFragment;
import com.mustofin.expandablenavigationdrawer.fragment.TemanDekatFragment;
import com.mustofin.expandablenavigationdrawer.fragment.TemanDekatSekaliFragment;
import com.mustofin.expandablenavigationdrawer.navigationdrawer.NavMenuModel;

import java.util.ArrayList;

/**
 * Created by miki on 7/7/17.
 */

public class Constant {

    public static ArrayList<NavMenuModel> getMenuNavigasi(){
        ArrayList<NavMenuModel> menu = new ArrayList<>();

        menu.add(new NavMenuModel("Beranda", R.drawable.ic_beranda, BerandaFragment.newInstance("kuy")));

        menu.add(new NavMenuModel("Teman", R.drawable.ic_teman,
                new ArrayList<NavMenuModel.SubMenuModel>() {{
                    add(new NavMenuModel.SubMenuModel("Dekat", TemanDekatFragment.newInstance("unch")));
                    add(new NavMenuModel.SubMenuModel("Dekat Sekali", TemanDekatSekaliFragment.newInstance("utututu")));
        }}));

        menu.add(new NavMenuModel("Notifikasi", R.drawable.ic_notifikasi, NotifikasiFragment.newInstance("cuy")));


        return menu;
    }
}
