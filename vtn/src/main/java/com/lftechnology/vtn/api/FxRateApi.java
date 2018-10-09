package com.lftechnology.vtn.api;

import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.response.FxRateResponse;
import com.lftechnology.vtn.enums.ResponseCode;
import com.lftechnology.vtn.exception.VtnException;
import com.lftechnology.vtn.service.FxRateApiService;
import retrofit2.Call;
import retrofit2.Retrofit;


/**
 * Foreign Exchange Rate related api
 *
 * @author Shankar Ghimire < shankarghimire@lftechnology.com >
 */

public class FxRateApi {

    private RequestApi requestApi;

    public FxRateApi(Credential credential) {

        this.requestApi = new RequestApi(credential);
    }

    /**
     * This method is used to get foreign exchange rate like selling rate and buying rate
     *
     * @param currencyCode : string currency code (e.g USD)
     * @return FxRateResponse which gives foreign exchange rates
     */
    public FxRateResponse getRate(String currencyCode) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        FxRateApiService service = retrofit.create(FxRateApiService.class);
        Call<FxRateResponse> call = service.getRate(currencyCode);
        FxRateResponse fxRateResponse = requestApi.executeApiCall(call);
        if (ResponseCode.getResponseByCode(fxRateResponse.getCode()) == null)
            throw new VtnException(fxRateResponse.getMessage(), fxRateResponse.getCode());
        return fxRateResponse;


    }


}
