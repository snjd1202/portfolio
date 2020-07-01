package com.proj.pro.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import org.springframework.web.multipart.MultipartFile;

public class SalesVO {
	private int pno, bcnt, rno, imgno, memno, rst, rpno, rcnt, lcnt, lno;
	private String ptt, bno, pbd, name, today, cate, bceo, memid, bname, bloc, oriname, savename, rtt, rbd, isshow, imgrut;
	private Date pDate;
	private Time pTime;
	private MultipartFile file;
	
	
	@Override
	public String toString() {
		return "SalesVO [pno=" + pno + ", bcnt=" + bcnt + ", rno=" + rno + ", imgno=" + imgno + ", memno=" + memno
				+ ", rst=" + rst + ", rpno=" + rpno + ", rcnt=" + rcnt + ", lcnt=" + lcnt + ", lno=" + lno + ", ptt="
				+ ptt + ", bno=" + bno + ", pbd=" + pbd + ", name=" + name + ", today=" + today + ", cate=" + cate
				+ ", bceo=" + bceo + ", memid=" + memid + ", bname=" + bname + ", bloc=" + bloc + ", oriname=" + oriname
				+ ", savename=" + savename + ", rtt=" + rtt + ", rbd=" + rbd + ", isshow=" + isshow + ", imgrut="
				+ imgrut + ", pDate=" + pDate + ", pTime=" + pTime + ", file=" + file + "]";
	}
	public String getImgrut() {
		return imgrut;
	}
	public void setImgrut(String imgrut) {
		this.imgrut = imgrut;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getLno() {
		return lno;
	}
	public void setLno(int lno) {
		this.lno = lno;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public int getLcnt() {
		return lcnt;
	}
	public void setLcnt(int lcnt) {
		this.lcnt = lcnt;
	}
	public int getRcnt() {
		return rcnt;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRpno() {
		return rpno;
	}
	public void setRpno(int rpno) {
		this.rpno = rpno;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public int getRst() {
		return rst;
	}
	public void setRst(int rst) {
		this.rst = rst;
	}
	public String getRtt() {
		return rtt;
	}
	public void setRtt(String rtt) {
		this.rtt = rtt;
	}
	public String getRbd() {
		return rbd;
	}
	public void setRbd(String rbd) {
		this.rbd = rbd;
	}
	public int getImgno() {
		return imgno;
	}
	public void setImgno(int imgno) {
		this.imgno = imgno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBloc() {
		return bloc;
	}
	public void setBloc(String bloc) {
		this.bloc = bloc;
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
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getBceo() {
		return bceo;
	}
	public void setBceo(String bceo) {
		this.bceo = bceo;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getBcnt() {
		return bcnt;
	}
	public void setBcnt(int bcnt) {
		this.bcnt = bcnt;
	}
	public String getPtt() {
		return ptt;
	}
	public void setPtt(String ptt) {
		this.ptt = ptt;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getPbd() {
		return pbd;
	}
	public void setPbd(String pbd) {
		this.pbd = pbd;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public void setToday() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss");
		this.today = form1.format(pDate) + " " + form2.format(pTime);
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public Time getpTime() {
		return pTime;
	}
	public void setpTime(Time pTime) {
		this.pTime = pTime;
	}
	
	
}
