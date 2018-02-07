package com.transfile.model.file_type;


import java.util.ArrayList;
import java.util.List;


import com.transfile.model.log_type.Chargeback;
import com.transfile.model.log_type.Matching;
import com.transfile.model.log_type.Operation;
import com.transfile.model.log_type.Transaction;
import com.transfile.model.log_type.Wallet;

public class Sendfile extends AFileType {
	
	public Sendfile() {
		super.filePath = "C:\\Workspace\\Transfile\\transfileV2";
		super.fileName = "sendfile.conf";
	}
	
	@Override
	public void generateFile() {
		Matching matching = new Matching();
		Chargeback chargeback = new Chargeback();
		Wallet wallet = new Wallet();
		Operation operation = new Operation();
		Transaction transaction = new Transaction();
		List<String> content = new ArrayList<String>();
		
		content.add(matching.getContent());
		content.add(chargeback.getContent());
		content.add(wallet.getContent());
		content.add(operation.getContent());
		content.add(transaction.getContent());
		
		super.fileContent = String.join(System.getProperty("line.separator"), content);
		
		super.appendFile();
		
	}

}
