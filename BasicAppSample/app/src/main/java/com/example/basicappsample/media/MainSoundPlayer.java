package com.example.basicappsample.media; // TODO パッケージ名は環境によって変更してください

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.basicappsample.R;

/**
 * メイン画面で使用するサウンドクラス.
 */
public class MainSoundPlayer implements LifecycleObserver {
    private final SoundPool soundPool;

    private final int buttonSoundId;
    private int buttonStreamId;
    private final int checkBoxSoundId;
    private int checkBoxStreamId;

    private static final String LOG_TAG = MainSoundPlayer.class.getSimpleName();
    private static final float LEFT_VOLUME_VALUE = 1.0f; // left volume value (range = 0.0 to 1.0)
    private static final float RIGHT_VOLUME_VALUE = 1.0f;// right volume value (range = 0.0 to 1.0)
    private static final int SOUND_LOOP_MODE_NO_LOOP = 0; // loop mode (0 = no loop, -1 = loop forever)
    private static final float SOUND_PLAY_BACK_RATE = 1.0f; // playback rate (1.0 = normal playback, range 0.5 to 2.0)
    private static final int PRIORITY_1 = 1;

    public MainSoundPlayer(Context context) {
        final AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        final int maxStreams = 2; // ストリーム数
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(maxStreams)
                .build();
        // TODO R.raw.xxxx 音声ファイル名は自分が追加したファイル名に変更してください
        buttonSoundId = soundPool.load(context, R.raw.button03b, PRIORITY_1);
        checkBoxSoundId = soundPool.load(context, R.raw.cracker2, PRIORITY_1);
    }

    // 音声を再生する
    public void playButtonSound() {
        buttonStreamId = soundPool.play(
                buttonSoundId, LEFT_VOLUME_VALUE, RIGHT_VOLUME_VALUE,
                PRIORITY_1, SOUND_LOOP_MODE_NO_LOOP, SOUND_PLAY_BACK_RATE);
    }

    public void playCheckBoxSound() {
        checkBoxStreamId = soundPool.play(
                checkBoxSoundId, LEFT_VOLUME_VALUE, RIGHT_VOLUME_VALUE,
                PRIORITY_1, SOUND_LOOP_MODE_NO_LOOP, SOUND_PLAY_BACK_RATE);
    }

    // 音声を停止する
    public void stopButtonSound() {
        soundPool.stop(buttonStreamId);
    }

    public void stopCheckBoxSound() {
        soundPool.stop(checkBoxStreamId);
    }

    // 画面表示時に呼ばれる
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        Log.d(LOG_TAG, "call autoResume");
        if (soundPool == null) return;
        soundPool.autoResume(); // soundPool.autoPause()したときにアクティブだったすべての音声ファイルを再生する.
    }

    // 画面非表示時に呼ばれる
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        Log.d(LOG_TAG, "call autoPause");
        if (soundPool == null) return;
        soundPool.autoPause(); // 全ての再生中の音声ファイルを停止する.
    }

    // 画面終了時に呼ばれる
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Log.d(LOG_TAG, "call release soundPool: " + soundPool);
        if (soundPool == null) return;
        soundPool.release(); // SoundPoolによって使用されているすべてのメモリとネイティブリソースを解放する.
    }
}
