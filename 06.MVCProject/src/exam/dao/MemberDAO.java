package exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exam.dto.Member;

public class MemberDAO {
	private Connection con = null; //써야되서 밖으로 빼버림
	private PreparedStatement pstmt = null; // 다른메소드에서도 써야하기 때문에
	private ResultSet rs = null;
	
	//생성자
	public MemberDAO(){
		System.out.println("생성자");
		
		//1. jdbc 드라이버 로드 
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 // 2. 데이터 베이스와 연결
				try {
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserc","jsp1234");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		//�뿰寃곗＜�냼,�븘�씠�뵒,�뙣�뒪�썙�뱶
		}
	
	
	//회원가입
	public void insertMember(Member member){
		System.out.println("회원가입");
		String sql = "insert into member values(?,?,?,?,?,?,default)";

		String id = member.getId();
		int age = member.getAge();
		String pass = member.getPass();
		String name = member.getName();
		String gender = member.getGender();
		String addr = member.getAddr();
		
		try {
			pstmt = con.prepareStatement(sql); // 바인딩을 해야함.(위에꺼 6개)
			
			
			pstmt.setString(1,id);
			pstmt.setString(2,pass);
			pstmt.setString(3,name);
			pstmt.setString(4,gender);
			pstmt.setString(5,addr);
			pstmt.setInt(6,age);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	//�쉶�썝�궘�젣
	public void deleteMember(){
		System.out.println("�쉶�썝�궘�젣");
		
	}
	
	//로그인
	//DTO 미사용
	public int loginMember(String id, String pwd){
		String sql = "select * from member where id=? and password=?"; //아이디와 비번확인
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			

			pstmt.setString(1,id);
			pstmt.setString(2,pwd);

			rs = pstmt.executeQuery(sql);
			
			
			if(rs.next()){ // 로그인 성공
				result = 1;
			}
			else// 로그인 실패
			{
					result = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result; //오버라이딩을 완벽하게 하려면 리턴타입이 똑같아야한다.
	}
	
	//DTO 사용
	public int loginMember(Member member){
		return 0;
	}
	//회원리스트
	public List<Member> listMember(){
		String sql = "select * from member order by id desc";
		List<Member> list = new ArrayList();//멤버객체를 담으려고 만듬 , 근데 꺼낼때는 object 라 형변환해야대 <Member>하면 담을때도 멤버 꺼낼때도 멤버
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				
				list.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	//회원 상세보기 
	public void detailMember(){
		
	}

}
