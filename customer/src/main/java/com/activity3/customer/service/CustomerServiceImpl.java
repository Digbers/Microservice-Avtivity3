package com.activity3.customer.service;

import com.activity3.customer.controller.DTO.CustomerDTO;
import com.activity3.customer.controller.DTO.OrderDTO;
import com.activity3.customer.entity.CustomerEntity;
import com.activity3.customer.feignClient.OrderClient;
import com.activity3.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    OrderClient orderClient;
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO orderDTO) {
        try {
            CustomerEntity customerEntity = CustomerServiceImpl.convertToEntity(orderDTO);
            CustomerEntity customer = customerRepository.save(customerEntity);
            return CustomerServiceImpl.convertToDTO(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        try {
            CustomerEntity customer = customerRepository.findById(id).orElse(null);
            if (customer != null) {
                return CustomerServiceImpl.convertToDTO(customer);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        try {
            List<CustomerDTO> customerDTOS = customerRepository.findAll().stream().map(CustomerServiceImpl::convertToDTO).toList();
            return customerDTOS;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO orderDTO) {
        try {
            CustomerEntity customerEntity = CustomerServiceImpl.convertToEntity(orderDTO);
            CustomerEntity customer = customerRepository.save(customerEntity);
            return CustomerServiceImpl.convertToDTO(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderDTO getOrderDetailsForCustomer(Long customerId) {
        try {
            return orderClient.getOrderById(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static CustomerDTO convertToDTO(CustomerEntity customerEntity) {
        return CustomerDTO.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .lastName(customerEntity.getLastName())
                .email(customerEntity.getEmail())
                .build();
    }
    public static CustomerEntity convertToEntity(CustomerDTO customerDTO) {
        return CustomerEntity.builder()
                .name(customerDTO.getName())
                .lastName(customerDTO.getLastName())
                .email(customerDTO.getEmail())
                .build();
    }
}
