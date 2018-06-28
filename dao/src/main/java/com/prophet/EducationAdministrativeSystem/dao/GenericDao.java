package com.prophet.EducationAdministrativeSystem.dao;

import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenericDao {


    /**
     * Query T by the specified ID
     * The ID must be a number
     **/
    <T> T queryByPk(Number id, Class<T> clazz)
            throws DaoServiceException;


    /**
     * Query against sample pojo. All not null attributes of the passed in pojo
     * will be used as search criteria.
     **/
    <T> List<T> queryLike(T sample) throws DaoServiceException;


    /**
     * Query the selected field with a fuzzy mode
     */
    <T> List<T> fuzzyQuery(String fieldName, T sample) throws DaoServiceException;


    /**
     * Get the all records count
     */
    <T> int count(Class<T> clazz) throws DaoServiceException ;


    /**
     * Get all records from table
     */
    <T> List<T> queryAll (Class<T> clazz) throws DaoServiceException;


    /**
     * Insert single pojo
     *
     * @param daoPojo
     *            pojo to be inserted
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    <T> int insert(T daoPojo) throws DaoServiceException;


    /**
     * Insert pojos one by one. If you want to inert them in the batch mode,
     * user batchInsert instead. You can also use the combinedInsert.
     *
     * @param daoPojos
     *            list of pojos to be inserted
     * @return how many rows been affected
     */
    <T> int[] insert(List<T> daoPojos) throws DaoServiceException;


    /**
     * Delete the given pojo.
     *
     * @param daoPojo pojo to be deleted
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    <T> int delete(T daoPojo) throws DaoServiceException;



    /**
     * Delete the given pojos list one by one.
     *
     * @param daoPojos list of pojos to be deleted
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    <T> int[] delete(List<T> daoPojos) throws DaoServiceException;




    /**
     * Update the given pojo . By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param daoPojo pojo to be updated
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    <T> int update(T daoPojo) throws DaoServiceException;


    /**
     * Update the given pojo list one by one. By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param daoPojos list of pojos to be updated
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    <T> int[] update(List<T> daoPojos) throws DaoServiceException;




}
