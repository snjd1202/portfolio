package com.proj.pro.controller.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.proj.pro.dao.SalesDAO;
import com.proj.pro.service.SalesService;
import com.proj.pro.vo.FileVO;
import com.proj.pro.vo.SalesVO;

@Controller
@RequestMapping("/sales")
public class Sales {
	@Autowired
	SalesDAO sDAO;
	@Inject
	private SalesService service;
	
	// Sales List Page
	@RequestMapping("/sales.pro")
	public ModelAndView getList(ModelAndView mv) {
		try {
			String view = "sales/sales";
			ArrayList<SalesVO> list = (ArrayList<SalesVO>)service.getSaList();
			mv.addObject("LIST", list);
			mv.setViewName(view);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	// Sales Detail Page
	@RequestMapping(value="/sales_inside.pro", method=RequestMethod.GET)
	public ModelAndView saDetail(ModelAndView mv, SalesVO sVO) {
		try {
			String view = "sales/sales_inside";
			service.saBcnt(sVO.getPno());
			SalesVO vo = service.saDetail(sVO);
//			String vv = service.likeck(sVO);
			mv.addObject("DATA", vo);
			mv.addObject("PNO", sVO.getPno());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	// Sales Write View Page
	@RequestMapping("/sales_write.pro")
	public String saWrite() {
		String view ="sales/sales_write";
		return view;
	}
	
	// Sales Write Action
	@RequestMapping(value="/sales_write.pro", method=RequestMethod.POST)
//	@ResponseBody
	public ModelAndView saWriteProc(SalesVO sVO, ModelAndView mv, FileVO fVO,  HttpSession session) {
		try {
			String view = "sales/sales_write";
			if(session.getAttribute("SID") == null) {
				RedirectView rv = new RedirectView("/pro/login/loginList.pro");
				mv.setView(rv);
				return mv;
			}
				if(sVO.getPbd() != null) {
				service.saWrite(sVO);
				RedirectView rv = new RedirectView("/pro/sales/sales.pro");
				mv.setView(rv);
				}
				service.saImage(fVO, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	// Sales Delete
	@RequestMapping(value="/sales_inside.pro", method=RequestMethod.POST, params= {"spno"})
	public ModelAndView saDelete(int spno, ModelAndView mv, SalesVO sVO) {
		try {
			String view = "sales/sales_inside.pro";
			int cnt = service.saDelete(spno);
			if(cnt == 1) {
				RedirectView rv = new RedirectView("/pro/sales/sales.pro");
				mv.setView(rv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	// Sales Edit Page
	@RequestMapping(value="/sales_modify.pro", method=RequestMethod.POST, params= {"pno", "ptt", "pbd", "cate"})
	public ModelAndView saEdit(int pno, String ptt, String pbd, String cate, SalesVO sVO, ModelAndView mv) {
		try {
			String view = "sales/sales_modify";
			SalesVO vo = service.saEdit(sVO);
			mv.addObject("DATA", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	// Sales Edit RedirectView
	@RequestMapping(value="/sales_modifyProc.pro", method=RequestMethod.POST, params= {"pno", "ptt", "pbd", "cate"})
	public ModelAndView saEditProc(int pno, String ptt, String pbd, String cate, SalesVO sVO, ModelAndView mv) {
		try {
			String view = "sales/sales_modify";
			SalesVO vo = service.saEdit(sVO);
			RedirectView rv = new RedirectView("/pro/sales/sales_inside.pro?pno="+sVO.getPno());
			mv.setView(rv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	// Review Add(ajax)
	@RequestMapping(value="/sales_review.pro", method=RequestMethod.POST)
	@ResponseBody
	public SalesVO reWrite(SalesVO sVO, @RequestParam("file")MultipartFile file, HttpSession session, ModelAndView mv) {
		try {
			String view = "sales/sales_inside";
			service.reWrite(sVO);
			if(sVO.getRbd() != null) {
				String ii = file.getOriginalFilename();
				System.out.println("oriname : " + ii);
				sVO.setFile(file);
				service.reImage(sVO, session);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sVO;
	}
	// Review List(ajax)
	@RequestMapping("/reviewList.pro")
	@ResponseBody
	public ArrayList<SalesVO>  reList(ModelAndView mv,SalesVO sVO, int pno) throws Exception {
		ArrayList<SalesVO> list = (ArrayList<SalesVO>)service.reList(pno);
		mv.addObject("LIST", list);
		return list;
	}
	// Review Delete(ajax)
	@RequestMapping(value="/reviewDelete.pro", method=RequestMethod.POST, params= {"rno"})
	@ResponseBody
	public Map reDelete(ModelAndView mv, int rno, SalesVO sVO) {
			String view = null;
			int cnt = 0;
			Map<String, Object> map = new HashMap<String, Object>();
		try {
			view="sales/sales_inside";
			cnt =  service.reDelete(sVO);
			map.put("result", cnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	// Review Edit(ajax)
	@RequestMapping(value="/reviewEdit.pro", method=RequestMethod.POST)
	@ResponseBody
	public Map reEdit(ModelAndView mv, SalesVO sVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = 0;
		try {
			cnt = service.reEdit(sVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("result", cnt);
		return map;
	}
	// Like Check(ajax)
	@RequestMapping(value="/likeCheck.pro", method=RequestMethod.POST)
	@ResponseBody
	public SalesVO like(SalesVO sVO) {
		SalesVO vo = service.likeCheck(sVO);
		return sVO;
	}
	
}
