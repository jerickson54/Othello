package othello.jerickson_a2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jake on 2/24/2018.
 */

public class othello extends AppCompatActivity {

    private static final String NUM_WINS_BLACK = "numWinsBlack";
    private static final String NUM_WINS_WHITE = "numWinsWhite";
    private static final String WHO_IS_FIRST = "whoIsFirst";

    private boolean blackFirst;
    private int numWinsBlack;
    private int numWinsWhite;

    public static Intent newIntentToMain(Context packageContext, int numWinsBlack, int numWinsWhite, boolean whoIsFirst){

        Intent intent = new Intent(packageContext,main.class);
        intent.putExtra(NUM_WINS_BLACK,numWinsBlack);
        intent.putExtra(NUM_WINS_WHITE,numWinsWhite);
        intent.putExtra(WHO_IS_FIRST,whoIsFirst);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container_othello);

        blackFirst = getIntent().getBooleanExtra(WHO_IS_FIRST,blackFirst);
        numWinsBlack = getIntent().getIntExtra(NUM_WINS_BLACK,0);
        numWinsWhite = getIntent().getIntExtra(NUM_WINS_WHITE,0);


        FragmentManager fm = getSupportFragmentManager();
        //fragment container simply holds fragments
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_othello);

        if(fragment == null){
            //doing this here establishes the fragment is filled with fragment_main as determined by mainFragment.java
            fragment = new othelloFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_othello,fragment)
                    .commit();
        }

    }

}