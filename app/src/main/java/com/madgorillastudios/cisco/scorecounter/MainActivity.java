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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = MainActivity.class.getName();

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
    private TextView tvOvertimeQuarterScoreTeamA;
    private TextView tvFirstQuarterScoreTeamB;
    private TextView tvSecondQuarterScoreTeamB;
    private TextView tvThirdQuarterScoreTeamB;
    private TextView tvFourthQuarterScoreTeamB;
    private TextView tvOvertimeQuarterScoreTeamB;

    private Spinner spinnerGameQuarter;
    private ArrayAdapter<CharSequence> adapterGameQuarter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        tvOvertimeQuarterScoreTeamA = (TextView) findViewById(R.id.text_view_overtime_score_team_a);

        tvFirstQuarterScoreTeamB = (TextView) findViewById(R.id.text_view_first_quarter_score_team_b);
        tvSecondQuarterScoreTeamB = (TextView) findViewById(R.id.text_view_second_quarter_score_team_b);
        tvThirdQuarterScoreTeamB = (TextView) findViewById(R.id.text_view_third_quarter_score_team_b);
        tvFourthQuarterScoreTeamB = (TextView) findViewById(R.id.text_view_fourth_quarter_score_team_b);
        tvOvertimeQuarterScoreTeamB = (TextView) findViewById(R.id.text_view_overtime_score_team_b);

        Button btnPlusThreePointsTeamA = (Button) findViewById(R.id.button_plus_three_points_team_a);
        btnPlusThreePointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamA(3);
            }
        });

        Button btnPlusTwoPointsTeamA = (Button) findViewById(R.id.button_plus_two_points_team_a);
        btnPlusTwoPointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamA(2);
            }
        });

        Button btnPlusOnePointTeamA = (Button) findViewById(R.id.button_plus_one_point_team_a);
        btnPlusOnePointTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamA(1);
            }
        });

        Button btnPlusThreePointsTeamB = (Button) findViewById(R.id.button_plus_three_points_team_b);
        btnPlusThreePointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamB(3);
            }
        });

        Button btnPlusTwoPointsTeamB = (Button) findViewById(R.id.button_plus_two_points_team_b);
        btnPlusTwoPointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamB(2);
            }
        });

        Button btnPlusOnePointTeamB = (Button) findViewById(R.id.button_plus_one_point_team_b);
        btnPlusOnePointTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementScoreTeamB(1);
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

        tvFirstQuarterScoreTeamA.setText("");
        tvSecondQuarterScoreTeamA.setText("");
        tvThirdQuarterScoreTeamA.setText("");
        tvFourthQuarterScoreTeamA.setText("");
        tvOvertimeQuarterScoreTeamA.setText("");

        firstQuarterScoreTeamB = 0;
        secondQuarterScoreTeamB = 0;
        thirdQuarterScoreTeamB = 0;
        fourthQuarterScoreTeamB = 0;
        overtimeScoreTeamB = 0;

        tvFirstQuarterScoreTeamB.setText("");
        tvSecondQuarterScoreTeamB.setText("");
        tvThirdQuarterScoreTeamB.setText("");
        tvFourthQuarterScoreTeamB.setText("");
        tvOvertimeQuarterScoreTeamB.setText("");

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
            tvOvertimeQuarterScoreTeamA.setText("" + overtimeScoreTeamA);
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
            tvOvertimeQuarterScoreTeamB.setText("" + overtimeScoreTeamB);
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
        int drawableId = 0;

        if (sideOfTeam.equalsIgnoreCase("A")) {
            imageViewId = R.id.image_view_team_a;
        } else {
            imageViewId = R.id.image_view_team_b;
        }

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
}

