package com.proj.pro.vo;

import java.io.File;
import java.sql.Date;
import java.sql.Time;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	private int pno, rno, imgno;
	private String oriname, savename, sDate, imgrut, sfile;
	private Date iDate;
	private Time iTime;
	private File mfile;
	private MultipartFile file;
	
	
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public File getMfile() {
		return mfile;
	}
	public void setMfile(File mfile) {
		this.mfile = mfile;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getImgno() {
		return imgno;
	}
	public void setImgno(int imgno) {
		this.imgno = imgno;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String getImgrut() {
		return imgrut;
	}
	public void setImgrut(String imgrut) {
		this.imgrut = imgrut;
	}
	public Date getiDate() {
		return iDate;
	}
	public void setiDate(Date iDate) {
		this.iDate = iDate;
	}
	public Time getiTime() {
		return iTime;
	}
	public void setiTime(Time iTime) {
		this.iTime = iTime;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
