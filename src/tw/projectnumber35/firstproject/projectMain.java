package tw.projectnumber35.firstproject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.json.JSONException;

public class projectMain {

	public static void main(String[] args) throws IOException, SQLException, JSONException {
		while (true) {
			before: {
				System.out.println("1.登入帳號");
				System.out.println("2.註冊帳號");
				System.out.println("3.忘記密碼");
				System.out.println("4.離開");

				Scanner choose_sca = new Scanner(System.in);
				int choose = choose_sca.nextInt();
				if (choose == 1) {
					System.out.println("請輸入您的帳號或輸入#回上一頁");
					Scanner account_sca = new Scanner(System.in);
					String account = account_sca.next();
					if ("#".equals(account)) {
						break before;
					}
					System.out.println("請輸入您的密碼或輸入#回上一頁");
					Scanner password_sca = new Scanner(System.in);
					String password = password_sca.next();
					if ("#".equals(password)) {
						break before;
					}

					IMemberDao mem1 = MemberDaoFactory.createMember();
					Member member_set = new Member();
					member_set.setAccount(account);
					member_set.setPassword(password);
					mem1.createConn();
					int status = mem1.fintById(member_set);
					if (status != 0) {
						System.out.println("1.存入資料");
						System.out.println("2.輸出json檔");
						Scanner member_choose_sca = new Scanner(System.in);
						int member_choose = member_choose_sca.nextInt();

						if (member_choose == 1) {
							System.out.println("1.以現有json檔存入資料");
							System.out.println("2.以輸入資料的方式存入");
							System.out.println("3.修改資料");
							Scanner choose_sca_createdata = new Scanner(System.in);
							int choose_sca_createdata_int = choose_sca_createdata.nextInt();

							if (choose_sca_createdata_int == 1) {
								System.out.println("請輸入您的json檔案路徑");
								Scanner JsonPath_sca = new Scanner(System.in);
								String JsonPath = JsonPath_sca.next();

								JsonReadForFile j = new JsonReadForFile();
								List<Libero> jlist = j.getJsonFile(JsonPath);
								ILiberoDio LBDF = LiberoDaoFactory.createLibero();
								LBDF.createConn();
								LBDF.addArrayList(jlist, status);
								LBDF.closeConn();
							} else if (choose_sca_createdata_int == 2) {
								ILiberoDio LBDF = LiberoDaoFactory.createLibero();
								LBDF.createConn();
								LBDF.add(status);
								LBDF.closeConn();
							} else if (choose_sca_createdata_int == 3) {
								ILiberoDio LBDF = LiberoDaoFactory.createLibero();
								LBDF.createConn();
								LBDF.update();
								;
								LBDF.closeConn();
							}

						} else if (member_choose == 2) {
							ILiberoDio LBDF = LiberoDaoFactory.createLibero();
							LBDF.createConn();
							LBDF.FindById(status);
							LBDF.closeConn();

						}

					}
					mem1.closeConn();

				} else if (choose == 2) {
					System.out.println("請輸入帳號");
					Scanner account_sca = new Scanner(System.in);
					String account = account_sca.next();
					System.out.println("請輸入密碼");
					Scanner password_sca = new Scanner(System.in);
					String password = password_sca.next();
					System.out.println("請輸入認證碼(忘記密碼用)");
					Scanner verificationCode_sca = new Scanner(System.in);
					int verificationCode = verificationCode_sca.nextInt();

					IMemberDao mem1 = MemberDaoFactory.createMember();
					Member member_set = new Member();
					member_set.setAccount(account);
					member_set.setPassword(password);
					member_set.setVerificationCode(verificationCode);
					mem1.createConn();
					mem1.add(member_set);
					mem1.closeConn();
				} else if (choose == 3) {
					System.out.println("請輸入帳號");
					Scanner account_sca = new Scanner(System.in);
					String account = account_sca.next();
					System.out.println("請輸入認證碼");
					Scanner verificationCode_sca = new Scanner(System.in);
					int verificationCode = verificationCode_sca.nextInt();

					IMemberDao mem1 = MemberDaoFactory.createMember();
					mem1.createConn();
					Member member_set = new Member();
					member_set.setAccount(account);

					member_set.setVerificationCode(verificationCode);
					int MemberID = mem1.checkAccount(member_set);
					if (MemberID != 0) {

						System.out.println("請輸入新的密碼");
						Scanner newPWD_sca = new Scanner(System.in);
						String PWD = newPWD_sca.next();
						member_set.setNewpassword(PWD);
						mem1.update(member_set);
					} else {
						System.out.println("帳號或認證碼錯誤");

					}
					mem1.closeConn();
				} else {
					System.exit(1);
				}

			}
		}
	}
}
