package  com.upgrad.quora.service.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "users", schema = "quora")
@NamedQueries(
        {
                @NamedQuery(name = "userByUuid", query = "select u from UserEntity u where u.uuid = :uuid"),
                @NamedQuery(name = "userByEmail", query = "select u from UserEntity u where u.email =:email")
        }
)


public class UserEntity implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uuid")
    @Size(max = 64)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "role")
    private RoleEntity role;

    @Column(name = "email")
    @NotNull
    @Size(max = 200)
    private String email;

    //@ToStringExclude
    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    @NotNull
    @Size(max = 200)
    private String firstName;

    @Column(name = "username")
    @NotNull
    @Size(max = 200)
    private String userName;
   
    @Column(name = "country")
    @NotNull
    @Size(max = 200)
    private String country;
    
    @Column(name = "aboutme")
    @NotNull
    @Size(max = 200)
    private String aboutme;
    
    @Column(name = "dob")
    @NotNull
    @Size(max = 200)
    private String dob;
    
    @Column(name = "lastname")
    @NotNull
    @Size(max = 200)
    private String lastName;

    @Column(name = "contactnumber")
    @NotNull
    @Size(max = 50)
    private String mobilePhone;

  
  
    @Column(name = "salt")
    @NotNull
    @Size(max = 200)
    //@ToStringExclude
    private String salt;

  
    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

  

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}



	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	/**
	 * @return the role
	 */
	public RoleEntity getRole() {
		return role;
	}



	/**
	 * @param role the role to set
	 */
	public void setRole(RoleEntity role) {
		this.role = role;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}



	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}



	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}



	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}



	/**
	 * @return the aboutme
	 */
	public String getAboutme() {
		return aboutme;
	}



	/**
	 * @param aboutme the aboutme to set
	 */
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}



	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}



	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}



	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}



	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}



	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}



	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}



	@Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }


}