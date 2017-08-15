package com.example.admin.mygreendaotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.mygreendaotest.adapter.ListViewAdapter;
import com.example.admin.mygreendaotest.bean.User;
import com.example.admin.mygreendaotest.utils.UserDbUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    String message;

    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et_text);

    }

    public void insert(View view) {
        message = editText.getText().toString();
        if (message.isEmpty()) {
            Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = new User();
        user.setName(message);
        user.setAge(21);
        user.setInterests("play basketball");
        user.setPhoneNumber("12345678910");
        UserDbUtil.getInstance().insert(user);
        editText.setText("");
        Toast.makeText(this, "insert success!", Toast.LENGTH_SHORT).show();
    }

    public void query(View view) {
        List<User> userList = UserDbUtil.getInstance().queryAll();
        if (userList.size() == 0) {
            Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer sb = new StringBuffer();
        for (User user : userList) {
            sb.append(user.getName() + " ");
        }
        editText.setText(sb.toString());
        Toast.makeText(this, "query success!", Toast.LENGTH_SHORT).show();
    }

    public void clear(View view) {
        editText.setText("");
        Toast.makeText(this, "clear success", Toast.LENGTH_SHORT).show();
    }

}
