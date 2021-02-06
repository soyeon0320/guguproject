package service;

import java.sql.SQLException;
import java.util.List;

import dao.JobnewsDAO;
import vo.JobNewsVO;

public interface JobNewsService {

	public List<JobNewsVO> jobnewsAllSelect(JobNewsVO jv);

	public int jobnewsInsert(JobNewsVO jv);

	public int jobnewsDelete(String jobnewsCode);

	public List<JobNewsVO> getSearchJobnews(JobNewsVO jv);

	public int jobnewsUpdate(JobNewsVO jv);

	
	

	}

