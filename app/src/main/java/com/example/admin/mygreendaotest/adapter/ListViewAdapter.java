package com.example.admin.mygreendaotest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.mygreendaotest.R;
import com.example.admin.mygreendaotest.base.MyApplication;
import com.example.admin.mygreendaotest.bean.User;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by admin on 2017/8/15.
 */

public class ListViewAdapter extends BaseAdapter {
    List<User> users;

    public ListViewAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(MyApplication.app).inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.userName = view.findViewById(R.id.tv_userName);
            viewHolder.age = view.findViewById(R.id.tv_age);
            viewHolder.interests = view.findViewById(R.id.tv_interests);
            viewHolder.phoneNumber = view.findViewById(R.id.tv_phoneNumber);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.userName.setText(users.get(i).getName());
        viewHolder.age.setText(users.get(i).getAge() + "");
        viewHolder.interests.setText(users.get(i).getInterests());
        viewHolder.phoneNumber.setText(users.get(i).getPhoneNumber());
        return view;
    }

    class ViewHolder {
        TextView userName;
        TextView age;
        TextView interests;
        TextView phoneNumber;
    }
}
