package com.example.order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.order.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        @NonNull ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);

        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

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
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);

        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

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



        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Inflate the menu; this adds items to the action bar if it is present.


        int id = item.getItemId();

        if (id == R.id.main_search_icon) {
            //todo:search
            return true;
        }else if (id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}