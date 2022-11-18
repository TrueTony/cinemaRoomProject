package com.example.cinemaroomproject.controllers;

import com.example.cinemaroomproject.CashRegister;
import com.example.cinemaroomproject.Cinema;
import com.example.cinemaroomproject.Seat;
import com.example.cinemaroomproject.Ticket;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {

    private final Cinema cinema = new Cinema(9, 9);
    private final CashRegister cashRegister = new CashRegister(cinema);

    @GetMapping("/seats")
    public Cinema getCinema() {
        return cinema;
    }

    @PostMapping("/purchase")
    public String getSeat(@RequestBody Seat wantedSeat) {
        return cashRegister.byTicket(wantedSeat);
    }

    @PostMapping("/return")
    public String returnTicket(@RequestBody Ticket ticket) {
        return cashRegister.returnTicket(ticket);
    }

    @PostMapping("/stats")
    public String getStats(@RequestParam (required = false) String password) {
        return cashRegister.returnStats(password);
    }
}
