//package util;
//
//import java.io.File;
//import java.io.UnsupportedEncodingException;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
///**
// * FileUpload API를 사용하는 HttpServletRequestWrapper 클래스
// * (HttpServletRequest에 기반한 API를 사용하면서 멀티파트처리 기능이 추가되었음.)
// */
////파싱하는 기능을 부여시키기 위해서
////Wrapper : 보조 스트림 같은 애 = 기본 리퀘스트는 받아서 쓰되 보조 스트림처럼 기능을 추가 해주는 것
////멀티 파트로 던져지면 인코딩이 잘 안됨
////리퀘스트 객체를 포장해서 매핑
//public class FileUploadRequestWrapper extends HttpServletRequestWrapper {
//    public static final String UPLOAD_DIRECTORY = "d:/D_Other/upload_files"; // 업로드 경로 설정
//    private boolean multipart = false; // 멀티파트여부
//
//    //getParameter를 하기 위함
//    private Map<String, String[]> parameterMap; // 폼 필드(파라미터) 데이터를 담기 위한 맵
//    private Map<String, Object> fileItemMap; // fileItem 객체를 담기위한 맵
//
//    /**
//     * 생성자
//     * @param request
//     * @throws FileUploadException
//     */
//    public FileUploadRequestWrapper(HttpServletRequest request) throws FileUploadException{
//    	//현재 생성자 호출 = 53번행
//        this(request, -1, -1, -1, null);
//    }
//
//    /**
//     * 생성자
//     * @param request
//     * @param memoryThreshold 메모리 임계크기(이 크기가 넘어가면 레파지토리 위치에 임시파일로 저장됨)
//     * @param fileSizeMax 파일 1개당 최대크기
//     * @param maxRequestSize 요청 파일 최대 크기
//     * @param repositoryPath 임시파일 저장경로
//     * @throws FileUploadException
//     */
//    //오버로드된 생성자
//    public FileUploadRequestWrapper(HttpServletRequest request, int memoryThreshold, long fileSizeMax, long maxRequestSize, String repositoryPath) throws FileUploadException {
//        //오리지널 객체는 super를 호출
//    	//super : HttpServletRequestWrapper를 호출 = FileUploadRequestWrapper는 HttpServletRequestWrapper를 상속하고 있기 때문에
//    	super(request);
//        
//        //자체 메소드
//        //repositoryPath : 임시 저장 공간
//        //파일 업로드 예제에서 한땀한땀 했던 것들을 생성자에서 받아서 셋팅
//        parsing(request, memoryThreshold, fileSizeMax, maxRequestSize, repositoryPath);
//    }
//
//    /**
//     * 멀티파트 데이터를 파싱하여 두개의 맵에 나누어 담는다.
//     * @param request
//     * @param memoryThreshold 메모리 임계크기(이 크기가 넘어가면 레파지토리 위치에 임시파일로 저장됨)
//     * @param fileSizeMax 파일 1개당 최대 크기
//     * @param maxRequestSize 요청 파일 최대 크기
//     * @param repositoryPath 임시파일 저장경로
//     * @throws FileUploadException
//     */
//    private void parsing(HttpServletRequest request, int memoryThreshold, long fileSizeMax, long maxRequestSize, String repositoryPath) throws FileUploadException {
//    	//리퀘스트 매퍼 객체를 생성하면 실행 = new FileUploadRequestWrapper()를 할 때
//        if (ServletFileUpload.isMultipartContent(request)) {
//            multipart = true; // 멀티파트를 설정함.
//
//            //멀티 파트일 때만 만들어지는 객체
//            parameterMap = new HashMap<>();
//            fileItemMap = new HashMap<>();
//
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            if (memoryThreshold != -1) {
//            	factory.setSizeThreshold(memoryThreshold);
//            }
//            if (repositoryPath != null) {// 저장 경로가 설정되지 않았으면...
//            	factory.setRepository(new File(repositoryPath));
//            }else {
//            	factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
//            }
//            
//            //파일 업로드를 하기 위한 준비 과정
//            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
//            servletFileUpload.setFileSizeMax(fileSizeMax);
//            servletFileUpload.setSizeMax(maxRequestSize);
//
//            List<FileItem> list = servletFileUpload.parseRequest(request);
//            for (int i = 0 ; i < list.size() ; i++) {
//                FileItem fileItem = (FileItem) list.get(i);
//                String name = fileItem.getFieldName(); // 필드명 가져오기
//
//                if (fileItem.isFormField()) { // 폼필드인 경우...
//                    String value = "";
//					try {
//						// 폼필드의 값이 한글인 경우에는 해당 문자열을 적절히 변환을 해주어야 한다.
//						//value = new String(fileItem.getString().getBytes("8859_1"), "UTF-8");
//						value = fileItem.getString("UTF-8");
//					} catch (UnsupportedEncodingException e) {
//						e.printStackTrace();
//					}
//					//꺼내서 매핑하는 작업
//					//맵에 담겨있는 파일들을 꺼내서 String 배열에 담기
//                    String[] values = (String[]) parameterMap.get(name);
//                    if (values == null) { // 처음 만드는 경우...
//                        values = new String[] { value };
//                    } else { // 기존에 이미 존재하는 경우...
//                    	//파일을 담기 위해서 공간 확보 = +1을 하여 공간을 확장
//                        String[] tempValues = new String[values.length + 1];
//                        //기존의 파일 복사
//                        System.arraycopy(values, 0, tempValues, 0, 1);
//                        //기존의 파일 담기
//                        tempValues[tempValues.length - 1] = value;
//                        values = tempValues;
//                    }
//                    parameterMap.put(name, values);
//                } else { // 파일인 경우...
//                	//업로드한 파일들이 들어있음
//                	//키를 가져오면 업로드한 파일들만 꺼내올 수 있음
//                    fileItemMap.put(name, fileItem);
//                }
//            }
//            addTo(); // 현재 객체를 속성값으로 설정한다.(래퍼클래스 여부 체크를 위해 설정)
//        }
//    }
//
//    //멀티 파트 여부 확인
//    public boolean isMultipartContent() {
//        return multipart;
//    }
//
//    //사용자의 요청이 멀티파트 유무에 상관없이 getParameter()를 호출해서 키 값을 꺼내기 위함 = 값 꺼내오기 가능
//    //getParameter를 하기 위해서 파싱하는 것
//    //멀티 파트이면 파싱이 되고 멀티 파트가 아니면 오리지널 데이터가 들어감
//    public String getParameter(String name) {
//    	//위에서 멀티 파트 여부가 확정됬음
//        if (multipart) {
//            String[] values = (String[])parameterMap.get(name);
//            if (values == null) {
//            	return null;
//            }
//            //첫번째 값 리턴
//            return values[0];
//        } else {
//        	//멀티 파트의 원래 기능을 사용하기 위해 리턴
//        	//multipart/form-data 형식
//            return super.getParameter(name);
//        }
//    }
//
//    public String[] getParameterValues(String name) {
//        if (multipart)
//            return (String[])parameterMap.get(name);
//        else
//            return super.getParameterValues(name);
//    }
//
//    public Enumeration<String> getParameterNames() {
//        if (multipart) {
//            return new Enumeration<String>() {
//                Iterator<String> iter = parameterMap.keySet().iterator();
//
//                public boolean hasMoreElements() {
//                    return iter.hasNext();
//                }
//                public String nextElement() {
//                    return iter.next();
//                }
//            };
//        } else {
//            return super.getParameterNames();
//        }
//    }
//
//    public Map<String, String[]> getParameterMap() {
//        if (multipart)
//        	//parameterMap의 값 반환
//            return parameterMap;
//        else
//            return super.getParameterMap();
//    }
//
//    //멀티 파트인 경우 해당 메소드를 호출
//    //파일 꺼내오기 => getFileItemMap().겟파라미터
//    public Map<String, Object> getFileItemMap() {
//    	 if (multipart)
//    		 //fileItemMap의 값 반환
//             return fileItemMap;
//         else
//             return null;
//    }
//
//    public FileItem getFileItem(String name) {
//        if (multipart)
//        	//fileItemMap의 값을 FileItem로 형변환하여 반환
//            return (FileItem) fileItemMap.get(name);
//        else
//            return null;
//    }
//
//    /**
//     * fileItemMap에 존재하는 FileItem을 삭제한다.
//     */
//    public void delete() {
//        if (multipart) {
//            Iterator<Object> fileItemIter = fileItemMap.values().iterator();
//            //임시 저장 되어있는 파일들이 있을 때
//            while( fileItemIter.hasNext()) {
//            	//임시 저장 되어있는 파일들을 꺼내옴
//                FileItem fileItem = (FileItem)fileItemIter.next();
//                //임시 저장된 파일을 제거
//                fileItem.delete();
//            }
//        }
//    }
//
//    /**
//     * request객체에 속성값으로 현재 래퍼객체(FileUploadRequestWrapper)를 등록함.
//     * (멀티파트인 경우에만 호출됨.)
//     */
//    public void addTo() {
//      super.setAttribute(FileUploadRequestWrapper.class.getName(), this);
//    }
//
//
//    /**
//     * 래퍼클래스 여부를 체크함.
//     * @param request 요청객체
//     * @return true 이면 래퍼클래스, false 이면 래퍼클래스 아님.
//     */
//    //업로드와는 관계 없음
//    //사용할 때도 있고 안할 때도 있음
//    public static boolean hasWrapper(HttpServletRequest request) {
//    	if (FileUploadRequestWrapper.getFrom(request) == null) {
//    		return false;
//    	} else {
//    		return true;
//    	}
//    }
//
//    /**
//     * request객체에 존재하는 FileUploadRequestWrapper객체를 가져옴
//     * @param request 객체
//     * @return 존재하면 FileUploadRequestWrapper 객체, 없으면 null 리턴함.
//     */
//    public static FileUploadRequestWrapper
//                  getFrom(HttpServletRequest request) {
//        return (FileUploadRequestWrapper)
//            request.getAttribute(FileUploadRequestWrapper.class.getName());
//    }
//
//}
