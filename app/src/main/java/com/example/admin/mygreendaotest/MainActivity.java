package com.example.admin.mygreendaotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.mygreendaotest.adapter.ListViewAdapter;
import com.example.admin.mygreendaotest.bean.User;
import com.example.admin.mygreendaotest.utils.UserDbUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etName;

    EditText etAge;

    EditText etInterests;

    EditText etPhoneNumber;

    ListViewAdapter listViewAdapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.et_name);
        etAge = (EditText) findViewById(R.id.et_age);
        etInterests = (EditText) findViewById(R.id.et_interests);
        etPhoneNumber = (EditText) findViewById(R.id.et_phoneNumber);
        listView = (ListView) findViewById(R.id.list_data);
    }

    public void insert(View view) {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String interests = etInterests.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();

        if (name.isEmpty() || age.isEmpty() || interests.isEmpty() || phoneNumber.isEmpty()) {
            Toast.makeText(this, "wrong!", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = new User();
        user.setName(name);
        user.setAge(Integer.valueOf(age));
        user.setInterests(interests);
        user.setPhoneNumber(phoneNumber);
        UserDbUtil.getInstance().insert(user);
        etName.setText("");
        etAge.setText("");
        etInterests.setText("");
        etPhoneNumber.setText("");
        Toast.makeText(this, "insert success!", Toast.LENGTH_SHORT).show();
    }

    public void query(View view) {
        List<User> userList = UserDbUtil.getInstance().queryAll();
        if (userList.size() == 0) {
            Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
            return;
        }
//        StringBuffer sb = new StringBuffer();
//        for (User user : userList) {
//            sb.append(user.getName() + " ");
//        }
//        editText.setText(sb.toString());
        listViewAdapter = new ListViewAdapter(userList);
        listView.setAdapter(listViewAdapter);
        Toast.makeText(this, "query success!", Toast.LENGTH_SHORT).show();
    }

    public void clear(View view) {
        etName.setText("");
        etAge.setText("");
        etInterests.setText("");
        etPhoneNumber.setText("");
        Toast.makeText(this, "clear success", Toast.LENGTH_SHORT).show();
    }

}
