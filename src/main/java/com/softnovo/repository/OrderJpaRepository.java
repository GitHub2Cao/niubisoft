package com.softnovo.repository;

import com.softnovo.domain.JpaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("orderJpaRepository")
public interface OrderJpaRepository extends JpaRepository<JpaOrder, Long> {
    @Query("select o from JpaOrder o where o.orderNumber = ?1")
    JpaOrder getOrderByOrderNumberWithQuery(String orderNumber);

}
