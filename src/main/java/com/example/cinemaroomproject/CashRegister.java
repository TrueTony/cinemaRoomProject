package com.example.cinemaroomproject;

import com.example.cinemaroomproject.exceptions.CashRegisterException;
import com.example.cinemaroomproject.exceptions.SeatException;
import com.example.cinemaroomproject.serializers.CashRegisterGsonSerializer;
import com.example.cinemaroomproject.serializers.ReturnedTicketGsonSerializer;
import com.example.cinemaroomproject.serializers.TicketGsonSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CashRegister {

    private Cinema cinema;
    private List<Ticket> ticketList;
    private int income;
    private int availableSeats;
    private int purchasedSeats;

    public CashRegister(Cinema cinema) {
        this.cinema = cinema;
        ticketList = new ArrayList<>();
        availableSeats = cinema.getAvailableSeats().size();
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getPurchasedSeats() {
        return purchasedSeats;
    }

    public void setPurchasedSeats(int purchasedSeats) {
        this.purchasedSeats = purchasedSeats;
    }

    public String byTicket(Seat wantedSeat) {
        for (Seat seat : cinema.getAvailableSeats()) {
            if (seat.equals(wantedSeat)) {
                if (seat.isTaken()) {
                    throw new SeatException("The ticket has been already purchased!");
                } else {
                    Gson gson = new GsonBuilder()
                            .setPrettyPrinting()
                            .excludeFieldsWithoutExposeAnnotation()
                            .serializeNulls()
                            .disableHtmlEscaping()
                            .registerTypeAdapter(Ticket.class, new TicketGsonSerializer())
                            .create();
                    seat.setTaken(true);
                    availableSeats--;
                    purchasedSeats++;
                    Ticket ticket = new Ticket(seat);
                    income += seat.getPrice();
                    ticketList.add(ticket);
                    return gson.toJson(ticket);
                }
            }
        }
        throw new SeatException("The number of a row or a column is out of bounds!");
    }

    public String returnTicket(Ticket ticket) {
        UUID uuid = ticket.getToken();
        for (Ticket t : ticketList) {
            if (uuid.equals(t.getToken())) {
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .excludeFieldsWithoutExposeAnnotation()
                        .serializeNulls()
                        .disableHtmlEscaping()
                        .registerTypeAdapter(Seat.class, new ReturnedTicketGsonSerializer())
                        .create();
                t.getSeat().setTaken(false);
                availableSeats++;
                purchasedSeats--;
                income -= t.getSeat().getPrice();
                ticketList.remove(t);
                return gson.toJson(t.getSeat());
            }
        }
        throw new SeatException("Wrong token!");
    }

    public String returnStats(String password) {
        if ("super_secret".equals(password)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .excludeFieldsWithoutExposeAnnotation()
                    .serializeNulls()
                    .disableHtmlEscaping()
                    .registerTypeAdapter(CashRegister.class, new CashRegisterGsonSerializer())
                    .create();
            return gson.toJson(this);
        }
        throw new CashRegisterException("The password is wrong!");
    }
}
