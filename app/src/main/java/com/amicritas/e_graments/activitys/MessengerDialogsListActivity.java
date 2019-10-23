package com.amicritas.e_graments.activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.amicritas.e_graments.R;
import com.amicritas.e_graments.modals.Author;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;

public class MessengerDialogsListActivity extends AppCompatActivity {

    DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger_dialogs_list);

        dialogsList = findViewById(R.id.dialogsList);
        Author d = new Author();

        DialogsListAdapter dialogsListAdapter = new DialogsListAdapter((imageView, url, payload) ->{
            Toast.makeText(this, "list", Toast.LENGTH_SHORT).show();
        } );
    }
}
