package com.lftechnology.vtn.api;

import com.lftechnology.vtn.dto.request.Credential;
import com.lftechnology.vtn.dto.response.BalanceResponse;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BalanceApiTest {

    Credential credential = new Credential("invalid", "invalid");

    @Test
    public void getBalance() {
        //Given
        BalanceApi balanceApi = new BalanceApi(credential);

        //When
        BalanceResponse balanceQueryDTO = balanceApi.getBalance();

        //Then
        assertNotNull(balanceQueryDTO);

    }


}