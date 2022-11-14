package pjmarket.controller;

import java.io.File


;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pjmarket.model.Options;
import pjmarket.model.Product;
import pjmarket.model.Review;
import pjmarket.service.ReviewServiceImpl;

@Controller
public class ReviewController {

	@Autowired
	private ReviewServiceImpl rs;

	// 리뷰 쓰는 폼으로 이동
	@RequestMapping("review_writeform")
	public String ReviewWriteForm(Review review,Model model, String member_id,  Product product,HttpSession session) throws Exception {

//       @RequestParam("product_num") int product_num,
//		 @RequestParam("options_num") int options_num ,

		// session 에서 아이디 구해오기
		member_id = (String) session.getAttribute("member_id");
		System.out.println("아이디 : " + member_id);

		// 상품명
//		product = rs.getProductName(product_num);
		// 상품코드 구해오기
		int product_num = review.getProduct_num();
		int options_num = review.getOptions_num();
		 
		 model.addAttribute("product_num", product_num);
		 model.addAttribute("options_num", options_num);
		 model.addAttribute("member_id", member_id);
		 model.addAttribute("product", product);
//		 model.addAttribute("product_name", product_name);

		return "review/review_writeform";
	}

	// 리뷰 게시판 작성 성공 이미지 업로드
	@RequestMapping("review_insertresult")
	public String ReviewInsert(Review review, Model model, @RequestParam("review_img1") 
	List<MultipartFile> multiFileList , HttpServletRequest request) throws Exception {

			
			// 받아온것 출력 확인
			System.out.println("multiFileList : " + multiFileList);
			
			// path 가져오기
			String path = request.getRealPath("/resources/upload/");
			String root = path + "\\" + "uploadFiles";
			System.out.println("root:"+ root);
			
			int size = (int) multiFileList.size(); // 첨부파일의 크기 (단위:Byte)
			System.out.println("size=" + size);
			
			File fileCheck = new File(root);
			
			if(!fileCheck.exists()) fileCheck.mkdirs();
						
			String filename = "";
			
			if (size > 1 ) {
			List<Map<String, String>> fileList = new ArrayList<>();
			
			for(int i = 0; i < multiFileList.size(); i++) {
				String originFile = multiFileList.get(i).getOriginalFilename();
				String ext = originFile.substring(originFile.lastIndexOf("."));
				String changeFile = UUID.randomUUID().toString() + ext;
				
				 
				filename += changeFile +",";
				
				Map<String, String> map = new HashMap<>();
				map.put("originFile", originFile);
				map.put("changeFile", changeFile);
				
				fileList.add(map);
			}
			
			// 파일업로드
			try {
				for(int i = 0; i < multiFileList.size(); i++) {
					File uploadFile = new File(root + "\\" + fileList.get(i).get("changeFile"));
					multiFileList.get(i).transferTo(uploadFile);
				}
				
				System.out.println("다중 파일 업로드 성공!");
				
			} catch (IllegalStateException | IOException e) {
				System.out.println("다중 파일 업로드 실패 ");
				// 만약 업로드 실패하면 파일 삭제
				for(int i = 0; i < multiFileList.size(); i++) {
					new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
				}
				
				e.printStackTrace();
				
			}
			review.setReview_img(filename);
			}
			
			else { 					// 첨부파일이 수정되지 않으면
				review.setReview_img(review.getReview_img());
			}
			
			System.out.println("리뷰 글 작성 성공");
			
			int result = rs.ReviewInsert(review);
			model.addAttribute("result", result);
			
			return "review/review_insertresult";
	}

	// 리뷰 게시판 목록
	@RequestMapping("review_boardlist")
	public String ReviewBoardList(Review review,Model model,Product product,Options options,
			HttpServletRequest request) throws Exception {

		List<Review> boardlist = new ArrayList<Review>();

		int page = 1;
		int limit = 5; 

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int product_num = review.getProduct_num();
		int options_num = review.getOptions_num();
		int listcount = rs.getListCount(product_num);
		System.out.println("controller page: "+page);
		boardlist = rs.getBoardList(page, product_num);
		product = rs.getProductNum(product_num);
		System.out.println("ehlskdy");

		int maxpage = (int) ((double) listcount / limit + 0.95);
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = maxpage;

		if (endpage > startpage + 10 - 1)
			endpage = startpage + 10 - 1;

		model.addAttribute("product_num", product_num);
		model.addAttribute("options_num", options_num);
		model.addAttribute("product", product);
		model.addAttribute("options", options);
		model.addAttribute("page", page);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);

		System.out.println("product_num :" + product_num);
		System.out.println(listcount);
		System.out.println("boardlistsize :" + boardlist.size());

		return "review/review_boardlist";
	}

	// 리뷰 상세
	@RequestMapping("review_detail")
	public String reviewDetail(@RequestParam("review_no") int review_no,Product product, Model model) throws Exception {

		// @RequestParam("p_no") int p_no
		// 조회수 증가
		int result = rs.updateHit(review_no);
		System.out.println("조회수 증가 결과: " + result);

		// 상품명
		// Product product = rs.getProductName(p_no);

		// 리뷰 내용 구해오기
		Review review = rs.select(review_no);
		System.out.println("리뷰 상세 내용: " + review);
		System.out.println("리뷰이미지:" + review.getReview_img());
		
		String review_img[] = review.getReview_img().split(",");		

		String content = review.getReview_content().replace("\n", "<br>");

		model.addAttribute("review", review);
		model.addAttribute("content", content);
		model.addAttribute("review_img", review_img);
		model.addAttribute("product", product);

		return "review/review_detail";
	}

	// 리뷰 업데이트 폼으로 이동
	@RequestMapping("review_update.do")
	public String ReviewUpdate(int review_no, Model model) throws Exception {

		System.out.println("review_update");
		Review review = rs.Reviewupdate(review_no);
		model.addAttribute("review", review);
		return "review/review_update";
	}

	// 리뷰 업데이트 성공 이미지 업로드 수정
	@RequestMapping("review_updateresult")
	public String Reviewupdateresult(Review review, Model model, @RequestParam("review_img1")
			List<MultipartFile> multiFileList , HttpServletRequest request) throws Exception {
				
				// 받아온것 출력 확인
				System.out.println("multiFileList : " + multiFileList);
				int review_no = review.getReview_no();
				Review review1 = this.rs.Reviewupdate(review_no);		
				
				// path 가져오기
				String path = request.getRealPath("/resources/upload/");
				String root = path + "\\" + "uploadFiles";
				System.out.println("root:"+ root);
				System.out.println(multiFileList.size());
				
				int size = (int) multiFileList.size(); // 첨부파일의 크기 (단위:Byte)
				System.out.println("size=" + size);
				
				
				
				File fileCheck = new File(root);
				if(!fileCheck.exists()) fileCheck.mkdirs();
				
				
				String filename = "";
				
				if (size > 1 ) {  // 첨부 파일이 수정되면
					System.out.println("?");
				List<Map<String, String>> fileList = new ArrayList<>();
				
				for(int i = 0; i < multiFileList.size(); i++) {
					String originFile = multiFileList.get(i).getOriginalFilename(); // 오리지널 파일이름
					String ext = originFile.substring(originFile.lastIndexOf(".")); // 확장자
					String changeFile = UUID.randomUUID().toString() + ext;			// 체인지 파일이름
					
					 
					filename += changeFile +",";
					
					Map<String, String> map = new HashMap<>();
					map.put("originFile", originFile);
					map.put("changeFile", changeFile);
					
					fileList.add(map);
				}
				
				// 파일업로드
				try {
					for(int i = 0; i < multiFileList.size(); i++) {
						File uploadFile = new File(root + "\\" + fileList.get(i).get("changeFile"));
						multiFileList.get(i).transferTo(uploadFile);
					}
					
					System.out.println("다중 파일 업로드 성공!");
					
				} catch (IllegalStateException | IOException e) {
					System.out.println("다중 파일 업로드 실패 ");
					// 만약 업로드 실패하면 파일 삭제
					for(int i = 0; i < multiFileList.size(); i++) {
						new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
					}
					
					e.printStackTrace();
				}
				review.setReview_img(filename);			
					
				} 
				
				
				else { 					// 첨부파일이 수정되지 않으면
					review.setReview_img(review1.getReview_img());
				}
				System.out.println("review_updateresult");
				
				int result = rs.ReviewUpdateok(review);
				
				if (result == 1)
					System.out.println("수정성공");
				
				model.addAttribute("result", result);
				return "review/review_updateresult";
	}

	// 리뷰 삭제
	@RequestMapping("review_delete.do")
	public String reviewdeleteform(int review_no, Model model) throws Exception {
		System.out.println("review_delete");
		Review review = rs.ReviewDelete(review_no);
		model.addAttribute("review", review);

		return "review/review_delete";
	}

	// 리뷰 삭제 성공
	@RequestMapping("review_deleteresult")
	public String reviewdelete(Review review, Model model) throws Exception {
		System.out.println("review_deleteresult");

		int result = rs.ReviewDeleteOk(review);
		if (result == 1)
			System.out.println("삭제성공");

		model.addAttribute("result", result);
		return "review/review_deleteresult";
	}

}
