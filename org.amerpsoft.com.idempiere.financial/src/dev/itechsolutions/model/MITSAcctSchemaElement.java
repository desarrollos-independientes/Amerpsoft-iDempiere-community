package dev.itechsolutions.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAcctSchemaElement;
import org.compiere.model.MTable;
import org.compiere.model.POInfo;
import org.compiere.util.DB;

/**
 * 
 * @author Argenis Rodríguez
 *
 */
public class MITSAcctSchemaElement extends MAcctSchemaElement {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MITSAcctSchemaElement(MAcctSchema as) {
		super(as);
	}

	public MITSAcctSchemaElement(Properties ctx, int C_AcctSchema_Element_ID, String trxName) {
		super(ctx, C_AcctSchema_Element_ID, trxName);
	}

	public MITSAcctSchemaElement(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param C_SalesRegion_ID
	 */
	public void setTypeSalesRegion(int seqNo, String name
			, int C_SalesRegion_ID) {
		setElementType(ELEMENTTYPE_SalesRegion);
		setSeqNo(seqNo);
		setName(name);
		setC_SalesRegion_ID(C_SalesRegion_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param C_Element_ID
	 * @param C_ElementValue_ID
	 */
	public void setElementTypeU2(int seqNo, String name
			, int C_Element_ID, int C_ElementValue_ID) {
		setElementTypeList(ELEMENTTYPE_UserElementList2
				, seqNo
				, name
				, C_Element_ID
				, C_ElementValue_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param C_Element_ID
	 * @param C_ElementValue_ID
	 */
	public void setElementTypeU1(int seqNo, String name
			, int C_Element_ID, int C_ElementValue_ID) {
		setElementTypeList(ELEMENTTYPE_UserElementList1
				, seqNo
				, name
				, C_Element_ID
				, C_ElementValue_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param elementType
	 * @param seqNo
	 * @param name
	 * @param C_Element_ID
	 * @param C_ElementValue_ID
	 */
	private void setElementTypeList(String elementType
			, int seqNo, String name
			, int C_Element_ID, int C_ElementValue_ID) {
		setElementType(elementType);
		setSeqNo(seqNo);
		setName(name);
		setC_Element_ID(C_Element_ID);
		setC_ElementValue_ID(C_ElementValue_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param C_Activity_ID
	 */
	public void setTypeActivity(int seqNo, String name, int C_Activity_ID) {
		
		setElementType(ELEMENTTYPE_Activity);
		setSeqNo(seqNo);
		setName(name);
		setC_Activity_ID(C_Activity_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param Org_ID
	 */
	public void setTypeOrgTrx(int seqNo, String name, int Org_ID) {
		
		setElementType(ELEMENTTYPE_OrgTrx);
		setSeqNo(seqNo);
		setName(name);
		setOrg_ID(Org_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param C_Location_ID
	 */
	public void setTypeLocationTo(int seqNo, String name, int C_Location_ID) {
		setTypeLocation(ELEMENTTYPE_LocationTo, seqNo, name, C_Location_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param C_Location_ID
	 */
	public void setTypeLocationFrom(int seqNo, String name, int C_Location_ID) {
		setTypeLocation(ELEMENTTYPE_LocationFrom, seqNo, name, C_Location_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param elementType
	 * @param seqNo
	 * @param name
	 * @param C_Location_ID
	 */
	private void setTypeLocation(String elementType
			, int seqNo, String name, int C_Location_ID) {
		setElementType(elementType);
		setSeqNo(seqNo);
		setName(name);
		setC_Location_ID(C_Location_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param C_Campaign_ID
	 */
	public void setTypeCampaign(int seqNo, String name, int C_Campaign_ID) {
		setElementType(ELEMENTTYPE_Campaign);
		setSeqNo(seqNo);
		setName(name);
		setC_Campaign_ID(C_Campaign_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param AD_Column_ID
	 */
	public void setTypeUC1(int seqNo, String name, int AD_Column_ID) {
		setTypeColumn(ELEMENTTYPE_UserColumn1, seqNo, name, AD_Column_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param seqNo
	 * @param name
	 * @param AD_Column_ID
	 */
	public void setTypeUC2(int seqNo, String name, int AD_Column_ID) {
		setTypeColumn(ELEMENTTYPE_UserColumn2, seqNo, name, AD_Column_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param elementType
	 * @param seqNo
	 * @param name
	 * @param AD_Column_ID
	 */
	private void setTypeColumn(String elementType, int seqNo
			, String name, int AD_Column_ID) {
		setElementType(elementType);
		setSeqNo(seqNo);
		setName(name);
		setAD_Column_ID(AD_Column_ID);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param elementType
	 * @param seqNo
	 * @param name
	 */
	public void setElementType(String elementType, int seqNo, String name) {
		setElementType(elementType);
		setSeqNo(seqNo);
		setName(name);
	}
	
	/**
	 * @author Argenis Rodríguez
	 * @param C_AcctSchema_ID
	 * @param elementType
	 * @return
	 */
	public static MITSAcctSchemaElement getAcctSchemaElement(MAcctSchema as, String elementType) {
		
		POInfo info = POInfo.getPOInfo(as.getCtx(), MTable.getTable_ID(Table_Name));
		StringBuilder sql = info.buildSelect(true, false);
		
		sql.append(" WHERE C_AcctSchema_Element.C_AcctSchema_ID = ?"
				+ " AND C_AcctSchema_Element.ElementType = ?");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = DB.prepareStatement(sql.toString(), as.get_TrxName());
			pstmt.setInt(1, as.get_ID());
			pstmt.setString(2, elementType);
			
			rs = pstmt.executeQuery();
			
			if (rs.next())
				return new MITSAcctSchemaElement(as.getCtx(), rs, as.get_TrxName());
		} catch (SQLException e) {
			throw new AdempiereException(e.getLocalizedMessage(), e);
		} finally {
			DB.close(rs, pstmt);
		}
		
		return null;
	}
}
