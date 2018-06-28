package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import com.prophet.EducationAdministrativeSystem.model.annotations.TableName;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GenericSqlProvider {

    private Logger logger = Logger.getLogger(this.getClass());

    private static final String SQL_ALL_FIELDS = "*";

    private static final String SQL_IS = "=";

    private static final String SQL_ARGS_LEFT_CHAR = "#{";

    private static final String SQL_ARGS_RIGHT_CHAR = "}";

    private static final String SQL_LIKE = "like";


    /**
     * Query T by the specified ID
     * The ID must be a number
     **/
    public <T> String queryByPk(Number id, Class<T> clazz) throws DaoServiceException {

        final String tableName = clazz.getAnnotation(TableName.class).value();

        String idFieldName = SqlProviderTools.getIdFieldName(clazz);

        final String idClause = idFieldName + SQL_IS + id;

        String sql = new SQL() {
            {
                SELECT(SQL_ALL_FIELDS);
                FROM(tableName);
                WHERE(idClause);
            }
        }.toString();

        logger.info("SQL EXECUTED:  \n"+sql);

        return sql;
    }



    /**
     * Query against sample pojo. All not null attributes of the passed in pojo
     * will be used as search criteria.
     **/
    public <T> String queryLike(T sample) throws DaoServiceException {

        if (sample == null) {
            throw new DaoServiceException("Validate failed, Criteria is null!");
        }

        final String tableName = sample.getClass().getAnnotation(TableName.class).value();

        final List<String> criteriaNames = SqlProviderTools.getCriteriaFieldNames(sample);

        final Map<String, Object> fieldMap = SqlProviderTools.toDBColumnNameMap(criteriaNames, sample);

        String sql = new SQL() {
            {
                SELECT(SQL_ALL_FIELDS);
                FROM(tableName);

                if (fieldMap.size() > 0) {

                    for (Map.Entry<String, Object> entry: fieldMap.entrySet()) {
                        WHERE(entry.getKey() + SQL_IS + SQL_ARGS_LEFT_CHAR
                                + entry.getValue() + SQL_ARGS_RIGHT_CHAR);
                    }
                }
            }
        }.toString();

        logger.info("SQL EXECUTED:  \n" + sql);

        return sql;
    }



    /**
     * Get the all records count
     */
    public <T> String count(Class<T> clazz) {

        final String tableName = clazz.getAnnotation(TableName.class).value();

        String sql = new SQL() {
            {
                SELECT("count(*)");
                FROM(tableName);
            }
        }.toString();

        logger.info("SQL EXECUTED: \n" + sql);

        return sql;
    }



    /**
     * Get all records from table
     */
    public <T> String queryAll(Class<T> clazz) {

        final String tableName = clazz.getAnnotation(TableName.class).value();

        String sql = new SQL() {
            {
                SELECT(SQL_ALL_FIELDS);
                FROM(tableName);
            }
        }.toString();

        logger.info("SQL EXECUTED: \n" + sql);

        return sql;
    }


    /**
     * Insert single pojo
     *
     * @param record
     *            pojo to be inserted
     * @return sql statement
     * @throws DaoServiceException Exception
     */
    public <T> String insert(T record) throws DaoServiceException {

        if (record == null) {
            throw new DaoServiceException("Validate failed, record to be insert is null!");
        }

        final String tableName = record.getClass().getAnnotation(TableName.class).value();

        final List<String> criteriaNames = SqlProviderTools.getCriteriaFieldNames(record);

        final Map<String, Object> fieldMap = SqlProviderTools.toDBColumnNameMap(criteriaNames, record);

        String sql = new SQL() {
            {
                INSERT_INTO(tableName);

                for (Map.Entry<String, Object> entry: fieldMap.entrySet()) {
                    VALUES(entry.getKey(), "#{" + entry.getValue() + "}");
                }
            }
        }.toString();

        logger.info("SQL EXECUTED: \n" + sql);

        return sql;
    }



    /**
     * Delete the given pojo.
     *
     * @param criteria pojo to be deleted
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> String delete(T criteria) throws DaoServiceException {

        if (criteria == null) {
            throw new DaoServiceException("Validate failed, record to be delete is null!");
        }

        final String tableName = criteria.getClass().getAnnotation(TableName.class).value();

        final List<String> criteriaNames = SqlProviderTools.getCriteriaFieldNames(criteria);

        final Map<String, Object> fieldMap = SqlProviderTools.toDBColumnNameMap(criteriaNames, criteria);

        String sql = new SQL() {
            {
                DELETE_FROM(tableName);

                if (fieldMap.size() <= 0) {
                    throw new DaoServiceException("Cannot delete with empty restrictions!");
                }

                for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
                    WHERE(entry.getKey() + SQL_IS + SQL_ARGS_LEFT_CHAR
                            + entry.getValue() + SQL_ARGS_RIGHT_CHAR);
                }
            }
        }.toString();

        logger.info("SQL EXECUTED: \n" + sql);

        return sql;
    }


    /**
     * Update the given pojo . By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param records pojo to be updated
     * @return how many rows been affected
     * @throws DaoServiceException
     */
    public <T> String update(final T records) throws DaoServiceException {

        final String tableName = records.getClass().getAnnotation(TableName.class).value();

        final String idFieldName = SqlProviderTools.getIdFieldName(records.getClass());

        final List<String> criteriaNames = SqlProviderTools.getCriteriaFieldNames(records);

        final Map<String, Object> fieldMap = SqlProviderTools.toDBColumnNameMap(criteriaNames, records);

        String sql = new SQL() {
            {
                UPDATE(tableName);

                for (Map.Entry<String, Object> entry: fieldMap.entrySet()) {
                    SET(entry.getKey() + SQL_IS + SQL_ARGS_LEFT_CHAR + entry.getValue() + SQL_ARGS_RIGHT_CHAR);
                }

                WHERE(SqlProviderTools.toDBColumnName(idFieldName) + SQL_IS +
                        SQL_ARGS_LEFT_CHAR + idFieldName + SQL_ARGS_RIGHT_CHAR);

            }
        }.toString();

        logger.info("SQL EXECUTED: \n" + sql);

        return sql;
    }


    /**
     * Query the selected field with a fuzzy mode
     * @param fuzzyKey  fuzzy key
     * @param fieldName field name
     * @param clazz class
     * @param <T>   T
     * @return  sql
     */
    public <T> String fuzzyQuery(@Param("fuzzyKey") final String fuzzyKey, String fieldName, Class<T> clazz) {

        final String tableName = clazz.getAnnotation(TableName.class).value();

        final String columnName = SqlProviderTools.toDBColumnName(fieldName);

        String sql = new SQL() {
            {
                SELECT(SQL_ALL_FIELDS);
                FROM(tableName);
                WHERE(columnName + " like concat('%',#{fuzzyKey},'%')");
            }
        }.toString();

        logger.info("SQL EXECUTED: \n" + sql);

        return sql;
    }





}
