package com.prophet.EducationAdministrativeSystem.dao.impl;

import com.prophet.EducationAdministrativeSystem.dao.GenericDao;
import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import com.prophet.EducationAdministrativeSystem.dao.mapper.GenericMapper;
import com.prophet.EducationAdministrativeSystem.dao.mapper.SqlProviderTools;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Component
public class GenericDaoServiceImpl implements GenericDao {

    @Autowired
    GenericMapper genericMapper;


    /**
     * Query T by the specified ID
     * The ID must be a number
     **/
    public <T> T queryByPk(Number id, Class<T> clazz) throws DaoServiceException {

        Map<String, Object> resultMap = genericMapper.queryByPk(id, clazz);
        return SqlProviderTools.toObject(resultMap, clazz);
    }


    /**
     * Query against sample pojo. All not null attributes of the passed in pojo
     * will be used as search criteria.
     **/
    public <T> List<T> queryLike(T sample) throws DaoServiceException {

        List<HashMap<String, Object>> resultMaps = genericMapper.queryLike(sample);

        return SqlProviderTools.toObjectList(resultMaps, ((Class<T>) sample.getClass()));
    }



    /**
     * Get the all records count
     */
    public <T> int count(Class<T> clazz) throws DaoServiceException {
        return genericMapper.count(clazz);
    }



    /**
     * Get all records from table
     */
    public <T> List<T> queryAll(Class<T> clazz) throws DaoServiceException {

        List<HashMap<String, Object>> resultMaps =  genericMapper.queryAll(clazz);

        return SqlProviderTools.toObjectList(resultMaps, clazz);
    }



    /**
     * Insert single pojo
     *
     * @param daoPojo
     *            pojo to be inserted
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> int insert(T daoPojo) throws DaoServiceException {

        return genericMapper.insert(daoPojo);
    }



    /**
     * Insert pojos one by one. If you want to inert them in the batch mode,
     * user batchInsert instead. You can also use the combinedInsert.
     *
     * @param daoPojos
     *            list of pojos to be inserted
     * @return how many rows been affected
     */
    public <T> int[] insert(List<T> daoPojos) throws DaoServiceException {

        if (CollectionUtils.isEmpty(daoPojos)) {
            throw new DaoServiceException("Cannot insert list which is empty!");
        }

        int[] result = new int[daoPojos.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = genericMapper.insert(daoPojos.get(i));
        }

        return result;
    }


    /**
     * Delete the given pojo.
     *
     * @param daoPojo pojo to be deleted
     * @return how many rows been affected
     * @throws DaoServiceException  Exception
     */
    public <T> int delete(T daoPojo) throws DaoServiceException {

         return genericMapper.delete(daoPojo);
    }



    /**
     * Delete the given pojos list one by one.
     *
     * @param daoPojos list of pojos to be deleted
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> int[] delete(List<T> daoPojos) throws DaoServiceException {

        if (CollectionUtils.isEmpty(daoPojos)) {
            throw new DaoServiceException("Cannot delete list which is empty!");
        }

        int[] result = new int[daoPojos.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = genericMapper.delete(daoPojos.get(i));
        }

        return result;
    }



    /**
     * Update the given pojo . By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param daoPojo pojo to be updated
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> int update(T daoPojo) throws DaoServiceException {
        return genericMapper.update(daoPojo);
    }



    public <T> int[] update(List<T> daoPojos) throws DaoServiceException {
        return new int[0];
    }
}
