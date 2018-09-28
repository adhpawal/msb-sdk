package com.lftechnology.vtn.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lftechnology.vtn.constant.CommonConstant;
import com.lftechnology.vtn.dto.request.TransactionRequest;
import com.lftechnology.vtn.exception.VtnException;
import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.response.TransactionResponse;
import com.lftechnology.vtn.service.TransactionApiService;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.Map;

public class TransactionApi {
    private RequestApi requestApi;

    public TransactionApi(Credential credential) {
        this.requestApi = new RequestApi(credential);
    }

    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionApiService service = retrofit.create(TransactionApiService.class);


        ObjectMapper oMapper = new ObjectMapper();
        Map<String, String> map = oMapper.convertValue(transactionRequest, Map.class);



        Call<TransactionResponse> call = service.createTransaction(map);
        TransactionResponse transactionResponseDTO = requestApi.executeApiCall(call);

        if (!transactionResponseDTO.getCode().equals(CommonConstant.SUCCESS))
            throw new VtnException(transactionResponseDTO.getMessage(), transactionResponseDTO.getCode());
        return transactionResponseDTO;

    }


}