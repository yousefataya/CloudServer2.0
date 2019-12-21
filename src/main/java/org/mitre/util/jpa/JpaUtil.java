
package org.mitre.util.jpa;

import org.mitre.data.PageCriteria;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaUtil {
	public static <T> T getSingleResult(List<T> list) {
		switch(list.size()) {
			case 0:
				return null;
			case 1:
				return list.get(0);
			default:
				throw new IllegalStateException("Expected single result, got " + list.size());
		}
	}


	/**
	 * Get a page of results from the specified TypedQuery
	 * by using the given PageCriteria to limit the query
	 * results. The PageCriteria will override any size or
	 * offset already specified on the query.
	 *
	 * @param <T>  the type parameter
	 * @param query the query
	 * @param pageCriteria the page criteria
	 * @return the list
	 */
	public static <T> List<T> getResultPage(TypedQuery<T> query, PageCriteria pageCriteria){
		query.setMaxResults(pageCriteria.getPageSize());
		query.setFirstResult(pageCriteria.getPageNumber()*pageCriteria.getPageSize());

		return query.getResultList();
	}

	public static <T, I> T saveOrUpdate(I id, EntityManager entityManager, T entity) {
		T tmp = entityManager.merge(entity);
		entityManager.flush();
		return tmp;
	}
}
