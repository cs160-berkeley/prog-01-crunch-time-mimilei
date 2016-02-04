package com.example.michang.crunchtime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String EXTRA_MESSAGE = "com.example.michang.crunchtime.MESSAGE";

    EditText numReps;
    TextView calsBurned;
    TextView calsBurned_accompany;
    TextView pushups;
    TextView situps;
    TextView jumpingjacks;
    TextView jogging;
    TextView itsthesameas;
    TextView squats;
    TextView leglifts;
    TextView plank;
    TextView pullups;
    TextView cycling;
    TextView walking;
    TextView swimming;
    TextView stairs;
    RelativeLayout results;

    Button calc;
    double reps_double;
    String exercise;
    double value_burned;
    double ratio_pushups;
    double ratio_situps;
    double ratio_jumpingjacks;
    double ratio_jogging;
    double ratio_squats;
    double ratio_leglifts;
    double ratio_plank;
    double ratio_pullups;
    double ratio_cycling;
    double ratio_walking;
    double ratio_swimming;
    double ratio_stairs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Spinner exercise_spinner = (Spinner) findViewById(R.id.exercise_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercise_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        exercise_spinner.setAdapter(adapter);
        exercise_spinner.setGravity(Gravity.CENTER_HORIZONTAL);

        results = (RelativeLayout)findViewById(R.id.results);
        calc = (Button)findViewById(R.id.calc_button);
        calsBurned = (TextView)findViewById(R.id.calsBurned_txtview);
        calsBurned_accompany = (TextView)findViewById(R.id.calsBurned_accompanytxt);
        pushups = (TextView)findViewById(R.id.pushups_txtview);
        situps = (TextView)findViewById(R.id.situps_txtview);
        jumpingjacks = (TextView)findViewById(R.id.jumpingjacks_txtview);
        jogging = (TextView)findViewById(R.id.jogging_txtview);
        itsthesameas = (TextView)findViewById(R.id.itsthesameas);
        squats = (TextView)findViewById(R.id.squats_txtview);
        leglifts = (TextView)findViewById(R.id.leglifts_txtview);
        plank = (TextView)findViewById(R.id.plank_txtview);
        pullups = (TextView)findViewById(R.id.pullups_txtview);
        cycling = (TextView)findViewById(R.id.cycling_txtview);
        walking = (TextView)findViewById(R.id.walking_txtview);
        swimming = (TextView)findViewById(R.id.swimming_txtview);
        stairs = (TextView)findViewById(R.id.stairs_txtview);
        calc.setOnClickListener(this);
        ratio_pushups = 350.;
        ratio_situps = 200.;
        ratio_jumpingjacks = 10.;
        ratio_jogging = 12.;
        ratio_squats = 225.;
        ratio_leglifts = 25.;
        ratio_plank = 25.;
        ratio_pullups = 100.;
        ratio_cycling = 12.;
        ratio_walking = 20.;
        ratio_swimming = 13.;
        ratio_stairs = 15.;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String getMinutes(double ratio) {
        double min = value_burned*ratio/100;
        String result;
        if (min == 1) {
            result = String.format("%.2f", min) + " minute";
        }
        else {
            result = String.format("%.2f", min) + " minutes";
        }
        return result;
    }

    public String getReps(double ratio) {
        double reps = value_burned*ratio/100;
        String result;
        if (reps == 1) {
            result = String.format("%.2f", reps) + " rep";
        }
        else {
            result = String.format("%.2f", reps) + " reps";
        }
        return result;
    }

    public double getCalsBurnedNum(double ratio) {
        return reps_double*100/ratio;
    }

    public String getCalsBurned() {
        if (exercise.equals("Situps")) {
            value_burned = getCalsBurnedNum(ratio_situps);
            situps.setVisibility(View.GONE);
        } else if (exercise.equals("Pushups")) {
            value_burned = getCalsBurnedNum(ratio_pushups);
            pushups.setVisibility(View.GONE);
        } else if (exercise.equals("Jumping Jacks")) {
            value_burned = getCalsBurnedNum(ratio_jumpingjacks);
            jumpingjacks.setVisibility(View.GONE);
        } else if (exercise.equals("Jogging")) {
            value_burned = getCalsBurnedNum(ratio_jogging);
            jogging.setVisibility(View.GONE);
        } else if (exercise.equals("Squats")) {
            value_burned = getCalsBurnedNum(ratio_squats);
            squats.setVisibility(View.GONE);
        } else if (exercise.equals("Leg-Lifts")) {
            value_burned = getCalsBurnedNum(ratio_leglifts);
            leglifts.setVisibility(View.GONE);
        } else if (exercise.equals("Plank")) {
            value_burned = getCalsBurnedNum(ratio_plank);
            plank.setVisibility(View.GONE);
        } else if (exercise.equals("Pullups")) {
            value_burned = getCalsBurnedNum(ratio_pullups);
            pullups.setVisibility(View.GONE);
        } else if (exercise.equals("Cycling")) {
            value_burned = getCalsBurnedNum(ratio_cycling);
            cycling.setVisibility(View.GONE);
        } else if (exercise.equals("Walking")) {
            value_burned = getCalsBurnedNum(ratio_walking);
            walking.setVisibility(View.GONE);
        } else if (exercise.equals("Swimming")) {
            value_burned = getCalsBurnedNum(ratio_swimming);
            swimming.setVisibility(View.GONE);
        } else if (exercise.equals("Stair-Climbing")) {
            value_burned = getCalsBurnedNum(ratio_stairs);
            stairs.setVisibility(View.GONE);
        }
        if (value_burned == 1) {
            calsBurned_accompany.setText("Calorie burned");
        }
        else {
            calsBurned_accompany.setText("Calories burned");
        }
        return String.format("%.2f", value_burned);
    }

    @Override
    public void onClick(View v) {
        numReps = (EditText)findViewById(R.id.reps_input);

        Spinner exercise_spinner = (Spinner) findViewById(R.id.exercise_spinner);
        exercise = exercise_spinner.getSelectedItem().toString();
        reps_double = Double.parseDouble(numReps.getText().toString());
        itsthesameas.setVisibility(View.VISIBLE);

        //Find calories burned
        results.setVisibility(View.VISIBLE);
        results.setGravity(Gravity.CENTER_HORIZONTAL);
        calsBurned.setText(getCalsBurned());
        calsBurned_accompany.setVisibility(View.VISIBLE);

        //Find equivalents
        if (!exercise.equals("Situps")) {
            situps.setVisibility(View.VISIBLE);
            situps.setText("Situps: " + getReps(ratio_situps));
        }
        if (!exercise.equals("Pushups")) {
            pushups.setVisibility(View.VISIBLE);
            pushups.setText("Pushups: " + getReps(ratio_pushups));
        }
        if (!exercise.equals("Jumping Jacks")) {
            jumpingjacks.setVisibility(View.VISIBLE);
            jumpingjacks.setText("Jumping Jacks: " + getMinutes(ratio_jumpingjacks));
        }
        if (!exercise.equals("Jogging")) {
            jogging.setVisibility(View.VISIBLE);
            jogging.setText("Jogging: " + getMinutes(ratio_jogging));
        }
        if (!exercise.equals("Squats")) {
            squats.setVisibility(View.VISIBLE);
            squats.setText("Squats: " + getReps(ratio_squats));
        }
        if (!exercise.equals("Leg-Lifts")) {
            leglifts.setVisibility(View.VISIBLE);
            leglifts.setText("Leg-Lifts: " + getMinutes(ratio_leglifts));
        }
        if (!exercise.equals("Plank")) {
            plank.setVisibility(View.VISIBLE);
            plank.setText("Plank: " + getMinutes(ratio_plank));
        }
        if (!exercise.equals("Pullups")) {
            pullups.setVisibility(View.VISIBLE);
            pullups.setText("Pullups: " + getReps(ratio_pullups));
        }
        if (!exercise.equals("Cycling")) {
            cycling.setVisibility(View.VISIBLE);
            cycling.setText("Cycling: " + getMinutes(ratio_cycling));
        }
        if (!exercise.equals("Walking")) {
            walking.setVisibility(View.VISIBLE);
            walking.setText("Walking: " + getMinutes(ratio_walking));
        }
        if (!exercise.equals("Swimming")) {
            swimming.setVisibility(View.VISIBLE);
            swimming.setText("Swimming: " + getMinutes(ratio_swimming));
        }
        if (!exercise.equals("Stair-Climbing")) {
            stairs.setVisibility(View.VISIBLE);
            stairs.setText("Stair-Climbing: " + getMinutes(ratio_stairs));
        }
    }
}
