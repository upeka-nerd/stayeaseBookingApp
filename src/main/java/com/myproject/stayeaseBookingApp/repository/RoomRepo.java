package com.myproject.stayeaseBookingApp.repository;

import com.myproject.stayeaseBookingApp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoomRepo extends JpaRepository<Room,Long> {
}
