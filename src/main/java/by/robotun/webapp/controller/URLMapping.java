package by.robotun.webapp.controller;

public final class URLMapping {

	/**
	 * Pages
	 */
	public static final String JSP_MAIN = "main";
	public static final String JSP_LOGIN = "login/login";
	public static final String JSP_ADD_LOT = "lot/add_lot";
	public static final String JSP_UPDATE_LOT = "lot/update_lot";
	public static final String JSP_RESULT = "result";
	public static final String JSP_LOT = "lot/lot";
	public static final String JSP_ARCHIVE_LOT = "lot/archive_lot";
	public static final String JSP_SIGNUP_PHYSICAL = "login/signupPhysical";
	public static final String JSP_SIGNUP_LEGAL = "login/signupLegal";
	
	public static final String JSP_FOOTER_RULES = "footer/rules";
	
	public static final String JSP_PROFILE_MAIN_ADMIN = "profile/admin/profile_main_admin";
	public static final String JSP_PROFILE_ADMIN_ADD_MODERATOR = "profile/admin/admin_add_moderator";
	public static final String JSP_PROFILE_VIEW = "profile/profile_view";

	public static final String JSP_PROFILE_RESPONSES_LEGAL = "profile/legal/profile_responses_legal";
	public static final String JSP_PROFILE_PERSONAL_LEGAL = "profile/legal/profile_personal_legal";
	public static final String JSP_PROFILE_LOTS_LEGAL = "profile/legal/profile_lots_legal";
	public static final String JSP_PROFILE_LOTS_ON_UPDATE_LEGAL = "profile/legal/profile_lots_on_update_legal";
	public static final String JSP_PROFILE_ARCHIVE_LOTS_LEGAL = "profile/legal/profile_archive_lots_legal";

	public static final String JSP_PROFILE_LOTS_PHYSICAL = "profile/physical/profile_lots_physical";
	public static final String JSP_PROFILE_PERSONAL_PHYSICAL = "profile/physical/profile_personal_physical";
	public static final String JSP_PROFILE_RESPONSES_PHYSICAL = "profile/physical/profile_responses_physical";
	public static final String JSP_PROFILE_LOTS_ON_UPDATE_PHYSICAL = "profile/physical/profile_lots_on_update_physical";
	public static final String JSP_PROFILE_ARCHIVE_LOTS_PHYSICAL = "profile/physical/profile_archive_lots_physical";

	public static final String JSP_PROFILE_MAIN_MODERATOR = "profile/moderator/profile_main_moderator";
	public static final String JSP_PROFILE_MODERATOR_REJECT_LOT = "profile/moderator/moderator_reject_lot";

	public static final String JSP_PROFILE_PHYSICAL_UPDATE_PASSWORD = "profile/physical/profile_update_password";
	public static final String JSP_PROFILE_LEGAL_UPDATE_PASSWORD = "profile/legal/profile_update_password";
	public static final String JSP_PROFILE_MODERATOR_UPDATE_PASSWORD = "profile/moderator/profile_update_password";
	public static final String JSP_PROFILE_ADMIN_UPDATE_PASSWORD = "profile/admin/profile_update_password";
	
	/**
	 * Redirects
	 */
	public static final String REDIRECT_MAIN = "redirect:/";
	public static final String REDIRECT_INDEX = "redirect:/index";
	public static final String REDIRECT_PROFILE_LOTS_PHYSICAL = "redirect:/physical/profile/myLots";
	public static final String REDIRECT_PROFILE_LOTS_LEGAL = "redirect:/legal/profile/myLots";
	public static final String REDIRECT_PROFILE_MAIN_ADMIN = "redirect:/admin/profile";
	public static final String REDIRECT_PROFILE_MAIN_MODERATOR = "redirect:/moderator/profile";
	
	/**
	 * Error pages
	 */
	public static final String JSP_ERROR_ON_MODERATION = "error/error_on_moderation";
	public static final String JSP_ERROR_404 = "error/error404";
	public static final String JSP_ERROR_403 = "error/error403";
	public static final String JSP_ERROR_500 = "error/error500";
}
