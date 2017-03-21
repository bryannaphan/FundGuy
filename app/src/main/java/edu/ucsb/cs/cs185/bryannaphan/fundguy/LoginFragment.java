package edu.ucsb.cs.cs185.bryannaphan.fundguy;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private static final String ARG_LAYOUT_RES_ID = "layoutResId";
    private int layoutResId;

    public static SetBudgetFragment newInstance(int layoutResId) {
        SetBudgetFragment setBudgetFragment = new SetBudgetFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        setBudgetFragment.setArguments(args);

        return setBudgetFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)) {
            layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(layoutResId, container, false);

        // Importing title font
        /*
        TextView welcomeText = (TextView) view.findViewById(R.id.titleText);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Gradies.otf");
        welcomeText.setTypeface(custom_font);
*/
        return view;
    }
}
