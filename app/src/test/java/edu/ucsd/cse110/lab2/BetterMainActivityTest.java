package edu.ucsd.cse110.lab2;


import static org.junit.Assert.assertEquals;

import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test1() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            TextView display = (TextView) activity.findViewById(R.id.display);
            Button button_1 = (Button) activity.findViewById(R.id.btn_one);
            Button add_button = (Button) activity.findViewById(R.id.btn_plus);
            Button enter_button = (Button) activity.findViewById(R.id.btn_equals);
            button_1.performClick();
            add_button.performClick();
            button_1.performClick();
            enter_button.performClick();
            assertEquals("2", display.getText());
        });
    }
}
