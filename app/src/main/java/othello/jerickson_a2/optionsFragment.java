package othello.jerickson_a2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Jake on 2/19/2018.
 */

public class optionsFragment extends Fragment{

    private Button mWhoIsFirst;
    private Button mGoBack;
    private Button mResetWins;

    private boolean blackFirst;
    private int numWinsBlack;
    private int numWinsWhite;

    private static final String NUM_WINS_BLACK = "numWinsBlack";
    private static final String NUM_WINS_WHITE = "numWinsWhite";
    private static final String WHO_IS_FIRST = "whoIsFirst";






    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(WHO_IS_FIRST,blackFirst);
        savedInstanceState.putInt(NUM_WINS_BLACK,numWinsBlack);
        savedInstanceState.putInt(NUM_WINS_WHITE,numWinsWhite);

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        /*

           if(savedInstanceState != null){
               Log.i("HEYYYY","YOU HAVE GOT STUFF FROM LANDSCAPE/PORTRAIT CHANGE");
            blackFirst = savedInstanceState.getBoolean(WHO_IS_FIRST);

            mWhoIsFirst = getView().findViewById(R.id.who_first_button);
            if(blackFirst)
            mWhoIsFirst.setText(R.string.first_black);
            else
            mWhoIsFirst.setText(R.string.first_white);
            numWinsBlack = savedInstanceState.getInt(NUM_WINS_BLACK);
            numWinsWhite = savedInstanceState.getInt(NUM_WINS_WHITE);

        }
        */


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_options,container,false);

        Bundle b = getActivity().getIntent().getExtras();
        blackFirst = b.getBoolean(WHO_IS_FIRST);
        numWinsWhite = b.getInt(NUM_WINS_WHITE);
        numWinsBlack = b.getInt(NUM_WINS_BLACK);

        if(savedInstanceState != null){

            blackFirst = savedInstanceState.getBoolean(WHO_IS_FIRST);
            if(blackFirst)
            Log.i("HEYYYY","BLACK");
            else
            Log.i("HEYYYYY","WHITE");

            mWhoIsFirst = v.findViewById(R.id.who_first_button);
            if(blackFirst)
                mWhoIsFirst.setText(R.string.first_black);
            else
                mWhoIsFirst.setText(R.string.first_white);

            numWinsBlack = savedInstanceState.getInt(NUM_WINS_BLACK);
            numWinsWhite = savedInstanceState.getInt(NUM_WINS_WHITE);

        }



        mWhoIsFirst = v.findViewById(R.id.who_first_button);
        if(!blackFirst)
            mWhoIsFirst.setText(R.string.first_white);
        else
            mWhoIsFirst.setText(R.string.first_black);

        mWhoIsFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blackFirst) {
                    mWhoIsFirst.setText(R.string.first_white);
                    blackFirst = false;
                }
                else{
                    mWhoIsFirst.setText(R.string.first_black);
                    blackFirst = true;
                }
            }
        });

        mGoBack= v.findViewById(R.id.go_back_button);
        mGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                Fragment mainFragment = new mainFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean(WHO_IS_FIRST,blackFirst);
                bundle.putInt(NUM_WINS_BLACK, numWinsBlack);
                bundle.putInt(NUM_WINS_WHITE,numWinsWhite);

                FragmentTransaction trans = getFragmentManager().beginTransaction();

                trans.replace(R.id.fragment_container,mainFragment);
                trans.addToBackStack(null);
                trans.commit();
                */

                Intent intent = options.newIntentToMain(getActivity(),numWinsBlack,numWinsWhite,blackFirst);
                startActivity(intent);


            }
        });

        mResetWins = v.findViewById(R.id.reset_wins_button);
        mResetWins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            numWinsBlack = 0;
            numWinsWhite = 0;

            Toast toast = Toast.makeText(getContext(),"Reset Win Count",Toast.LENGTH_SHORT);
            toast.show();
            }
        });


        return v;
    }


}
