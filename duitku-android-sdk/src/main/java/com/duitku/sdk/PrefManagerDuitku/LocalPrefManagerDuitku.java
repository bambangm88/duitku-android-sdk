package com.duitku.sdk.PrefManagerDuitku;

import android.content.Context;
import android.content.SharedPreferences;

import com.duitku.sdk.DuitkuUtility.BaseKitDuitku;
import com.duitku.sdk.DuitkuUtility.DuitkuKit;
import com.duitku.sdk.Model.ItemDetails;

import java.util.ArrayList;
import java.util.Set;


public class LocalPrefManagerDuitku {

    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor setPref;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "paymentSDK_";

    private static final String TAG_TRANSACTION = "N";
    // All Shared Preferences Keys
    private static final String TAG_STATUS = "statusMessage_";
    private static final String TAG_REFERENCE = "reference_";
    private static final String TAG_AMOUNT = "amount_";
    private static final String TAG_CODE = "statusCode_";
    private static final String TAG_TOTAL = "total_";
    private static final String TAG_URL = "urlX_";


    private static  String TAG_PAYMENT_AMOUNT = "0"   ;
    private static  String  TAG_PAYMENT_METHOD = "paymentMethodX_" ;
    private static String  TAG_PRODUCT_DETAILS = "productDetailX_" ;
    private static String  TAG_ADDITIONAL_PARAM = "additionalParamX_";
    private static  String  TAG_MERCHANT_USER_INFO = "merchantUserInfoX_";
    private static String  TAG_PHONE_NUMBER = "phoneNumberX_" ;
    private static  String  TAG_CUSTOMER_VA_NAME = "customerVaNameX_";
    private static  String  TAG_CALLBACK_URL = "callbackUrlX_";
    private static  String  TAG_RETURN_URL= "returnUrlX_";
    private static  String  TAG_EXPIRE_PERIOD = "expirePeriodX_";
    private static String  TAG_TITLE_PAYMENT = "titlePaymentX_";
    private static String  TAG_MODE_PAYMENT = "modePaymentX_";
    private static String  TAG_EMAIL = "emailX_";
    private static String  TAG_FIRSTNAME = "firstNameX_";
    private static String  TAG_LASTNAME = "lastNameX_";
    private static String  TAG_ADDRESS = "addressX_";
    private static String  TAG_CITY = "cityX_";
    private static String  TAG_POSTAL_CODE = "postalCodeX_";
    private static String  TAG_PHONE = "phoneX_";
    private static String  TAG_COUNTRY_CODE = "countryCodeX_";

    private static String TAG_BASE_URL_API_DUITKU = "baseUrlApiX_";
    private static String TAG_URL_REQUEST_TRANSACTION = "requestTrxX_";
    private static String TAG_URL_CHECK_TRANSACTION = "checkTrxX_";
    private static String TAG_URL_LIST_PAYMENT = "listPaymentX_";



    // Constructor
    public LocalPrefManagerDuitku(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        setPref = pref.edit();
    }


    public void createLocalDataTrx(int amount , String paymentMethod , String productdetail , String additionalParam , String merchantUserInfo , String phoneNumber,
                                   String customerVaName , String callbackUrl , String returnUrl , String expirePeriod , String titlePayment , String modePayment
                                    , String email , String firstName , String lastName , String address , String city
                                    , String postal_code , String phone , String countryCode , String baseUrl, String requestTrx , String checkTrx , String listPayment ){

        setPref.putInt(TAG_PAYMENT_AMOUNT, amount);
        setPref.putString(TAG_PAYMENT_METHOD, paymentMethod);
        setPref.putString(TAG_PRODUCT_DETAILS, productdetail);
        setPref.putString(TAG_ADDITIONAL_PARAM, additionalParam);
        setPref.putString(TAG_MERCHANT_USER_INFO, merchantUserInfo);
        setPref.putString(TAG_PHONE_NUMBER, phoneNumber);
        setPref.putString(TAG_CUSTOMER_VA_NAME, customerVaName);
        setPref.putString(TAG_CALLBACK_URL, callbackUrl);
        setPref.putString(TAG_RETURN_URL, returnUrl);
        setPref.putString(TAG_EXPIRE_PERIOD, expirePeriod);
        setPref.putString(TAG_TITLE_PAYMENT, titlePayment);
        setPref.putString(TAG_MODE_PAYMENT, modePayment);
        setPref.putString(TAG_EMAIL, email);
        setPref.putString(TAG_FIRSTNAME, firstName);
        setPref.putString(TAG_LASTNAME, lastName);
        setPref.putString(TAG_ADDRESS, address);
        setPref.putString(TAG_CITY, city);
        setPref.putString(TAG_POSTAL_CODE, postal_code);
        setPref.putString(TAG_PHONE, phone);
        setPref.putString(TAG_COUNTRY_CODE, countryCode);

        setPref.putString(TAG_BASE_URL_API_DUITKU, baseUrl);
        setPref.putString(TAG_URL_REQUEST_TRANSACTION, requestTrx);
        setPref.putString(TAG_URL_CHECK_TRANSACTION, checkTrx);
        setPref.putString(TAG_URL_LIST_PAYMENT, listPayment);


        setPref.commit();

    }

    public void createLocalData(String status,String reference, String amount, String Code){

        setPref.putBoolean(TAG_TRANSACTION, true);
        setPref.putString(TAG_STATUS, status);
        setPref.putString(TAG_REFERENCE, reference);
        setPref.putString(TAG_AMOUNT, amount);
        setPref.putString(TAG_CODE, Code);
        setPref.commit();

    }


    public void createTotal( String total ){

        setPref.putString(TAG_TOTAL, total);
        setPref.commit();

    }

    public void createURLTRX( String url){

        setPref.putString(TAG_URL, url);
        setPref.commit();

    }

    public String getTagTotalAmount() {

        return pref.getString(TAG_TOTAL, "");
    }



    public String getStatusMessage() {

        return pref.getString(TAG_STATUS, "");
    }

    public String getStatusCode() {

        return pref.getString(TAG_CODE, "");
    }

    public String getReference() {

        return pref.getString(TAG_REFERENCE, "");
    }

    public String getAmount() {

        return pref.getString(TAG_AMOUNT, "");
    }

    public String getTagUrlTRX() {

        return pref.getString(TAG_URL, "");
    }


    public void onfinish(){
        // Clearing all data from Shared Preferences
        setPref.clear();
        setPref.commit();
    }

    public boolean isTransaction(){
        return pref.getBoolean(TAG_TRANSACTION, false);
    }




    public void setTrxResume(DuitkuKit duitku){

        BaseKitDuitku.setBaseUrlApiDuitku(TAG_BASE_URL_API_DUITKU);
        BaseKitDuitku.setUrlRequestTransaction(TAG_URL_REQUEST_TRANSACTION);
        BaseKitDuitku.setUrlCheckTransaction(TAG_URL_CHECK_TRANSACTION);
        BaseKitDuitku.setUrlListPayment(TAG_URL_LIST_PAYMENT);

        duitku.setProductDetails(TAG_PRODUCT_DETAILS);
        duitku.setEmail(TAG_EMAIL);
        duitku.setPhoneNumber(TAG_PHONE_NUMBER);
        duitku.setAdditionalParam(TAG_ADDITIONAL_PARAM);
        duitku.setMerchantUserInfo(TAG_MERCHANT_USER_INFO);
        duitku.setCustomerVaName(TAG_CUSTOMER_VA_NAME);
        duitku.setExpiryPeriod(TAG_EXPIRE_PERIOD);
        duitku.setCallbackUrl(TAG_CALLBACK_URL);
        duitku.setReturnUrl(TAG_RETURN_URL);


        duitku.setFirstName(TAG_FIRSTNAME);
        duitku.setLastName(TAG_LASTNAME);
        duitku.setAddress(TAG_ADDRESS);
        duitku.setCity(TAG_CITY);
        duitku.setPostalCode(TAG_POSTAL_CODE);
        duitku.setCountryCode(TAG_COUNTRY_CODE);
        //duitku.setItemDetails(arrayList);
        duitku.setPaymentAmount(Integer.parseInt(TAG_PAYMENT_AMOUNT));

    }






}
