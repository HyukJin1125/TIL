package Hyukjinproj.src.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Hyukjinproj.src.model.AccountVO;
import Hyukjinproj.src.model.UserVO;
import Hyukjinproj.src.service.AccountService;
import Hyukjinproj.src.service.UserService;

public class MyProjMain {

	public static void main(String[] args) {

		UserService userService = UserService.getInstance();
		AccountService accountService = AccountService.getInstance();
		Scanner sc = new Scanner(System.in);

		System.out.println("\n" + "  ___   _____  _____  _____  _   _  _   _  _____  ______  _____  _____  _   __\n"
				+ " / _ \\ /  __ \\/  __ \\|  _  || | | || \\ | ||_   _| | ___ \\|  _  ||  _  || | / /\n"
				+ "/ /_\\ \\| /  \\/| /  \\/| | | || | | ||  \\| |  | |   | |_/ /| | | || | | || |/ / \n"
				+ "|  _  || |    | |    | | | || | | || . ` |  | |   | ___ \\| | | || | | ||    \\ \n"
				+ "| | | || \\__/\\| \\__/\\\\ \\_/ /| |_| || |\\  |  | |   | |_/ /\\ \\_/ /\\ \\_/ /| |\\  \\\n"
				+ "\\_| |_/ \\____/ \\____/ \\___/  \\___/ \\_| \\_/  \\_/   \\____/  \\___/  \\___/ \\_| \\_/\n"
				+ "                                                                              \n"
				+ "                                                                              \n" + "");

		while (true) {
			System.out.println("====================");
			System.out.println("가계부를 작성해보자");
			System.out.println("====================");
			System.out.println("행동을 선택해주세요.");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
			System.out.print(">>> ");

			int command = 0;
			try {
				command = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요");
				continue;
			}

			if (command == 1) {
				// 회원가입
				System.out.println("아이디를 입력해주세요");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요");
				System.out.print(">>> ");
				String pw = sc.nextLine();
				System.out.println("나이를 입력해주세요");
				System.out.print(">>> ");
				int age = Integer.parseInt(sc.nextLine());


				// 중복체크
				boolean isDuple = userService.dupleCheck(id);

				if (isDuple) {
					System.out.println("중복된 아이디 입니다.");
				} else {
					// 회원가입 진행
					int cnt = userService.registMem(new UserVO(id, pw, age));

					if (cnt > 0) {
						System.out.println("회원가입이 성공적으로 이루어졌습니다.");
					} else {
						System.out.println("회원가입 실패. 관리자에게 문의하세요");
					}
				}

			} else if (command == 2) {
				// 로그인
				System.out.println("아이디를 입력해주세요");
				System.out.print(">>> ");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요");
				System.out.print(">>> ");
				String pw = sc.nextLine();

				UserVO login = userService.loginMem(id);

				if (login != null) {
					if (pw.equals(login.getMemPw())) {
						// 로그인 성공
						System.out.println(login.getMemId() + "님 환영합니다.");

						// 가계부 입장
						while (true) {
							System.out.println("행동을 선택해주세요");
							System.out.println("1. 내역 쓰기 | 2. 내역 조회 | 3. 통계 | 4. 로그아웃");
							System.out.print(">>> ");

							int select = 0;
							try {
								select = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e) {
								System.out.println("숫자만 입력해주세요");
								continue;
							}
							int price = 0;
							if (select == 1) {
								// TODO 내역쓰기
								String date1 = "";
								while (true) {
									System.out.println("날짜를 입력해주세요.");
									System.out.println("EX_22.05.29");
									System.out.print(">>> ");
									String date = sc.nextLine();

									SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd");
									try {
										Date day = sdf.parse(date);
										date1 = date;
										break;
									} catch (ParseException e) {
										System.out.println("올바른 형식으로 입력해주세요");
										continue;
									}
								}
								System.out.println("내용을 입력해주세요.");
								System.out.print(">>> ");
								String contents = sc.nextLine();
								System.out.println("금액을 입력해주세요.");
								System.out.print(">>> ");
								price = Integer.parseInt(sc.nextLine());

								AccountVO account = new AccountVO(login.getMemId(),date1,contents,price);
								int count = accountService.writeAccount(account);
																
								if (count > 0) {
									System.out.println("내역 작성이 완료되었습니다.");
								} else {
									System.out.println("내역 작성 실패");
								}

							} else if (select == 2) {
								ArrayList<AccountVO> acList = accountService.getAccount(login.getMemId());
								// TODO 내역조회
								String date1 = "";
								while (true) {
									System.out.println("날짜를 입력해주세요.");
									System.out.println("EX_22.05.29");
									System.out.print(">>> ");
									String date = sc.nextLine();

									SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd");
									try {
										Date day = sdf.parse(date);
										date1 = date;
										break;
									} catch (ParseException e) {
										System.out.println("올바른 형식으로 입력해주세요");
										continue;
									}
								}
								
								System.out.println("=======================================================");
								ArrayList<AccountVO> temp = new ArrayList<>();
								for(int i=0; i<acList.size();i++) {
									if(date1.equals(acList.get(i).getDate())) {
										AccountVO l = new AccountVO(acList.get(i).getId(),acList.get(i).getDate(),acList.get(i).getContents(),acList.get(i).getPrice());
										temp.add(l);
										System.out.print(acList.get(i).getDate()+"\t");
										System.out.print(acList.get(i).getContents()+"\t");
										System.out.println(acList.get(i).getPrice()+"\t");
									}
								}
								if(temp.size()==0) {
									System.out.println("해당 날짜는 존재하지 않습니다.");
								}
								System.out.println("=======================================================");
								

							} else if (select == 3) {
								// TODO 통계
								System.out.println("연령별 평균 사용 금액");
								ArrayList<UserVO> total = userService.totalMem();
								for(int i=0;i<total.size();i++) {
									System.out.println(total.get(i));
								}
							} else if (select == 4) {
								// 로그아웃
								break;
							} else {
								System.out.println("잘못 입력하셨습니다.");
							}
						}
					} else {
						// 로그인 실패
						System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
					}
				} else {
					System.out.println("존재하지 않는 아이디입니다.");
				}
			} else if (command == 3) {
				// 종료
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}

		}

	}

}
