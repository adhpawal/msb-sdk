package com.lftechnology.vtn.api;


import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.response.BalanceResponse;
import com.lftechnology.vtn.enums.ResponseCode;
import com.lftechnology.vtn.exception.VtnException;
import com.lftechnology.vtn.service.BalanceApiService;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Balance related Api request are handle by this class
 *
 * @author Shankar Ghimire < shankarghimire@lftechnology.com >
 */

public class BalanceApi {

    private RequestApi requestApi;

    public BalanceApi(Credential credential) {
        this.requestApi = new RequestApi(credential);
    }

    /**
     * This method is used to get Balance status from API
     *
     * @return BalanceResponceDTO : return only if there response code is R00
     */
    public BalanceResponse getBalance() {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        BalanceApiService service = retrofit.create(BalanceApiService.class);
        Call<BalanceResponse> call = service.getBalance();
        BalanceResponse balanceResponse = requestApi.executeApiCall(call);
        if (ResponseCode.getResponseByCode(balanceResponse.getCode()) == null)
            throw new VtnException(balanceResponse.getMessage(), balanceResponse.getCode());
        return balanceResponse;
    }

}
