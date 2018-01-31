package br.com.mm.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "SHO_SHOPPING")
@AttributeOverrides({ @AttributeOverride(name = AbstractEntity.PK, column = @Column(name = Shopping.PK)) })
public class Shopping extends AbstractEntity<Long> {

    private static final long serialVersionUID = -6843255675459467096L;

    public static final String PK = "SHO_ID";

    @Lob
    @Column(name = "SHO_API_RESPONSE", nullable = false)
    private String apiResponse;

    public String getApiResponse() {
	return apiResponse;
    }

    public void setApiResponse(String apiResponse) {
	this.apiResponse = apiResponse;
    }

}
