package com.gudfeat.org.catalogweb.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/create-checkout-session")
public class CheckoutController {

    public static final String YOUR_DOMAIN = "http://localhost:8080";
    //public static Logger log =
    @PostMapping
    @ResponseBody
    public String checkout() throws StripeException {
        Stripe.apiKey = "sk_test_51N9felHWVeW84MwZ7QiEThU8ZEiqwYyA1dn82SLMVXDt1MATQWxUy8CFaR1QrbJG86iuVFhDYCdZGGEquc14kPwR00BXmmvKxL";

//        staticFiles.externalLocation(
//                Paths.get("public").toAbsolutePath().toString());
            // {{PRICE_ID}}
            SessionCreateParams params =
                    SessionCreateParams.builder()
                            .setMode(SessionCreateParams.Mode.PAYMENT)
                            .setSuccessUrl(YOUR_DOMAIN + "/success.html")
                            .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
                            .setAutomaticTax(
                                    SessionCreateParams.AutomaticTax.builder()
                                            .setEnabled(true)
                                            .build())
                            .addLineItem(
                                    SessionCreateParams.LineItem.builder()
                                            .setQuantity(1L)
                                            // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                                            .setPrice("price_1NLuzuHWVeW84MwZgegMR9Mk")
                                            .build())
                            .build();



            Session session = Session.create(params);

            return "success" ;

    }

}
