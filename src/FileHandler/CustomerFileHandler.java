package FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import com.google.gson.Gson;

public class CustomerFileHandler {
    private String filePath;
    private Gson gson;

    public CustomerFileHandler(String filePath) {
        this.filePath = filePath;
        this.gson = new Gson();
    }

    public void create(Customer customer) {
        List<Customer> customers = getAllCustomers();
        customers.add(customer);
        saveAllCustomers(customers);
    }

    public Customer read(String email) {
        List<Customer> customers = getAllCustomers();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    public void update(Customer updatedCustomer) {
        List<Customer> customers = getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getEmail().equals(updatedCustomer.getEmail())) {
                customers.set(i, updatedCustomer);
                saveAllCustomers(customers);
                return;
            }
        }
    }

    public void delete(String email) {
        List<Customer> customers = getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getEmail().equals(email)) {
                customers.remove(i);
                saveAllCustomers(customers);
                return;
            }
        }
    }

    private List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Customer customer = gson.fromJson(line, Customer.class);
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<Customer> readAll() {
        return getAllCustomers();
    }

    private void saveAllCustomers(List<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                String json = gson.toJson(customer);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}