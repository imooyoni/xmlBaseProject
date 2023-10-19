package org.base.domain;

import java.util.Date;

import lombok.Data;


@Data
public class BoardVO {

	private Integer boardId;
	private String boardTitle;
	private String boardContent;
	private String regUserId;
	private Date regDate;
	private Date uptDate;

}
