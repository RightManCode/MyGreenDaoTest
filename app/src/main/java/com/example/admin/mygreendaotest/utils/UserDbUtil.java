package com.example.admin.mygreendaotest.utils;

import android.content.Context;

import com.example.admin.mygreendaotest.base.MyApplication;
import com.example.admin.mygreendaotest.bean.User;
import com.example.admin.mygreendaotest.dao.DaoMaster;
import com.example.admin.mygreendaotest.dao.DaoSession;
import com.example.admin.mygreendaotest.dao.UserDao;

import org.greenrobot.greendao.database.Database;

import java.util.List;

/**
 * Created by admin on 2017/8/15.
 */

public class UserDbUtil {

    private static UserDbUtil db;

    private DaoMaster.OpenHelper openHelper;

    private Context context;

    private UserDbUtil() {
        context = MyApplication.app;
        openHelper = new DaoMaster.DevOpenHelper(context, "uer_db");
    }

    public static UserDbUtil getInstance() {
        if (db == null) {
            synchronized (UserDbUtil.class) {
                db = new UserDbUtil();
            }
        }
        return db;
    }

    private Database getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, "user_db");
        }
        Database database = openHelper.getReadableDb();
        return database;
    }

    private Database getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, "user_db");
        }
        Database database = openHelper.getWritableDb();
        return database;
    }


    //增
    public void insert(User user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.insertOrReplace(user);
    }

    //删
    public void delete(User user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.delete(user);
    }

    //改
    public void update(User user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.update(user);
    }

    //查全部
    public List<User> queryAll() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        List<User> userList = userDao.queryBuilder().build().list();
        return userList;
    }
}
