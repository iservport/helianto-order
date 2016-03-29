package org.helianto.order.repository;

import java.io.Serializable;
import java.util.Date;

/**
 * Part assessment adapter.
 * 
 * @author mauriciofernandesdecastro
 */
public class PartAssessmentAdapter 
	implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	public static final String QUERY = "select new "
			+ "org.helianto.order.repository.PartAssessmentAdapter"
			+ "( a_.id" 
			+ ", a_.part.id" 
			+ ", a_.identity.principal" 
			+ ", a_.identity.personalData.firstName " 
			+ ", a_.identity.personalData.lastName " 
			+ ", a_.identity.personalData.gender " 
			+ ", a_.issueDate" 
			+ ", a_.content" 
			+ ", a_.assessmentGrade" 
			+ ") "
			+ "from PartAssessment a_ ";
	
	private int id;
	private int partId; 
	private String identityPrincipal;
	private String identityFirstName;
	private String identityLastName;
	private Character identityGender;
	private Date issueDate; 
	private byte[] content;
	private int assessmentGrade;
	
	/**
	 * Read constructor.
	 * 
	 * @param id
	 * @param partId
	 * @param identityPrincipal
	 * @param identityFirstName
	 * @param identityLastName
	 * @param identityGender
	 * @param issueDate
	 * @param content
	 * @param assessmentGrade
	 */
	public PartAssessmentAdapter(int id
			, int partId
			, String identityPrincipal
			, String identityFirstName
			, String identityLastName
			, Character identityGender
			, Date issueDate
			, byte[] content
			, int assessmentGrade) {
		super();
		this.id = id;
		this.partId = partId;
		this.identityPrincipal = identityPrincipal;
		this.identityFirstName = identityFirstName;
		this.identityLastName = identityLastName;
		this.identityGender = identityGender;
		this.issueDate = issueDate;
		this.content = content;
		this.assessmentGrade = assessmentGrade;
	}
	
	public int getId() {
		return id;
	}

	public int getPartId() {
		return partId;
	}

	public String getIdentityPrincipal() {
		return identityPrincipal;
	}

	public String getIdentityFirstName() {
		return identityFirstName;
	}

	public String getIdentityLastName() {
		return identityLastName;
	}

	public Character getIdentityGender() {
		return identityGender;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public byte[] getContent() {
		return content;
	}
	
	public String getContentAsString() {
		if (getContent()!=null) {
			return new String(getContent());
		}
		return "";
	}
	
	public int getAssessmentGrade() {
		return assessmentGrade;
	}
}
