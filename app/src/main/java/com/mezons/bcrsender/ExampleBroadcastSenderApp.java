package com.mezons.bcrsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ExampleBroadcastSenderApp extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context,"EBR triggered",Toast.LENGTH_SHORT).show();
        int resultCode=getResultCode();
        String resultData=getResultData();
        Bundle resultExtras=getResultExtras(true);
        String stringExtra=resultExtras.getString("stringExtra");
        resultCode++;
        stringExtra+="->senderApp";
        String toastText="senderApp\n"+ "resultCode: "+resultCode+"\n"+
                "resultData:"+resultData+"\n" +
                "stringExtra: "+stringExtra;
        Toast.makeText(context,toastText,Toast.LENGTH_LONG).show();
        Log.d("orb",toastText);
        resultData="senderApp";
        resultExtras.putString("stringExtra",stringExtra);
        setResult(resultCode,resultData,resultExtras);
    }
}
