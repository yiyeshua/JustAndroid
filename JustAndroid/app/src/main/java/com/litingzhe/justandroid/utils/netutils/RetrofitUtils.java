package com.litingzhe.justandroid.utils.netutils;

import com.litingzhe.justandroid.utils.netutils.StringFactory.StringConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类名称：RetrofitUtils
 * 创建人：wangliteng
 * 创建时间：2016-5-18 14:57:11
 * 类描述：封装一个retrofit集成0kHttp3的抽象基类
 */
public abstract class RetrofitUtils {

    //服务器路径
    private static final String API_SERVER = "https://api.tianapi.com/";

    private static Retrofit mRetrofit;
    private static OkHttpClient mOkHttpClient;

    /**
     * 获取Retrofit对象
     *
     * @return
     */
    protected static Retrofit getRetrofit() {

        if (null == mRetrofit) {

            if (null == mOkHttpClient) {
                mOkHttpClient = OkHttp3Utils.getOkHttpClient();
            }

            //Retrofit2后使用build设计模式
            mRetrofit = new Retrofit.Builder()
                    //设置服务器路径
                    .baseUrl(API_SERVER)
                    //添加转化库，默认是Gson
                    .addConverterFactory(GsonConverterFactory.create())
                    //字符串
//                    .addConverterFactory(StringConverterFactory.create())
                    //添加回调库，采用RxJava
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //设置使用okhttp网络请求
                    .client(mOkHttpClient)
                    .build();

        }

        return mRetrofit;
    }

}
