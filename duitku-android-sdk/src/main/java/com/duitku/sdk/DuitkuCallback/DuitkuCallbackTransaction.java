package com.duitku.sdk.DuitkuCallback;

public class DuitkuCallbackTransaction {

    public static boolean CallbackFromMerchant = false ;

    public static boolean RedirectOnBack = false ;



    public boolean isCallbackFromMerchant() {
        return CallbackFromMerchant;
    }

    public void setCallbackFromMerchant(boolean infoFromMerchant) {
        this.CallbackFromMerchant = infoFromMerchant;
    }

    public boolean isRedirectOnBack() {
        return RedirectOnBack;
    }

    public void setRedirectOnBack(boolean redirectOnBack) {
        RedirectOnBack = redirectOnBack;
    }





}
