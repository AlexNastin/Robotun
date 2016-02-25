package by.robotun.webapp.controller;

public final class URLMapping {
	
	// PAGE
	public static final String MAIN = "main";
	public static final String PHYSICAL_SIGNUP = "login/physical_signup";
	public static final String LEGAL_SIGNUP = "login/legal_signup";
	public static final String ADD_LOT = "lot/add_lot";
	public static final String RESULT = "result";
	public static final String LOT = "lot/lot";
	
	// FORWARD
	public static final String FORWARD_ADD_USER_PHYSICAL_TO_DB = "forward:/addUserPhysicalToDB";
	public static final String FORWARD_ADD_USER_LEGAL_TO_DB = "forward:/addUserLegalToDB";
	public static final String FORWARD_ADD_LOT_TO_DB = "forward:/user/addLotToDB";
	
	// REDIRECT
	public static final String REDIRECT_MAIN = "redirect:/";
	public static final String REDIRECT_ADD_LOT = "redirect:/user/addLot";
}
