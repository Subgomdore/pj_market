package pjmarket.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import pjmarket.model.MemberDTO;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession session;

	// 회원 가입정보 저장
	@Override
	public int MemberInsert(MemberDTO member) throws Exception {
		System.out.println("member_id :"+member.getMember_id());
		System.out.println("member_pw :"+member.getMember_pw());
		System.out.println("member_name :"+member.getMember_name());
		System.out.println("member_email :"+member.getMember_email());
		System.out.println("member_domain :"+member.getMember_domain());
		System.out.println("member_pw2 :"+member.getMember_pw2());
		System.out.println("member_add1 :"+member.getMember_addr1());
		System.out.println("member_add2 :"+member.getMember_addr2());
		System.out.println("member_tel3 :"+member.getMember_tel3());
		System.out.println("member_phone3 :"+member.getMember_phone3());
		System.out.println("member_phone2 :"+member.getMember_phone2());
		System.out.println("member_phone :"+member.getMember_phone());
		System.out.println("member_zip1 :"+member.getMember_zip1());
		
		
		return session.insert("memberns.member_join", member);
	}

	// 로그인 인증
	@Override
	public MemberDTO UserCheck(String member_id) {
		return session.selectOne("memberns.login_check", member_id);
	}

	// 아이디 중복검사
	@Override
	public int CheckMemberID(String member_id) throws Exception {
		int re = -1; // 사용가능한 ID

		MemberDTO dto = session.selectOne("memberns.id_check", member_id);
		if (dto != null) {
			re = 1; // 중복id
		} else {
			re = -1;
		}
		return re;
	}

	// 회원정보 수정
	public void UpdateMember(MemberDTO member) throws Exception {
		session.update("memberns.member_edit", member);

	}

	// 회원 탈퇴
	public void DeleteMember(MemberDTO member) throws Exception {
		session.update("memberns.member_delete", member);
	}

}
