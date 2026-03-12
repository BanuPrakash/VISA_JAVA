package com.visa.ecomapp.repo;

import com.visa.ecomapp.dto.ReportDTO;
import com.visa.ecomapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {

//    @Query(value = "select c.fname, c.email, o.order_date, o.total from orders o left outer join customers c on c.email = o.custome\n" +
//            "r_fk", nativeQuery = true)
//    @Query("select c.firstName, c.lastName, o.orderDate, o.total from Order o left join o.customer c")
//    List<Object[]> getReport();

    @Query("select new com.visa.ecomapp.dto.ReportDTO(c.firstName, c.lastName, o.orderDate, o.total) from Order o left join o.customer c")
    List<ReportDTO> getReport();

    @Query("select o from Order o JOIN FETCH o.items JOIN FETCH o.customer")
    List<Order> fetchWithItems();
}
