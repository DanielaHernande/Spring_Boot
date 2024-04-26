package com.riwi.vacants.services.interfaces;

import org.springframework.data.domain.Page;

/*
 * RQ va a ser el Resquest
 * RS va a ser el Response
 * ID = Tipo de dato de la llave primaria de cualquier entidad
 */
public interface CrudService <RQ, RS, ID>{
    
    public void delet(ID id);

    public RS create(RQ request);

    public RS update(ID id, RQ request);

    public Page<RS> getAll(int page, int size);
    

}
