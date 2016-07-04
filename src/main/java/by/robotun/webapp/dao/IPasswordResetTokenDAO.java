package by.robotun.webapp.dao;

import java.util.List;

import by.robotun.webapp.domain.PasswordResetToken;
import by.robotun.webapp.exception.DaoException;



public interface IPasswordResetTokenDAO {

	public void updatePasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException;

	public void insertPasswordResetToken(PasswordResetToken passwordResetToken)
			throws DaoException;

	public List<PasswordResetToken> selectAllPasswordResetTokens()
			throws DaoException;

	public void deletePasswordResetToken(Integer idToken) throws DaoException;
	
	public PasswordResetToken selectTokenByUser(Integer idUser) throws DaoException;

	public PasswordResetToken selectTokenByToken(String token) throws DaoException;

}
