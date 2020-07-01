package com.proj.pro.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proj.pro.dao.SalesDAO;
import com.proj.pro.util.FileUtil;
import com.proj.pro.vo.FileVO;
import com.proj.pro.vo.SalesVO;

@Service("SalesService")
public class SalesService {
	
	@Autowired
	private SalesDAO sDAO;
	
	// Sales List
	public List<SalesVO> getSaList() throws Exception {
		return sDAO.getSaList();
	}
	// Sales Detail
	public SalesVO saDetail(SalesVO sVO) throws Exception {
		return sDAO.saDetail(sVO);
	}
	// Sales Bcnt
	public void saBcnt(int bpno) throws Exception {
		sDAO.saBcnt(bpno);
	}
	// Sales Write
	public SalesVO saWrite(SalesVO sVO) throws Exception {
		return sDAO.saWrite(sVO);
	}
	// Sales Delete
	public int saDelete(int spno) throws Exception {
		return sDAO.saDelete(spno);
	}
	// Sales Edit
	public SalesVO saEdit(SalesVO sVO) throws Exception {
		return sDAO.saEdit(sVO);
	}
	// Review add(ajax)
	public SalesVO reWrite(SalesVO sVO) throws Exception {
		return sDAO.reWrite(sVO);
	}
	// Review List(ajax)
	public List reList(int pno) throws Exception {
		return sDAO.reList(pno);
	}
	// Review Delete(ajax)
	public int reDelete(SalesVO sVO) throws Exception {
		return sDAO.reDelete(sVO);
	}
	// Review Edit(ajax)
	public int reEdit(SalesVO sVO) throws Exception {
		return sDAO.reEdit(sVO);
	}
	// Sales Image Add
	public int saImage(FileVO fVO, HttpSession session) {
		try {
			MultipartFile file = fVO.getFile();
			String filePath = session.getServletContext().getRealPath("resources/upload");
//			String savename = FileUtil.rename(filePath, fVO.getOriname());
			String savename = FileUtil.getSavename(session, file, "upload");
			fVO.setOriname(file.getOriginalFilename());
			fVO.setSavename(savename);
			file.transferTo(new File(filePath, fVO.getOriname()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sDAO.saImage(fVO);
	}
	// Review Image Add(ajax)
	public int reImage(SalesVO sVO, HttpSession session) {
		try {
			MultipartFile file = sVO.getFile();
			System.out.println("ser.file : " + file);
			String filePath = session.getServletContext().getRealPath("resources/upload");
			String savename = FileUtil.getSavename(session, file, "upload");
			sVO.setOriname(file.getOriginalFilename());
			sVO.setSavename(savename);
			file.transferTo(new File(filePath, sVO.getOriname()));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return sDAO.reImage(sVO);
	}
	// 좋아요 아이디 체크(ajax)
	public SalesVO likeCheck(SalesVO sVO) {
		String vo = sDAO.likeCheck(sVO);
		System.out.println("vo : " + vo);
		if(vo == null){
			sDAO.like(sVO);
			sDAO.likeUp(sVO);
			System.out.println("sVO.toString : " + sVO.toString());
//			likeck(sVO);
		} else if(vo.equals(sVO.getMemid())) {
			sDAO.disLike(sVO);
			sDAO.likeDown(sVO);
		}
		return sVO;
	}
	/*
	public String likeck(SalesVO sVO) {
		String svo = sDAO.likeCheck(sVO);
		System.out.println("ser.svo : " + svo);
		String result;
		if(svo == null) {
			result = " ";
		} else {
			result = svo;
		}
		System.out.println("result : " + result);
		return result;
	}
	*/
}
