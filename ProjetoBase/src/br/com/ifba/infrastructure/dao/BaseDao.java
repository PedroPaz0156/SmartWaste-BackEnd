package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("unchecked")
public class BaseDao<Entity extends PersistenceEntity> implements IBaseDao<Entity>{

    
    protected static EntityManager entityManager;
    
    static{
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("bd_test");
        entityManager = fac.createEntityManager();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Entity save(Entity entity){
       entityManager.getTransaction().begin();
       entityManager.persist(entity);
       entityManager.getTransaction().commit();
       return entity;
        
    }
    
    /**
     * {@inheritDoc}
     * @param entity
     * @return 
     */
    @Override
    public Entity update(Entity entity){
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;

    }
    
    /**
     * {@inheritDoc}
     * @param entity
     */
    @Override
    public void delete(Entity entity){
       entity = findById(entity.getId());
       entityManager.getTransaction().begin();
       entityManager.remove(entity);
       entityManager.getTransaction().commit();       
    }
    
    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    public List<Entity> findAll(){
        String table = getTypeClass().getSimpleName()+" "+getTypeClass().getSimpleName().charAt(0);
        return entityManager.createQuery(("FROM " + table)).getResultList();
    }
    
    
    /**
     * {@inheritDoc}
     * @param id
     * @return 
     */
    @Override
    public Entity findById(Long id){
        return (Entity) entityManager.find(getTypeClass(), id);
    }
    
    
    public Class<?> getTypeClassEntity(Entity entity){
        Class<?> typeClass = entity.getClass();
        return typeClass;
    }

    protected Class<?> getTypeClass(){
        
        Class<?> typeClass = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        
        return typeClass;
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
