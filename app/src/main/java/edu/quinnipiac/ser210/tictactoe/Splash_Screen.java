package edu.quinnipiac.ser210.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
    }

    //onClick method for button on splash screen
    public void startGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = findViewById(R.id.editText);
        String name = editText.getText().toString();
        intent.putExtra("playerName", name);
        startActivity(intent); //send player name to MainActivity via intent
    }
}
