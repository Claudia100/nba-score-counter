package com.madgorillastudios.cisco.scorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = MainActivity.class.getName();
    private static final int THREE_POINTS = 3;
    private static final int TWO_POINTS = 2;
    private static final int ONE_POINT = 1;

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int firstQuarterScoreTeamA = 0;
    private int secondQuarterScoreTeamA = 0;
    private int thirdQuarterScoreTeamA = 0;
    private int fourthQuarterScoreTeamA = 0;
    private int overtimeScoreTeamA = 0;
    private int firstQuarterScoreTeamB = 0;
    private int secondQuarterScoreTeamB = 0;
    private int thirdQuarterScoreTeamB = 0;
    private int fourthQuarterScoreTeamB = 0;
    private int overtimeScoreTeamB = 0;

    private boolean isFirstQuarterSelected = false;
    private boolean isSecondQuarterSelected = false;
    private boolean isThirdQuarterSelected = false;
    private boolean isFourthQuarterSelected = false;
    private boolean isOvertimeSelected = false;

    private TextView tvScoreTeamA;
    private TextView tvScoreTeamB;
    private TextView tvFirstQuarterScoreTeamA;
    private TextView tvSecondQuarterScoreTeamA;
    private TextView tvThirdQuarterScoreTeamA;
    private TextView tvFourthQuarterScoreTeamA;
    private TextView tvOvertimeScoreTeamA;
    private TextView tvFirstQuarterScoreTeamB;
    private TextView tvSecondQuarterScoreTeamB;
    private TextView tvThirdQuarterScoreTeamB;
    private TextView tvFourthQuarterScoreTeamB;
    private TextView tvOvertimeScoreTeamB;

    private Spinner spinnerGameQuarter;
    private ArrayAdapter<CharSequence> adapterGameQuarter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");

        setContentView(R.layout.activity_main);

        Toolbar custom_toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(custom_toolbar);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        spinnerGameQuarter = (Spinner) findViewById(R.id.game_quarter_spinner);
        Spinner spinnerTeamA = (Spinner) findViewById(R.id.team_a_spinner);
        Spinner spinnerTeamB = (Spinner) findViewById(R.id.team_b_spinner);

        adapterGameQuarter = ArrayAdapter.createFromResource(this,
                R.array.game_quarter_array, R.layout.game_quarters_spinner_layout);
        adapterGameQuarter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterTeamA = ArrayAdapter.createFromResource(this,
                R.array.team_a_array, R.layout.teams_spinner_layout);
        adapterTeamA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterTeamB = ArrayAdapter.createFromResource(this,
                R.array.team_b_array, R.layout.teams_spinner_layout);
        adapterTeamB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerGameQuarter.setAdapter(adapterGameQuarter);
        spinnerTeamA.setAdapter(adapterTeamA);
        spinnerTeamB.setAdapter(adapterTeamB);

        spinnerGameQuarter.setOnItemSelectedListener(this);
        spinnerTeamA.setOnItemSelectedListener(this);
        spinnerTeamB.setOnItemSelectedListener(this);

        String[] arrayTeamA = getResources().getStringArray(R.array.team_a_array);
        String[] arrayTeamB = getResources().getStringArray(R.array.team_b_array);

        spinnerTeamA.setSelection(adapterTeamA.getPosition((arrayTeamA[3])));
        spinnerTeamB.setSelection(adapterTeamB.getPosition((arrayTeamB[2])));

        tvScoreTeamA = (TextView) findViewById(R.id.text_view_score_team_a);
        tvScoreTeamB = (TextView) findViewById(R.id.text_view_score_team_b);

        tvScoreTeamA.setText("" + scoreTeamA);
        tvScoreTeamB.setText("" + scoreTeamB);

        tvFirstQuarterScoreTeamA = (TextView) findViewById(R.id.text_view_first_quarter_score_team_a);
        tvSecondQuarterScoreTeamA = (TextView) findViewById(R.id.text_view_second_quarter_score_team_a);
        tvThirdQuarterScoreTeamA = (TextView) findViewById(R.id.text_view_third_quarter_score_team_a);
        tvFourthQuarterScoreTeamA = (TextView) findViewById(R.id.text_view_fourth_quarter_score_team_a);
        tvOvertimeScoreTeamA = (TextView) findViewById(R.id.text_view_overtime_score_team_a);

        tvFirstQuarterScoreTeamA.setText("" + firstQuarterScoreTeamA);
        tvSecondQuarterScoreTeamA.setText("" + secondQuarterScoreTeamA);
        tvThirdQuarterScoreTeamA.setText("" + thirdQuarterScoreTeamA);
        tvFourthQuarterScoreTeamA.setText("" + fourthQuarterScoreTeamA);
        tvOvertimeScoreTeamA.setText("" + overtimeScoreTeamA);

        tvFirstQuarterScoreTeamB = (TextView) findViewById(R.id.text_view_first_quarter_score_team_b);
        tvSecondQuarterScoreTeamB = (TextView) findViewById(R.id.text_view_second_quarter_score_team_b);
        tvThirdQuarterScoreTeamB = (TextView) findViewById(R.id.text_view_third_quarter_score_team_b);
        tvFourthQuarterScoreTeamB = (TextView) findViewById(R.id.text_view_fourth_quarter_score_team_b);
        tvOvertimeScoreTeamB = (TextView) findViewById(R.id.text_view_overtime_score_team_b);

        tvFirstQuarterScoreTeamB.setText("" + firstQuarterScoreTeamB);
        tvSecondQuarterScoreTeamB.setText("" + secondQuarterScoreTeamB);
        tvThirdQuarterScoreTeamB.setText("" + thirdQuarterScoreTeamB);
        tvFourthQuarterScoreTeamB.setText("" + fourthQuarterScoreTeamB);
        tvOvertimeScoreTeamB.setText("" + overtimeScoreTeamB);

        Button btnPlusThreePointsTeamA = (Button) findViewById(R.id.button_plus_three_points_team_a);
        btnPlusThreePointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamA(THREE_POINTS);
            }
        });

        Button btnPlusTwoPointsTeamA = (Button) findViewById(R.id.button_plus_two_points_team_a);
        btnPlusTwoPointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamA(TWO_POINTS);
            }
        });

        Button btnPlusOnePointTeamA = (Button) findViewById(R.id.button_plus_one_point_team_a);
        btnPlusOnePointTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamA(ONE_POINT);
            }
        });

        Button btnPlusThreePointsTeamB = (Button) findViewById(R.id.button_plus_three_points_team_b);
        btnPlusThreePointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamB(THREE_POINTS);
            }
        });

        Button btnPlusTwoPointsTeamB = (Button) findViewById(R.id.button_plus_two_points_team_b);
        btnPlusTwoPointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamB(TWO_POINTS);
            }
        });

        Button btnPlusOnePointTeamB = (Button) findViewById(R.id.button_plus_one_point_team_b);
        btnPlusOnePointTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamB(ONE_POINT);
            }
        });

        Button btnResetScores = (Button) findViewById(R.id.button_reset_scores);
        btnResetScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScores();
            }
        });
    }

    public void incrementScoreTeamA(int score) {
        scoreTeamA += score;
        tvScoreTeamA.setText("" + scoreTeamA);

        incrementScorePerQuarterTeamA(score);
    }

    public void incrementScoreTeamB(int score) {
        scoreTeamB += score;
        tvScoreTeamB.setText("" + scoreTeamB);

        incrementScorePerQuarterTeamB(score);
    }

    public void resetScores() {
        scoreTeamA = 0;
        scoreTeamB = 0;

        tvScoreTeamA.setText("" + scoreTeamA);
        tvScoreTeamB.setText("" + scoreTeamB);

        firstQuarterScoreTeamA = 0;
        secondQuarterScoreTeamA = 0;
        thirdQuarterScoreTeamA = 0;
        fourthQuarterScoreTeamA = 0;
        overtimeScoreTeamA = 0;

        tvFirstQuarterScoreTeamA.setText("" + firstQuarterScoreTeamA);
        tvSecondQuarterScoreTeamA.setText("" + secondQuarterScoreTeamA);
        tvThirdQuarterScoreTeamA.setText("" + thirdQuarterScoreTeamA);
        tvFourthQuarterScoreTeamA.setText("" + fourthQuarterScoreTeamA);
        tvOvertimeScoreTeamA.setText("" + overtimeScoreTeamA);

        firstQuarterScoreTeamB = 0;
        secondQuarterScoreTeamB = 0;
        thirdQuarterScoreTeamB = 0;
        fourthQuarterScoreTeamB = 0;
        overtimeScoreTeamB = 0;

        tvFirstQuarterScoreTeamB.setText("" + firstQuarterScoreTeamB);
        tvSecondQuarterScoreTeamB.setText("" + secondQuarterScoreTeamB);
        tvThirdQuarterScoreTeamB.setText("" + thirdQuarterScoreTeamB);
        tvFourthQuarterScoreTeamB.setText("" + fourthQuarterScoreTeamB);
        tvOvertimeScoreTeamB.setText("" + overtimeScoreTeamB);

        spinnerGameQuarter.setSelection(adapterGameQuarter.getPosition(getString(R.string.first_quarter_label)));
    }

    public void incrementScorePerQuarterTeamA(int score) {
        if (isFirstQuarterSelected) {
            firstQuarterScoreTeamA += score;
            tvFirstQuarterScoreTeamA.setText("" + firstQuarterScoreTeamA);
        } else if (isSecondQuarterSelected) {
            secondQuarterScoreTeamA += score;
            tvSecondQuarterScoreTeamA.setText("" + secondQuarterScoreTeamA);
        } else if (isThirdQuarterSelected) {
            thirdQuarterScoreTeamA += score;
            tvThirdQuarterScoreTeamA.setText("" + thirdQuarterScoreTeamA);
        } else if (isFourthQuarterSelected) {
            fourthQuarterScoreTeamA += score;
            tvFourthQuarterScoreTeamA.setText("" + fourthQuarterScoreTeamA);
        } else if (isOvertimeSelected) {
            overtimeScoreTeamA += score;
            tvOvertimeScoreTeamA.setText("" + overtimeScoreTeamA);
        }
    }

    public void incrementScorePerQuarterTeamB(int score) {
        if (isFirstQuarterSelected) {
            firstQuarterScoreTeamB += score;
            tvFirstQuarterScoreTeamB.setText("" + firstQuarterScoreTeamB);
        } else if (isSecondQuarterSelected) {
            secondQuarterScoreTeamB += score;
            tvSecondQuarterScoreTeamB.setText("" + secondQuarterScoreTeamB);
        } else if (isThirdQuarterSelected) {
            thirdQuarterScoreTeamB += score;
            tvThirdQuarterScoreTeamB.setText("" + thirdQuarterScoreTeamB);
        } else if (isFourthQuarterSelected) {
            fourthQuarterScoreTeamB += score;
            tvFourthQuarterScoreTeamB.setText("" + fourthQuarterScoreTeamB);
        } else if (isOvertimeSelected) {
            overtimeScoreTeamB += score;
            tvOvertimeScoreTeamB.setText("" + overtimeScoreTeamB);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        switch (item) {
            case "Q1":
                isFirstQuarterSelected = true;
                isSecondQuarterSelected = isThirdQuarterSelected = isFourthQuarterSelected = isOvertimeSelected = false;
                break;
            case "Q2":
                isSecondQuarterSelected = true;
                isFirstQuarterSelected = isThirdQuarterSelected = isFourthQuarterSelected = isOvertimeSelected = false;
                break;
            case "Q3":
                isThirdQuarterSelected = true;
                isFirstQuarterSelected = isSecondQuarterSelected = isFourthQuarterSelected = isOvertimeSelected = false;
                break;
            case "Q4":
                isFourthQuarterSelected = true;
                isFirstQuarterSelected = isSecondQuarterSelected = isThirdQuarterSelected = isOvertimeSelected = false;
                break;
            case "OT":
                isOvertimeSelected = true;
                isFirstQuarterSelected = isSecondQuarterSelected = isThirdQuarterSelected = isFourthQuarterSelected = false;
                break;
            default:
                changeTeamLogo(item);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void changeTeamLogo(String item) {
        String sideOfTeam = item.substring(1, 2);
        int imageViewId = 0;

        if (sideOfTeam.equalsIgnoreCase("A")) {
            imageViewId = R.id.image_view_team_a;
        } else {
            imageViewId = R.id.image_view_team_b;
        }

        int drawableId = 0;

        if (item.indexOf("Celtics") != -1 ? true : false) {
            drawableId = R.drawable.boston_celtics;
        } else if (item.indexOf("Bulls") != -1 ? true : false) {
            drawableId = R.drawable.chicago_bulls;
        } else if (item.indexOf("Cavaliers") != -1 ? true : false) {
            drawableId = R.drawable.cleveland_cavaliers;
        } else if (item.indexOf("Warriors") != -1 ? true : false) {
            drawableId = R.drawable.golden_state_warriors;
        } else if (item.indexOf("Lakers") != -1 ? true : false) {
            drawableId = R.drawable.los_angeles_lakers;
        } else if (item.indexOf("Thunder") != -1 ? true : false) {
            drawableId = R.drawable.okc_thunder;
        }

        try {
            ImageView image = (ImageView) findViewById(imageViewId);
            image.setImageResource(drawableId);
        } catch (NullPointerException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");

        outState.putCharSequence("savedScoreTeamA", tvScoreTeamA.getText());
        outState.putCharSequence("savedScoreTeamB", tvScoreTeamB.getText());

        outState.putCharSequence("savedFirstQuarterScoreTeamA", tvFirstQuarterScoreTeamA.getText());
        outState.putCharSequence("savedSecondQuarterScoreTeamA", tvSecondQuarterScoreTeamA.getText());
        outState.putCharSequence("savedThirdQuarterScoreTeamA", tvThirdQuarterScoreTeamA.getText());
        outState.putCharSequence("savedFourthQuarterScoreTeamA", tvFourthQuarterScoreTeamA.getText());
        outState.putCharSequence("savedOvertimeScoreTeamA", tvOvertimeScoreTeamA.getText());

        outState.putCharSequence("savedFirstQuarterScoreTeamB", tvFirstQuarterScoreTeamB.getText());
        outState.putCharSequence("savedSecondQuarterScoreTeamB", tvSecondQuarterScoreTeamB.getText());
        outState.putCharSequence("savedThirdQuarterScoreTeamB", tvThirdQuarterScoreTeamB.getText());
        outState.putCharSequence("savedFourthQuarterScoreTeamB", tvFourthQuarterScoreTeamB.getText());
        outState.putCharSequence("savedOvertimeScoreTeamB", tvOvertimeScoreTeamB.getText());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        Log.i(TAG, "onRestoreInstanceState");

        CharSequence currScoreTeamA = savedState.getCharSequence("savedScoreTeamA");
        CharSequence currScoreTeamB = savedState.getCharSequence("savedScoreTeamB");

        scoreTeamA = Integer.parseInt(currScoreTeamA.toString());
        scoreTeamB = Integer.parseInt(currScoreTeamB.toString());

        tvScoreTeamA.setText("" + scoreTeamA);
        tvScoreTeamB.setText("" + scoreTeamB);

        CharSequence currFirstQuarterScoreTeamA = savedState.getCharSequence("savedFirstQuarterScoreTeamA");
        CharSequence currSecondQuarterScoreTeamA = savedState.getCharSequence("savedSecondQuarterScoreTeamA");
        CharSequence currThirdQuarterScoreTeamA = savedState.getCharSequence("savedThirdQuarterScoreTeamA");
        CharSequence currFourthQuarterScoreTeamA = savedState.getCharSequence("savedFourthQuarterScoreTeamA");
        CharSequence currOvertimeScoreTeamA = savedState.getCharSequence("savedOvertimeScoreTeamA");

        firstQuarterScoreTeamA = Integer.parseInt(currFirstQuarterScoreTeamA.toString());
        secondQuarterScoreTeamA = Integer.parseInt(currSecondQuarterScoreTeamA.toString());
        thirdQuarterScoreTeamA = Integer.parseInt(currThirdQuarterScoreTeamA.toString());
        fourthQuarterScoreTeamA = Integer.parseInt(currFourthQuarterScoreTeamA.toString());
        overtimeScoreTeamA = Integer.parseInt(currOvertimeScoreTeamA.toString());

        tvFirstQuarterScoreTeamA.setText("" + firstQuarterScoreTeamA);
        tvSecondQuarterScoreTeamA.setText("" + secondQuarterScoreTeamA);
        tvThirdQuarterScoreTeamA.setText("" + thirdQuarterScoreTeamA);
        tvFourthQuarterScoreTeamA.setText("" + fourthQuarterScoreTeamA);
        tvOvertimeScoreTeamA.setText("" + overtimeScoreTeamA);

        CharSequence currFirstQuarterScoreTeamB = savedState.getCharSequence("savedFirstQuarterScoreTeamB");
        CharSequence currSecondQuarterScoreTeamB = savedState.getCharSequence("savedSecondQuarterScoreTeamB");
        CharSequence currThirdQuarterScoreTeamB = savedState.getCharSequence("savedThirdQuarterScoreTeamB");
        CharSequence currFourthQuarterScoreTeamB = savedState.getCharSequence("savedFourthQuarterScoreTeamB");
        CharSequence currOvertimeScoreTeamB = savedState.getCharSequence("savedOvertimeScoreTeamB");

        firstQuarterScoreTeamB = Integer.parseInt(currFirstQuarterScoreTeamB.toString());
        secondQuarterScoreTeamB = Integer.parseInt(currSecondQuarterScoreTeamB.toString());
        thirdQuarterScoreTeamB = Integer.parseInt(currThirdQuarterScoreTeamB.toString());
        fourthQuarterScoreTeamB = Integer.parseInt(currFourthQuarterScoreTeamB.toString());
        overtimeScoreTeamB = Integer.parseInt(currOvertimeScoreTeamB.toString());

        tvFirstQuarterScoreTeamB.setText("" + firstQuarterScoreTeamB);
        tvSecondQuarterScoreTeamB.setText("" + secondQuarterScoreTeamB);
        tvThirdQuarterScoreTeamB.setText("" + thirdQuarterScoreTeamB);
        tvFourthQuarterScoreTeamB.setText("" + fourthQuarterScoreTeamB);
        tvOvertimeScoreTeamB.setText("" + overtimeScoreTeamB);
    }
}