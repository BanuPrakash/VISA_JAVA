package com.visa.rental.service;


import com.visa.rental.dto.RentalVehicleDTO;
import com.visa.rental.entity.Booking;
import com.visa.rental.entity.Customer;
import com.visa.rental.entity.Vehicle;
import com.visa.rental.repo.BookingRepo;
import com.visa.rental.repo.CustomerRepo;
import com.visa.rental.repo.VehicleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RentalService {
    private final VehicleRepo vehicleRepo; // constructor wiring instead of @Autowired [setter]
    private final CustomerRepo customerRepo;
    private final BookingRepo bookingRepo;

    // this won't have return date and amount
    public Booking doBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    /**
     *
     * @param id rental ID
     * @param returnDate when vehicle is returned
     * @return success message
     */
    @Transactional
    public String returnBookedVehicle(int id, LocalDateTime returnDate) {
        Booking booking = bookingRepo.findById(id).get(); // get complete booking info form DB
        Vehicle vehicle =
                vehicleRepo.findById(booking.getVehicle().getRegistrationNumber()).get();
        double cost = vehicle.getDailyHireRate();

        Duration duration = Duration.between(booking.getDateFrom(),returnDate);
        long days = duration.toDays();
        double amount = cost * days;

        booking.setDateTo(returnDate); // DIRTY
        booking.setAmount(amount); // DIRTY
        // no explicit UPDATE called
        // booking became DIRTY, ORM does DIRTY CHECKING and issues UPDATE SQL

        return "Vehicle returned!!!";
    }

    public List<Booking> getBookings() {
        return bookingRepo.findAll();
    }

    public long getVehicleCount() {
        return vehicleRepo.count();
    }
    public long getCustomerCount() {
        return customerRepo.count();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public Customer addCustomer(Customer customer) {
        return  customerRepo.save(customer);
    }

    public List<Vehicle> getVehicles() {
        // select * from vehicles
        return  vehicleRepo.findAll();
    }

    public List<Vehicle> getVehiclesByType(String type) {
        // select * from vehicles
        return  vehicleRepo.findByFuelType(type);
    }

    public List<Customer> getCustomers() {
        // select * from customers
        return  customerRepo.findAll();
    }

    public Vehicle getByRegNo(String reg)  {
        Optional<Vehicle> opt = vehicleRepo.findById(reg);
        if(opt.isPresent()) {
            return opt.get();
        }
        return null;
    }


    public List<RentalVehicleDTO> getVehicleRentalInfo() {
        return bookingRepo.getVehicleRentalInfo();
    }
}
