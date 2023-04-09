package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Supermercado;


//CLASSE REPOSITORY = INTERFACE BANCO E TABELA
@Repository
public interface SupermercadoRepository extends JpaRepository <Supermercado, Long>{

}
