package by.robotun.webapp.controller;

public final class URLMapping {
	
	// PAGE
	public static final String JSP_MAIN = "main";
	public static final String JSP_ADD_LOT = "lot/add_lot";
	public static final String JSP_RESULT = "result";
	public static final String JSP_LOT = "lot/lot";
	public static final String JSP_SIGNUP = "login/signup";
	
	public static final String JSP_PROFILE_MAIN_ADMIN = "profile/admin/profile_main_admin";
	
	public static final String JSP_PROFILE_MAIN_LEGAL = "profile/legal/profile_main_legal";
	
	public static final String JSP_PROFILE_MAIN_PHYSICAL = "profile/physical/profile_main_physical";
	
	public static final String JSP_PROFILE_MAIN_MODERATOR = "profile/moderator/profile_main_moderator";
	
	// FORWARD
	public static final String FORWARD_ADD_USER_PHYSICAL_TO_DB = "forward:/addUserPhysicalToDB";
	public static final String FORWARD_ADD_USER_LEGAL_TO_DB = "forward:/addUserLegalToDB";
	public static final String FORWARD_ADD_LOT_TO_DB = "forward:/user/addLotToDB";
	
	// REDIRECT
	public static final String REDIRECT_MAIN = "redirect:/";
	public static final String REDIRECT_ADD_LOT = "redirect:/user/addLot";
}
