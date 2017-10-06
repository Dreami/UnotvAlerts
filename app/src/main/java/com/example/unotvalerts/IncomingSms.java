package com.example.unotvalerts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class IncomingSms extends BroadcastReceiver {
    String number;
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getExtras() != null) {
            final Bundle bundle = intent.getExtras();
            try {
                if (bundle != null) {
                    final Object[] pdusObj = (Object[]) bundle.get("pdus");
                    for (int i = 0; i < pdusObj.length; i++) {

                        SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                        number = currentMessage.getDisplayOriginatingAddress();
                        Log.i("SmsReceiver", number);
                        Toast toast = Toast.makeText(context,
                                "Oh si, un msg de " + number, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    Intent phoneIntent = new Intent(context, MainActivity.class);
                    phoneIntent.putExtra("number", number);
                    phoneIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(phoneIntent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
