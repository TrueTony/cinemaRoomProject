package com.example.cinemaroomproject.serializers;

import com.example.cinemaroomproject.Ticket;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class TicketGsonSerializer implements JsonSerializer<Ticket> {
    @Override
    public JsonElement serialize(Ticket ticket, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("token", ticket.getToken().toString());
        JsonObject seat = new JsonObject();
        seat.addProperty("row", ticket.getSeat().getRow());
        seat.addProperty("column", ticket.getSeat().getColumn());
        seat.addProperty("price", ticket.getSeat().getPrice());
        jsonObject.add("ticket", seat);
        return jsonObject;
    }
}
