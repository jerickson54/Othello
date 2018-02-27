package othello.jerickson_a2;


import android.content.Intent;
import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Jake on 2/19/2018.
 */

public class othelloFragment extends Fragment implements View.OnClickListener{

    private int numWinsBlack = 0;
    private int numWinsWhite = 0;

    private TextView numBlackWins;
    private TextView numWhiteWins;

    private Button newGameButton;
    private Button goBackButton;

    private static final String NUM_WINS_BLACK = "numWinsBlack";
    private static final String NUM_WINS_WHITE = "numWinsWhite";
    private static final String WHO_IS_FIRST = "whoIsFirst";
    private static final String GAME_OVER = "gameover";

    private static final String KEY_BOARD1 = "board1";
    private static final String KEY_BOARD0 = "board0";
    private static final String KEY_BOARD2 = "board2";
    private static final String KEY_BOARD3 = "board3";
    private static final String KEY_BOARD4 = "board4";
    private static final String KEY_BOARD5 = "board5";

    private boolean blackGoing = true;
    private boolean gameIsOver;

    private boolean blackHasPlayableMoves = true;
    private boolean whiteHasPlayableMoves = true;

    private int mBoard[][];
    private TextView whosTurnIsIt;

    private ImageButton b00;
    private ImageButton b10;
    private ImageButton b20;
    private ImageButton b30;
    private ImageButton b40;
    private ImageButton b50;

    private ImageButton b01;
    private ImageButton b11;
    private ImageButton b21;
    private ImageButton b31;
    private ImageButton b41;
    private ImageButton b51;

    private ImageButton b02;
    private ImageButton b12;
    private ImageButton b22;
    private ImageButton b32;
    private ImageButton b42;
    private ImageButton b52;

    private ImageButton b03;
    private ImageButton b13;
    private ImageButton b23;
    private ImageButton b33;
    private ImageButton b43;
    private ImageButton b53;

    private ImageButton b04;
    private ImageButton b14;
    private ImageButton b24;
    private ImageButton b34;
    private ImageButton b44;
    private ImageButton b54;

    private ImageButton b05;
    private ImageButton b15;
    private ImageButton b25;
    private ImageButton b35;
    private ImageButton b45;
    private ImageButton b55;



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);




    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(WHO_IS_FIRST,blackGoing);
        savedInstanceState.putInt(NUM_WINS_BLACK,numWinsBlack);
        savedInstanceState.putInt(NUM_WINS_WHITE,numWinsWhite);
        savedInstanceState.putBoolean(GAME_OVER,gameIsOver);
        //have to put each row at a time

        savedInstanceState.putIntArray(KEY_BOARD0,mBoard[0]);
        savedInstanceState.putIntArray(KEY_BOARD1,mBoard[1]);
        savedInstanceState.putIntArray(KEY_BOARD2,mBoard[2]);
        savedInstanceState.putIntArray(KEY_BOARD3,mBoard[3]);
        savedInstanceState.putIntArray(KEY_BOARD4,mBoard[4]);
        savedInstanceState.putIntArray(KEY_BOARD5,mBoard[5]);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_othello,container,false);


        Bundle b = getActivity().getIntent().getExtras();
        blackGoing = b.getBoolean(WHO_IS_FIRST);
        numWinsWhite = b.getInt(NUM_WINS_WHITE);
        numWinsBlack = b.getInt(NUM_WINS_BLACK);


        b00 = v.findViewById(R.id.button00);
        b00.setOnClickListener(this);
        b10 = v.findViewById(R.id.button10);
        b10.setOnClickListener(this);
        b20 = v.findViewById(R.id.button20);
        b20.setOnClickListener(this);
        b30 = v.findViewById(R.id.button30);
        b30.setOnClickListener(this);
        b40 = v.findViewById(R.id.button40);
        b40.setOnClickListener(this);
        b50 = v.findViewById(R.id.button50);
        b50.setOnClickListener(this);

        b01 = v.findViewById(R.id.button01);
        b01.setOnClickListener(this);
        b11 = v.findViewById(R.id.button11);
        b11.setOnClickListener(this);
        b21 = v.findViewById(R.id.button21);
        b21.setOnClickListener(this);
        b31 = v.findViewById(R.id.button31);
        b31.setOnClickListener(this);
        b41 = v.findViewById(R.id.button41);
        b41.setOnClickListener(this);
        b51 = v.findViewById(R.id.button51);
        b51.setOnClickListener(this);

        b02 = v.findViewById(R.id.button02);
        b02.setOnClickListener(this);
        b12 = v.findViewById(R.id.button12);
        b12.setOnClickListener(this);
        b22 = v.findViewById(R.id.button22);
        b22.setOnClickListener(this);
        b32 = v.findViewById(R.id.button32);
        b32.setOnClickListener(this);
        b42 = v.findViewById(R.id.button42);
        b42.setOnClickListener(this);
        b52 = v.findViewById(R.id.button52);
        b52.setOnClickListener(this);

        b03 = v.findViewById(R.id.button03);
        b03.setOnClickListener(this);
        b13 = v.findViewById(R.id.button13);
        b13.setOnClickListener(this);
        b23 = v.findViewById(R.id.button23);
        b23.setOnClickListener(this);
        b33 = v.findViewById(R.id.button33);
        b33.setOnClickListener(this);
        b43 = v.findViewById(R.id.button43);
        b43.setOnClickListener(this);
        b53 = v.findViewById(R.id.button53);
        b53.setOnClickListener(this);

        b04 = v.findViewById(R.id.button04);
        b04.setOnClickListener(this);
        b14 = v.findViewById(R.id.button14);
        b14.setOnClickListener(this);
        b24 = v.findViewById(R.id.button24);
        b24.setOnClickListener(this);
        b34 = v.findViewById(R.id.button34);
        b34.setOnClickListener(this);
        b44 = v.findViewById(R.id.button44);
        b44.setOnClickListener(this);
        b54 = v.findViewById(R.id.button54);
        b54.setOnClickListener(this);

        b05 = v.findViewById(R.id.button05);
        b05.setOnClickListener(this);
        b15 = v.findViewById(R.id.button15);
        b15.setOnClickListener(this);
        b25 = v.findViewById(R.id.button25);
        b25.setOnClickListener(this);
        b35 = v.findViewById(R.id.button35);
        b35.setOnClickListener(this);
        b45 = v.findViewById(R.id.button45);
        b45.setOnClickListener(this);
        b55 = v.findViewById(R.id.button55);
        b55.setOnClickListener(this);

        if(savedInstanceState != null){

            blackGoing = savedInstanceState.getBoolean(WHO_IS_FIRST);
            whosTurnIsIt = v.findViewById(R.id.whoTurnIsIt);
            if(blackGoing)
                whosTurnIsIt.setText(R.string.blackTurn);
            else
                whosTurnIsIt.setText(R.string.whiteTurn);

            numWinsBlack = savedInstanceState.getInt(NUM_WINS_BLACK);
            numBlackWins = v.findViewById(R.id.numBlackWins);
            numBlackWins.setText(Integer.toString(numWinsBlack));
            numWinsWhite = savedInstanceState.getInt(NUM_WINS_WHITE);
            numWhiteWins = v.findViewById(R.id.numWhiteWins);
            numWhiteWins.setText(Integer.toString(numWinsWhite));

            mBoard = new int [6][6];
            mBoard[0] = savedInstanceState.getIntArray(KEY_BOARD0);
            mBoard[1] = savedInstanceState.getIntArray(KEY_BOARD1);
            mBoard[2] = savedInstanceState.getIntArray(KEY_BOARD2);
            mBoard[3] = savedInstanceState.getIntArray(KEY_BOARD3);
            mBoard[4] = savedInstanceState.getIntArray(KEY_BOARD4);
            mBoard[5] = savedInstanceState.getIntArray(KEY_BOARD5);

            updateBoardOrientationChange();

            gameIsOver = savedInstanceState.getBoolean(GAME_OVER);
            if(gameIsOver){
                newGameButton = v.findViewById(R.id.new_game_button);
                newGameButton.setVisibility(View.VISIBLE);
                goBackButton = v.findViewById(R.id.go_back_button);
                goBackButton.setVisibility(View.VISIBLE);

            }



        }

        else {
            mBoard = new int[6][6];
            //WHITE IS 2. BLACK is 1. EMPTY is 0
            mBoard[2][2] = 2;
            mBoard[3][3] = 2;
            mBoard[3][2] = 1;
            mBoard[2][3] = 1;
            gameIsOver = false;
        }

        //check whether options have been changed to see who is first

        whosTurnIsIt = v.findViewById(R.id.whoTurnIsIt);
        if(blackGoing)
            whosTurnIsIt.setText(R.string.blackTurn);
        else
            whosTurnIsIt.setText(R.string.whiteTurn);

        newGameButton = v.findViewById(R.id.new_game_button);
        if(!gameIsOver)
        newGameButton.setVisibility(View.GONE);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBoard();
                gameIsOver = false;
                newGameButton.setVisibility(View.GONE);
                goBackButton.setVisibility(View.GONE);

            }
        });

        goBackButton = v.findViewById(R.id.go_back_button);
        if(!gameIsOver)
        goBackButton.setVisibility(View.GONE);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                Fragment mainFragment = new mainFragment();
                FragmentTransaction trans = getFragmentManager().beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putBoolean(WHO_IS_FIRST,blackGoing);
                bundle.putInt(NUM_WINS_BLACK, numWinsBlack);
                bundle.putInt(NUM_WINS_WHITE,numWinsWhite);

                trans.replace(R.id.fragment_container,mainFragment);
                trans.addToBackStack(null);
                trans.commit();
                */

                Intent intent = options.newIntentToMain(getActivity(),numWinsBlack,numWinsWhite,blackGoing);
                startActivity(intent);

            }
        });

        numBlackWins = v.findViewById(R.id.numBlackWins);
        numBlackWins.setText(Integer.toString(numWinsBlack));

        numWhiteWins = v.findViewById(R.id.numWhiteWins);
        numWhiteWins.setText(Integer.toString(numWinsWhite));







        return v;

    }


    public void resetBoard(){
        for(int i =0; i < mBoard.length;++i){
            for(int j = 0; j < mBoard.length;++j){
                mBoard[i][j] = 0;
            }
        }

        //blackGoing = !blackGoing;
        blackHasPlayableMoves = true;
        whiteHasPlayableMoves = true;

        //default board placement
        mBoard[2][2] = 2;
        mBoard[3][3] = 2;
        mBoard[3][2] = 1;
        mBoard[2][3] = 1;

        b00.setImageResource(0);
        b01.setImageResource(0);
        b02.setImageResource(0);
        b03.setImageResource(0);
        b04.setImageResource(0);
        b05.setImageResource(0);

        b10.setImageResource(0);
        b11.setImageResource(0);
        b12.setImageResource(0);
        b13.setImageResource(0);
        b14.setImageResource(0);
        b15.setImageResource(0);

        b20.setImageResource(0);
        b21.setImageResource(0);
        b22.setImageResource(R.mipmap.white_piece);
        b23.setImageResource(R.mipmap.black_piece);
        b24.setImageResource(0);
        b25.setImageResource(0);

        b30.setImageResource(0);
        b31.setImageResource(0);
        b32.setImageResource(R.mipmap.black_piece);
        b33.setImageResource(R.mipmap.white_piece);
        b34.setImageResource(0);
        b35.setImageResource(0);

        b40.setImageResource(0);
        b41.setImageResource(0);
        b42.setImageResource(0);
        b43.setImageResource(0);
        b44.setImageResource(0);
        b45.setImageResource(0);

        b50.setImageResource(0);
        b51.setImageResource(0);
        b52.setImageResource(0);
        b53.setImageResource(0);
        b54.setImageResource(0);
        b55.setImageResource(0);

    }
    public void checkIfAnyPlayableMoves() {

        if (blackGoing) {
            doesBlackHavePlayableMoves();
            if (!blackHasPlayableMoves) {
                blackGoing = !blackGoing;
                doesWhiteHavePlayableMoves();
                if (!whiteHasPlayableMoves)
                    checkWhoWins();
                else
                    whiteHasPlayableMoves = true;


            }
            else
                blackHasPlayableMoves = true;
        } else {
            doesWhiteHavePlayableMoves();
            if (!whiteHasPlayableMoves) {
                blackGoing = !blackGoing;
                doesBlackHavePlayableMoves();
                if (!blackHasPlayableMoves)
                    checkWhoWins();



            }

        }
    }

    //using this for all the buttons
    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.button00:
                if(mBoard[0][0] == 0 && blackGoing && canPlay(0,0)) {
                    b00.setImageResource(R.mipmap.black_piece);
                    mBoard[0][0] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();



                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);


                }
                else if(mBoard[0][0] == 0 && (!blackGoing) && canPlay(0,0)) {
                    b00.setImageResource(R.mipmap.white_piece);
                    mBoard[0][0] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button10:
                if(mBoard[1][0] == 0 && blackGoing && canPlay(1,0)) {
                    b10.setImageResource(R.mipmap.black_piece);
                    mBoard[1][0] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[1][0] == 0 && (!blackGoing)&& canPlay(1,0)) {
                    b10.setImageResource(R.mipmap.white_piece);
                    mBoard[1][0] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button20:
                if(mBoard[2][0] == 0 && blackGoing && canPlay(2,0)) {
                    b20.setImageResource(R.mipmap.black_piece);
                    mBoard[2][0] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[2][0] == 0 && (!blackGoing) && canPlay(2,0)) {
                    b20.setImageResource(R.mipmap.white_piece);
                    mBoard[2][0] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button30:
                if(mBoard[3][0] == 0 && blackGoing && canPlay(3,0)) {
                    b30.setImageResource(R.mipmap.black_piece);
                    mBoard[3][0] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);


                }
                else if(mBoard[3][0] == 0 && (!blackGoing) && canPlay(3,0)) {
                    b30.setImageResource(R.mipmap.white_piece);
                    mBoard[3][0] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button40:
                if(mBoard[4][0] == 0 && blackGoing && canPlay(4,0)) {
                    b40.setImageResource(R.mipmap.black_piece);
                    mBoard[4][0] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[4][0] == 0 && (!blackGoing) && canPlay(4,0)) {
                    b40.setImageResource(R.mipmap.white_piece);
                    mBoard[4][0] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button50:
                if(mBoard[5][0] == 0 && blackGoing && canPlay(5,0)) {
                    b50.setImageResource(R.mipmap.black_piece);
                    mBoard[5][0] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[5][0] == 0 && (!blackGoing) && canPlay(5,0)) {
                    b50.setImageResource(R.mipmap.white_piece);
                    mBoard[5][0] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();
                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;

            case R.id.button01:
                if(mBoard[0][1] == 0 && blackGoing && canPlay(0,1)) {
                    b01.setImageResource(R.mipmap.black_piece);
                    mBoard[0][1] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[0][1] == 0 && (!blackGoing) && canPlay(0,1)) {
                    b01.setImageResource(R.mipmap.white_piece);
                    mBoard[0][1] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button11:
                if(mBoard[1][1] == 0 && blackGoing && canPlay(1,1)) {
                    b11.setImageResource(R.mipmap.black_piece);
                    mBoard[1][1] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[1][1] == 0 && (!blackGoing) && canPlay(1,1)) {
                    b11.setImageResource(R.mipmap.white_piece);
                    mBoard[1][1] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button21:
                if(mBoard[2][1] == 0 && blackGoing && canPlay(2,1)) {
                    b21.setImageResource(R.mipmap.black_piece);
                    mBoard[2][1] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                    whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);


                }
                else if(mBoard[2][1] == 0 && (!blackGoing) && canPlay(2,1)) {
                    b21.setImageResource(R.mipmap.white_piece);
                    mBoard[2][1] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);



                }
                break;
            case R.id.button31:
                if(mBoard[3][1] == 0 && blackGoing && canPlay(3,1)) {
                    b31.setImageResource(R.mipmap.black_piece);
                    mBoard[3][1] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[3][1] == 0 && (!blackGoing) && canPlay(3,1)) {
                    b31.setImageResource(R.mipmap.white_piece);
                    mBoard[3][1] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button41:
                if(mBoard[4][1] == 0 && blackGoing && canPlay(4,1)) {
                    b41.setImageResource(R.mipmap.black_piece);
                    mBoard[4][1] = 1;
                    blackGoing = !blackGoing;

                    ///checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[4][1] == 0 && (!blackGoing)&& canPlay(4,1)) {
                    b41.setImageResource(R.mipmap.white_piece);
                    mBoard[4][1] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button51:
                if(mBoard[5][1] == 0 && blackGoing && canPlay(5,1)) {
                    b51.setImageResource(R.mipmap.black_piece);
                    mBoard[5][1] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[5][1] == 0 && (!blackGoing) && canPlay(5,1)) {
                    b51.setImageResource(R.mipmap.white_piece);
                    mBoard[5][1] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;

            case R.id.button02:
                if(mBoard[0][2] == 0 && blackGoing && canPlay(0,2)) {
                    b02.setImageResource(R.mipmap.black_piece);
                    mBoard[0][2] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[0][2] == 0 && (!blackGoing) && canPlay(0,2)) {
                    b02.setImageResource(R.mipmap.white_piece);
                    mBoard[0][2] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button12:
                if(mBoard[1][2] == 0 && blackGoing && canPlay(1,2)) {
                    b12.setImageResource(R.mipmap.black_piece);
                    mBoard[1][2] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();;

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[1][2] == 0 && (!blackGoing) && canPlay(1,2)) {
                    b12.setImageResource(R.mipmap.white_piece);
                    mBoard[1][2] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button22:
                if(mBoard[2][2] == 0 && blackGoing && canPlay(2,2)) {
                    b22.setImageResource(R.mipmap.black_piece);
                    mBoard[2][2] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[2][2] == 0 && (!blackGoing) && canPlay(2,2)) {
                    b22.setImageResource(R.mipmap.white_piece);
                    mBoard[2][2] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button32:
                if(mBoard[3][2] == 0 && blackGoing && canPlay(3,2)) {
                    b32.setImageResource(R.mipmap.black_piece);
                    mBoard[3][2] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[3][2] == 0 && (!blackGoing) && canPlay(3,2)) {
                    b32.setImageResource(R.mipmap.white_piece);
                    mBoard[3][2] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button42:
                if(mBoard[4][2] == 0 && blackGoing && canPlay(4,2)) {
                    b42.setImageResource(R.mipmap.black_piece);
                    mBoard[4][2] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[4][2] == 0 && (!blackGoing) && canPlay(4,2)) {
                    b42.setImageResource(R.mipmap.white_piece);
                    mBoard[4][2] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button52:
                if(mBoard[5][2] == 0 && blackGoing && canPlay(5,2)) {
                    b52.setImageResource(R.mipmap.black_piece);
                    mBoard[5][2] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[5][2] == 0 && (!blackGoing) && canPlay(5,2)) {
                    b52.setImageResource(R.mipmap.white_piece);
                    mBoard[5][2] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;

            case R.id.button03:
                if(mBoard[0][3] == 0 && blackGoing && canPlay(0,3)) {
                    b03.setImageResource(R.mipmap.black_piece);
                    mBoard[0][3] = 1;
                    blackGoing = !blackGoing;

                    ///checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[0][3] == 0 && (!blackGoing) && canPlay(0,3)) {
                    b03.setImageResource(R.mipmap.white_piece);
                    mBoard[0][3] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();;

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button13:
                if(mBoard[1][3] == 0 && blackGoing && canPlay(1,3)) {
                    b13.setImageResource(R.mipmap.black_piece);
                    mBoard[1][3] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[1][3] == 0 && (!blackGoing) && canPlay(1,3)) {
                    b13.setImageResource(R.mipmap.white_piece);
                    mBoard[1][3] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button23:
                if(mBoard[2][3] == 0 && blackGoing && canPlay(2,3)) {
                    b23.setImageResource(R.mipmap.black_piece);
                    mBoard[2][3] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[2][3] == 0 && (!blackGoing) && canPlay(2,3)) {
                    b23.setImageResource(R.mipmap.white_piece);
                    mBoard[2][3] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button33:
                if(mBoard[3][3] == 0 && blackGoing && canPlay(3,3)) {
                    b33.setImageResource(R.mipmap.black_piece);
                    mBoard[3][3] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[3][3] == 0 && (!blackGoing) && canPlay(3,3)) {
                    b33.setImageResource(R.mipmap.white_piece);
                    mBoard[3][3] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button43:
                if(mBoard[4][3] == 0 && blackGoing && canPlay(4,3)) {
                    b43.setImageResource(R.mipmap.black_piece);
                    mBoard[4][3] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[4][3] == 0 && (!blackGoing) && canPlay(4,3)) {
                    b43.setImageResource(R.mipmap.white_piece);
                    mBoard[4][3] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();;

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button53:
                if(mBoard[5][3] == 0 && blackGoing  && canPlay(5,3)) {
                    b53.setImageResource(R.mipmap.black_piece);
                    mBoard[5][3] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[5][3] == 0 && (!blackGoing) && canPlay(5,3)) {
                    b53.setImageResource(R.mipmap.white_piece);
                    mBoard[5][3] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;

            case R.id.button04:
                if(mBoard[0][4] == 0 && blackGoing && canPlay(0,4)) {
                    b04.setImageResource(R.mipmap.black_piece);
                    mBoard[0][4] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[0][4] == 0 && (!blackGoing) && canPlay(0,4)) {
                    b04.setImageResource(R.mipmap.white_piece);
                    mBoard[0][4] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button14:
                if(mBoard[1][4] == 0 && blackGoing && canPlay(1,4)) {
                    b14.setImageResource(R.mipmap.black_piece);
                    mBoard[1][4] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[1][4] == 0 && (!blackGoing) && canPlay(1,4)) {
                    b14.setImageResource(R.mipmap.white_piece);
                    mBoard[1][4] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button24:
                if(mBoard[2][4] == 0 && blackGoing && canPlay(2,4)) {
                    b24.setImageResource(R.mipmap.black_piece);
                    mBoard[2][4] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[2][4] == 0 && (!blackGoing) && canPlay(2,4)) {
                    b24.setImageResource(R.mipmap.white_piece);
                    mBoard[2][4] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button34:
                if(mBoard[3][4] == 0 && blackGoing && canPlay(3,4)) {
                    b34.setImageResource(R.mipmap.black_piece);
                    mBoard[3][4] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[3][4] == 0 && (!blackGoing) && canPlay(3,4)) {
                    b34.setImageResource(R.mipmap.white_piece);
                    mBoard[3][4] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();;

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button44:
                if(mBoard[4][4] == 0 && blackGoing && canPlay(4,4)) {
                    b44.setImageResource(R.mipmap.black_piece);
                    mBoard[4][4] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[4][4] == 0 && (!blackGoing) && canPlay(4,4)) {
                    b44.setImageResource(R.mipmap.white_piece);
                    mBoard[4][4] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button54:
                if(mBoard[5][4] == 0 && blackGoing && canPlay(5,4)) {
                    b54.setImageResource(R.mipmap.black_piece);
                    mBoard[5][4] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[5][4] == 0 && (!blackGoing) && canPlay(5,4)) {
                    b54.setImageResource(R.mipmap.white_piece);
                    mBoard[5][4] = 2;
                    blackGoing = !blackGoing;

                    ///checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;

            case R.id.button05:
                if(mBoard[0][5] == 0 && blackGoing && canPlay(0,5)) {
                    b05.setImageResource(R.mipmap.black_piece);
                    mBoard[0][5] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();;

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[0][5] == 0 && (!blackGoing) && canPlay(0,5)) {
                    b05.setImageResource(R.mipmap.white_piece);
                    mBoard[0][5] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();;

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button15:
                if(mBoard[1][5] == 0 && blackGoing && canPlay(1,5)) {
                    b15.setImageResource(R.mipmap.black_piece);
                    mBoard[1][5] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[1][5] == 0 && (!blackGoing) && canPlay(1,5)) {
                    b15.setImageResource(R.mipmap.white_piece);
                    mBoard[1][5] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button25:
                if(mBoard[2][5] == 0 && blackGoing && canPlay(2,5)) {
                    b25.setImageResource(R.mipmap.black_piece);
                    mBoard[2][5] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[2][5] == 0 && (!blackGoing) && canPlay(2,5)) {
                    b25.setImageResource(R.mipmap.white_piece);
                    mBoard[2][5] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button35:
                if(mBoard[3][5] == 0 && blackGoing && canPlay(3,5)) {
                    b35.setImageResource(R.mipmap.black_piece);
                    mBoard[3][5] = 1;
                    blackGoing = !blackGoing;

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[3][5] == 0 && (!blackGoing) && canPlay(3,5)) {
                    b35.setImageResource(R.mipmap.white_piece);
                    mBoard[3][5] = 2;
                    blackGoing = !blackGoing;

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }

                break;
            case R.id.button45:
                if(mBoard[4][5] == 0 && blackGoing && canPlay(4,5)) {
                    b45.setImageResource(R.mipmap.black_piece);
                    mBoard[4][5] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[4][5] == 0 && (!blackGoing) && canPlay(4,5)) {
                    b45.setImageResource(R.mipmap.white_piece);
                    mBoard[4][5] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;
            case R.id.button55:
                if(mBoard[5][5] == 0 && blackGoing && canPlay(5,5)) {
                    b55.setImageResource(R.mipmap.black_piece);
                    mBoard[5][5] = 1;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                else if(mBoard[5][5] == 0 && (!blackGoing) && canPlay(5,5)) {
                    b55.setImageResource(R.mipmap.white_piece);
                    mBoard[5][5] = 2;
                    blackGoing = !blackGoing;

                    //checking if next player has any playable moves
                    checkIfAnyPlayableMoves();

                    whosTurnIsIt = getView().findViewById(R.id.whoTurnIsIt);
                    if(blackGoing)
                        whosTurnIsIt.setText(R.string.blackTurn);
                    else
                        whosTurnIsIt.setText(R.string.whiteTurn);

                }
                break;

            default:
            Log.i("You cllicked: ",String.valueOf(view.getId()));
            break;

        }



    }

    public void checkWhoWins(){
        int totalPiecesBlack = 0;
        int totalPiecesWhite = 0;

        for(int i = 0; i < mBoard.length;++i){
            for(int j = 0; j < mBoard.length;++j){
                if(mBoard[i][j] == 1)
                    totalPiecesBlack++;
                else if(mBoard[i][j] == 2)
                    totalPiecesWhite++;

            }

        }

        gameIsOver = true;
        newGameButton.setVisibility(getView().VISIBLE);
        goBackButton.setVisibility(getView().VISIBLE);

        if(totalPiecesBlack > totalPiecesWhite) {
            ++numWinsBlack;
            numBlackWins = getView().findViewById(R.id.numBlackWins);
            numBlackWins.setText(Integer.toString(numWinsBlack));
            Toast toast = Toast.makeText(getContext(),"Black Wins!!", Toast.LENGTH_SHORT);
            toast.show();

        }
        else if(totalPiecesWhite > totalPiecesBlack){
            numWinsWhite++;
            numWhiteWins = getView().findViewById(R.id.numWhiteWins);
            numWhiteWins.setText(Integer.toString(numWinsWhite));
            Toast toast = Toast.makeText(getContext(),"White Wins!!", Toast.LENGTH_SHORT);
            toast.show();
        }

        else{
            Toast toast = Toast.makeText(getContext(),"You tied!!", Toast.LENGTH_SHORT);
            toast.show();
        }


    }


   public boolean isBoardFull(){
        for(int i = 0; i <mBoard.length; ++i){
            for(int j = 0; j < mBoard.length;++j){
                if(mBoard[i][j] == 0)
                    return false;
            }
        }

        return true;
   }

    public void doesWhiteHavePlayableMoves(){

       if(isBoardFull()) {
           whiteHasPlayableMoves=false;
           Toast toast = Toast.makeText(getContext(),"White has no moves!", Toast.LENGTH_SHORT);
           toast.show();
           return;

       }

       //check white
       for(int x = 0; x < mBoard.length; ++x){
           for(int y = 0; y < mBoard.length; ++y){
               if(mBoard[x][y] == 0) {
                   if (checkAbove(x, y, 2, 1, false) ||
                           (checkLeft(x, y, 2, 1, false)) ||
                           (checkRight(x, y, 2, 1, false)) ||
                           (checkBelow(x, y, 2, 1, false)) ||
                           (checkDownLeft(x, y, 2, 1, false)) ||
                           (checkDownRight(x, y, 2, 1, false)) ||
                           (checkUpLeft(x, y, 2, 1, false)) ||
                           (checkUpRight(x, y, 2, 1, false))) {
                       whiteHasPlayableMoves = true;
                       return; //found one playable move,hence stop checking
                   }
               }
           }
       }

       whiteHasPlayableMoves = false;
       Toast toast = Toast.makeText(getContext(),"White has no moves!", Toast.LENGTH_SHORT);
       toast.show();
   }

    public void doesBlackHavePlayableMoves(){

        //white is 2
        //black is 1

        if(isBoardFull()) {
            blackHasPlayableMoves=false;
            Toast toast = Toast.makeText(getContext(),"Black has no moves!", Toast.LENGTH_SHORT);
            toast.show();
            return;

        }


        //check black first
        for(int x = 0; x < mBoard.length; ++x){
            for(int y = 0; y < mBoard.length; ++y){
                if(mBoard[x][y] == 0) {
                    if (checkAbove(x, y, 1, 2, false) ||
                            (checkLeft(x, y, 1, 2, false)) ||
                            (checkRight(x, y, 1, 2, false)) ||
                            (checkBelow(x, y, 1, 2, false)) ||
                            (checkDownLeft(x, y, 1, 2, false)) ||
                            (checkDownRight(x, y, 1, 2, false)) ||
                            (checkUpLeft(x, y, 1, 2, false)) ||
                            (checkUpRight(x, y, 1, 2, false))) {
                        blackHasPlayableMoves = true;
                        return; //found one playable move,hence stop checking
                    }
                }
            }
        }



        blackHasPlayableMoves = false;
        Toast toast = Toast.makeText(getContext(),"Black has no moves!", Toast.LENGTH_SHORT);
        toast.show();







        /*
        if(blackGoing) {
            blackHasPlayableMoves = false;
            Toast toast = Toast.makeText(getContext(),"Black has no moves!", Toast.LENGTH_SHORT);
            toast.show();
            blackGoing = !blackGoing;
        }
        else {
            whiteHasPlayableMoves = false;
            Toast toast = Toast.makeText(getContext(),"White has no moves!",Toast.LENGTH_SHORT);
            toast.show();
            blackGoing = !blackGoing;

        }

        if(!blackHasPlayableMoves && !whiteHasPlayableMoves)
            checkWhoWins();
            */

    }

    public boolean canPlay(int positionx, int positiony){


        int toBeColor = 2;
        int oppositeColor = 1;
        if(blackGoing) {
            toBeColor = 1;
            oppositeColor = 2;
        }

        //check if can play
        //must make boolean for everything to get multidirecitonal flips
        boolean canAbove = checkAbove(positionx, positiony,toBeColor,oppositeColor, true);
        boolean canBelow = checkBelow(positionx,positiony,toBeColor,oppositeColor,true);
        boolean checkLeft = checkLeft(positionx,positiony,toBeColor,oppositeColor,true);
        boolean checkRight = checkRight(positionx,positiony,toBeColor,oppositeColor,true);
        boolean checkUpLeft = checkUpLeft(positionx,positiony,toBeColor,oppositeColor,true);
        boolean checkUpRight = checkUpRight(positionx,positiony,toBeColor,oppositeColor,true);
        boolean checkDownRight = checkDownRight(positionx,positiony,toBeColor,oppositeColor,true);
        boolean checkDownLeft = checkDownLeft(positionx,positiony,toBeColor,oppositeColor,true);

        //now check if at least one is true, hence a valid move
            if(canAbove
                    || canBelow
                    || checkLeft
                    || checkRight
                    || checkUpLeft
                    || checkUpRight
                    || checkDownRight
                    || checkDownLeft) {
                if(blackGoing)
                    blackHasPlayableMoves = true;
                else
                    whiteHasPlayableMoves = true;
                return true;
            }

        /*
        //check below
            if(checkBelow(positionx,positiony,toBeColor,oppositeColor))
                return true;
        //check left
            if(checkLeft(positionx,positiony,toBeColor,oppositeColor))
                return true;
            //check right
            if(checkRight(positionx,positiony,toBeColor,oppositeColor))
                return true;
            //check diagonal left
            if(checkUpLeft(positionx,positiony,toBeColor,oppositeColor))
                return true;
            //check diagonal right
            if(checkUpRight(positionx,positiony,toBeColor,oppositeColor))
                return true;
                */


        return false;
    }

    public boolean checkAbove(int positionx, int positiony,int toBeColor, int oppositeColor, boolean updateBoard){
        //in order to play above you must check below
        int counter = 1;
        int foundY = 0;
        if(positiony+1!= 6) {
            //piece below is not a different color, already doesnt work
            if (mBoard[positionx][positiony + 1] == toBeColor)
                return false;
            else if(mBoard[positionx][positiony+1] == oppositeColor){
                while(positiony+counter != 6){
                    //found a sandwich
                    if(mBoard[positionx][positiony+counter] == toBeColor) {
                        foundY = positiony+counter;
                        counter = 1;
                        //flip all pieces in between the sandwich
                        while(positiony+counter!=foundY) {
                            if(updateBoard)
                            updateBoard(positionx, positiony + counter, toBeColor);
                            counter++;
                        }
                        return true;
                    }

                    counter++;
                }

            }

        }



        return false;
    }



    public boolean checkBelow(int positionx, int positiony, int toBeColor, int oppositeColor, boolean updateBoard){

        //in order to play below you must check above
        int counter = -1;
        int foundY = 0;
        if(positiony-1!= -1) {
            if (mBoard[positionx][positiony - 1] == toBeColor)
                return false;
            else if(mBoard[positionx][positiony-1] == oppositeColor){
                while(positiony+counter != -1){
                    //found a sandwich
                    if(mBoard[positionx][positiony+counter] == toBeColor) {
                        foundY = positiony+counter;
                        counter = -1;
                        while(positiony+counter!=foundY){
                            if(updateBoard)
                            updateBoard(positionx,positiony+counter,toBeColor);
                            counter--;
                        }
                        return true;
                    }



                    counter--;
                }

            }

        }



        return false;
    }

    public boolean checkLeft(int positionx, int positiony, int toBeColor, int oppositeColor, boolean updateBoard){
        //in order to play left you must check right if sandwich
        //x+1

        int counter = 1;
        int foundX = 0;
        if(positionx+1!= 6) {
            //piece below is not a different color, already doesnt work
            if (mBoard[positionx+1][positiony] == toBeColor)
                return false;
            else if(mBoard[positionx+1][positiony] == oppositeColor){
                while(positionx+counter != 6){
                    //found a sandwich
                    if(mBoard[positionx+counter][positiony] == toBeColor) {
                        foundX = positionx+counter;
                        counter = 1;
                        //flip all pieces in between the sandwich
                        while(positionx+counter!=foundX) {
                            if(updateBoard)
                            updateBoard(positionx+counter, positiony, toBeColor);
                            counter++;
                        }
                        return true;
                    }

                    counter++;
                }

            }

        }



        return false;






    }

    public boolean checkRight(int positionx, int positiony, int toBeColor, int oppositeColor, boolean updateBoard){

        //in order to play below you must check above
        int counter = -1;
        int foundX = 0;
        if(positionx-1!= -1) {
            if (mBoard[positionx-1][positiony] == toBeColor)
                return false;
            else if(mBoard[positionx-1][positiony] == oppositeColor){
                while(positionx+counter != -1){
                    //found a sandwich
                    if(mBoard[positionx+counter][positiony] == toBeColor) {
                        foundX = positionx+counter;
                        counter = -1;
                        while(positionx+counter!=foundX){
                            if(updateBoard)
                            updateBoard(positionx+counter,positiony,toBeColor);
                            counter--;
                        }
                        return true;
                    }



                    counter--;
                }

            }

        }



        return false;
    }

    public boolean checkUpLeft(int positionx, int positiony, int toBeColor, int oppositeColor, boolean updateBoard){
        //both x and y are + 1
        int counter = 1;
        int foundX = 0;
        if(positionx+1!= 6 && positiony+1 != 6) {
            //piece below is not a different color, already doesnt work
            if (mBoard[positionx+1][positiony+1] == toBeColor)
                return false;
            else if(mBoard[positionx+1][positiony+1] == oppositeColor){
                while(positionx+counter != 6 && positiony+counter != 6){
                    //found a sandwich
                    if(mBoard[positionx+counter][positiony+counter] == toBeColor) {
                        foundX = positionx+counter;
                        counter = 1;
                        //flip all pieces in between the sandwich
                        while(positionx+counter!=foundX) {
                            if(updateBoard)
                            updateBoard(positionx+counter, positiony+counter, toBeColor);
                            counter++;
                        }
                        return true;
                    }

                    counter++;
                }

            }

        }



        return false;


    }

    public boolean checkUpRight(int positionx, int positiony, int toBeColor, int oppositeColor, boolean updateBoard){
       //both x is -1 and y is + 1

        int counterX = -1;
        int counterY = 1;
        int foundX = 0;
        int foundY = 0;
        if(positionx-1!= -1 && positiony+1 != 6) {
            if (mBoard[positionx-1][positiony+1] == toBeColor)
                return false;
            else if(mBoard[positionx-1][positiony+1] == oppositeColor){
                while(positionx+counterX != -1 && positiony+counterY != 6){
                    //found a sandwich
                    if(mBoard[positionx+counterX][positiony+counterY] == toBeColor) {
                        foundX = positionx+counterX;
                        foundY = positiony+counterY;
                        counterX = -1;
                        counterY = 1;
                        while(positionx+counterX!=foundX && positiony+counterY!=foundY){
                            if(updateBoard)
                            updateBoard(positionx+counterX,positiony+counterY,toBeColor);
                            counterX--;
                            counterY++;
                        }
                        return true;
                    }



                    counterX--;
                    counterY++;
                }

            }

        }



        return false;


    }

    public boolean checkDownRight(int positionx, int positiony, int toBeColor, int oppositeColor, boolean updateBoard){
        //both x and y are minus 1
        int counter = -1;
        int foundX = 0;
        if(positionx-1!= -1 && positiony-1 != -1) {
            //piece below is not a different color, already doesnt work
            if (mBoard[positionx-1][positiony-1] == toBeColor)
                return false;
            else if(mBoard[positionx-1][positiony-1] == oppositeColor){
                while(positionx+counter != -1 && positiony+counter != -1){
                    //found a sandwich
                    if(mBoard[positionx+counter][positiony+counter] == toBeColor) {
                        foundX = positionx+counter;
                        counter = -1;
                        //flip all pieces in between the sandwich
                        while(positionx+counter!=foundX) {
                            if(updateBoard)
                            updateBoard(positionx+counter, positiony+counter, toBeColor);
                            counter--;
                        }
                        return true;
                    }

                    counter--;
                }

            }

        }



        return false;

    }

    public boolean checkDownLeft(int positionx, int positiony, int toBeColor, int oppositeColor, boolean updateBoard){
        //x is +1 y is -1
        int counterX = 1;
        int counterY = -1;
        int foundX = 0;
        int foundY = 0;
        if(positiony-1!= -1 && positionx+1 != 6) {
            if (mBoard[positionx+1][positiony-1] == toBeColor)
                return false;
            else if(mBoard[positionx+1][positiony-1] == oppositeColor){
                while(positionx+counterX != 6 && positiony+counterY != -1){
                    //found a sandwich
                    if(mBoard[positionx+counterX][positiony+counterY] == toBeColor) {
                        foundX = positionx+counterX;
                        foundY = positiony+counterY;
                        counterX = 1;
                        counterY = -1;
                        while(positionx+counterX!=foundX && positiony+counterY!=foundY){
                            if(updateBoard)
                            updateBoard(positionx+counterX,positiony+counterY,toBeColor);
                            counterX++;
                            counterY--;
                        }
                        return true;
                    }



                    counterX++;
                    counterY--;
                }

            }

        }



        return false;


    }

    public void updateBoardOrientationChange(){
        for(int i = 0; i < mBoard.length; ++i){
            for(int j = 0; j < mBoard.length; ++j){
                updateBoard(i,j,mBoard[i][j]);
            }
        }
    }

    public void updateBoard(int positionx, int positiony, int toBeColor){
        mBoard[positionx][positiony] = toBeColor;

        switch(positionx){
            case 0:
                switch(positiony){
                    case 0:
                        if(toBeColor == 2)
                            b00.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b00.setImageResource(R.mipmap.black_piece);
                        break;
                    case 1:
                        if(toBeColor == 2)
                            b01.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b01.setImageResource(R.mipmap.black_piece);
                        break;
                    case 2:
                        if(toBeColor == 2)
                            b02.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b02.setImageResource(R.mipmap.black_piece);
                        break;
                    case 3:
                        if(toBeColor == 2)
                            b03.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b03.setImageResource(R.mipmap.black_piece);
                        break;
                    case 4:
                        if(toBeColor == 2)
                            b04.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b04.setImageResource(R.mipmap.black_piece);
                        break;
                    case 5:
                        if(toBeColor == 2)
                            b05.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b05.setImageResource(R.mipmap.black_piece);
                        break;

                    default:
                        break;


                }
                break;
            case 1:
                switch(positiony){
                    case 0:
                        if(toBeColor == 2)
                            b10.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b10.setImageResource(R.mipmap.black_piece);
                        break;
                    case 1:
                        if(toBeColor == 2)
                            b11.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b11.setImageResource(R.mipmap.black_piece);
                        break;
                    case 2:
                        if(toBeColor == 2)
                            b12.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b12.setImageResource(R.mipmap.black_piece);
                        break;
                    case 3:
                        if(toBeColor == 2)
                            b13.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b13.setImageResource(R.mipmap.black_piece);
                        break;
                    case 4:
                        if(toBeColor == 2)
                            b14.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b14.setImageResource(R.mipmap.black_piece);
                        break;
                    case 5:
                        if(toBeColor == 2)
                            b15.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b15.setImageResource(R.mipmap.black_piece);
                        break;

                    default:
                        break;


                }
                break;

            case 2:
                switch(positiony){
                    case 0:
                        if(toBeColor == 2)
                            b20.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b20.setImageResource(R.mipmap.black_piece);
                        break;
                    case 1:
                        if(toBeColor == 2)
                            b21.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b21.setImageResource(R.mipmap.black_piece);
                        break;
                    case 2:
                        if(toBeColor == 2)
                            b22.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b22.setImageResource(R.mipmap.black_piece);
                        break;
                    case 3:
                        if(toBeColor == 2)
                            b23.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b23.setImageResource(R.mipmap.black_piece);
                        break;
                    case 4:
                        if(toBeColor == 2)
                            b24.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b24.setImageResource(R.mipmap.black_piece);
                        break;
                    case 5:
                        if(toBeColor == 2)
                            b25.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b25.setImageResource(R.mipmap.black_piece);
                        break;

                    default:
                        break;


                }
                break;

            case 3:
                switch(positiony){
                    case 0:
                        if(toBeColor == 2)
                            b30.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b30.setImageResource(R.mipmap.black_piece);
                        break;
                    case 1:
                        if(toBeColor == 2)
                            b31.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b31.setImageResource(R.mipmap.black_piece);
                        break;
                    case 2:
                        if(toBeColor == 2)
                            b32.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b32.setImageResource(R.mipmap.black_piece);
                        break;
                    case 3:
                        if(toBeColor == 2)
                            b33.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b33.setImageResource(R.mipmap.black_piece);
                        break;
                    case 4:
                        if(toBeColor == 2)
                            b34.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b34.setImageResource(R.mipmap.black_piece);
                        break;
                    case 5:
                        if(toBeColor == 2)
                            b35.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b35.setImageResource(R.mipmap.black_piece);
                        break;

                    default:
                        break;


                }
                break;
            case 4:
                switch(positiony){
                    case 0:
                        if(toBeColor == 2)
                            b40.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b40.setImageResource(R.mipmap.black_piece);
                        break;
                    case 1:
                        if(toBeColor == 2)
                            b41.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b41.setImageResource(R.mipmap.black_piece);
                        break;
                    case 2:
                        if(toBeColor == 2)
                            b42.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b42.setImageResource(R.mipmap.black_piece);
                        break;
                    case 3:
                        if(toBeColor == 2)
                            b43.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b43.setImageResource(R.mipmap.black_piece);
                        break;
                    case 4:
                        if(toBeColor == 2)
                            b44.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b44.setImageResource(R.mipmap.black_piece);
                        break;
                    case 5:
                        if(toBeColor == 2)
                            b55.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b55.setImageResource(R.mipmap.black_piece);
                        break;

                    default:
                        break;


                }
                break;
            case 5:
                switch(positiony){
                    case 0:
                        if(toBeColor == 2)
                            b50.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b50.setImageResource(R.mipmap.black_piece);
                        break;
                    case 1:
                        if(toBeColor == 2)
                            b51.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b51.setImageResource(R.mipmap.black_piece);
                        break;
                    case 2:
                        if(toBeColor == 2)
                            b52.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b52.setImageResource(R.mipmap.black_piece);
                        break;
                    case 3:
                        if(toBeColor == 2)
                            b53.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b53.setImageResource(R.mipmap.black_piece);
                        break;
                    case 4:
                        if(toBeColor == 2)
                            b54.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b54.setImageResource(R.mipmap.black_piece);
                        break;
                    case 5:
                        if(toBeColor == 2)
                            b55.setImageResource(R.mipmap.white_piece);
                        else if(toBeColor == 1)
                            b55.setImageResource(R.mipmap.black_piece);
                        break;

                    default:
                        break;


                }
                break;

            default:
                break;

        }

    }


}
