package com.mustofin.expandablenavigationdrawer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mustofin.expandablenavigationdrawer.R;

public class NotifikasiFragment extends Fragment {

    private static final String ARG_PARAM = "";

    public static NotifikasiFragment newInstance() {
        NotifikasiFragment fragment = new NotifikasiFragment();
        return fragment;
    }

    public static NotifikasiFragment newInstance(String param) {
        NotifikasiFragment fragment = new NotifikasiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    String paramText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            paramText = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notifikasi_fragment, container, false);;
        TextView paramView = (TextView) view.findViewById(R.id.param);
        paramView.setText(paramText);

        return view;
    }
}
