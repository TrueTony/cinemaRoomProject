package com.example.cinemaroomproject.serializers;

import com.example.cinemaroomproject.CashRegister;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class CashRegisterGsonSerializer implements JsonSerializer<CashRegister> {
    @Override
    public JsonElement serialize(CashRegister cashRegister, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("current_income", cashRegister.getIncome());
        jsonObject.addProperty("number_of_available_seats", cashRegister.getAvailableSeats());
        jsonObject.addProperty("number_of_purchased_tickets", cashRegister.getPurchasedSeats());
        return jsonObject;
    }
}
