package serviceImpl;

import org.apache.commons.fileupload.FileItem;

import dao.ImgDAO;
import daoImpl.ImgDAOImpl;
import service.ImgService;
import vo.ImgVO;

public class ImgServiceImpl implements ImgService{
	private static ImgService ImgService;
	private ImgDAO imgDao;
	
	private ImgServiceImpl() {
		imgDao = ImgDAOImpl.getInstance();
	}
	
	public static ImgService getInstance() {
		if(ImgService==null) {
			ImgService = new ImgServiceImpl();
		}
		return ImgService;
	}

//	@Override
//	public ImgVO imgInsert(FileItem item) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
