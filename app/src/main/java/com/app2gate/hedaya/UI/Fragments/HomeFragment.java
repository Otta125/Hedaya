package com.app2gate.hedaya.UI.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.app2gate.hedaya.Pojo.PostModel;
import com.app2gate.hedaya.R;
import com.app2gate.hedaya.viewmodels.PostInterface;
import com.app2gate.hedaya.viewmodels.PostViewModel;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.app2gate.hedaya.UI.Adapters.Home_adapter;

import net.time4j.calendar.HijriCalendar;
import net.time4j.format.expert.ChronoFormatter;
import net.time4j.format.expert.PatternType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static net.time4j.SystemClock.inLocalView;


public class HomeFragment extends Fragment implements PostInterface {

    ImageSlider Slider ;
    RecyclerView HomeRecycler;
    PostViewModel postViewModel;
    FrameLayout Loading;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        //// Slider Images
        Slider = view.findViewById(R.id.slide);
                Loading = view.findViewById(R.id.f_prog_id);
        List<SlideModel> imageSlider = new ArrayList<>() ;

        ChronoFormatter<HijriCalendar> hijriFormat =
                ChronoFormatter.setUp(HijriCalendar.family(), Locale.ENGLISH)
                        .addEnglishOrdinal(HijriCalendar.DAY_OF_MONTH)
                        .addPattern(" MMMM yyyy", PatternType.CLDR)
                        .build()
                        .withCalendarVariant(HijriCalendar.VARIANT_UMALQURA);

// conversion from gregorian to hijri-umalqura valid at noon
// (not really valid in the evening when next islamic day starts)
        HijriCalendar today =
               inLocalView().today().transform(
                        HijriCalendar.class,
                        HijriCalendar.VARIANT_UMALQURA
                );
        System.out.println(hijriFormat.format(today));
        imageSlider.add(new SlideModel("https://i.ytimg.com/vi/oaGp88TrQnY/maxresdefault.jpg",hijriFormat.format(today)));
        imageSlider.add(new SlideModel("https://alwasateia.com/wp-content/uploads/2018/02/alhedaia.jpg",hijriFormat.format(today)));
        imageSlider.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHZbW2g_XELpY_64HbFCvxt6IMAMdYbVn8CQ&usqp=CAU",hijriFormat.format(today)));
        Slider.setImageList(imageSlider,true);

        // home menu
        HomeRecycler = view.findViewById(R.id.home_recycle_id);
        postViewModel= new PostViewModel(this);
//        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getPosts();
        Home_adapter adapter = new Home_adapter();
        HomeRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        HomeRecycler.setAdapter(adapter);
        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });

    return view;
    }

    @Override
    public void Load() {
        Loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void Dissmiss() {
        Loading.setVisibility(View.GONE);
    }
}