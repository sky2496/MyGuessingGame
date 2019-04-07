package bd.nasimdeveloper.myguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button checkButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextId);
        checkButton = findViewById(R.id.checkButtonId);
        resultTextView = findViewById(R.id.resultTextViewId);

        checkButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        String guessString  = editText.getText().toString();
        if(guessString.isEmpty()){
            errorMessage();
        }
        else{
            int guess = Integer.parseInt(guessString);

            if(guess>10){
                errorMessage();
            }

            // Generating random numbers

            Random random = new Random();
            int randomNumber = random.nextInt(10)+1;

            if(randomNumber==guess){
                resultTextView.setText("Congrats !! You have won");

            }
            else{
                resultTextView.setText("Sorry, You have lost! The random number was "+ randomNumber);
            }
        }

    }
    void errorMessage(){
        editText.setError("Please enter a valid input");
        editText.requestFocus();
        return;
    }
}
