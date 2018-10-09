package com.lftechnology.vtn.api;

import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.response.TransactionListResponse;
import com.lftechnology.vtn.enums.ResponseCode;
import com.lftechnology.vtn.exception.VtnException;
import com.lftechnology.vtn.service.TransactionListApiService;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * @author Shankar Ghimire < shankarghimire@lftechnology.com >
 */

public class TransactionListApi {

    private RequestApi requestApi;

    public TransactionListApi(Credential credential) {
        this.requestApi = new RequestApi(credential);
    }

    /**
     * This method will list out all the transaction details
     *
     * @param transactionId it will take transactionId string as input
     * @return list of multiple transaction with details
     */
    public TransactionListResponse retrieveTransaction(String transactionId) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionListApiService service = retrofit.create(TransactionListApiService.class);

        Call<TransactionListResponse> call = service.getTransaction(transactionId);
        TransactionListResponse transactionListResponseDTO = requestApi.executeApiCall(call);
        if (ResponseCode.getResponseByCode(transactionListResponseDTO.getCode()) == null)
            throw new VtnException(transactionListResponseDTO.getMessage(), transactionListResponseDTO.getCode());
        return transactionListResponseDTO;
    }


}
