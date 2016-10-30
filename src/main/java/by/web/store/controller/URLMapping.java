package by.web.store.controller;

public class URLMapping {
	
	/**
	 * Pages
	 */
	public static final String JSP_MAIN = "main";
	public static final String JSP_ADMIN_MAIN = "cabinet/admin/main";
	public static final String JSP_ADMIN_ADD_USER = "cabinet/admin/add_user";
	public static final String JSP_USER_MAIN = "cabinet/user/main";
	public static final String JSP_USER_ADD_PRODUCT = "cabinet/user/add_product";
	public static final String JSP_LOGIN = "cabinet/login";
	
	/**
	 * Redirects
	 */
	public static final String REDIRECT_ADMIN_MAIN = "redirect:/private/admin/main";
	public static final String REDIRECT_USER_MAIN = "redirect:/private/user/main";
	
	/**
	 * Error pages
	 */
	public static final String JSP_ERROR_404 = "error/error404";
	public static final String JSP_ERROR_403 = "error/error403";
	public static final String JSP_ERROR_500 = "error/error500";

}
