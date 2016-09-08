package com.umpay.four_view2;

import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.umpay.three_view.ServerLinstener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    Intent intent = null;
    VV vv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent("com.aa.remote_service");
        intent.setPackage("com.umpay.three_view");
        vv = (VV) findViewById(R.id.vv);
        Log.i(TAG, "onCreate: vv width = " + vv.getWidth() + " vv height = " + vv.getHeight());
        bindService(intent, sc, Context.BIND_AUTO_CREATE);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "ll onClick: ");
            }
        });
        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i(TAG, "ll OnTouchListener: action_down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i(TAG, "ll OnTouchListener: action_move");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(TAG, "ll OnTouchListener: action_up");
                        break;
                }
                return false;
            }
        });
        vv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i(TAG, " OnTouchListener: action_down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i(TAG, " OnTouchListener: action_move");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(TAG, " OnTouchListener: action_up");
                        break;
                }
                return false;
            }
        });

        ViewTreeObserver tree = vv.getViewTreeObserver();
        tree.addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                Log.i(TAG, "onGlobalFocusChanged: vv width = " + vv.getWidth() + " vv height = " + vv.getHeight());
            }
        });
        vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "vv onClick: ");
            }
        });
        findViewById(R.id.ccc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = 0;
                try {
                    if (sl == null) {
                        Log.i(TAG, "onClick: sl  == null");
                        return;
                    }
                    a = sl.clac(34, 5);
                    System.out.println("clc2 = " + a);
                    List<String> lists = sl.gotList("op");
                    System.out.println("lists = " + lists);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    bindService(intent, sc, Context.BIND_AUTO_CREATE);
                }
                ObjectAnimator.ofFloat(vv, "translationX", 0, 100).setDuration(1000).start();
            }
        });
        ((EditText) findViewById(R.id.et)).setError("hehe");

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent: action_down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "onTouchEvent: action_move");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "onTouchEvent: action_up");
                break;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "dispatchTouchEvent: ");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i(TAG, "onWindowFocusChanged: vv width = " + vv.getWidth() + " vv height = " + vv.getHeight());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: vv width = " + vv.getWidth() + " vv height = " + vv.getHeight());
        Log.i(TAG, "onStart: ");
        Uri uri = Uri.parse("content://com.fnz.provider");
        getContentResolver().query(uri, null, null, null, null, null);

    }

    ServerLinstener sl = null;
    ServiceConnection sc = new ServiceConnection() {
        final Intent ii = intent;

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(TAG, "onServiceConnected: ");
            sl = ServerLinstener.Stub.asInterface(iBinder);
            try {
                sl.asBinder().linkToDeath(new IBinder.DeathRecipient() {

                    @Override
                    public void binderDied() {
                        Log.i(TAG, "binderDied: " + Thread.currentThread());
                        bindService(ii, sc, Context.BIND_AUTO_CREATE);
                    }
                }, 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(TAG, "onServiceDisconnected: " + Thread.currentThread());

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: vv width = " + vv.getWidth() + " vv height = " + vv.getHeight());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: vv width = " + vv.getWidth() + " vv height = " + vv.getHeight());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(sc);
    }
}

