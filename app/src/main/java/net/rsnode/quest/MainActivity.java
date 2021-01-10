package net.rsnode.quest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button[] choices = new Button[3];
    TextView console;
    Story story;
    Character player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choices[0] = findViewById(R.id.ch1);
        choices[1] = findViewById(R.id.ch2);
        choices[2] = findViewById(R.id.ch3);
        for(Button b: choices){
            b.setOnClickListener(this);
        }
        console = findViewById(R.id.Console);
        player = new Character("Игрок");
        story = new Story(this);
        console.setText("============" + story.current_situation.subject + "============\n" + story.current_situation.text);
    }

    @Override
    public void onClick(View v) {
        int choice = 0;
        if(v.getId() == R.id.ch1)
            choice = 1;
        if(v.getId() == R.id.ch2)
            choice = 2;
        if(v.getId() == R.id.ch3)
            choice = 3;
        player.Health += story.current_situation.dHealth;
        player.Money += story.current_situation.dMoney;
        player.Power += story.current_situation.dPower;
        if (story.isEnd()) {
            console.setText("==========Конец игры==========");
            return;
        }
        story.go(choice);
        console.setText("============" + story.current_situation.subject + "============\n" + story.current_situation.text);
    }
}