package com.github.shareme.gwskenburnsview;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by fgrott on 9/1/2015.
 */
public abstract class KenBurnsActivity extends AppCompatActivity {

    private boolean mPaused;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.playPause);
        if (mPaused) {
            item.setIcon(R.mipmap.ic_media_play);
            item.setTitle(R.string.play);
        } else {
            item.setIcon(R.mipmap.ic_media_pause);
            item.setTitle(R.string.pause);
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.playPause:
                if (mPaused) {
                    onPlayClick();
                } else {
                    onPauseClick();
                }
                mPaused = !mPaused;
                invalidateOptionsMenu();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    protected abstract void onPlayClick();
    protected abstract void onPauseClick();

}
