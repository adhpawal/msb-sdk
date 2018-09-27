package com.lftechnology.vtn.sdk.api;

import com.lftechnology.vtn.sdk.dto.Request.Credentials;
import com.lftechnology.vtn.sdk.dto.Request.TransactionListRequestDTO;
import com.lftechnology.vtn.sdk.dto.Response.TransactionListResponseDTO;
import com.lftechnology.vtn.sdk.exception.ApiException;
import com.lftechnology.vtn.sdk.services.TransactionListApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class TransactionListApi {

    private RequestApi requestApi;

    public TransactionListApi(){
        this.requestApi = new RequestApi();
    }

    public TransactionListResponseDTO retrieveTransaction(Credentials credentials, TransactionListRequestDTO transactionListRequestDTO) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionListApiService service = retrofit.create(TransactionListApiService.class);
        Call<TransactionListResponseDTO> call = service.retrieveTransaction(credentials.getAccessToken(),credentials.getAccessKey(),
                transactionListRequestDTO.getTransactionId() );
        TransactionListResponseDTO transactionListResponseDTO = executeApiCall(call);


        return  transactionListResponseDTO;

    }



    private TransactionListResponseDTO executeApiCall(Call<TransactionListResponseDTO> call) {
        try {
            Response<TransactionListResponseDTO> response = call.execute();

            if (!response.isSuccessful()) {
                throw new ApiException(response.errorBody().string());
            }

            return response.body();
        } catch (IOException e) {
            throw new ApiException();
        }
    }
}
