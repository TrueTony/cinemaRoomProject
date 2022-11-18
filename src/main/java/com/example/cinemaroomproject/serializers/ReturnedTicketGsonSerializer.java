package com.example.cinemaroomproject.serializers;

import com.example.cinemaroomproject.Seat;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ReturnedTicketGsonSerializer implements JsonSerializer<Seat> {
    @Override
    public JsonElement serialize(Seat seat, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        JsonObject returnedSeat = new JsonObject();
        returnedSeat.addProperty("row", seat.getRow());
        returnedSeat.addProperty("column", seat.getColumn());
        returnedSeat.addProperty("price", seat.getPrice());
        jsonObject.add("returned_ticket", returnedSeat);
        return jsonObject;
    }
}
