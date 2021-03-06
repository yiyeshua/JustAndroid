package com.litingzhe.justandroid.global;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.DisplayMetrics;

import com.litingzhe.justandroid.netdb.db.dao.DaoMaster;
import com.litingzhe.justandroid.netdb.db.dao.DaoSession;
import com.litingzhe.justandroid.utils.dbutils.DBHelper;
import com.ningcui.mylibrary.utiils.AbViewUtil;
import com.ningcui.mylibrary.viewLib.segment.utils.TypefaceProvider;

/**
 *
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;

        initDisplayOpinion();
        setDatabase();

        TypefaceProvider.registerDefaultIconSets();
    }



    public static MyApplication getInstance() {
        return instance;
    }



    /**
     * 设置greenDao
     */
    private void setDatabase() {

        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "mydb", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }


    public static Context getContext(){
        return instance;
    }


    private void initDisplayOpinion() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        AbViewUtil.density = dm.density;
        AbViewUtil.densityDPI = dm.densityDpi;
        AbViewUtil.screenWidthPx = dm.widthPixels;
        AbViewUtil.screenhightPx = dm.heightPixels;
        AbViewUtil.screenWidthDip = AbViewUtil.px2dip(getApplicationContext(), dm.widthPixels);
        AbViewUtil.screenHightDip = AbViewUtil.px2dip(getApplicationContext(), dm.heightPixels);
    }




}

