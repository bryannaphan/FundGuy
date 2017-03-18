package edu.ucsb.cs.cs185.bryannaphan.fundguy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.content_main, container, false);
        ListView listView = (ListView) v.findViewById(R.id.purchase_list);

        // Set image adapter and onItemClickListener
        ItemAdapter imageAdapter = new ItemAdapter(getActivity(), true);
        listView.setAdapter(imageAdapter);

        // onItemClickListener should launch intent for ImageActivity w/ correct image by passing in position
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Start new activity with the new extra as its parameters
                // Put position in extra
                //Intent intent = new Intent(getActivity(), DetailsActivity.class);
                //intent.putExtra("Bitmap Position", position);
                //startActivity(intent);
            }
        });

        return v;
    }

}
