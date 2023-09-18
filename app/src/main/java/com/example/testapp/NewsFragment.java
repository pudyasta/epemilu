package com.example.testapp;
import de.hdodenhof.circleimageview.CircleImageView;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<DataModel> listData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = view.findViewById(R.id.rvData);
        listData = new ArrayList<>();
        listData.add(new DataModel("Terbuka Peluang Prima Lolos Sebagai Peserta Pemilu 2024","By DETIK.COM (31 Maret 2023)",R.drawable.gambar1));
        listData.add(new DataModel("Studi NC State University Ungkap Resiko Terkait Pemilu, Apa Itu?","By DETIK.COM (1 Maret 2023)",R.drawable.gambar2));
        listData.add(new DataModel("Bukber Golkar Jabar, Kang Ace Sebut Solidaritas Jadi Modal Menang Pemilu","By DETIK.COM (31 Maret 2023)",R.drawable.gambar3));
        listData.add(new DataModel( "Benarkah Ganjar Antisesis Jokowi Karena Urusan Piala Dunia U-20?","By DETIK.COM (10 Maret 2023)",R.drawable.gambar4));
        listData.add(new DataModel("Politikus PDIP: Capres dari Internal Parpol Itu Keharusan","By DETIK.COM (11 April 2023)",R.drawable.gambar5));
        listData.add(new DataModel("2 Skenario Koalisi Besar Ini Diprediksi Mungkin Terjadi di 2024","By DETIK.COM (20 Mei 2023)",R.drawable.gambar6));

        recyclerView = view.findViewById(R.id.rvData);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new RandomNumListAdapter(listData));
        return view;
    }
}