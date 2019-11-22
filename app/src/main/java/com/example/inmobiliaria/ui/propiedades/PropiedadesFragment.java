package com.example.inmobiliaria.ui.propiedades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.inmobiliaria.ui.inicio.MainActivity;
import com.example.inmobiliaria.ui.inicio.Principal;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Propiedad;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBar;
    private int i=1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);
        ((Principal) getActivity()).setActionBarTitle("Propiedades");

        viewPager=root.findViewById(R.id.viewPager);
        appBar=root.findViewById(R.id.appBar);
        tabLayout=new TabLayout(getContext());

        appBar.addView(tabLayout);

        ViewPageAdapter vpa=new ViewPageAdapter(getChildFragmentManager());
        /*for( Propiedad p : MainActivity.propiedades){
            vpa.addFragment(new ItemPropiedad(p),""+i++);
        }*/

        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);

        return root;
    }

    public  class ViewPageAdapter extends FragmentPagerAdapter{
        private List<Fragment> fragmentList= new ArrayList<>();
        private List<String> titulos=new ArrayList<>();

         public ViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulos.get(position);
        }

        public void addFragment(Fragment fragment,String titulo){
             fragmentList.add(fragment);
             titulos.add(titulo);
        }

    }
}