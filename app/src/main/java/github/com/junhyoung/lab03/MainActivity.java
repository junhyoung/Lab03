package github.com.junhyoung.lab03;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btStart;
    Button btStop;
    MediaPlayer mMplayer; // Prepare mp3 file for MediaPlayer
    // Prepare mp3 file for MediaPlayer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMplayer = new MediaPlayer();
        btStart = (Button) findViewById(R.id.bt_start);
        btStop = (Button) findViewById(R.id.bt_stop);
        try {
            AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.boysandgirls);
            mMplayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mMplayer.prepare(); //start 하기전에 필수로 prepare을 꼭 해줘야함.
                    mMplayer.start();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

        });
        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMplayer.stop();

            }
        });

    }

}
