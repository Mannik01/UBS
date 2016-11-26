package buyBorrowExchange;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import app.com.example.android.UBaS.DetailBuy;
import app.com.example.android.UBaS.R;
import app.com.example.android.UBaS.TakeItemPic;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Buy extends Fragment {

    GridView buyGrid;
    ImageAdapter imageAdapter;
    Button sellItem;
    int[] tempImg = {R.drawable.images};

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private RecyclerView mRecycler;

    public Fragment_Buy() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_buy, container, false);
        buyGrid = (GridView) rootView.findViewById(R.id.gridView);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        mEditor = mSharedPreferences.edit();

        mRecycler = (RecyclerView) rootView.findViewById(R.id.recyclerview);

        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        sellItem = (Button) rootView.findViewById(R.id.sell);
        sellItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itemDesc = new Intent(getContext(), TakeItemPic.class);
                mEditor.putString(getResources().getString(R.string.prevFrag), "buy").apply();
//                itemDesc.putExtra("Frag", "buy");
                startActivity(itemDesc);
            }
        });

        imageAdapter = new ImageAdapter(getContext(), tempImg);
        buyGrid.setAdapter(imageAdapter);

        buyGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            Intent buyIntent = null;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Transition to DetailFragment
                buyIntent = new Intent(getContext(), DetailBuy.class);
                startActivity(buyIntent);
            }
        });

        return rootView;
    }

}
