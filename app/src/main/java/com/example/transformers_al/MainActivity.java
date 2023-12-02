package com.example.transformers_al;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private TextView name1, name2, opisanie1;
    private TextView energy1, energy2;
    private TextView shoots1, shoots2;
    private Button btnStart, btnFight, btnEnd;
    private ImageView image1, image2;
    private LottieAnimationView lotty1, lotty2, lotty_night_sky;

    TransformerRed robot1 = new TransformerRed(
            "Optimus", 2000, 200);

    TransformerYellow robot2 = new TransformerYellow(
            "Galactus", 3000, 100);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1.setText(robot1.getName());
                energy1.setText(String.valueOf(robot1.energy));
                shoots1.setText(String.valueOf(robot1.num_lasers));
                name2.setText(robot2.name);
                energy2.setText(String.valueOf(robot2.energy));
                shoots2.setText(String.valueOf(robot2.num_lasers));
                btnFight.setVisibility(View.VISIBLE);
                String printSelf = robot1.printSelf();
                opisanie1.setText(printSelf);
            }
        });
        gaming();
    }

    private void init() {
        opisanie1 = findViewById(R.id.opisanie1);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        shoots1 = findViewById(R.id.shoots1);
        shoots2 = findViewById(R.id.shoots2);
        energy1 = findViewById(R.id.energy1);
        energy2 = findViewById(R.id.energy2);
        btnStart = findViewById(R.id.btnStart);
        btnFight = findViewById(R.id.btnFight);
        btnEnd = findViewById(R.id.btnEnd);
        lotty1 = findViewById(R.id.lotty1);
        lotty2 = findViewById(R.id.lotty2);
        lotty_night_sky = findViewById(R.id.lotty_night_sky);
        lotty_night_sky.setAnimation(R.raw.black_fone_shootingstars);
        lotty1.setAnimation(R.raw.red_robot);
        lotty2.setAnimation(R.raw.y_robot);
    }

    private void gaming() {
        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStart.setVisibility(View.INVISIBLE);
                image1.setVisibility(View.INVISIBLE);
                image2.setVisibility(View.INVISIBLE);
                if (robot1.energy == 0 || robot2.energy == 0) {
                    btnFight.setVisibility(View.INVISIBLE);
                    btnStart.setVisibility(View.INVISIBLE);
                    lotty1.setVisibility(View.INVISIBLE);
                    lotty2.setVisibility(View.INVISIBLE);
                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.VISIBLE);
                    btnEnd.setVisibility(View.VISIBLE);
                } else {
                    lotty1.setVisibility(View.VISIBLE);
                    lotty2.setVisibility(View.VISIBLE);
                    lotty_night_sky.setVisibility(View.VISIBLE);
                    int m = Integer.parseInt(shoots1.getText().toString());
                    robot1.minusEnergy(m);
                    energy1.setText(String.valueOf(robot1.energy));
                    int n = Integer.parseInt(shoots2.getText().toString());
                    robot2.minusEnergy(n);
                    energy2.setText(String.valueOf(robot2.energy));
                }
            }
        });
    }
}
