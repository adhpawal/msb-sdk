package com.lftechnology.moneytun.outbound.service;


import com.lftechnology.moneytun.outbound.dto.OutboundResponse;
import com.lftechnology.moneytun.outbound.dto.Transaction;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface OutboundResource {

    @GET("token")
    Call<OutboundResponse> getToken(@Query("id") String id);

    @GET("transaction")
    Call<List<Transaction>> getUnpaidTransactionList(@Query("method_name") String methodName, @Query("TransferNo") String transferNo, @Query("payeecode") String payeeCode);

    @GET("transaction")
    Call<OutboundResponse> conformTransaction(@Query("method_name") String methodName, @Query("TransferNo") String transferNo, @Query("payeecode") String payeeCode);

}