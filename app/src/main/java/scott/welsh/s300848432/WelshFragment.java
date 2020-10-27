package scott.welsh.s300848432;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import scott.welsh.s300848432.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelshFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelshFragment extends Fragment {
    AnimationDrawable mframeAnimation = null;
    View mView;
    int speed = 250;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WelshFragment() {
        // Required empty public constructor
    }


    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WelshFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WelshFragment newInstance(String param1, String param2) {
        WelshFragment fragment = new WelshFragment();
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
        View view = inflater.inflate(R.layout.fragment_welsh, container, false);

        Button btnCapture = (Button)view.findViewById(R.id.btnCapture);
        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        final Button onButton = (Button) view.findViewById(R.id.btnPlay);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) view.findViewById(R.id.btnStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });

        RadioButton rd1S = (RadioButton) view.findViewById(R.id.rdOneS);
        RadioButton rd2S = (RadioButton) view.findViewById(R.id.rdTwoS);
        RadioButton rd3s = (RadioButton) view.findViewById(R.id.rdThreeS);
        RadioButton rd4s = (RadioButton) view.findViewById(R.id.rdFourS);
        RadioButton.OnClickListener speedClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int newSpeed = 250;
                switch (v.getId()){
                    case R.id.rdOneS:
                        newSpeed = 250;
                        break;
                    case R.id.rdTwoS:
                        newSpeed = 500;
                        break;
                    case R.id.rdThreeS:
                        newSpeed = 750;
                        break;
                    case R.id.rdFourS:
                        newSpeed = 1000;
                        break;
                }

                setAnimSpeed(newSpeed);
            }
        };
        rd1S.setOnClickListener(speedClickListener);
        rd2S.setOnClickListener(speedClickListener);
        rd3s.setOnClickListener(speedClickListener);
        rd4s.setOnClickListener(speedClickListener);


        mView = view;
        return view;
    }

    private void setAnimSpeed(int newSpeed){
        speed = newSpeed;
        mframeAnimation.stop();
        startAnimation();
    }


    private void startAnimation()
    {

        ImageView img = (ImageView)mView.findViewById(R.id.ImageView_anim);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.can0);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.can1);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.can2);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.can3);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.can4);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.can5);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = speed;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);

        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }
}