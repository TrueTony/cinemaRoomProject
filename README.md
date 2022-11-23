# Cinema Room Project
Study project by creating Spring REST service that simulates the work of cinema<br>
Handle HTTP requests in a controller, create services and respond with JSON objects

## Implementation Features
- creating Spring REST service
- handle GET/POST requests
- process and respond with JSON data
- throw custom exceptions

## Implementation
The service creates a Cinema with a certain number of seats and a cost depending on the location <br><br>

By GET request <b>/seats</b> returns JSON
```JSON
{
   "total_rows":5,
   "total_columns":6,
   "available_seats":[
      {
         "row":1,
         "column":1
      },

      ........

      {
         "row":5,
         "column":5
      },
      {
         "row":5,
         "column":6
      }
   ]
}
```

By POST request <b>/purchase</b> you can buy a ticket. The seat determined by the incoming JSON
```JSON
{
    "row": 5,
    "column": 7
}
```

If the purchase went through, JSON is returned
```JSON
{
    "token": "00ae15f2-1ab6-4a02-a01f-07810b42c0ee",
    "ticket": {
        "row": 5,
        "column": 7,
        "price": 8
    }
}
```
Where there is information about the place and unique purchase tokens <br>

If the seat is already taken returns <b>400</b> code in JSON
```JSON
{
    "error": "The ticket has been already purchased!"
}
```
If the location is incorrect, then an error is returned.
```JSON
"error": "The number of a row or a column is out of bounds!"
```

POST request on <b>/return</b> returns the ticket if `token` is specified
```JSON
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556"
}
```
Returns on success
```JSON
{
    "returned_ticket": {
        "row": 1,
        "column": 2,
        "price": 10
    }
}
```
Else
```JSON
"error": "Wrong token!"
```

You can also get statistics using a POST request <b>/stats</b> using the URL parameter `password`
```JSON
{
    "current_income": 0,
    "number_of_available_seats": 81,
    "number_of_purchased_tickets": 0
}
```
Incorrect data returns <b>401</b> error with text
```JSON
"error": "The password is wrong!"
```
