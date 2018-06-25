package com.prophet.EducationAdministrativeSystem.dao.service;

import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;

import java.util.List;

public interface GenericDaoService {


    /**
     * Query T by the specified ID
     * The ID must be a number
     **/
    public <T> T queryByPk(Number id, Class<T> clazz)
            throws DaoServiceException;


    /**
     * Query against sample pojo. All not null attributes of the passed in pojo
     * will be used as search criteria.
     **/
    public <T> List<T> queryLike(T sample) throws DaoServiceException;


    /**
     * Get the all records count
     */
    public <T> int count(Class<T> clazz) throws DaoServiceException ;


    /**
     * Get all records from table
     */
    public <T> List<T> queryAll (Class<T> clazz) throws DaoServiceException;


    /**
     * Insert single pojo
     *
     * @param daoPojo
     *            pojo to be inserted
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> int insert(T daoPojo, Class<T> clazz) throws DaoServiceException;


    /**
     * Insert pojos one by one. If you want to inert them in the batch mode,
     * user batchInsert instead. You can also use the combinedInsert.
     *
     * @param daoPojos
     *            list of pojos to be inserted
     * @return how many rows been affected
     */
    public <T> int[] insert(List<T> daoPojos, Class<T> clazz) throws DaoServiceException;


    /**
     * Delete the given pojo.
     *
     * @param daoPojo pojo to be deleted
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> int delete(T daoPojo, Class<T> clazz) throws DaoServiceException;



    /**
     * Delete the given pojos list one by one.
     *
     * @param daoPojos list of pojos to be deleted
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> int[] delete(List<T> daoPojos, Class<T> clazz) throws DaoServiceException;




    /**
     * Update the given pojo . By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param daoPojo pojo to be updated
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> int update(T daoPojo, Class<T> clazz) throws DaoServiceException;


    /**
     * Update the given pojo list one by one. By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param daoPojos list of pojos to be updated
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> int[] update(List<T> daoPojos, Class<T> clazz) throws DaoServiceException;



}
