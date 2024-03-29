package com.example.sliit.ds.payment.connecter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.example.sliit.ds.entities.Payment;

public class PaymentConnecter {
	private static final String gatewayAuthenticationURL = "http://localhost:8081/spg/card/authenticate";

    // secondary method will be called.
    public boolean makePayment(Payment payment) throws IOException {
        switch (payment.getPaymentType()) {
            case "card":
                return makeCardPayment(payment.getPaymentDetails());

            case "bill":
                return makeDialogBillPayment(payment.getPaymentDetails());

            default:
                return false;
        }
    }

    public boolean makeCardPayment(Map<String, String> paymentDetails) throws IOException {
        // contact Samptha Payment Gateway.
        URL reqUrl = new URL(PaymentConnecter.gatewayAuthenticationURL);
        doPOST(reqUrl, paymentDetails);
        return true;
    }

    public boolean makeDialogBillPayment(Map<String, String> paymentDetails) {
        return false;
    }

    private String doPOST(URL requestUrl, Map<String, String> payload) throws IOException {
        String urlParams = "number=" + payload.get("number") + "&" +
                            "cvc=" + payload.get("cvc") + "&" +
                            "expiry" + payload.get("expiry");
        byte[] urlParamsAsPostData = urlParams.getBytes(StandardCharsets.UTF_8);
        HttpURLConnection connection = (HttpURLConnection)requestUrl.openConnection();

        connection.setRequestMethod("POST");
        // set headers.
        connection.setRequestProperty("User-Agent", "Java Client");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        // send request.
        try(DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
            out.write(urlParamsAsPostData);
        }

        // read response.
        String response = "";
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;

            while ( (line = in.readLine()) != null ) {
                response += line;
            }

            System.out.println(response);
        }
        finally {
            connection.disconnect();
        }

        return response;
    }
}
