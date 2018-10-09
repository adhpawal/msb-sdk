package com.lftechnology.vtn.api;

import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.response.ManualTransactionResponse;
import com.lftechnology.vtn.enums.ResponseCode;
import com.lftechnology.vtn.exception.VtnException;
import com.lftechnology.vtn.service.ManualUpdateService;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * @author Shankar Ghimire < shankarghimire@lftechnology.com >
 */

public class ManualUpdateApi {
    private RequestApi requestApi;

    public ManualUpdateApi(Credential credential) {

        this.requestApi = new RequestApi(credential);

    }

    /**
     * This method will get the update status of cancelled transaction
     *
     * @param transactionId transaction id as input
     * @return ManualTransactionResponse which have detailed of canceled transaction
     */
    public ManualTransactionResponse getUpdateStatus(String transactionId) {

        Retrofit retrofit = this.requestApi.getRetrofitObject();
        ManualUpdateService service = retrofit.create(ManualUpdateService.class);
        Call<ManualTransactionResponse> call = service.getUpdateStatus(transactionId);
        ManualTransactionResponse manualTransactionResponse = requestApi.executeApiCall(call);
        if (ResponseCode.getResponseByCode(manualTransactionResponse.getCode()) == null)
            throw new VtnException(manualTransactionResponse.getMessage(), manualTransactionResponse.getCode());
        return manualTransactionResponse;
    }

}



