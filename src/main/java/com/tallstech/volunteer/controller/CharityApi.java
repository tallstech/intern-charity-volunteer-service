package com.tallstech.volunteer.controller;

import com.tallstech.volunteer.model.Charity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Tag(name="Charities")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/charities")
public interface CharityApi {
    @Operation(operationId = "getClickableCharities", summary = "Get clickable charities fro client pages")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = Charity.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @GetMapping(produces = {"application/json;charset=utf-8"})
    ResponseEntity<List<Charity>> getCharities(@RequestHeader Map<String, String> header,
                                             @RequestParam(required = false) String charity
    ) throws Exception;
    /*@PostMapping(path = "/set", consumes = {"application/json;charset=utf-8"}, produces = {"application/json;charset=utf-8"})
    ResponseEntity createCharity(@RequestBody Charity charity, String admin_name, String admin_surname, String admin_tckn, String admin_email,
                                 String admin_password, String admin_phone_number) throws Exception;
*/

}
