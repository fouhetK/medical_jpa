package medical.m2i.controller.beans;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import medical.m2i.DAO.UserDAO;
import medical.m2i.model.User;

public class UsersBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserDAO userDAO = new UserDAO();
	private Collection<User> listeUser;
	private User user;

	/**
	 * @return the listeUser
	 */
	public Collection<User> getListeUser() {
		return listeUser;
	}

	/**
	 * @param listeUser the listeUser to set
	 */
	public void setListeUser(Collection<User> listeUser) {
		this.listeUser = listeUser;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public UsersBean() {
		listeUser = userDAO.findAll();

		user = new User();
	}

	public String saveUser() throws ClassNotFoundException {
		user.setPassword(getCryptedPassword(user.getPassword()));

		userDAO.save(user);

		return "/done.xhtml?faces-redirect=true";
	}

	private String getCryptedPassword(String notCryptedPassword) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(UsersBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (md == null)
			return notCryptedPassword;

		md.update(notCryptedPassword.getBytes());

		byte input[] = md.digest();

		// Convert the byte variable to hexadecimal format
		StringBuilder hexaString = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			String hexaChar = Integer.toHexString(0xff & input[i]);
			if (hexaChar.length() == 1)
				hexaString.append('0');
			hexaString.append(hexaChar);
		}
		return hexaString.toString();
	}
}
