package co.micol.prj.notice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private Date noticeDate;
	private String noticeTitle;
	private String noticeSubject;
	private int noticeHit;
	private String noticeFile;
	private String noticeFileDir;
}
