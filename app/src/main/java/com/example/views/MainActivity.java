package com.example.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.views.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.viewBinding.getRoot());

        this.viewBinding.tv.setText(R.string.label);
        this.viewBinding.bt1.setOnClickListener(v -> viewBinding.sw.toggle());
        final String string = this.viewBinding.et.getText().toString();

        this.viewBinding.et.setOnEditorActionListener((et,actionId, keyEvent) -> {
            if(actionId == EditorInfo.IME_ACTION_GO)
            {
                this.viewBinding.tv.setText(et.getText().toString());
            }
            return false;
        });

        this.viewBinding.et.addTextChangedListener(new TextWatcher() {
                                        @Override
                                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

                                        @Override
                                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                            viewBinding.tv.setText(charSequence.toString().toUpperCase(Locale.ROOT));
                                        }

                                        @Override
                                        public void afterTextChanged(Editable editable) {}
                                    });

        this.viewBinding.sw.setOnClickListener(this::onBtClick);
        this.viewBinding.sw.setOnCheckedChangeListener((bt, isChecked) -> viewBinding.tv.setText(String.valueOf(isChecked)));
    }

    public void onBtClick(View view)
    {
        Snackbar.make(MainActivity.this,view,getString(R.string.saludo), Snackbar.LENGTH_SHORT).show();
    }
}