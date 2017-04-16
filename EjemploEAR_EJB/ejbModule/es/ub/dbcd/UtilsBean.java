package es.ub.dbcd;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class UtilsBean
 */
@Singleton
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class UtilsBean {

	private int hits = 0;

	@Lock(LockType.READ)
	public Calendar getDate() {
		return GregorianCalendar.getInstance();
	}

	public int getHits() {
		return hits++;
	}

	public UtilsBean() {
		// TODO Auto-generated constructor stub
	}

}
