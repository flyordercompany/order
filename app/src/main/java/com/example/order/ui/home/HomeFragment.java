package com.example.order.ui.home;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.order.CategoryAdapter;
import com.example.order.CategoryModel;
import com.example.order.GridProductLayoutAdapter;
import com.example.order.HomePageAdapter;
import com.example.order.HomePageModel;
import com.example.order.HorizontalProductScrollAdapter;
import com.example.order.HorizontalProductScrollModel;
import com.example.order.R;
import com.example.order.SliderAdapter;
import com.example.order.SliderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_home, container, false);
       categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

       final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronics"));
        categoryModelList.add(new CategoryModel("link","Appliances"));
        categoryModelList.add(new CategoryModel("link","Furniture"));
        categoryModelList.add(new CategoryModel("link","Fashion"));
        categoryModelList.add(new CategoryModel("link","Toys"));
        categoryModelList.add(new CategoryModel("link","Wall Arts"));
        categoryModelList.add(new CategoryModel("link","Books"));
        categoryModelList.add(new CategoryModel("link","shoes"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
        ////////////////////////banner slider

        List<SliderModel>sliderModelList = new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.drawable.my_wishlisticon,"#ffdfd3"));
        sliderModelList.add(new SliderModel(R.drawable.notificationicon,"#ffdfd3"));
        sliderModelList.add(new SliderModel(R.drawable.searchicon,"#ffdfd3"));

        sliderModelList.add(new SliderModel(R.drawable.singouticon,"#ffdfd3"));
        sliderModelList.add(new SliderModel(R.drawable.homeicon,"#ffdfd3"));
        sliderModelList.add(new SliderModel(R.drawable.gmailread,"#ffdfd3"));
        sliderModelList.add(new SliderModel(R.drawable.gmailgreen,"#ffdfd3"));
        sliderModelList.add(new SliderModel(R.drawable.my_accounticon,"#ffdfd3"));
        sliderModelList.add(new SliderModel(R.drawable.my_wishlisticon,"#ffdfd3"));

        sliderModelList.add(new SliderModel(R.drawable.notificationicon,"#ffdfd3"));
        sliderModelList.add(new SliderModel(R.drawable.searchicon,"#ffdfd3"));
        sliderModelList.add(new SliderModel(R.drawable.singouticon,"#ffdfd3"));


        ////////////////////////banner slider



        /////////////// Horizontal product layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone,"iphone 10","Fastest processer","Rs.59999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.homeicon,"home ","world best","Rs.59599/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.searchicon,"search","search processer","Rs.599/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.my_wishlisticon,"iphone 10","Fastest processer","Rs.59949/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.singouticon,"iphone 10","Fastest processer","Rs.999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.my_accounticon,"iphone 10","Fastest processer","Rs.2999/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.notificationicon,"iphone 10","Fastest processer","Rs.399/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.myordericon,"iphone 10","Fastest processer","Rs.599/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone,"iphone 10","Fastest P rocesser","Rs.59999/-"));


        /////////////// Horizontal product layout



        ///////////////////////////

        testing = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());

        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banneronlineshopingimageadd,"#ff0000"));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banneronlineshopingimageadd,"#000000"));
        homePageModelList.add(new HomePageModel(3,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2,"Deals of the Day!",horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banneronlineshopingimageadd,"#000000"));
        homePageModelList.add(new HomePageModel(1,R.drawable.newlogo,"#ffff00"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));


        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        /////////////////////////


        return view;
    }

}