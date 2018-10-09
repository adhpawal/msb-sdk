package com.lftechnology.vtn.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.request.TransactionRequest;
import com.lftechnology.vtn.dto.response.TransactionResponse;
import com.lftechnology.vtn.enums.ResponseCode;
import com.lftechnology.vtn.exception.VtnException;
import com.lftechnology.vtn.service.TransactionApiService;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.Map;

/**
 * TransactionApi is used to call Transaction related method
 *
 * @author Shankar Ghimire < shankarghimire@lftechnology.com >
 */
public class TransactionApi {
    private RequestApi requestApi;

    public TransactionApi(Credential credential) {
        this.requestApi = new RequestApi(credential);
    }

    /**
     * This method will call vtn api for transaction
     *
     * @param transactionRequest @see TransactionRequest
     * @return transactionResponse object if success which contains all the details of successful transaction
     */

    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        TransactionApiService service = retrofit.create(TransactionApiService.class);
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, String> map = oMapper.convertValue(transactionRequest, Map.class);
        Call<TransactionResponse> call = service.createTransaction(map);
        TransactionResponse transactionResponseDTO = requestApi.executeApiCall(call);
        if (ResponseCode.getResponseByCode(transactionResponseDTO.getCode()) == null)
            throw new VtnException(ResponseCode.getResponseByCode(transactionResponseDTO.getCode()), transactionResponseDTO.getCode());
        return transactionResponseDTO;
    }
}
