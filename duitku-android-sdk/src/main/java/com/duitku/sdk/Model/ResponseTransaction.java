package com.duitku.sdk.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ResponseTransaction {

    @SerializedName("reference")
    String reference;

    @SerializedName("paymentUrl")
    String paymentUrl;

    @SerializedName("statusMessage")
    String statusMessage;

    @SerializedName("paymentMethod")
    String paymentMethod;



    @SerializedName("merchantOrderId")
    String merchantOrderId;

    @SerializedName("paymentAmount")
    int paymentAmount;

    @SerializedName("productDetails")
    String productDetails;

    @SerializedName("email")
    String email;

    @SerializedName("phoneNumber")
    String phoneNumber;

    @SerializedName("additionalParam")
    String additionalParam;

    @SerializedName("merchantUserInfo")
    String merchantUserInfo;

    @SerializedName("customerVaName")
    String customerVaName;

    @SerializedName("callbackUrl")
    String callbackUrl;

    @SerializedName("returnUrl")
    String returnUrl;

    @SerializedName("expiryPeriod")
    String expiryPeriod;

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    private ArrayList<ItemDetails> itemDetails ;

    private CustomerDetails customerDetail ;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public ResponseTransaction(ArrayList<ItemDetails> itemDetails, int paymentAmount, String paymentMethod , String productDetails , String email , String phoneNumber , String additionalParam , String merchantUserInfo , String customerVaName , String callbackUrl , String returnUrl , String expiryPeriod , CustomerDetails customerDetails  , String merchantOrderId) {
        this.itemDetails = itemDetails;
        this.paymentAmount = paymentAmount;
        this.merchantOrderId = merchantOrderId;
        this.paymentMethod = paymentMethod;
        this.productDetails = productDetails;
        this.email = email;
        this.phoneNumber= phoneNumber;
        this.additionalParam = additionalParam;
        this.merchantUserInfo = merchantUserInfo;
        this.customerVaName = customerVaName;
        this.callbackUrl = callbackUrl;
        this.returnUrl= returnUrl;
        this.expiryPeriod= expiryPeriod;
        this.customerDetail= customerDetails;

    }




}
