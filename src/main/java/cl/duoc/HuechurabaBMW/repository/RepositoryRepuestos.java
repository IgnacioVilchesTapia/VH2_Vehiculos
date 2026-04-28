package cl.duoc.HuechurabaBMW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.HuechurabaBMW.model.ModelRepuestos;

public interface RepositoryRepuestos extends JpaRepository<ModelRepuestos, Long> {
    
}

