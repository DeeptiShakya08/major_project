package utils;

public class CacheUtil {
	
	public static  String adoptorMail = null;
	public static String donorMail = null;
	public static String adoptorPassword = null;

	public static String getDonorMail() {
		return donorMail;
	}
	public static void setDonorMail(String donorMail) {
		CacheUtil.donorMail = donorMail;
	}
	public static String getAdoptorPassword() {
		return adoptorPassword;
	}
	public static void setAdoptorPassword(String adoptorPassword) {
		CacheUtil.adoptorPassword = adoptorPassword;
	}
	public static String getAdoptorMail() {
		return adoptorMail;
	}
	public static void  setAdoptorMail(String mail) {
		adoptorMail = mail;
	}
}
