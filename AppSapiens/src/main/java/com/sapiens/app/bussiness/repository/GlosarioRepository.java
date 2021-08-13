package com.sapiens.app.bussiness.repository;

import com.sapiens.app.bussiness.entities.Glosario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author hcarreno
 */
@Repository
public interface GlosarioRepository extends JpaRepository<Glosario, Integer> {

    /**
     * TODO remove
     * Example to call postgresql procedure with param
     * @param p1 param
     * @return procedure result
     */
    @Query(value = "CALL procedure1(:p1);", nativeQuery = true)
    String procedurePostgres(String p1);

    /**
     * TODO remove
     * Example to call oracle procedure without param,
     * to send param is like in the postgresql example, adding :param
     * @return procedure result
     */
    @Query(value = "BEGIN test_pkg.greetings(); END;", nativeQuery = true)
    String procedureOracle();
}
