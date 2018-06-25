package com.prophet.EducationAdministrativeSystem.dao.mapper;

import com.prophet.EducationAdministrativeSystem.dao.exception.DaoServiceException;
import com.prophet.EducationAdministrativeSystem.model.User;
import com.prophet.EducationAdministrativeSystem.model.annotations.TableName;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenericSqlProvider {

    private static final String SQL_ALL_FIELDS = "*";

    private static final String SQL_IS = "=";

    private static final String SQL_ARGS_LEFT_CHAR = "#{";

    private static final String SQL_ARGS_RIGHT_CHAR = "}";



    /**
     * Query T by the specified ID
     * The ID must be a number
     **/
    public <T> String queryByPk(Number id, Class<T> clazz) throws DaoServiceException {

        final String tableName = clazz.getAnnotation(TableName.class).value();

        String idFieldName = SqlProviderTools.getIdFieldName(clazz);

        final String idClause = idFieldName + SQL_IS + id;

        return new SQL() {
            {
                SELECT(SQL_ALL_FIELDS);
                FROM(tableName);
                WHERE(idClause);
            }
        }.toString();
    }



    public <T> String queryLike(T sample) throws DaoServiceException {

        if (sample == null) {
            throw new DaoServiceException("Validate failed, Criteria is null!");
        }

        final String tableName = sample.getClass().getAnnotation(TableName.class).value();

        final List<String> criteriaNames = SqlProviderTools.getCriteriaFieldNames(sample);

        return new SQL() {
            {
                SELECT(SQL_ALL_FIELDS);
                FROM(tableName);

                if (criteriaNames.size() > 0) {

                    for (int i = 0; i < criteriaNames.size()-1; i++) {

                        WHERE(criteriaNames.get(i) + SQL_IS + SQL_ARGS_LEFT_CHAR +
                                criteriaNames.get(i) + SQL_ARGS_RIGHT_CHAR);
                        AND();
                    }

                    WHERE(criteriaNames.get(criteriaNames.size()-1) + SQL_IS + SQL_ARGS_LEFT_CHAR +
                            criteriaNames.get(criteriaNames.size()-1) + SQL_ARGS_RIGHT_CHAR);
                }
            }
        }.toString();
    }


    public String queryUserByPk(Number id) {
        return "select * from user where id=#{id}";
    }




}
