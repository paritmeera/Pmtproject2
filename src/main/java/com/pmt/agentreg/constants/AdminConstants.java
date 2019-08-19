package com.pmt.agentreg.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminConstants {
	
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final String ALPHA_NUMERIC = "0123456789";
	private static final SimpleDateFormat date = new SimpleDateFormat("ddMM");
	
	public static String password() {
		int count = 8;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC.length());
			builder.append(ALPHA_NUMERIC.charAt(character));
		}
		String id = builder.toString();
		return id;
	}
	
	
	public static String uniqueCustomerId() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC.length());
			builder.append(ALPHA_NUMERIC.charAt(character));
		}
		String id = builder.toString();
		return id;
	}
	
	public static String uniqueCreditNoteId() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		
		String creditdate = date.format(new Date().getTime());
		
		String id = "CN" + creditdate + builder.toString();
		return id;
	}
	
	public static String uniqueDebitNoteId() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		
		String debitdate = date.format(new Date().getTime());
		
		String id = "DN" + debitdate + builder.toString();
		return id;
	}
	
	
	public static String uniqueSupplierId() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC.length());
			builder.append(ALPHA_NUMERIC.charAt(character));
		}
		
		String id = "SUP"  + builder.toString();
		return id;
	}
	
	public static String uniqueTransactionId() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM");
		String dates = formatter.format(date);

		String id = "FB" + dates + builder.toString();

		return id;
	}
	
	public static String uniquePaymentTransactionId() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC.length());
			builder.append(ALPHA_NUMERIC.charAt(character));
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM");
		String dates = formatter.format(date);

		String id = "PT" + dates + builder.toString();

		return id;
	}
	
	
	
	
	public static String uniqueVisaId() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC.length());
			builder.append(ALPHA_NUMERIC.charAt(character));
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM");
		String dates = formatter.format(date);

		String id = "VI" + dates + builder.toString();

		return id;
	}
	
	public static String uniquePassportId() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC.length());
			builder.append(ALPHA_NUMERIC.charAt(character));
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM");
		String dates = formatter.format(date);

		String id = "PS" + dates + builder.toString();

		return id;
	}
	
	/*public static String uniqueMiscId() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC.length());
			builder.append(ALPHA_NUMERIC.charAt(character));
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM");
		String dates = formatter.format(date);

		String id = "MI" + dates + builder.toString();

		return id;
	}*/
	
	
	public static String uniqueBusBooking() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC.length());
			builder.append(ALPHA_NUMERIC.charAt(character));
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM");
		String dates = formatter.format(date);

		String id = "BS" + dates + builder.toString();

		return id;
	}
	
	public static String uniqueHotelBooking() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC.length());
			builder.append(ALPHA_NUMERIC.charAt(character));
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM");
		String dates = formatter.format(date);

		String id = "HB" + dates + builder.toString();

		return id;
	}

	public static String uniqueFlightCancellation() {
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM");
		String dates = formatter.format(date);

		String id = "FC" + dates + builder.toString();

		return id;
	}



}
