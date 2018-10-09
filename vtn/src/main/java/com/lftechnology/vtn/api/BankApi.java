package com.lftechnology.vtn.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lftechnology.vtn.dto.request.BankRequest;
import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.response.BankResponse;
import com.lftechnology.vtn.enums.ResponseCode;
import com.lftechnology.vtn.exception.VtnException;
import com.lftechnology.vtn.service.BankApiService;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.Map;

/**
 * Bank related Api request are handle by this class
 *
 * @author Shankar Ghimire < shankarghimire@lftechnology.com >
 */

public class BankApi {

    private RequestApi requestApi;

    public BankApi(Credential credential) {
        this.requestApi = new RequestApi(credential);
    }

    /**
     * verifyBank will call Api to verify Bank  and if sucess return BankResponse object
     *
     * @param bankRequest :@see BankRequest
     * @return BankResponse object it return if ResponseCode is R00
     */
    public BankResponse verifyBank(BankRequest bankRequest) {

        Retrofit retrofit = this.requestApi.getRetrofitObject();
        BankApiService service = retrofit.create(BankApiService.class);
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, String> map = oMapper.convertValue(bankRequest, Map.class);
        Call<BankResponse> call = service.verifyBank(map);
        BankResponse bankResponse = requestApi.executeApiCall(call);
        if (ResponseCode.getResponseByCode(bankResponse.getCode()) == null)
            throw new VtnException(bankResponse.getMessage(), bankResponse.getCode());
        return bankResponse;
    }


}
