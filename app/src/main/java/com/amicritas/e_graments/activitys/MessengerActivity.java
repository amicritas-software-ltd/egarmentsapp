package com.amicritas.e_graments.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.stfalcon.chatkit.messages.MessageInput;

public class MessengerActivity extends AppCompatActivity {
    MessageInput messageInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        messageInput = findViewById(R.id.input);
        messageInput.setInputListener(new MessageInput.InputListener() {
            @Override
            public boolean onSubmit(CharSequence input) {
                Toast.makeText(MessengerActivity.this, input, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
