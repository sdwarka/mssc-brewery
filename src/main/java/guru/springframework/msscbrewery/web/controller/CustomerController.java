package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService custService;

    public CustomerController(CustomerService custService) {
        this.custService = custService;
    }

    @GetMapping("/{custId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("custId") UUID custId) {
        return new ResponseEntity<>(custService.getCustomerById(custId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCust = custService.createCustomer(customerDto);

        HttpHeaders hdrs = new HttpHeaders();
        hdrs.add("Location", "/api/v1/customer/" + savedCust.getId());

        return new ResponseEntity(hdrs, HttpStatus.CREATED);
    }

    @PutMapping("/{custId}")
    public ResponseEntity updateCustomer(@PathVariable UUID custId, @RequestBody CustomerDto customerDto) {
        custService.updateCustomer(custId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{custId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("custId") UUID custId) {
        custService.deleteCustomer(custId);
    }
}
