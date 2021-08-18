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
    @Query(value = "DECLARE\n" +
            "   p_lista_glosarios  SM2_K_VALIDATOR.t_t_glosario;\n" +
            "   p_resultado        INTEGER;\n" +
            "   p_lista_errores    SM2_K_VALIDATOR.t_t_error;\n" +
            "BEGIN\n" +
            "SM2_K_VALIDATOR.P_BUSCAR_GLOSARIOS('desccripcion uno', p_lista_glosarios, p_resultado, p_lista_errores);"+
            "END;", nativeQuery = true)
    String procedureOracle();
}
