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
	Acc acc; // ���� â
	In in; // �Ա� â
	Out out; // ��� â
	Go go; // ��ü â
	Money mon; // �ܾ� â
	Del del; // ���� â
	Big big; // ���÷��ڿ� â
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
			 * Ȯ�� ��ư�� �������� �ؽ�Ʈ �ʵ忡 ������ Dao �� �ִ� accountInsert �޼ҵ忡 ���� �Ѱ��ְ�
			 * �������� �����մϴ�. 
			 * 
			 * 
			 * */
			String accBk = accountCreation.tfBank.getText();
			String accId = accountCreation.tfAccountId.getText();
			String accPw = accountCreation.pfAccountPwd.getText();
			String accN = accountCreation.tfName.getText();
			if (accId.length() < 4) {
				accountCreation.lbId.setText("4�ڸ� �̻�"); // �׸��� accountInsert�� ����Ǳ����� ���¹�ȣ�� ���̸� ���� 4�ڸ� �̸��̸� ������ �����ϴ�
			} else {
				acc = new Acc();
				String result = dao.accountInsert(accBk, accId, accPw, accN);
				acc.lbBank.setText("������ ���� : " + accBk);
				acc.lbAcc.setText("������ ���� : " + accId);
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
		} else if (btn == deposit.btnJoin) { // �Ա�
			String dpBk = deposit.tfBank.getText();
			String dpId = deposit.tfAccountId.getText();
			String dpPw = deposit.pfAccountPwd.getText();
			String dpAm = deposit.tfAmountDeposit.getText();
			/*
			 * �Ա�ȭ�鿡 Ȯ�� ��ư�� �������� �Էµ� ������ �߸��Ǹ���
			 * �Էµ� ������ �߸��Ǿ��ٰ� â�� ���ϴ�. ������ �������� dao�� updateDeposit ����
			 * */
			if (dao.accSelect(dpBk, dpId, dpPw) == null || dpAm == null) {
				JOptionPane.showMessageDialog(null, "�Էµ� ������ �߸��Ǿ����ϴ�.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				in = new In();
				String result = dao.updateDeposit(dpAm, dpId, dpPw, dpBk);
				System.out.println("�ܾ� : " + result);
				in.lbIn.setText("�Ա�      �ݾ� : " + dpAm + "��");
				in.lbMoney.setText("�Ա� �� �ܾ� : " + result + "��");
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
			 * ���ȭ�鿡 Ȯ�� ��ư�� �������� �Էµ� ������ �߸��Ǹ���
			 * �Էµ� ������ �߸��Ǿ��ٰ� â�� ���ϴ�. ������ �������� dao�� updateWithdraw ����
			 * */
			if (dao.accSelect(wdBk, wdId, wdPw) == null || wdAm == null) {
				JOptionPane.showMessageDialog(null, "�Էµ� ������ �߸��Ǿ����ϴ�.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else if (Integer.parseInt((dao.accSelect(wdBk, wdId, wdPw))) < Integer.parseInt(wdAm)) { // �ܾ��� �����Ҷ�
				JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				out = new Out();
				String result = dao.updateWithdraw(wdAm, wdId, wdPw, wdBk);
				System.out.println("�ܾ� : " + result);
				out.lbOut.setText("���      �ݾ� : " + wdAm + "��");
				out.lbMoney.setText("��� �� �ܾ� : " + result + "��");
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
		} else if (btn == bankTransfer.btnJoin) { // ������ü
			String btMbk = bankTransfer.tfMyBank.getText();
			String btMacc = bankTransfer.tfMyacc.getText();
			String btPw = bankTransfer.pfAccountPwd.getText();
			String btYbk = bankTransfer.tfYouBank.getText();
			String Yacc = bankTransfer.tfYouacc.getText();
			String btAccm = bankTransfer.tfAccMoney.getText();
			if (dao.accSelect(btMbk, btMacc, btPw) == null || dao.accSelect(btYbk, Yacc, null) == null) {
				JOptionPane.showMessageDialog(null, "�Էµ� ������ �߸��Ǿ����ϴ�.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else if (Integer.parseInt(btAccm) > Integer.parseInt(dao.accSelect(btMbk, btMacc, btPw))) {
				JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				go = new Go();
				dao.updateTransfer(btMbk, btMacc, btPw, btAccm, btYbk, Yacc);
				go.lbMoney.setText("��ü    �ݾ� : " + btAccm + "��");
				go.lbTo.setText("�޴��� ����: " + Yacc);
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
		} else if (btn == displayBalance.btnJoin) { // �ܾ� ��ȸ
			String dbBk = displayBalance.tfBank.getText();
			String dbId = displayBalance.tfAccountId.getText();
			String dbPw = displayBalance.pfAccountPwd.getText();
			if (dao.accSelect(dbBk, dbId, dbPw) == null) {
				JOptionPane.showMessageDialog(null, "�Էµ� ������ �߸��Ǿ����ϴ�.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				mon = new Money();
				String money = dao.accSelect(dbBk, dbId, dbPw);
				mon.lbBank.setText("��        �� : " + dbBk);
				mon.lbAcc.setText("���¹�ȣ : " + dbId);
				mon.lbMoney.setText("��        �� : " + dao.accSelect(dbBk, dbId, dbPw) + "��");
				displayBalance.tfBank.setText("");
				displayBalance.tfAccountId.setText("");
				displayBalance.pfAccountPwd.setText("");
				System.out.println("�ܾ� : " + money);
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
		} else if (btn == deleteAcc.btnJoin) { // ���� ����
			String dlBk = deleteAcc.tfBank.getText();
			String dlId = deleteAcc.tfAccountId.getText();
			String dlPw = deleteAcc.pfAccountPwd.getText();
			if (dao.accSelect(dlBk, dlId, dlPw) == null) {
				JOptionPane.showMessageDialog(null, "�Էµ� ������ �߸��Ǿ����ϴ�.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else if (Integer.parseInt((dao.accSelect(dlBk, dlId, dlPw))) > 0) {
				JOptionPane.showMessageDialog(null, "�ܾ��� �����־� ������ �Ұ����մϴ�.", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				del = new Del();
				String result = dao.accDelete(dlBk, dlId, dlPw);
				del.lbBank.setText("������ ���� : " + dlBk);
				del.lbAcc.setText("������ ���� : " + dlId);
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
		} else if (btn == big.btnDeposit) { // ū��ư �Ա�
			this.remove(big);
			this.add(deposit);
			updateUI();
		} else if (btn == big.btnWithdraw) { // ū��ư ���
			this.remove(big);
			this.add(withdraw);
			updateUI();
		} else if (btn == big.btnBankTransfer) { // ū ��ư ���� ��ü
			this.remove(big);
			this.add(bankTransfer);
			updateUI();
		} else if (btn == big.btnDisplayBalance) { // ū��ư �ܾ���ȸ
			this.remove(big);
			this.add(displayBalance);
			updateUI();
		}
	}

}
