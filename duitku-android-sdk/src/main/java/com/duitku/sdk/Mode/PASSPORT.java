package com.duitku.sdk.Mode;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

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


        if(url.contains(duitkuKit.getReturnUrl()) || url.equals("") || url == ""   ) {

            //wait(500);
            ((DuitkuTransaction)(context)).closeProgreesLoading();
            webView.stopLoading();


            if (!url.equals("")){

                DuitkuClient duitkuClient = new DuitkuClient();

                if (callbackKit.isRedirectOnBack()) {

                    if (url.contains("resultCode=01")){

                        ((DuitkuTransaction)(context)).isCheckTransactionDOne = true ;
                        duitkuClient.code = "01";
                        duitkuClient.amount= ""+duitkuKit.getPaymentAmount();
                        duitkuClient.reference = reference;
                        duitkuClient.status = "Pending" ;


                    }else if (url.contains("resultCode=02")){

                        ((DuitkuTransaction)(context)).isCheckTransactionDOne = true ;
                        duitkuClient.code = "01";
                        duitkuClient.amount= ""+duitkuKit.getPaymentAmount();
                        duitkuClient.reference = reference;
                        duitkuClient.status = "Pending" ;

                    }else{

                        ((DuitkuTransaction)(context)).isCheckTransactionDOne = true ;
                        duitkuClient.code = "404"; //code forfinish
                        duitkuClient.amount= "";
                        duitkuClient.reference = "";
                        duitkuClient.status = "" ;

                    }

                    ((DuitkuTransaction)(context)).finish();
                    localPrefManagerDuitku.createURLTRX("");



                }else{

                    if (url.contains("resultCode=00")){

                        ((DuitkuTransaction)(context)).isCheckTransactionDOne = true ;
                        duitkuClient.code = "404"; //code forfinish
                        duitkuClient.amount= "";
                        duitkuClient.reference = "";
                        duitkuClient.status = "" ;

                        ((DuitkuTransaction)(context)).finish();
                        localPrefManagerDuitku.createURLTRX("");


                    }else{

                        ((DuitkuTransaction)(context)).finish();
                        localPrefManagerDuitku.createURLTRX("");

                    }





                }



            }else{

                ((DuitkuTransaction)(context)).finish();
                localPrefManagerDuitku.createURLTRX("");

            }




        }
        //except url webview //open in browser
        else if(url.equals("https://www.duitku.com/en/") || url.equals("www.duitku.com")|| url.equals("https://www.duitku.com")){
            webView.stopLoading();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
        }else if(url.equals("https://new.permatanet.com/") || url.equals("https://new.permatanet.com")|| url.equals("https://new.permatanet.com/permatanet/retail/logon")){
            webView.stopLoading();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(browserIntent);
        }else if(url.contains("shopee.co.id")|| url.contains("airpay.co.id") ){
            webView.stopLoading();
            try
            {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browserIntent);
                ((DuitkuTransaction)(context)).finish();
                localPrefManagerDuitku.createURLTRX("");
            }
            catch (Exception e)
            {
                // TODO: handle exception
                Toast.makeText(context,"Try Again",Toast.LENGTH_LONG).show();
                ((DuitkuTransaction)(context)).finish();
            }


        }
        else if(url.contains("linkaja.id") ){
            webView.stopLoading();

            try
            {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browserIntent);
                //((DuitkuTransaction)(context)).finish();
            }
            catch (Exception e)
            {
                // TODO: handle exception
                Toast.makeText(context,"Please, Download App",Toast.LENGTH_LONG).show();
            }


        }else if(url.contains("linkaja") ){

            //IF linkajaQRIS still on page | if else url intent
            if (url.contains("Qris")){

            }else{
                webView.stopLoading();
                try
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(browserIntent);

                }
                catch (Exception e)
                {
                    // TODO: handle exception
                    Toast.makeText(context,"Try Again",Toast.LENGTH_LONG).show();
                }

            }


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

                //if contain return url
                if(url.contains(duitkuKit.getReturnUrl()) || url.equals("") || url == ""   ) {
                    //wait(500);
                    ((DuitkuTransaction)(context)).closeProgreesLoading();

                    webView.stopLoading();
                    ((DuitkuTransaction)(context)).finish();
                    localPrefManagerDuitku.createURLTRX("");
                }

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
