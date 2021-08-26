package dev.itechsolutions.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.POInfo;
import org.compiere.util.DB;

/**
 * 
 * @author Argenis Rodríguez
 *
 */
public class MITSAccount extends MAccount {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MITSAccount(MAcctSchema as) {
		super(as);
	}
	
	public MITSAccount(Properties ctx, int C_ValidCombination_ID, String trxName) {
		super(ctx, C_ValidCombination_ID, trxName);
	}
	
	public MITSAccount(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public static MITSAccount get(Properties ctx, int AD_Client_ID, int AD_Org_ID
			, int C_AcctSchema_ID, int Account_ID, int C_SubAcct_ID
			, int M_Product_ID, int C_BPartner_ID, int AD_OrgTrx_ID
			, int C_LocFrom_ID, int C_LocTo_ID, int C_SalesRegion_ID
			, int C_Project_ID, int C_Campaign_ID, int C_Activity_ID
			, int User1_ID, int User2_ID, int UserElement1_ID
			, int UserElement2_ID, String trxName, boolean save) {
		
		StringBuilder info = new StringBuilder();
		info.append("AD_Client_ID=").append(AD_Client_ID).append(",AD_Org_ID=").append(AD_Org_ID);
		//	Schema
		info.append(",C_AcctSchema_ID=").append(C_AcctSchema_ID);
		//	Account
		info.append(",Account_ID=").append(Account_ID).append(" ");
		
		ArrayList<Object> params = new ArrayList<Object>();
		//		Mandatory fields
		StringBuilder whereClause =  new StringBuilder("C_ValidCombination.AD_Client_ID=?")		//	#1
							.append(" AND C_ValidCombination.AD_Org_ID=?")
							.append(" AND C_ValidCombination.C_AcctSchema_ID=?")
							.append(" AND C_ValidCombination.Account_ID=?");			//	#4
		
		params.add(AD_Client_ID);
		params.add(AD_Org_ID);
		params.add(C_AcctSchema_ID);
		params.add(Account_ID);
		//	Optional fields
		if (C_SubAcct_ID == 0)
			whereClause.append(" AND C_ValidCombination.C_SubAcct_ID IS NULL");	
		else
		{	
			whereClause.append(" AND C_ValidCombination.C_SubAcct_ID=?");
			params.add(C_SubAcct_ID);
		}
		if (M_Product_ID == 0)
			whereClause.append(" AND C_ValidCombination.M_Product_ID IS NULL");
		else
		{
			whereClause.append(" AND C_ValidCombination.M_Product_ID=?");
			params.add(M_Product_ID);
		}	
		if (C_BPartner_ID == 0)
			whereClause.append(" AND C_ValidCombination.C_BPartner_ID IS NULL");
		else
		{
			whereClause.append(" AND C_ValidCombination.C_BPartner_ID=?");
			params.add(C_BPartner_ID);
		}
		if (AD_OrgTrx_ID == 0)
			whereClause.append(" AND C_ValidCombination.AD_OrgTrx_ID IS NULL");
		else
		{	
			whereClause.append(" AND C_ValidCombination.AD_OrgTrx_ID=?");
			params.add(AD_OrgTrx_ID);
		}
		if (C_LocFrom_ID == 0)
			whereClause.append(" AND C_ValidCombination.C_LocFrom_ID IS NULL");
		else
		{
			whereClause.append(" AND C_ValidCombination.C_LocFrom_ID=?");
			params.add(C_LocFrom_ID);
		}
		if (C_LocTo_ID == 0)
			whereClause.append(" AND C_ValidCombination.C_LocTo_ID IS NULL");
		else
		{
			whereClause.append(" AND C_ValidCombination.C_LocTo_ID=?");
			params.add(C_LocTo_ID);
		}	
		if (C_SalesRegion_ID == 0)
			whereClause.append(" AND C_ValidCombination.C_SalesRegion_ID IS NULL");
		else
		{
			whereClause.append(" AND C_ValidCombination.C_SalesRegion_ID=?");
			params.add(C_SalesRegion_ID);
		}
		if (C_Project_ID == 0)
			whereClause.append(" AND C_ValidCombination.C_Project_ID IS NULL");
		else
		{	
			whereClause.append(" AND C_ValidCombination.C_Project_ID=?");
			params.add(C_Project_ID);
		}
		if (C_Campaign_ID == 0)
			whereClause.append(" AND C_ValidCombination.C_Campaign_ID IS NULL");
		else
		{	
			whereClause.append(" AND C_ValidCombination.C_Campaign_ID=?");
			params.add(C_Campaign_ID);
		}
		if (C_Activity_ID == 0)
			whereClause.append(" AND C_ValidCombination.C_Activity_ID IS NULL");
		else
		{
			whereClause.append(" AND C_ValidCombination.C_Activity_ID=?");
			params.add(C_Activity_ID);
		}
		if (User1_ID == 0)
			whereClause.append(" AND C_ValidCombination.User1_ID IS NULL");
		else
		{
			whereClause.append(" AND C_ValidCombination.User1_ID=?");
			params.add(User1_ID);
		}
		if (User2_ID == 0)
			whereClause.append(" AND C_ValidCombination.User2_ID IS NULL");
		else
		{
			whereClause.append(" AND C_ValidCombination.User2_ID=?");
			params.add(User2_ID);
		}
		if (UserElement1_ID == 0)
			whereClause.append(" AND C_ValidCombination.UserElement1_ID IS NULL");
		else
		{	
			whereClause.append(" AND C_ValidCombination.UserElement1_ID=?");
			params.add(UserElement1_ID);
		}
		if (UserElement2_ID == 0)
			whereClause.append(" AND C_ValidCombination.UserElement2_ID IS NULL");
		else
		{
			whereClause.append(" AND C_ValidCombination.UserElement2_ID=?");
			params.add(UserElement2_ID);
		}
		//	whereClause.append(" ORDER BY IsFullyQualified DESC");
		
		/*MAccount existingAccount = new Query(ctx, MAccount.Table_Name, whereClause.toString(), trxName)
										.setParameters(params)
										.setOnlyActiveRecords(true)
										.first();*/
		
		MITSAccount existingAccount = null;
		POInfo poInfo = POInfo.getPOInfo(ctx, Table_ID);
		
		StringBuilder sql = poInfo.buildSelect(true, false)
				.append(" WHERE ").append(whereClause);
		
		//Create Prepared Statement and ResultSet
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = DB.prepareStatement(sql.toString(), trxName);
			DB.setParameters(pstmt, params);
			
			rs = pstmt.executeQuery();
			
			if (rs.next())
				existingAccount = new MITSAccount(ctx, rs, trxName);
		} catch (SQLException e) {
			throw new AdempiereException(e.getLocalizedMessage(), e);
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
		
		//Existing
		if (existingAccount != null)
			return existingAccount;
		
		//		New
		MITSAccount newAccount = new MITSAccount(ctx, 0, trxName);
		newAccount.setClientOrg(AD_Client_ID, AD_Org_ID);
		newAccount.setC_AcctSchema_ID(C_AcctSchema_ID);
		newAccount.setAccount_ID(Account_ID);
		//	--  Optional Accounting fields
		newAccount.setC_SubAcct_ID(C_SubAcct_ID);
		newAccount.setM_Product_ID(M_Product_ID);
		newAccount.setC_BPartner_ID(C_BPartner_ID);
		newAccount.setAD_OrgTrx_ID(AD_OrgTrx_ID);
		newAccount.setC_LocFrom_ID(C_LocFrom_ID);
		newAccount.setC_LocTo_ID(C_LocTo_ID);
		newAccount.setC_SalesRegion_ID(C_SalesRegion_ID);
		newAccount.setC_Project_ID(C_Project_ID);
		newAccount.setC_Campaign_ID(C_Campaign_ID);
		newAccount.setC_Activity_ID(C_Activity_ID);
		newAccount.setUser1_ID(User1_ID);
		newAccount.setUser2_ID(User2_ID);
		newAccount.setUserElement1_ID(UserElement1_ID);
		newAccount.setUserElement2_ID(UserElement2_ID);
		
		if (save)
			newAccount.saveEx();
		
		return newAccount;
	}
}
