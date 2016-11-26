package buyBorrowExchange;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import app.com.example.android.UBaS.DetailBorrow;
import app.com.example.android.UBaS.R;
import app.com.example.android.UBaS.TakeItemPic;


/**
 * A simple {@link Fragment} subclass.
 */


public class Fragment_Borrow extends Fragment {

    GridView buyGrid;
    ImageAdapter imageAdapter;
    Button lendItem;
    int[] tempImg = {R.drawable.images};
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    public Fragment_Borrow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_borrow, container, false);
        buyGrid = (GridView) rootView.findViewById(R.id.gridView);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        mEditor = mSharedPreferences.edit();



        lendItem = (Button) rootView.findViewById(R.id.lend);
        lendItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itemDesc = new Intent(getContext(), TakeItemPic.class);
                mEditor.putString(getResources().getString(R.string.prevFrag), "borrow").apply();
//                itemDesc.putExtra("Frag", "borrow");
                startActivity(itemDesc);
            }
        });
        imageAdapter = new ImageAdapter(getContext(), tempImg);
        buyGrid.setAdapter(imageAdapter);

        buyGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent borrowIntent = null;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Transition to DetailFragment
                borrowIntent = new Intent(getContext(), DetailBorrow.class);
                startActivity(borrowIntent);
            }
        });

        return rootView;
    }

}
