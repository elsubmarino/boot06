package org.zerock.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude="replies")
@Table(name="tbl_webboards")
@EqualsAndHashCode(of="bno")
public class WebBoard {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long bno;
	private String title;
	private String content;
	private String writer;
	@CreationTimestamp
	private Timestamp regdate;
	@UpdateTimestamp
	private Timestamp updatedate;
	
	@OneToMany(mappedBy="board",fetch=FetchType.LAZY)
	List<WebReply> replies;

}
