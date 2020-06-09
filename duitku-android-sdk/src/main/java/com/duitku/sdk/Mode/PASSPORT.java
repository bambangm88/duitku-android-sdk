package com.duitku.sdk.Mode;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;

import com.duitku.sdk.PrefManagerDuitku.LocalPrefManagerDuitku;
import com.duitku.sdk.R;
import com.duitku.sdk.DuitkuCallback.DuitkuCallbackTransaction;
import com.duitku.sdk.DuitkuTransaction;
import com.duitku.sdk.DuitkuUtility.DuitkuKit;
import com.duitku.sdk.DuitkuClient;

public class PASSPORT {

    public void runPasport(WebView webView, Context context, DuitkuKit duitkuKit, String url , String reference , LocalPrefManagerDuitku localPrefManagerDuitku){
        if (url.toLowerCase().contains(duitkuKit.getReturnUrl())){
            ((DuitkuTransaction)(context)).closeProgreesLoading();
        }else {
            ((DuitkuTransaction) (context)).displayProgreesLoading();
        }
        DuitkuCallbackTransaction callbackKit = new DuitkuCallbackTransaction();

        //except url webview //open in browser
        if(url.equals("https://www.duitku.com/en/") || url.equals("www.duitku.com")|| url.equals("https://www.duitku.com")){
            webView.stopLoading();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
        }else if(url.equals("https://new.permatanet.com/") || url.equals("https://new.permatanet.com")|| url.equals("https://new.permatanet.com/permatanet/retail/logon")){
            webView.stopLoading();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
        }else if(url.contains("shopee.co.id")|| url.contains("airpay.co.id") ){
            webView.stopLoading();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
            ((DuitkuTransaction)(context)).finish();
        }
        else if(url.contains("linkaja.id") ){
            webView.stopLoading();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
            ((DuitkuTransaction)(context)).finish();
        }else if(url.contains("linkaja") ){
            webView.stopLoading();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
        }else{
                    //CC
                    if(url.contains("TopUp") && url.contains("Notification") )  {
                        //if information from merchant
                        if(callbackKit.isCallbackFromMerchant()){
                            ((DuitkuTransaction)(context)).displayProgreesLoading();
                            //solve double reload check transaction
                            if(((DuitkuTransaction)(context)).num == 0){
                                ((DuitkuTransaction)(context)).isCheckTransactionDOne = true ;
                                ((DuitkuTransaction)(context)).checkTransaction(reference);
                                ((DuitkuTransaction)(context)).num = ((DuitkuTransaction)(context)).num+1;
                            }

                        }

                        if(callbackKit.isCallbackFromMerchant() && ((DuitkuTransaction)(context)).num > 0) {
                            ((DuitkuTransaction)(context)).displayProgreesLoading();
                        }
                        else{
                            DuitkuClient.topUpNotif = "TopUp";

                            ((DuitkuTransaction)(context)).closeProgreesLoading();
                            ((DuitkuTransaction)(context)).closeToolbar();

                        }

                    }

                    if(url.contains(context.getString(R.string.passport)) ) {


                    }else if(url.contains("TopUpOVO")) {

                    }else if(url.contains(duitkuKit.getReturnUrl()) || url.equals("") || url == ""   ) {
                        //wait(500);
                        ((DuitkuTransaction)(context)).closeProgreesLoading();

                        webView.stopLoading();
                        ((DuitkuTransaction)(context)).finish();
                        localPrefManagerDuitku.createURLTRX("");
                    }
                    else {
                        if (url.contains(duitkuKit.getReturnUrl())){
                            ((DuitkuTransaction)(context)).closeProgreesLoading();
                        }else {
                            ((DuitkuTransaction) (context)).displayProgreesLoading();
                        }
                    }

        }
    }
}
