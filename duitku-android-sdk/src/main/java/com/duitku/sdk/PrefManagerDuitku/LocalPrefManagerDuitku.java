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
    private SharedPreferences pref;
    // Editor for Shared preferences
    private SharedPreferences.Editor setPref;

    // Context
    private Context _context;

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


    private static final String TAG_PAYMENT_AMOUNT = "0"   ;
    private static final  String  TAG_PAYMENT_METHOD = "paymentMethodX_" ;
    private static final String  TAG_PRODUCT_DETAILS = "productDetailX_" ;
    private static final String  TAG_ADDITIONAL_PARAM = "additionalParamX_";
    private static  final String  TAG_MERCHANT_USER_INFO = "merchantUserInfoX_";
    private static final String  TAG_PHONE_NUMBER = "phoneNumberX_" ;
    private static  final String  TAG_CUSTOMER_VA_NAME = "customerVaNameX_";
    private static  final String  TAG_CALLBACK_URL = "callbackUrlX_";
    private static final String  TAG_RETURN_URL= "returnUrlX_";
    private static final String  TAG_EXPIRE_PERIOD = "expirePeriodX_";
    private static final String  TAG_TITLE_PAYMENT = "titlePaymentX_";
    private static final String  TAG_MODE_PAYMENT = "modePaymentX_";
    private static final String  TAG_EMAIL = "emailX_";
    private static final String  TAG_FIRSTNAME = "firstNameX_";
    private static final String  TAG_LASTNAME = "lastNameX_";
    private static final String  TAG_ADDRESS = "addressX_";
    private static  final String  TAG_CITY = "cityX_";
    private static final String  TAG_POSTAL_CODE = "postalCodeX_";
    private static final String  TAG_PHONE = "phoneX_";
    private static final String  TAG_COUNTRY_CODE = "countryCodeX_";

    private static final String TAG_BASE_URL_API_DUITKU = "baseUrlApiX_";
    private static final String TAG_URL_REQUEST_TRANSACTION = "requestTrxX_";
    private static final String TAG_URL_CHECK_TRANSACTION = "checkTrxX_";
    private static final String TAG_URL_LIST_PAYMENT = "listPaymentX_";

    private static final String TAG_LIST_TRX = "listPaymentTRX_";



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

    public void createListTRX( String text){

        setPref.putString(TAG_LIST_TRX,text);
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

    public String getTagListTrx() {

        return pref.getString(TAG_LIST_TRX, "");
    }




    public String getTagPaymentAmount() {

        return pref.getString(TAG_PAYMENT_AMOUNT, "");
    }

    public String getTagPaymentMethod() {

        return pref.getString(TAG_PAYMENT_METHOD, "");
    }
    public String getTagProductDetails() {

        return pref.getString(TAG_PRODUCT_DETAILS, "");
    }

    public String getTagAdditionalParam() {

        return pref.getString(TAG_ADDITIONAL_PARAM, "");
    }

    public String getTagMerchantUserInfo() {

        return pref.getString(TAG_MERCHANT_USER_INFO, "");
    }
    public String getTagPhoneNumber() {

        return pref.getString(TAG_PHONE_NUMBER, "");
    }

    public String getTagCustomerVaName() {

        return pref.getString(TAG_CUSTOMER_VA_NAME, "");
    }

    public String getTagCallbackUrl() {

        return pref.getString(TAG_CALLBACK_URL, "");
    }
    public String getTagReturnUrl() {

        return pref.getString(TAG_RETURN_URL, "");
    }

    public String getTagExpirePeriod() {

        return pref.getString(TAG_EXPIRE_PERIOD, "");
    }
    public String getTagTitlePayment() {

        return pref.getString(TAG_TITLE_PAYMENT, "");
    }

    public String getTagModePayment() {

        return pref.getString(TAG_MODE_PAYMENT, "");
    }

    public String getTagEmail() {

        return pref.getString(TAG_EMAIL, "");
    }

    public String getTagFirstname() {

        return pref.getString(TAG_FIRSTNAME, "");
    }

    public String getTagLastname() {

        return pref.getString(TAG_LASTNAME, "");
    }

    public String getTagAddress() {

        return pref.getString(TAG_ADDRESS, "");
    }

    public String getTagCity() {

        return pref.getString(TAG_CITY, "");
    }

    public String getTagPostalCode() {

        return pref.getString(TAG_POSTAL_CODE, "");
    }
    public String getTagPhone() {

        return pref.getString(TAG_PHONE, "");
    }

    public String getTagCountryCode() {

        return pref.getString(TAG_COUNTRY_CODE, "");
    }

    public String getTagBaseUrlApiDuitku(){

        return pref.getString(TAG_BASE_URL_API_DUITKU, "");
    }

    public String getTagUrlRequestTransaction(){

        return pref.getString(TAG_URL_REQUEST_TRANSACTION, "");
    }


    public String getTagUrlListPayment(){

        return pref.getString(TAG_URL_LIST_PAYMENT, "");
    }

    public String getTagUrlCheckTransaction(){

        return pref.getString(TAG_URL_CHECK_TRANSACTION, "");
    }
























    public void onfinish(){
        // Clearing all data from Shared Preferences
        setPref.clear();
        setPref.commit();
    }

    public boolean isTransaction(){
        return pref.getBoolean(TAG_TRANSACTION, false);
    }




    public void setTrxResume(DuitkuKit duitku , LocalPrefManagerDuitku localPrefManagerDuitku){

        BaseKitDuitku.setBaseUrlApiDuitku(getTagBaseUrlApiDuitku());
        BaseKitDuitku.setUrlRequestTransaction(getTagUrlRequestTransaction());
        BaseKitDuitku.setUrlCheckTransaction(getTagUrlCheckTransaction());
        BaseKitDuitku.setUrlListPayment(getTagUrlListPayment());

        duitku.setProductDetails(getTagProductDetails());
        duitku.setEmail(getTagEmail());
        duitku.setPhoneNumber(getTagPhoneNumber());
        duitku.setAdditionalParam(getTagAdditionalParam());
        duitku.setMerchantUserInfo(getTagMerchantUserInfo());
        duitku.setCustomerVaName(getTagCustomerVaName());
        duitku.setExpiryPeriod(getTagExpirePeriod());
        duitku.setCallbackUrl(getTagCallbackUrl());
        duitku.setReturnUrl(getTagReturnUrl());


        duitku.setFirstName(getTagFirstname());
        duitku.setLastName(getTagLastname());
        duitku.setAddress(getTagAddress());
        duitku.setCity(getTagCity());
        duitku.setPostalCode(getTagPostalCode());
        duitku.setCountryCode(getTagCountryCode());
        //duitku.setItemDetails(arrayList);
        duitku.setPaymentAmount(Integer.parseInt(getTagPaymentAmount()));

    }






}
