package com.springboot.model1;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.model.Robber;

public interface CaptainRepo extends JpaRepository<Robber, Integer> {

}
