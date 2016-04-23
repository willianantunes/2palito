package br.com.aqlbras.doispalito.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalTime;

import br.com.aqlbras.doispalito.portal.model.common.AbstractEntity;


@Entity
/**
 * This class represents a business hours, in other words the work time that the enterprise will provide his services.
 * Prospecções: Inserir restrição de funcionamento para um dia em específico (algum feriado, por exemplo).
 * @author Willian Antunes / Bruno Alves
 * @version 1.0.0
 */
public class BusinessHour extends AbstractEntity
{
	@Enumerated(EnumType.STRING)
	private WeekDays fromWeekDay;
	@Enumerated(EnumType.STRING)
	private WeekDays toWeekDay;
	@Type(type= "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	private LocalTime from;
	@Type(type= "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	private LocalTime to;
	@NotNull
	@Column(length = 128)	
	private String description;
	
	public enum WeekDays
	{
		Sunday(1), Monday(2), Tuesday(3), Wednesday(4), Thursday(5), Friday(6), Saturday(7);
		
		private final int dayOfWeek;
		
		WeekDays(int dayOfWeek)
		{			
			this.dayOfWeek = dayOfWeek;
		}
	}
}
