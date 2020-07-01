package com.proj.pro.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.proj.pro.vo.FileVO;

public class FileUtil {
   // 동일한 파일명이 존재하면 이름을 바꿔주는 함수
   
   public static String rename(String path, String oldName) {
      // 규칙 : 같은 이름의 파일 존재 시, _(숫자) 형태로 이름 변경
      int count = 0; // 뒤에 붙을 번호 기억할 변수
      String tmpName = oldName; // 현재이름 기억시킬 변수
      
      File file = new File(path, oldName);
      
      while(file.exists()) {
         // 이미 존재하는 파일 이름 변경 ==> 붙일 번호 증가 시켜야
         count++;
         // .을 기준으로 파일의 이름과 확장자 분리
         int len = tmpName.lastIndexOf('.');
         String tmp1 = tmpName.substring(0,len); // 파일이름
         String tmp2 = tmpName.substring(len); // 확장자
         
         // 분리 후 숫자 붙이기
         oldName = tmp1 + "_" + count + tmp2;
         
         // 동일한 이름이 있는지 확인 ==> file 객체로 만들어서 확인
         file = new File(path, oldName);
      }
      return oldName;
   }
 // savename 만들기
   public static String getSavename(HttpSession session, MultipartFile file, String folder) {
      String savename = null;
      String filePath = session.getServletContext().getRealPath("resources") + "/" + folder;
      
         String oriname = file.getOriginalFilename();
         if(oriname != null) {
            savename = getUUID(oriname);
         }
         try {
            File refile = new File(filePath, savename);
            byte[] fByte = file.getBytes();
            FileCopyUtils.copy(fByte, refile);
         } catch(Exception e) {
            e.printStackTrace();
         }
      return savename;
   }
   // 랜덤이름 만들기
   public static String getUUID(String oriname) {
	   UUID uuid = UUID.randomUUID();
	   String savename = uuid.toString()+"_"+oriname;
	   return savename;
   }
}