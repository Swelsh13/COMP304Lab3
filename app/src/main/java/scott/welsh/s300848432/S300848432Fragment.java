package scott.welsh.s300848432;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

//Full Name: Scott Welsh
//student ID: 300848432
//section number: 002

import scott.welsh.s300848432.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link S300848432Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class S300848432Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public S300848432Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment S300848432Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static S300848432Fragment newInstance(String param1, String param2) {
        S300848432Fragment fragment = new S300848432Fragment();
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

        View view = inflater.inflate(R.layout.fragment_s300848432, container, false);


        // We will animate the imageview
        ImageView layoutToAnimate = (ImageView)view.findViewById(R.id.scottImageMoon);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(getContext(), R.anim.orbit);
        // Start the animationa
        layoutToAnimate.startAnimation(an);
        return view;

    }
}