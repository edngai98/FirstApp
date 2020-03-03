    package com.example.helloworld;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;

    public class MainActivity extends AppCompatActivity{
        private static final String TAG = "MainActivity";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            Log.d(TAG, "onCreate: Starting OnCreate");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button button = (Button) findViewById(R.id.DetailButton);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moveToDetailActivity();
                }
            });

        }

        private void moveToDetailActivity() {
            Intent intent = new Intent(MainActivity.this, CoinViewActivity.class);

            String text = "Bitcoin";
            intent.putExtra("Bitcoin", text);

            startActivity(intent);
        }
    }
