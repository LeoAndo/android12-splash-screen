package com.example.basicappsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.KeyEvent
import com.example.basicappsample.databinding.ActivityMainBinding
import com.example.basicappsample.helpers.AnimationHelper
import com.example.basicappsample.helpers.KeyboardHelpable
import com.example.basicappsample.media.MainSoundPlayer

class MainActivity : AppCompatActivity(), KeyboardHelpable {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textHello.text = "Hello, Android Java"
        AnimationHelper.startAlphaAnimation(binding.textHello)
        binding.editEmail.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                this@MainActivity.hideKeyboard()
                return@setOnKeyListener true
            } else {
                return@setOnKeyListener false
            }
        }
        binding.editEmail.addTextChangedListener(MyTextWatcher())
        val soundPlayer = MainSoundPlayer(this)
        lifecycle.addObserver(soundPlayer)
        binding.button.setOnClickListener { v -> soundPlayer.playButtonSound() }
    }

    private inner class MyTextWatcher : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            binding.button.isEnabled = !TextUtils.isEmpty(s)
            val isErrorEnabled = TextUtils.isEmpty(s)
            binding.editEmailLayout.isErrorEnabled = isErrorEnabled
            if (isErrorEnabled) {
                binding.editEmailLayout.error = "入力してください！！"
            }
        }

        override fun afterTextChanged(s: Editable) {}
    }
}