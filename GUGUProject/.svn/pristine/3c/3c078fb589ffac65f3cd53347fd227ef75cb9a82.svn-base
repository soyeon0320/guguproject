package daoImpl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.ImgDAO;
import util.SqlMapClientFactory;
import vo.ImgVO;

public class ImgDAOImpl implements ImgDAO{
	private static ImgDAO imgDao;
	private SqlMapClient smc;
	
	private ImgDAOImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static ImgDAO getInstance() {
		if(imgDao==null) {
			imgDao = new ImgDAOImpl();
		}
		return imgDao;
	}

//	@Override
//	public int imgInsert(ImgVO iv) throws SQLException {
//		int resCnt = 0;
//		Object obj = smc.insert("resume.ResumeImgInsert", iv);
//		if(obj==null) {
//			resCnt = 1;
//		}
//		return resCnt;
//	}
}
