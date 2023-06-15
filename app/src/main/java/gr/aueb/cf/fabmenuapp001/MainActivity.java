package gr.aueb.cf.fabmenuapp001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fabMain;
    private FloatingActionButton fabOne;
    private FloatingActionButton fabTwo;
    private FloatingActionButton fabThree;
    private Float translationY = 100f;
    private Boolean isMenuOpen = false;
    private OvershootInterpolator overshootInterpolator = new OvershootInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFabMenu();

    }

    private void initFabMenu() {
        fabMain = findViewById(R.id.fabMain);
        fabOne = findViewById(R.id.fabOne);
        fabTwo = findViewById(R.id.fabTwo);
        fabThree = findViewById(R.id.fabThree);

        fabOne.setAlpha(0f);
        fabTwo.setAlpha(0f);
        fabThree.setAlpha(0f);

        fabOne.setTranslationY(translationY);
        fabTwo.setTranslationY(translationY);
        fabThree.setTranslationY(translationY);

        fabMain.setOnClickListener(this);
        fabOne.setOnClickListener(this);
        fabTwo.setOnClickListener(this);
        fabThree.setOnClickListener(this);
    }

    private void openMenu() {
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(overshootInterpolator)
                .rotation(45f)
                .setDuration(300)
                .start();

        fabOne.animate().translationY(0f).alpha(1f)
                .setInterpolator(overshootInterpolator)
                .setDuration(300)
                .start();
        fabTwo.animate().translationY(0f).alpha(1f)
                .setInterpolator(overshootInterpolator)
                .setDuration(300)
                .start();
        fabThree.animate().translationY(0f).alpha(1f)
                .setInterpolator(overshootInterpolator)
                .setDuration(300)
                .start();
    }

    private void closeMenu() {
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(overshootInterpolator)
                .rotation(0f)
                .setDuration(300)
                .start();

        fabOne.animate().translationY(translationY).alpha(0f)
                .setInterpolator(overshootInterpolator)
                .setDuration(300)
                .start();
        fabTwo.animate().translationY(translationY).alpha(0f)
                .setInterpolator(overshootInterpolator)
                .setDuration(300)
                .start();
        fabThree.animate().translationY(translationY).alpha(0f)
                .setInterpolator(overshootInterpolator)
                .setDuration(300)
                .start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabMain:
                if (isMenuOpen) {
                    closeMenu();
                } else {
                    openMenu();
                }
                break;
            case R.id.fabOne:
                Toast.makeText(MainActivity.this, "Fab PHOTO", Toast.LENGTH_SHORT).show();
                if (isMenuOpen) {
                    closeMenu();
                } else {
                    openMenu();
                }
                break;
            case R.id.fabTwo:
                Toast.makeText(MainActivity.this, "Fab MUSIC", Toast.LENGTH_SHORT).show();
                if (isMenuOpen) {
                    closeMenu();
                } else {
                    openMenu();
                }
                   break;
            case R.id.fabThree:
                Toast.makeText(MainActivity.this, "Fab TRAVEL", Toast.LENGTH_SHORT).show();
                if (isMenuOpen) {
                    closeMenu();
                } else {
                    openMenu();
                }
                 break;
            default:
                break;
        }
    }
}