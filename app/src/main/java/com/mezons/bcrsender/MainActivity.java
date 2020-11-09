package com.mezons.bcrsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            textView.setText(intent.getStringExtra("com.ba.MY_ACTION_EXTRATXT"));
        }
    };
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.sendBut);
        textView=findViewById(R.id.sendTxt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent =new Intent("com.ba.MY_ACTION");
                intent.putExtra("com.ba.MY_ACTION_EXTRATXT","Broadcasr Recived");
                sendBroadcast(intent);
                Intent intent=new Intent();
                ComponentName componentName=new ComponentName("com.mezons.broadcast","com.mezons.broadcast.ExampleBroadCast");
                intent.setComponent(componentName);
                sendBroadcast(intent);
                Intent intent =new Intent("com.ba.MY_ACTION");
                PackageManager packageManager=getPackageManager();
                List<ResolveInfo>infos=packageManager.queryBroadcastReceivers(intent,0);
                for(ResolveInfo info:infos){
                    ComponentName componentName=new ComponentName(info.activityInfo.packageName,info.activityInfo.name);
                    intent.setComponent(componentName);
                    intent.putExtra("com.ba.MY_ACTION_EXTRATXT","Broadcasr Recived");
                    sendBroadcast(intent);
                }*/
                Intent intent=new Intent("com.ba.MY_ACTION");
                intent.setPackage("com.mezons.broadcast");
                
                Bundle extras=new Bundle();
                extras.putString("stringExtra","start");
                sendOrderedBroadcast(intent,null,new ExampleBroadcastSenderApp(),null,0,"Start",extras);
            }
        });
    }

   /* @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter("com.ba.MY_ACTION");
        registerReceiver(broadcastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }*/
}
