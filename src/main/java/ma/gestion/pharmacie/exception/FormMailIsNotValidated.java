package ma.gestion.pharmacie.exception;

import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLException;

public class FormMailIsNotValidated extends ConstraintViolationException {

	public FormMailIsNotValidated(String message, SQLException root, String constraintName) {
		super(message, root, constraintName);
		// TODO Auto-generated constructor stub
	}

}
