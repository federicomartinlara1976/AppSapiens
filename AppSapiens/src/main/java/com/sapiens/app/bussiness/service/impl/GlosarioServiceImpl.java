package com.sapiens.app.bussiness.service.impl;

import com.sapiens.app.bussiness.repository.GlosarioRepository;
import com.sapiens.app.bussiness.service.GlosarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("glosarioService")
public class GlosarioServiceImpl implements GlosarioService {

    @Autowired
    private GlosarioRepository glosarioRepository;

    /**
     * TODO remove
     * get procedure result from postgresql db example
     * @param p1 dummy param
     * @return procedure result
     */
    @Override
    public String procedurePostgres(String p1) {
        return glosarioRepository.procedurePostgres(p1);
    }

    /**
     * TODO remove
     * get procedure result from oracle db example
     * @return procedure result
     */
    @Override
    public String procedureOracle(){
        return  glosarioRepository.procedureOracle();
    }
}
