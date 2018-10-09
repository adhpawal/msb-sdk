package com.lftechnology.vtn.enums;

import java.util.HashMap;
import java.util.Map;

public enum ResponseCode {
    R00("R00","Success"),
    R01("R01","Both Sender Phone And Email Empty"),
    R02("R02","Invalid Sender Email Address"),
    R03("R03","Invalid Sender Phone Format"),
    R04("R04","Sender First Name Empty"),
    R05("R05","Sender Country Empty"),
    R06("R06","Both Receiver Phone And Email Empty"),
    R07("R07","Invalid Receiver Email Address"),
    R08("R08","Invalid Receiver Phone Format"),
    R09("R09","Receiver First Name Empty"),
    R10("R10","Receiver Country Empty"),
    R11("R11","Access Token Empty"),
    R12("R12","Access Key Empty"),
    R13("R13","Access Token And Access Key Mismatch"),
    R14("R14","Transaction Id Empty"),
    R15("R15","Currency Code Empty"),
    R16("R16","Amount in Sender Currency Empty"),
    R17("R17","Amount in Naira Empty"),
    R18("R18","Fee in Sender Currency Empty"),
    R19("R19","Fee in Naira Empty"),
    R20("R20","Transfer Date Empty"),
    R21("R21","Transfer Type Empty"),
    R22("R22","Bank Account Number Empty"),
    R23("R23","Bank Account Name Empty"),
    R24("R24","Bank Name Empty"),
    R25("R25","Invalid Bank Account"),
    R26("R26","Invalid IP Address"),
    R27("R27","Remittance Provider Inactive"),
    R28("R28","Insufficient Funds"),
    R29("R29","Invalid Sender Account"),
    R30("R30","Invalid Receiver Account"),
    R31("R31","Invalid Sender Account"),
    R32("R32","Invalid Receiver Account"),
    R33("R33","Invalid Request"),
    R34("R34","System Failure"),
    R35("R35","Server Time Out"),
    R36("R36","Invalid Bank Name"),
    R38("R38","Empty Data"),
    R39("R39","Amount in Naira less than required Minimum amount"),
    R40("R40","Fee in Naira less than required Minimum fee"),
    R41("R41","Invalid Transaction"),
    R42("R42","Bank Account Name' received from Bank/NIBSS does not match what you provided."),
    R43("R43","Transactions received with same ID within 60 seconds. Please try after 60 seconds"),
    R44("R44","You have exceeded your VTN limit for the day Please try again at 2 PM Nigeria time"),
    Z01("Z01","Bank Transfer Queued"),
    Z02("Z02","Bank Transfer Failed and the amount was returned back to Remittance Provider. Try again with another TransactionId"),
    Z03("Z03","Bank Transfer failed, but amount is held"),
    Z04("Z04","Refund Bank Reversal"),
    Z05("Z05","Refund Manually"),
    Z06("Z06","This is a low KYC Account.Amount exceed limit allowed"),
    Z07("Z07","VTN NIBSS transfer limit exceeded"),

    T03("03","Invalid Sender"),
    T06("06" , "Dormant Account"),
    T07("07","Invalid Account"),
    T08("08","Account Name Mismatch"),
    T09("09","Request processing in progress"),
    T12("12","Invalid transaction"),
    T14("14","Invalid Batch Number"),
    T15("15","Invalid Session or Record ID"),
    T16("16","Unknown Bank Code"),
    T17("17","Invalid Channel"),
    T18("18","Wrong Method Call"),
    T21("21","No action taken"),
    T25("25","Unable to locate record"),
    T26("26","Duplicate record"),
    T30("30","Format error"),
    T34("34","Suspected fraud"),
    T35("35","Contact sending bank"),
    T57("57","Transaction not permitted to sender"),
    T58("58","Transaction not permitted on channel"),
    T63("63","Security violation"),
    T65("65","Exceeds withdrawal frequency"),
    T68("68","Response received too late"),
    T91("91","Beneficiary Bank not available"),
    T92("92","Routing error"),
    T94("94","Duplicate transaction"),
    T96("96","System malfunction"),
    T97("97","Timeout waiting for response from destination");


    private String message;
    private String code;
    private static  Map<String, String> responseCode;

    private ResponseCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public static String getResponseByCode(String code) {
        if (responseCode == null) {
            initializeMapping();
        }
        if (responseCode.containsKey(code)) {
            return responseCode.get(code);
        }
        return null;
    }

    private static void initializeMapping() {
        responseCode = new HashMap<String, String>();
        for (ResponseCode s : ResponseCode.values()) {
            responseCode.put(s.code, s.message);
        }
    }




}
