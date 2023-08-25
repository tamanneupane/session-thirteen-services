package com.metta.quotes.controller;

import com.metta.quotes.model.ErrorResponse;
import com.metta.quotes.model.Quote;
import com.metta.quotes.model.QuoteDTO;
import com.metta.quotes.service.QuoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/quote-service/api/v1")
public class QuoteController {

    //CRUD Operation

    /*
        POST
            -> If sending sensitive info
            -> If sending very large info
            -> If the requesting is creating something in the database

         GET
            -> If user want to read the data
            -> If user want to read the data by applying filter(Request Params)
            -> If user want to read the data by sending some small insensitive data (Path Variable)

         PUT
            -> If user want to update the data

         PATCH
            -> If user want to update only one part of data

         DELETE
            -> If user wants to delete the data from database


         HTTP Codes:
         SUCCESSFUL
         200 => OK (For Every Read Request and update request)
         201 => CREATED (When something is created in database)
         204 => NO_CONTENT (When deleted successfully)

         Redirection
         301 => (Frontend) MOVED_PERMANENTLY

         Client Error
         400 => BAD_REQUEST (sent data not valid)
         401 => UNAUTHORIZED
         404 => NOT_FOUND
         422 => UNProcessable_entity

         Server Error
         500 => INTERNAL_SERVER_ERROR (when exception is thrown by your code)
     */

    @Autowired
    private QuoteService quoteService;

    @Operation(summary = "Create the quote")
    @PostMapping(value = "/create-quote")
    public ResponseEntity<Quote> createQuote(@Valid @RequestBody QuoteDTO quoteDTO){
        return new ResponseEntity<>(quoteService.storeQuote(quoteDTO), HttpStatus.CREATED);
//        return quoteService.storeQuote(quoteDTO);
    }

    @GetMapping(value = "/quotes")
    public ResponseEntity<List<Quote>> readQuotes(){
//        return quoteService.readQuotes();
        return new ResponseEntity<>(quoteService.readQuotes(), HttpStatus.OK);
//        return ResponseEntity.ok(quoteService.readQuotes());
    }


    @Operation(summary = "Read the individual quote with id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Quote",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Quote.class)) }),
            @ApiResponse(responseCode = "404", description = "Quote not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) }) })
    @GetMapping(value = "/quote-detail")
    public ResponseEntity<Quote> readSingleQuotes(@RequestParam("quoteId") Long quoteId){
        return new ResponseEntity<>(quoteService.readSingleQuote(quoteId), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Quote",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Quote.class)) }),
            @ApiResponse(responseCode = "404", description = "Quote not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) }) })
    @PutMapping(value = "/update-quote")
    public ResponseEntity<Quote> updateQuote(@RequestParam("quoteId") Long quoteId, @RequestBody QuoteDTO quoteDTO){
        return new ResponseEntity<>(quoteService.updateQuote(quoteId, quoteDTO), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Quote",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Quote.class)) }),
            @ApiResponse(responseCode = "404", description = "Quote not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) }) })
    @PatchMapping(value = "/enable-quote")
    public String enableQuote(@RequestParam("quoteId") Long quoteId, @RequestParam("enable") boolean isEnabled){
        // Update the data to database
        System.out.println(quoteId);
        System.out.println(isEnabled);
        return "Enable  quotes";
    }

    @DeleteMapping(value = "/delete-quote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Found the Quote",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Quote.class)) }),
            @ApiResponse(responseCode = "404", description = "Quote not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) }) })
    public ResponseEntity<String> deleteQuote(@RequestParam("quoteId") Long quoteId){
        quoteService.deleteQuoteById(quoteId);
        return ResponseEntity.noContent().build();
    }
}
