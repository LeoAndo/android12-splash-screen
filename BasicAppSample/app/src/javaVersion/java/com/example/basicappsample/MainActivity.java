package com.example.basicappsample;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicappsample.databinding.ActivityMainBinding;
import com.example.basicappsample.helpers.AnimationHelper;
import com.example.basicappsample.media.MainSoundPlayer;
import com.example.basicappsample.helpers.KeyboardHelpable;

public class MainActivity extends AppCompatActivity implements KeyboardHelpable {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.textHello.setText("Hello, Android Java");
        AnimationHelper.startAlphaAnimation(binding.textHello);
        binding.editEmail.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                hideKeyboard(MainActivity.this);
                return true;
            } else {
                return false;
            }
        });
        binding.editEmail.addTextChangedListener(new MyTextWatcher());

        MainSoundPlayer soundPlayer = new MainSoundPlayer(this);
        getLifecycle().addObserver(soundPlayer);
        binding.button.setOnClickListener(v -> soundPlayer.playButtonSound());
    }

    private class MyTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            binding.button.setEnabled(!TextUtils.isEmpty(s));
            final boolean isErrorEnabled = TextUtils.isEmpty(s);
            binding.editEmailLayout.setErrorEnabled(isErrorEnabled);
            if (isErrorEnabled) {
                binding.editEmailLayout.setError("入力してください！！");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
