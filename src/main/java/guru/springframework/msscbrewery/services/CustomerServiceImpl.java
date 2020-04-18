package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder()
                .id(id)
                .customerName("John Doe")
                .build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("Jane Doe")
                .build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto customerDto) {
        //TODO we need to add a real impl here
    }

    @Override
    public void deleteCustomer(UUID id) {
        log.debug("Deleting customer " + id);
    }
}
