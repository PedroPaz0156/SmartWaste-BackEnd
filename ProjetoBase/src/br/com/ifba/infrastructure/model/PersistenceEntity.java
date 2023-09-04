package br.com.ifba.infrastructure.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author JONATAS BASTOS
 */

//

//Classe que as entidades irão herdar
@MappedSuperclass
public class PersistenceEntity{
        
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
        
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
