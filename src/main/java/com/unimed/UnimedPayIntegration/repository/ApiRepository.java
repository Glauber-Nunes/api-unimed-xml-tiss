package com.unimed.UnimedPayIntegration.repository;

import com.unimed.UnimedPayIntegration.model.GuiaMedicaTiss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<GuiaMedicaTiss,Long> {
}
