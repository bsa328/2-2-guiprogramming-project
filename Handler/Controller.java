package Handler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DB.ATMDao;

public class Controller extends JPanel implements ActionListener {
	MainView mainView;
	AccountCreation accountCreation;
	Deposit deposit;
	Withdraw withdraw;
	BankTransfer bankTransfer;
	DisplayBalance displayBalance;
	DeleteAcc deleteAcc;
	ATMDao dao;
	Acc acc; // 생성 창
	In in; // 입금 창
	Out out; // 출금 창
	Go go; // 이체 창
	Money mon; // 잔액 창
	Del del; // 삭제 창
	Big big; // 저시력자용 창
	boolean check;

	public Controller() {
		check = true;
		dao = new ATMDao();
		mainView = new MainView();
		accountCreation = new AccountCreation();
		deposit = new Deposit();
		withdraw = new Withdraw();
		bankTransfer = new BankTransfer();
		displayBalance = new DisplayBalance();
		deleteAcc = new DeleteAcc();
		big = new Big();

		mainView.btnAccountCreation.addActionListener(this);
		accountCreation.btnJoin.addActionListener(this);
		accountCreation.btnBack.addActionListener(this);

		mainView.btnDeposit.addActionListener(this);
		deposit.btnJoin.addActionListener(this);
		deposit.btnBack.addActionListener(this);

		mainView.btnWithdraw.addActionListener(this);
		withdraw.btnJoin.addActionListener(this);
		withdraw.btnBack.addActionListener(this);

		mainView.btnBankTransfer.addActionListener(this);
		bankTransfer.btnJoin.addActionListener(this);
		bankTransfer.btnBack.addActionListener(this);

		mainView.btnDisplayBalance.addActionListener(this);
		displayBalance.btnJoin.addActionListener(this);
		displayBalance.btnBack.addActionListener(this);

		mainView.btnDeleteAcc.addActionListener(this);
		deleteAcc.btnJoin.addActionListener(this);
		deleteAcc.btnBack.addActionListener(this);

		mainView.btnBig.addActionListener(this);
		big.btnBankTransfer.addActionListener(this);
		big.btnDeposit.addActionListener(this);
		big.btnDisplayBalance.addActionListener(this);
		big.btnWithdraw.addActionListener(this);
		big.btnSmall.addActionListener(this);

		this.setLayout(new BorderLayout());
		this.add(mainView);
		dao.allSelect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();

		if (btn == mainView.btnAccountCreation) {
			this.remove(mainView);
			this.add(accountCreation);
			updateUI();
		} else if (btn == accountCreation.btnJoin) { 
			/*
			 * 확인 버튼을 누르면은 텍스트 필드에 내용을 Dao 에 있는 accountInsert 메소드에 값을 넘겨주고
			 * 쿼리문을 실행합니다. 
			 * 
			 * 
			 * */
			String accBk = accountCreation.tfBank.getText();
			String accId = accountCreation.tfAccountId.getText();
			String accPw = accountCreation.pfAccountPwd.getText();
			String accN = accountCreation.tfName.getText();
			if (accId.length() < 4) {
				accountCreation.lbId.setText("4자리 이상"); // 그리고 accountInsert가 실행되기전에 계좌번호의 길이를 비교해 4자리 미만이면 생성을 막습니다
			} else {
				acc = new Acc();
				String result = dao.accountInsert(accBk, accId, accPw, accN);
				acc.lbBank.setText("생성된 은행 : " + accBk);
				acc.lbAcc.setText("생성된 계좌 : " + accId);
				accountCreation.tfBank.setText("");
				accountCreation.tfAccountId.setText("");
				accountCreation.pfAccountPwd.setText("");
				accountCreation.tfName.setText("");
				accountCreation.lbId.setText("");
				acc.btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						acc.dispose();
					}
				});
			}
		} else if (btn == accountCreation.btnBack) {
			accountCreation.tfBank.setText("");
			accountCreation.tfAccountId.setText("");
			accountCreation.pfAccountPwd.setText("");
			accountCreation.tfName.setText("");
			this.remove(accountCreation);
			this.add(mainView);
			updateUI();
		} else if (btn == mainView.btnDeposit) {
			this.remove(mainView);
			this.add(deposit);
			updateUI();
		} else if (btn == deposit.btnJoin) { // 입금
			String dpBk = deposit.tfBank.getText();
			String dpId = deposit.tfAccountId.getText();
			String dpPw = deposit.pfAccountPwd.getText();
			String dpAm = deposit.tfAmountDeposit.getText();
			/*
			 * 입금화면에 확인 버튼을 눌렀을때 입력된 정보가 잘못되면은
			 * 입력된 정보가 잘못되었다고 창을 띄웁니다. 정보가 맞으면은 dao의 updateDeposit 실행
			 * */
			if (dao.accSelect(dpBk, dpId, dpPw) == null || dpAm == null) {
				JOptionPane.showMessageDialog(null, "입력된 정보가 잘못되었습니다.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				in = new In();
				String result = dao.updateDeposit(dpAm, dpId, dpPw, dpBk);
				System.out.println("잔액 : " + result);
				in.lbIn.setText("입금      금액 : " + dpAm + "원");
				in.lbMoney.setText("입금 후 잔액 : " + result + "원");
				deposit.tfBank.setText("");
				deposit.tfAccountId.setText("");
				deposit.pfAccountPwd.setText("");
				deposit.tfAmountDeposit.setText("");
				in.btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						in.dispose();
					}
				});
			}
		} else if (btn == deposit.btnBack) {
			deposit.tfBank.setText("");
			deposit.tfAccountId.setText("");
			deposit.pfAccountPwd.setText("");
			deposit.tfAmountDeposit.setText("");
			if (check) {
				this.remove(deposit);
				this.add(mainView);
				updateUI();
			} else {
				this.remove(deposit);
				this.add(big);
				updateUI();
			}
		} else if (btn == mainView.btnWithdraw) {
			this.remove(mainView);
			this.add(withdraw);
			updateUI();
		} else if (btn == withdraw.btnJoin) {
			String wdBk = withdraw.tfBank.getText();
			String wdId = withdraw.tfAccountId.getText();
			String wdPw = withdraw.pfAccountPwd.getText();
			String wdAm = withdraw.tfAmountWithdraw.getText();
			/*
			 * 출금화면에 확인 버튼을 눌렀을때 입력된 정보가 잘못되면은
			 * 입력된 정보가 잘못되었다고 창을 띄웁니다. 정보가 맞으면은 dao의 updateWithdraw 실행
			 * */
			if (dao.accSelect(wdBk, wdId, wdPw) == null || wdAm == null) {
				JOptionPane.showMessageDialog(null, "입력된 정보가 잘못되었습니다.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else if (Integer.parseInt((dao.accSelect(wdBk, wdId, wdPw))) < Integer.parseInt(wdAm)) { // 잔액이 부족할때
				JOptionPane.showMessageDialog(null, "잔액이 부족합니다.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				out = new Out();
				String result = dao.updateWithdraw(wdAm, wdId, wdPw, wdBk);
				System.out.println("잔액 : " + result);
				out.lbOut.setText("출금      금액 : " + wdAm + "원");
				out.lbMoney.setText("출금 후 잔액 : " + result + "원");
				withdraw.tfAmountWithdraw.setText("");
				withdraw.tfAccountId.setText("");
				withdraw.pfAccountPwd.setText("");
				withdraw.tfBank.setText("");
				out.btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						out.dispose();
					}
				});
			}
		} else if (btn == withdraw.btnBack) {
			withdraw.tfAmountWithdraw.setText("");
			withdraw.tfAccountId.setText("");
			withdraw.pfAccountPwd.setText("");
			withdraw.tfBank.setText("");
			if (check) {
				this.remove(withdraw);
				this.add(mainView);
				updateUI();
			} else {
				this.remove(withdraw);
				this.add(big);
				updateUI();
			}
		} else if (btn == mainView.btnBankTransfer) {
			this.remove(mainView);
			this.add(bankTransfer);
			updateUI();
		} else if (btn == bankTransfer.btnJoin) { // 계좌이체
			String btMbk = bankTransfer.tfMyBank.getText();
			String btMacc = bankTransfer.tfMyacc.getText();
			String btPw = bankTransfer.pfAccountPwd.getText();
			String btYbk = bankTransfer.tfYouBank.getText();
			String Yacc = bankTransfer.tfYouacc.getText();
			String btAccm = bankTransfer.tfAccMoney.getText();
			if (dao.accSelect(btMbk, btMacc, btPw) == null || dao.accSelect(btYbk, Yacc, null) == null) {
				JOptionPane.showMessageDialog(null, "입력된 정보가 잘못되었습니다.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else if (Integer.parseInt(btAccm) > Integer.parseInt(dao.accSelect(btMbk, btMacc, btPw))) {
				JOptionPane.showMessageDialog(null, "잔액이 부족합니다.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				go = new Go();
				dao.updateTransfer(btMbk, btMacc, btPw, btAccm, btYbk, Yacc);
				go.lbMoney.setText("이체    금액 : " + btAccm + "원");
				go.lbTo.setText("받는이 계좌: " + Yacc);
				bankTransfer.tfMyBank.setText("");
				bankTransfer.tfMyacc.setText("");
				bankTransfer.pfAccountPwd.setText("");
				bankTransfer.tfAccMoney.setText("");
				bankTransfer.tfYouBank.setText("");
				bankTransfer.tfYouacc.setText("");
				go.btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						go.dispose();
					}
				});
			}
		} else if (btn == bankTransfer.btnBack) {
			bankTransfer.tfMyBank.setText("");
			bankTransfer.tfMyacc.setText("");
			bankTransfer.pfAccountPwd.setText("");
			bankTransfer.tfAccMoney.setText("");
			bankTransfer.tfYouBank.setText("");
			bankTransfer.tfYouacc.setText("");
			if (check) {
				this.remove(bankTransfer);
				this.add(mainView);
				updateUI();
			} else {
				this.remove(bankTransfer);
				this.add(big);
				updateUI();
			}
		} else if (btn == mainView.btnDisplayBalance) {
			this.remove(mainView);
			this.add(displayBalance);
			updateUI();
		} else if (btn == displayBalance.btnJoin) { // 잔액 조회
			String dbBk = displayBalance.tfBank.getText();
			String dbId = displayBalance.tfAccountId.getText();
			String dbPw = displayBalance.pfAccountPwd.getText();
			if (dao.accSelect(dbBk, dbId, dbPw) == null) {
				JOptionPane.showMessageDialog(null, "입력된 정보가 잘못되었습니다.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				mon = new Money();
				String money = dao.accSelect(dbBk, dbId, dbPw);
				mon.lbBank.setText("은        행 : " + dbBk);
				mon.lbAcc.setText("계좌번호 : " + dbId);
				mon.lbMoney.setText("잔        액 : " + dao.accSelect(dbBk, dbId, dbPw) + "원");
				displayBalance.tfBank.setText("");
				displayBalance.tfAccountId.setText("");
				displayBalance.pfAccountPwd.setText("");
				System.out.println("잔액 : " + money);
				mon.btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						mon.dispose();
					}
				});
			}
		} else if (btn == displayBalance.btnBack) {
			displayBalance.tfBank.setText("");
			displayBalance.tfAccountId.setText("");
			displayBalance.pfAccountPwd.setText("");
			if (check) {
				this.remove(displayBalance);
				this.add(mainView);
				updateUI();
			} else {
				this.remove(displayBalance);
				this.add(big);
				updateUI();
			}
		} else if (btn == mainView.btnDeleteAcc) {
			this.remove(mainView);
			this.add(deleteAcc);
			updateUI();
		} else if (btn == deleteAcc.btnJoin) { // 계좌 삭제
			String dlBk = deleteAcc.tfBank.getText();
			String dlId = deleteAcc.tfAccountId.getText();
			String dlPw = deleteAcc.pfAccountPwd.getText();
			if (dao.accSelect(dlBk, dlId, dlPw) == null) {
				JOptionPane.showMessageDialog(null, "입력된 정보가 잘못되었습니다.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else if (Integer.parseInt((dao.accSelect(dlBk, dlId, dlPw))) > 0) {
				JOptionPane.showMessageDialog(null, "잔액이 남아있어 삭제가 불가능합니다.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				del = new Del();
				String result = dao.accDelete(dlBk, dlId, dlPw);
				del.lbBank.setText("삭제된 은행 : " + dlBk);
				del.lbAcc.setText("삭제된 계좌 : " + dlId);
				deleteAcc.tfBank.setText("");
				deleteAcc.tfAccountId.setText("");
				deleteAcc.pfAccountPwd.setText("");
				del.btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						del.dispose();
					}
				});
			}
		} else if (btn == deleteAcc.btnBack) {
			deleteAcc.tfBank.setText("");
			deleteAcc.tfAccountId.setText("");
			deleteAcc.pfAccountPwd.setText("");
			this.remove(deleteAcc);
			this.add(mainView);
			updateUI();
		} else if (btn == mainView.btnBig) {
			this.remove(mainView);
			this.add(big);
			check = !check;
			updateUI();
		} else if (btn == big.btnSmall) {
			this.remove(big);
			this.add(mainView);
			check = !check;
			updateUI();
		} else if (btn == big.btnDeposit) { // 큰버튼 입금
			this.remove(big);
			this.add(deposit);
			updateUI();
		} else if (btn == big.btnWithdraw) { // 큰버튼 출금
			this.remove(big);
			this.add(withdraw);
			updateUI();
		} else if (btn == big.btnBankTransfer) { // 큰 버튼 계좌 이체
			this.remove(big);
			this.add(bankTransfer);
			updateUI();
		} else if (btn == big.btnDisplayBalance) { // 큰버튼 잔액조회
			this.remove(big);
			this.add(displayBalance);
			updateUI();
		}
	}

}
