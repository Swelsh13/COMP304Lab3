package scott.welsh.s300848432;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScottFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScottFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;

    public ScottFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScottFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScottFragment newInstance(String param1, String param2) {
        ScottFragment fragment = new ScottFragment();
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
//        return inflater.inflate(R.layout.fragment_scott, container, false);
        view = inflater.inflate(R.layout.fragment_scott,
                container, false);
        Button button = (Button) view.findViewById(R.id.btnClear);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CanvasView cv = (CanvasView)view.findViewById(R.id.canvasDraw);
                cv.clearCanvas();
            }
        });

        RadioButton rdsmall = (RadioButton) view.findViewById(R.id.rdStrokeSmall);
        RadioButton rdmed = (RadioButton) view.findViewById(R.id.rdStrokeMedium);
        RadioButton rdlarge = (RadioButton) view.findViewById(R.id.rdStrokeLarge);
        RadioButton.OnClickListener strokeClickListenener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                float stroke = 1;
                switch (v.getId()){
                    case R.id.rdStrokeLarge:
                        stroke = 24;
                        break;
                    case R.id.rdStrokeMedium:
                        stroke = 14;
                        break;
                    case R.id.rdStrokeSmall:
                        stroke = 4;
                        break;
                }
                CanvasView cv = (CanvasView)view.findViewById(R.id.canvasDraw);

                cv.setStrokeWidth(stroke);
            }
        };
        rdsmall.setOnClickListener(strokeClickListenener);
        rdmed.setOnClickListener(strokeClickListenener);
        rdlarge.setOnClickListener(strokeClickListenener);

        RadioButton rdsBlack = (RadioButton) view.findViewById(R.id.rdColorBlack);
        RadioButton rdBlue = (RadioButton) view.findViewById(R.id.rdColorBlue);
        RadioButton rdRed = (RadioButton) view.findViewById(R.id.rdColorRed);
        RadioButton.OnClickListener colorClickListenener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int color = Color.BLACK;
                switch (v.getId()){
                    case R.id.rdColorRed:
                        color = Color.RED;
                        break;
                    case R.id.rdColorBlue:
                        color = Color.BLUE;
                        break;
                    case R.id.rdColorBlack:
                        color = Color.BLACK;
                        break;
                }
                CanvasView cv = (CanvasView)view.findViewById(R.id.canvasDraw);

                cv.setColor(color);
            }
        };
        rdsBlack.setOnClickListener(colorClickListenener);
        rdBlue.setOnClickListener(colorClickListenener);
        rdRed.setOnClickListener(colorClickListenener);


        return view;
    }
}