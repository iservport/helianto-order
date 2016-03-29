package org.helianto.order.domain;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.helianto.core.domain.Entity;
import org.helianto.core.domain.PublicEntity;
import org.helianto.document.domain.ProcessDocument;
import org.helianto.document.internal.AbstractVersionableContent;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Contract.
 * 
 * @author mauriciofernandesdecastro
 */

@javax.persistence.Entity
@Table(name = "ord_contract", 
	uniqueConstraints = { @UniqueConstraint(columnNames = {"entityId", "docCode"})}
)
public class Contract 
	extends AbstractVersionableContent 
{

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name="privateEntityId")
	private PublicEntity publicEntity;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="processDocumentId")
	private ProcessDocument processDocument;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date nextCheckDate;
	
	private Double currencyRate;
	
	private Double discountRate;
	
	private int createOrder;
	
	private int createOrderDay;
	
	public String getDiscriminator() {
		return "C";
	}

	/**
	 * Default constructor.
	 */
	public Contract() {
		super();
	}
	
	/**
	 * Key constructor.
	 * 
	 * @param entity
	 * @param docCode
	 */
	public Contract(Entity entity, String docCode) {
		this();
		setEntity(entity);
		setDocCode(docCode);
	}
	
	public PublicEntity getPublicEntity() {
		return publicEntity;
	}
	public void setPublicEntity(PublicEntity publicEntity) {
		this.publicEntity = publicEntity;
	}
	
	/**
	 * Date of contract expiration.
	 */
	public Date getNextCheckDate() {
		return nextCheckDate;
	}
	public void setNextCheckDate(Date nextCheckDate) {
		this.nextCheckDate = nextCheckDate;
	}
	
	/**
	 * Currency rate.
	 */
	public Double getCurrencyRate() {
		return currencyRate;
	}
	public void setCurrencyRate(Double currencyRate) {
		this.currencyRate = currencyRate;
	}
	
	/**
	 * Discount rate applied to the contract.
	 */
	public Double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}
	
	/**
	 * Number of orders to create automatically.
	 */
	public int getCreateOrder() {
		return createOrder;
	}
	public void setCreateOrder(int createOrder) {
		this.createOrder = createOrder;
	}
	
	public int getCreateOrderDay() {
		return createOrderDay;
	}
	public void setCreateOrderDay(int createOrderDay) {
		this.createOrderDay = createOrderDay;
	}
	
	public ProcessDocument getProcessDocument() {
		return processDocument;
	}
	
	public void setProcessDocument(ProcessDocument processDocument) {
		this.processDocument = processDocument;
	}

	/**
	 * Merger.
	 * 
	 * @param command
	 */
	public Contract merge(Contract command) {
		super.merge(command);
		setNextCheckDate(command.getNextCheckDate());
		setCurrencyRate(command.getCurrencyRate());
		setDiscountRate(command.getDiscountRate());
		setCreateOrder(command.getCreateOrder());
		setCreateOrderDay(command.getCreateOrderDay());
		return this;
	}
		
	
	/**
	 * equals
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Contract) {
			return super.equals(other);
		}
		return false;
	}
	
}
