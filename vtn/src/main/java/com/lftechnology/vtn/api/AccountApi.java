package com.lftechnology.vtn.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lftechnology.vtn.dto.request.AccountStatusRequest;
import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.response.AccountStatusResponse;
import com.lftechnology.vtn.enums.ResponseCode;
import com.lftechnology.vtn.exception.VtnException;
import com.lftechnology.vtn.service.AccountApiService;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.Map;

/**
 * AccountApi is used to call account related method
 *
 * @author Shankar Ghimire < shankarghimire@lftechnology.com >
 */
public class AccountApi {

    private RequestApi requestApi;

    public AccountApi(Credential credential) {

        this.requestApi = new RequestApi(credential);
    }

    /**
     * This method will call api using requestApi object and  if sucucess return AccountStatusResponse and on failure it will throw an error
     *
     * @param account :@see AccountStatusRequest
     * @return AccountStatusResponse : return if accountStatsusResponseDto code is R00
     */
    public AccountStatusResponse getAccount(AccountStatusRequest account) {
        Retrofit retrofit = this.requestApi.getRetrofitObject();
        AccountApiService service = retrofit.create(AccountApiService.class);

        ObjectMapper oMapper = new ObjectMapper();
        Map<String, String> map = oMapper.convertValue(account, Map.class);
        Call<AccountStatusResponse> call = service.getAccount(map);
        AccountStatusResponse accountStatusResponse = requestApi.executeApiCall(call);
        if (ResponseCode.getResponseByCode(accountStatusResponse.getCode()) == null)
            throw new VtnException(accountStatusResponse.getMessage(), accountStatusResponse.getCode());
        return accountStatusResponse;
    }

}
