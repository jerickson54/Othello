package othello.jerickson_a2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Jake on 2/19/2018.
 */

public class mainFragment extends Fragment {

    private Button mPlayGameButton;
    private Button mOptionsButton;
    private Button mQuitButton;

    private static final String NUM_WINS_BLACK = "numWinsBlack";
    private static final String NUM_WINS_WHITE = "numWinsWhite";
    private static final String WHO_IS_FIRST = "whoIsFirst";

    private boolean blackFirst;
    private int numWinsBlack;
    private int numWinsWhite;




    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            Log.i("HEYYYY","YOU HAVE GOT STUFF FROM AN INTENT");
            blackFirst = savedInstanceState.getBoolean(WHO_IS_FIRST);
            numWinsBlack = savedInstanceState.getInt(NUM_WINS_BLACK);
            numWinsWhite = savedInstanceState.getInt(NUM_WINS_WHITE);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_main,container,false);

        Bundle b = getActivity().getIntent().getExtras();
        if(b != null) {
            blackFirst = b.getBoolean(WHO_IS_FIRST);
            numWinsWhite = b.getInt(NUM_WINS_WHITE);
            numWinsBlack = b.getInt(NUM_WINS_BLACK);
        }

        else
            blackFirst = true;

        mPlayGameButton = v.findViewById(R.id.play_button);
        mPlayGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent = main.newIntentToGame(getActivity(),numWinsBlack,numWinsWhite,blackFirst);
            startActivity(intent);


                /*
                Fragment othelloFragment = new othelloFragment();

                Bundle bundle = new Bundle();
                bundle.putBoolean(WHO_IS_FIRST,blackFirst);
                bundle.putInt(NUM_WINS_BLACK, numWinsBlack);
                bundle.putInt(NUM_WINS_WHITE,numWinsWhite);
                FragmentTransaction trans = getFragmentManager().beginTransaction();

                trans.replace(R.id.fragment_container,othelloFragment);
                trans.addToBackStack(null);
                trans.commit();
                */




            }


        });

        mOptionsButton = v.findViewById(R.id.options_button);
        mOptionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = main.newIntentToOptions(getActivity(),numWinsBlack,numWinsWhite,blackFirst);
               startActivity(intent);

                /*
                Fragment optionsFragment = new optionsFragment();
                FragmentTransaction trans = getFragmentManager().beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putBoolean(WHO_IS_FIRST,blackFirst);
                bundle.putInt(NUM_WINS_BLACK, numWinsBlack);
                bundle.putInt(NUM_WINS_WHITE,numWinsWhite);

                trans.replace(R.id.fragment_container,optionsFragment);
                trans.addToBackStack(null);
                trans.commit();
                */


            }
        });

        mQuitButton = v.findViewById(R.id.quit_button);
        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            System.exit(1);
            }
        });

        return v;
    }
}
