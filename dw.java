package com.example.manue.myapplication;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Rijeka_Quiz extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    int brojacTick = 0; // varijabla korištena za ispis rezultata; TOČNIH
    int brojacNoTick = 0; // varijabla korištena za ispis rezultata; NETOČNIH
    boolean stanje;
    byte brPitanja = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        program();
    }

    public void program() {
        setContentView(R.layout.activity_rijeka__quiz);
        RelativeLayout relativePitanjaTN = (RelativeLayout) findViewById(R.id.relativePitanjaTocnoNetocno);  // Objekt za RELATIVE LAYOUT
        Button btnTocno = (Button) findViewById(R.id.buttonTocno);                                           // Objekt za button 'TOČNO'
        Button btnNetocno = (Button) findViewById(R.id.buttonNetocno);                                       // Objekt za button 'NETOČNO'

        // 1. PITANJE  - TOČNO/NETOČNO *******
        if (brPitanja == 1) {
            relativePitanjaTN.setVisibility(View.VISIBLE);
            promjenaTekstaTočnoNetočno("Crkva Gospe Trsatske najstarije je hrvatsko marijansko svetište.");
            stanje = true;
        }


        // 2. PITANJE  - TOČNO/NETOČNO *******
        if (brPitanja == 2) {
            promjenaTekstaTočnoNetočno("Srednjovjekovna crkva Uznesenja Marijina sagrađena je na temeljima rimskih termi i starokršćanske bazilike iz 5.st.");
            stanje = true;
            //    buttonListener(stanje);
        }
    }

    public void Tick() {  // ISPIS TOČNIH ODGOVORA, UZ 'KVAČICU'

        brojacTick++;
        TextView Tick = (TextView) findViewById(R.id.trueText);
        Tick.setText(brojacTick);
    }

    public void NoTick() { // ISPIS NETOČNIH ODGOVORA, UZ 'X'
        brojacNoTick++;
        TextView NoTick = (TextView) findViewById(R.id.falseText);
        NoTick.setText(brojacNoTick);
    }

    public void promjenaTekstaTočnoNetočno(String y) {
        TextView pitanjeText = (TextView) findViewById(R.id.pitanjeText);
        pitanjeText.setText(y);
    }

    public void btnFlaseClick(View view) {
        if (stanje == true) NoTick();
        else Tick();
        brPitanja++;
        program();
    }

    public void btnTrueClick(View view) {
        if (stanje == false) NoTick();
        else Tick();
        brPitanja++;
        program();
    }
}




